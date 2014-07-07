import whiley.lang.System



//== Tests ==
native method motorsTest() => bool
native method imu6Test() => bool
native method sensfusion6Test() => bool
native method controllerTest() => bool
//== Initialize ==
native method motorsInit()
native method imu6Init()
native method sensfusion6Init()
native method controllerInit()
native method isStabilizerInit() => bool
//== Simple methods, no parameters ==
native method systemWaitStart()
native method cf_lib_xTaskGetTickCount() => int
native method imu6IsCalibrated() => bool
native method controllerResetAllPID()

//================================================
//== FreeRTOS
// portBASE_TYPE xTaskCreate( pdTASK_CODE pvTaskCode, const char * const pcName, unsigned short usStackDepth, void *pvParameters, unsigned portBASE_TYPE uxPriority, xTaskHandle *pvCreatedTask );
native method cf_lib_xTaskCreate(method() => void stabilizerTask, string b, int c, int d, int e, int f) => void

// void vTaskSetApplicationTaskTag( xTaskHandle xTask, pdTASK_HOOK_CODE pxHookFunction ) PRIVILEGED_FUNCTION;
// typedef void * xTaskHandle;
// pdTASK_HOOK_CODE is used as a void*, replace with void* ?
native method cf_lib_vTaskSetApplicationTaskTag(int p, int taskStabilizerIdNmr)

//void vTaskDelayUntil( portTickType * const pxPreviousWakeTime, portTickType xTimeIncrement ) PRIVILEGED_FUNCTION;
native method cf_lib_vTaskDelayUntil( int lastWakeTime, int xTimeIncrement )

//================================================
//== i/o operations ==
//void imu9Read(Axis3f* gyroOut, Axis3f* accOut, Axis3f* magOut);
native method cf_lib_imu9Read([real] _gyro, [real] _acc, [real] _mag) //done
native method cf_lib_getGyro() => [real]
native method cf_lib_getAcc()  => [real]
native method cf_lib_getMag()  => [real]

//void sensfusion6UpdateQ(float gx, float gy, float gz, float ax, float ay, float az, float dt);
native method sensfusion6UpdateQ(real gx, real gy, real gz, real ax, real ay, real az, real dt)

//void sensfusion6GetEulerRPY(float* roll, float* pitch, float* yaw);
native method cf_lib_sensfusion6GetEulerRPY(real eulerRollActual, real eulerPitchActual, real eulerYawActual) //done
native method cf_lib_getEulerRollActual()  => real
native method cf_lib_getEulerPitchActual() => real
native method cf_lib_getEulerYawActual()   => real

//=================================================
//== Firmware ==
//== controller.c ==
//void controllerCorrectAttitudePID(
//       float eulerRollActual, float eulerPitchActual, float eulerYawActual,
//       float eulerRollDesired, float eulerPitchDesired, float eulerYawDesired,
//       float* rollRateDesired, float* pitchRateDesired, float* yawRateDesired);
native method cf_lib_controllerCorrectAttitudePID(real eulerRollActual, real eulerPitchActual, real eulerYawActual, real eulerRollDesired, real eulerPitchDesired, real eulerYawDesired, real rollRateDesired, real pitchRateDesired, real yawRateDesired)
native method cf_lib_getRollRateDesired()  => real
native method cf_lib_getPitchRateDesired() => real
native method cf_lib_getYawRateDesired()   => real

//void controllerCorrectRatePID(
//       float rollRateActual, float pitchRateActual, float yawRateActual,
//       float rollRateDesired, float pitchRateDesired, float yawRateDesired);
native method controllerCorrectRatePID(real rollRateActual, real pitchRateActual, real yawRateActual, real rollRateDesired, real pitchRateDesired, real yawRateDesired)

//void controllerGetActuatorOutput(&actuatorRoll, &actuatorPitch, &actuatorYaw)
native method cf_lib_controllerGetActuatorOutput(int actuatorRoll, int actuatorPitch, int actuatorYaw)
native method cf_lib_getActuatorRoll() => int
native method cf_lib_getActuatorPitch() => int
native method cf_lib_getActuatorYaw() => int

//== commander.c ==
//void commanderGetThrust(uint16_t* thrust);
native method cf_lib_commanderGetThrust(int actuatorThrust) => int // done
//void commanderGetRPY(float* eulerRollDesired, float* eulerPitchDesired, float* eulerYawDesired);
native method cf_lib_commanderGetRPY(real eulerRollDesired, real eulerPitchDesired, real eulerYawDesired)
native method cf_lib_getEulerRollDesired() => real
native method cf_lib_getPitchRollDesired() => real
native method cf_lib_getEulerYawDesired()  => real

//void commanderGetRPYType(RPYType* rollType, RPYType* pitchType, RPYType* yawType);
native method cf_lib_commanderGetRPYType(string rollType, string pitchType, string yawType)
native method cf_lib_getRollType()  => string
native method cf_lib_getPitchType() => string
native method cf_lib_getYawType()   => string


native method motorsSetRatio(int motor, int power)

//method main(System.Console console):

export method stabilizerTest() => bool:
  bool pass = true

  pass = pass && motorsTest()
  pass = pass && imu6Test()
  pass = pass && sensfusion6Test()
  pass = pass && controllerTest()

  return pass

export method stabilizerInit() => void:
  if(isStabilizerInit()):
    return

  motorsInit()
  imu6Init()
  sensfusion6Init()
  controllerInit()

  // create the stabilizer task. Places the task into the FreeRTOS task que/s.
  cf_lib_xTaskCreate(&stabilizerTask, /*(const signed char * const)*/ "STABILIZER", 200, /*null*/0, /*Piority*/2, /*null*/0)

