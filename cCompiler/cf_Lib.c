/*
 * Library for interfacing Whiley methods with Crazyflie methods
 *
 * Solving two problems.
 * 1. Allowing a global variable, to let callers of stabilizerInit(void) to return immediately if the method has already been run.
 * 2. Whiley does not allow pointers as parameters in methods. Values are passed and returned back to Whiley methods.
 */


// declared in FreeRTOS commander.h
typedef enum
{
  RATE,
  ANGLE
} RPYType;
// declared in FreeRTOC hal/interface/imu_types.h
typedef struct {
        float x;
        float y;
        float z;
} Axis3f;
// declared in FreeRTOS include/projdefs.h
typedef void (*pdTASK_CODE)( void * );



//== Initialized? ==
// called to utilise global variable
static bool stabilizerIsInit = false;

static Any isStabilizerInit(){
  bool temp = stabilizerIsInit;
  stabilizerIsInit = true;
  return Bool(temp);
}


// NOTES - IMPORTANT
// naming pattern; cf_lib_ plus original name
// simple solution pattern to this interface; first call to update globals, then specify the getters for Whiley

//=============================================
//== FreeRTOS ==

// xTaskCreate(&stabilizerTask, /*(const signed char * const)*/ "STABILIZER", 200, null, /*Piority*/2, null)
// portmacro.h #define portBASE_TYPE	long
static void cf_lib_xTaskCreate(Any stabilizerTask, char* stabilizerName, int depth, int n1, int priority, int n2){
  pdTASK_CODE pvTaskCode = (pdTASK_CODE) stabilizerTask.ptr; // method pointer
  const char * const pcName = stabilizerName; // "STABILIZER"
  unsigned short usStackDepth = depth; // 200
  void *pvParameters = Null; // null
  unsigned long uxPriority = priority; // 2
  void *pvCreatedTask = Null; // null

  xTaskCreate( pvTaskCode, pcName, usStackDepth, pvParameters, uxPriority, pvCreatedTask );
}

// vTaskSetApplicationTaskTag(0, (void*)/*TASK_STABILIZER_ID_NBR*/3) // TODO not sure how this (void*)3 is meant to work...
//   FreeRTOSConfig.h #define TASK_STABILIZER_ID_NBR  3
// vTaskSetApplicationTaskTag( xTaskHandle xTask, pdTASK_HOOK_CODE pxHookFunction ) PRIVILEGED_FUNCTION;
//   typedef void * xTaskHandle;
//   typedef portBASE_TYPE (*pdTASK_HOOK_CODE)( void * );
static int g_xTask;
static int g_taskStabilizerIdNmr;
static void cf_lib_vTaskSetApplicationTaskTag(int xTask, int taskStabilizerIdNmr){
  g_xTask = xTask;
  g_taskStabilizerIdNmr = taskStabilizerIdNmr;
  vTaskSetApplicationTaskTag(&g_xTask, &g_taskStabilizerIdNmr);
}


//void vTaskDelayUntil( portTickType * const pxPreviousWakeTime, portTickType xTimeIncrement ) PRIVILEGED_FUNCTION;
//== portTickType defined in portable/GCC/ARM_CM3/portmacro.h
//#if( configUSE_16_BIT_TICKS == 1 )
//	typedef unsigned portSHORT portTickType;
//	#define portMAX_DELAY ( portTickType ) 0xffff
//#else
//	typedef unsigned portLONG portTickType;
//	#define portMAX_DELAY ( portTickType ) 0xffffffff
//#endif
static int lastWakeTime;
static void cf_lib_vTaskDelayUntil( int _lastWakeTime, int xTimeIncrement ){
  lastWakeTime = _lastWakeTime;

  vTaskDelayUntil( &lastWakeTime, xTimeIncrement );
}

//=====================================================
//== Firmware ==

// commanderGetThrust
static short thrust;
static Any cf_lib_commanderGetThrust(Any _thrust){
  thrust = _thrust.i;
  commanderGetThrust(&thrust);
  return Int(thrust);
}

// commanderGetRPY
static float eulerRollDesired;
static float eulerPitchDesired;
static float eulerYawDesired;
static void cf_lib_commanderGetRPY(double _eulerRollDesired, double _eulerPitchDesired, double _eulerYawDesired){
  eulerRollDesired  = (float) _eulerRollDesired;
  eulerPitchDesired = (float) _eulerPitchDesired;
  eulerYawDesired   = (float) _eulerYawDesired;
  commanderGetRPY(&eulerRollDesired, &eulerPitchDesired, &eulerYawDesired);
}
static Any cf_lib_getEulerRollDesired() { return Real(eulerRollDesired);}
static Any cf_lib_getEulerPitchDesired(){ return Real(eulerPitchDesired);}
static Any cf_lib_getEulerYawDesired()  { return Real(eulerYawDesired);}

