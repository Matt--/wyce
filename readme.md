Whiley to C for Embedded Systems

This is an Honours project for my final year (2014) of a four year (equivalent) degree in Software Engineering at Victoria University.

Supervisor is Dr David Pearce (djs@ecs.vuw.ac.nz), the author of the Whiley language, which includes a Verifying Compiler. The goal of Whiley is to enable verification of safety critical code.

This project is to demonstrate and test Whiley running on an embedded system. The target platform is the Crazyflie Quadcopter (http://www.bitcraze.se/).

To achieve this requires developing an Intermediate to Source Compiler. In essence this is a Java program, taking a Whiley program already compiled to bytecode (capturing all the verification) and generating a C source file that can be compiled to an image and flashed to the embedded system.

C is used because of the wide range of cpu's the gcc compiler caters for.

This will ultimately enable developers to write in Whiley, generate verified code suitable for safety critical systems (eg: car brake and acceleration systems) and compile direct to an image ready for flashing to thier desired cpu.

This projects focus is on getting the Crazyflie to do stuff with Whiley code. I cannot promise the best code in the world, but hopefully along the way I have resolved some tricky coding issues and my code is easy(ish) to follow.

Enjoy :-)