// This sets up and contains the loop that the stabilzer task runs
method stabilizerTask() => void:
  [real] gyro = [0, 0, 0]
  [real] acc  = [0, 0, 0]
  [real] mag  = [0, 0, 0]

  real eulerRollActual   = 0
  real eulerPitchActual  = 0
  real eulerYawActual    = 0
  real eulerRollDesired  = 0
  real eulerPitchDesired = 0
  real eulerYawDesired   = 0
  real rollRateDesired   = 0
  real pitchRateDesired  = 0
  real yawRateDesired    = 0

  string rollType  = "ANGLE"
  string pitchType = "ANGLE"
  string yawType   = "ANGLE"

  int actuatorThrust = 0 // was uint16
  int actuatorRoll   = 0 // was int16
  int actuatorPitch  = 0
  int actuatorYaw    = 0

  int attitudeCounter = 0 // was uint32_t
  int lastWakeTime // was uint32_t

  cf_lib_vTaskSetApplicationTaskTag(0, /*TASK_STABILIZER_ID_NBR*/3) // FreeRTOSConfig.h #define TASK_STABILIZER_ID_NBR  3

  systemWaitStart()

  lastWakeTime = cf_lib_xTaskGetTickCount()

  while(true):
    //vTaskDelayUntil(&lastWakeTime, (unsigned int)((/*configTICK_RATE_HZ*/ /*( portTickType ) cast to short*/ 1000 / /*IMU_UPDATE_FREQ*/500)) ); // 500Hz
    cf_lib_vTaskDelayUntil(lastWakeTime, 2)

    cf_lib_imu9Read(gyro, acc, mag)
    gyro = cf_lib_getGyro()
    acc  = cf_lib_getAcc()
    mag  = cf_lib_getMag()

    if(imu6IsCalibrated()):
      cf_lib_commanderGetRPY(eulerRollDesired, eulerPitchDesired, eulerYawDesired)
//      eulerRollDesired  = cf_lib_getEulerRollDesired() // gcc throwing unused error
//      eulerPitchDesired = cf_lib_getPitchRollDesired() // gcc throwing unused error
      eulerYawDesired   = cf_lib_getEulerYawDesired()

      cf_lib_commanderGetRPYType(rollType, pitchType, yawType)
      rollType  = cf_lib_getRollType()
      pitchType = cf_lib_getPitchType()
      yawType   = cf_lib_getYawType()

      attitudeCounter = attitudeCounter + 1
      if(attitudeCounter >= 2):
        real fusion_update_dt = 1.0/(500.0 / 2.0)
        sensfusion6UpdateQ(gyro[0], gyro[1], gyro[2], acc[0], acc[1], acc[2], fusion_update_dt)
        cf_lib_sensfusion6GetEulerRPY(eulerRollActual, eulerPitchActual, eulerYawActual)
        eulerRollActual  = cf_lib_getEulerRollActual()
        eulerPitchActual = cf_lib_getEulerPitchActual()
        eulerYawActual   = cf_lib_getEulerYawActual()

        cf_lib_controllerCorrectAttitudePID(eulerRollActual, eulerPitchActual, eulerYawActual, eulerRollDesired, eulerPitchDesired, -eulerYawDesired, rollRateDesired, pitchRateDesired, yawRateDesired)
        rollRateDesired = cf_lib_getRollRateDesired()
        pitchRateDesired = cf_lib_getPitchRateDesired()
//        yawRateDesired = cf_lib_getYawRateDesired() // gcc throwing unused error

        attitudeCounter = 0

      // dropped several redundent if statements
      yawRateDesired = -eulerYawDesired

      controllerCorrectRatePID(gyro[0], -gyro[1], gyro[2], rollRateDesired, pitchRateDesired, yawRateDesired)

      cf_lib_controllerGetActuatorOutput(actuatorRoll, actuatorPitch, actuatorYaw)
      actuatorRoll  = cf_lib_getActuatorRoll()
      actuatorPitch = cf_lib_getActuatorPitch()
      actuatorYaw   = cf_lib_getActuatorYaw()

      actuatorThrust = cf_lib_commanderGetThrust(actuatorThrust)

      if(actuatorThrust > 0):
        distributePower(actuatorThrust, actuatorRoll, actuatorPitch, -actuatorYaw)
      else:
        distributePower(0, 0, 0, 0)
        controllerResetAllPID()

method distributePower(int thrust, int roll, int pitch, int yaw): // takes uint16
  int motorPowerM1 = limitThrust(thrust + pitch + yaw)
  int motorPowerM2 = limitThrust(thrust - roll - yaw)
  int motorPowerM3 = limitThrust(thrust - pitch + yaw)
  int motorPowerM4 = limitThrust(thrust + roll - yaw)

  motorsSetRatio(/*MOTOR_M1*/0, motorPowerM1)
  motorsSetRatio(/*MOTOR_M2*/1, motorPowerM2)
  motorsSetRatio(/*MOTOR_M3*/2, motorPowerM3)
  motorsSetRatio(/*MOTOR_M4*/3, motorPowerM4)

method limitThrust(int v) => int: // converts an uint32 to a uint16
  int value = v
  int uint16_Max = 65535
  if(value > uint16_Max):
    value = uint16_Max
  else if(value < 0):
    value = 0
  return value