// commanderGetRPYType
static RPYType rollType;
static RPYType pitchType;
static RPYType yawType;
// need to accept a Str() type and return a Str() type
static void cf_lib_commanderGetRPYType(char* _rollType, char* _pitchType, char* _yawType){
  rollType  = _rollType == "ANGLE" ? 0 :
		  	  	  _rollType == "RATE" ? 1 : 99;
  pitchType = _pitchType == "ANGLE" ? 0 :
		  	  	  _pitchType == "RATE" ? 1 : 99;
  yawType   = _yawType == "ANGLE" ? 0 :
		  	  	  _yawType == "RATE" ? 1 : 99;
  commanderGetRPYType(&rollType, &pitchType, &yawType);
}
static Any cf_lib_getRollType() { Any a = rollType == 0 ? Str("ANGLE") : rollType == 2 ? Str("RATE") : Str("error"); return a;}
static Any cf_lib_getPitchType(){ Any a = pitchType == 0 ? Str("ANGLE") : pitchType == 2 ? Str("RATE") : Str("error"); return a;}
static Any cf_lib_getYawType()  { Any a = yawType == 0 ? Str("ANGLE") : yawType == 2 ? Str("RATE") : Str("error"); return a;}

// controllerCorrectAttitudePID
static float eulerRollActual;
static float eulerPitchActual;
static float eulerYawActual;
static float rollRateDesired = 0;
static float pitchRateDesired = 0;
static float yawRateDesired = 0;
static void cf_lib_controllerCorrectAttitudePID(
       Any _eulerRollActual,  Any _eulerPitchActual,  Any _eulerYawActual,
       Any _eulerRollDesired, Any _eulerPitchDesired, Any _eulerYawDesired,
       Any _rollRateDesired,  Any _pitchRateDesired,  Any _yawRateDesired){
  eulerRollActual   = (float) _eulerRollActual.r;
  eulerPitchActual  = (float) _eulerPitchActual.r;
  eulerYawActual    = (float) _eulerYawActual.r;
  eulerRollDesired  = (float) _eulerRollDesired.r;
  eulerPitchDesired = (float) _eulerPitchDesired.r;
  eulerYawDesired   = (float) _eulerYawDesired.r;
  rollRateDesired   = (float) _rollRateDesired.r;
  pitchRateDesired  = (float) _pitchRateDesired.r;
  yawRateDesired    = (float) _yawRateDesired.r;
  controllerCorrectAttitudePID(
       eulerRollActual,  eulerPitchActual,  eulerYawActual,
       eulerRollDesired, eulerPitchDesired, eulerYawDesired,
       &rollRateDesired, &pitchRateDesired, &yawRateDesired);
}
static Any cf_lib_getRollRateDesired() { return Real(rollRateDesired);}
static Any cf_lib_getPitchRateDesired(){ return Real(pitchRateDesired);}
static Any cf_lib_getYawRateDesired()  { return Real(yawRateDesired);}

// controllerGetActuatorOutput(&actuatorRoll, &actuatorPitch, &actuatorYaw)
static short actuatorRoll;
static short actuatorPitch;
static short actuatorYaw;
static void cf_lib_controllerGetActuatorOutput(int _actuatorRoll, int _actuatorPitch, int _actuatorYaw){
  actuatorRoll  = (short) _actuatorRoll;
  actuatorPitch = (short) _actuatorPitch;
  actuatorYaw   = (short) _actuatorYaw;
  controllerGetActuatorOutput(&actuatorRoll, &actuatorPitch, &actuatorYaw);
}
static Any cf_lib_getActuatorRoll() { return Int(actuatorRoll);}
static Any cf_lib_getActuatorPitch(){ return Int(actuatorPitch);}
static Any cf_lib_getActuatorYaw()  { return Int(actuatorYaw);}

//========================================================
//== i/o ==

// imu9Read
static Axis3f gyro; // Gyro axis data in deg/s
static Axis3f acc;  // Accelerometer axis data in mG
static Axis3f mag;  // Magnetometer axis data in testla
static Any gyroArray[3];
static Any accArray[3];
static Any magArray[3];
// translater method
void axis3f_to_array(Axis3f axis, Any* array){
	array[0] = Real(axis.x);
	array[1] = Real(axis.y);
	array[2] = Real(axis.z);
}
static void cf_lib_imu9Read(Any _gyro[3], Any _acc[3], Any _mag[3]){
  gyro.x = _gyro[0].r; gyro.y = _gyro[1].r; gyro.z = _gyro[2].r;
  acc.x  = _acc[0].r;  acc.y  = _acc[1].r;  acc.z  = _acc[2].r;
  mag.x  = _mag[0].r;  mag.y  = _mag[1].r;  mag.z  = _mag[2].r;
  imu9Read(&gyro, &acc, &mag);
}
static Any* cf_lib_getGyro(){ axis3f_to_array(gyro, gyroArray); return gyroArray;}
static Any* cf_lib_getAcc() { axis3f_to_array( acc,  accArray); return  accArray;}
static Any* cf_lib_getMag() { axis3f_to_array( mag,  magArray); return  magArray;}


// sensfusion6GetEulerRPY
static float eulerRollActual;
static float eulerPitchActual;
static float eulerYawActual;
static void cf_lib_sensfusion6GetEulerRPY(double _eulerRollActual, double _eulerPitchActual, double _eulerYawActual){
  eulerRollActual  = (float) _eulerRollActual;
  eulerPitchActual = (float) _eulerPitchActual;
  eulerYawActual   = (float) _eulerYawActual;
  sensfusion6GetEulerRPY(&eulerRollActual, &eulerPitchActual, &eulerYawActual);
}
static Any cf_lib_getEulerRollActual() { return Real(eulerRollActual);}
static Any cf_lib_getEulerPitchActual(){ return Real(eulerPitchActual);}
static Any cf_lib_getEulerYawActual()  { return Real(eulerYawActual);}

