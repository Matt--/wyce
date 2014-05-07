#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any f_bool1 ( Any , Any );
Any f_bool2 ( Any , Any );
Any f_bool3 ( Any , Any );
Any f_bool4 ( Any , Any );
Any f_bool5 ( Any , Any );
Any f_bool6 ( Any , Any );
Any f_bool7 ( Any , Any );
Any f_bool8 ( Any , Any );
Any f_bool9 ( Any , Any );
Any f_bool10 ( Any , Any );
Any f_bool11 ( Any , Any );
Any f_bool12 ( Any , Any );
Any f_bool13 ( Any , Any );
Any f_bool14 ( Any , Any );
Any f_bool15 ( Any , Any );
Any f_bool16 ( Any , Any );
Any f_bool17 ( Any , Any );
Any f_bool18 ( Any , Any );
Any f_bool19 ( Any , Any );
Any f_bool20 ( Any , Any );
Any f_bool21 ( Any , Any );
Any f_bool22 ( Any , Any );
Any f_bool23 ( Any , Any );
Any f_bool24 ( Any , Any );
Any f_bool25 ( Any , Any );

int main (){
  Any a2 = Bool(true);
  Any a4 = Bool(false);
  Any a6 = f_bool1 ( a2, a4 );
  Any a5 = a6;
  Any a12 = a5;
  println ( a12 );
  Any a16 = f_bool2 ( a2, a4 );
  println ( a16 );
  Any a22 = f_bool3 ( a2, a4 );
  println ( a22 );
  Any a28 = f_bool4 ( a2, a4 );
  println ( a28 );
  Any a34 = f_bool5 ( a2, a4 );
  println ( a34 );
  Any a40 = f_bool6 ( a2, a4 );
  println ( a40 );
  Any a46 = f_bool7 ( a2, a4 );
  println ( a46 );
  Any a52 = f_bool8 ( a2, a4 );
  println ( a52 );
  Any a58 = f_bool9 ( a2, a4 );
  println ( a58 );
  Any a64 = Str("10");
  println ( a64 );
  Any a68 = f_bool10 ( a2, a4 );
  println ( a68 );
  Any a74 = f_bool11 ( a2, a4 );
  println ( a74 );
  Any a80 = f_bool12 ( a2, a4 );
  println ( a80 );
  Any a86 = f_bool13 ( a2, a4 );
  println ( a86 );
  Any a92 = f_bool14 ( a2, a4 );
  println ( a92 );
  Any a98 = Str("15");
  println ( a98 );
  Any a102 = f_bool15 ( a2, a4 );
  println ( a102 );
  Any a108 = f_bool16 ( a2, a4 );
  println ( a108 );
  Any a114 = f_bool17 ( a2, a4 );
  println ( a114 );
  Any a120 = f_bool18 ( a2, a4 );
  println ( a120 );
  Any a126 = f_bool19 ( a2, a4 );
  println ( a126 );
  Any a132 = Str("20");
  println ( a132 );
  Any a136 = f_bool20 ( a2, a4 );
  println ( a136 );
  Any a142 = f_bool21 ( a2, a4 );
  println ( a142 );
  Any a148 = f_bool22 ( a2, a4 );
  println ( a148 );
  Any a154 = f_bool23 ( a2, a4 );
  println ( a154 );
  Any a160 = f_bool24 ( a2, a4 );
  println ( a160 );
  Any a166 = Str("25");
  println ( a166 );
  Any a170 = f_bool25 ( a2, a4 );
  println ( a170 );
  return;
}

Any f_bool1 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) == dataAsInt( a1 ) ) { goto label0; };
  Any a5 = Bool(false);
  goto label1;
  label0: ;
  a5 = Bool(true);
  label1: ;
  return a5;
}

Any f_bool2 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) == dataAsInt( a1 ) ) { goto label2; };
  Any a4 = Bool(false);
  goto label3;
  label2: ;
  a4 = Bool(true);
  label3: ;
  return a4;
}

Any f_bool3 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) != dataAsInt( a1 ) ) { goto label4; };
  Any a4 = Bool(false);
  goto label5;
  label4: ;
  a4 = Bool(true);
  label5: ;
  return a4;
}

Any f_bool4 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label6; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label6; };
  Any a6 = Bool(false);
  goto label7;
  label6: ;
  a6 = Bool(true);
  label7: ;
  return a6;
}

Any f_bool5 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label8; };
  goto label9;
  label8: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label10; };
  label9: ;
  Any a6 = Bool(false);
  goto label11;
  label10: ;
  a6 = Bool(true);
  label11: ;
  return a6;
}

Any f_bool6 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label12; };
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label12; };
  Any a6 = Bool(false);
  goto label13;
  label12: ;
  a6 = Bool(true);
  label13: ;
  return a6;
}

Any f_bool7 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label14; };
  goto label15;
  label14: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label16; };
  label15: ;
  Any a6 = Bool(false);
  goto label17;
  label16: ;
  a6 = Bool(true);
  label17: ;
  return a6;
}

Any f_bool8 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label18; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label18; };
  Any a6 = Bool(false);
  goto label19;
  label18: ;
  a6 = Bool(true);
  label19: ;
  return a6;
}

Any f_bool9 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label20; };
  goto label21;
  label20: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label22; };
  label21: ;
  Any a6 = Bool(false);
  goto label23;
  label22: ;
  a6 = Bool(true);
  label23: ;
  return a6;
}

Any f_bool10 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label24; };
  goto label25;
  label24: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label26; };
  Any a7 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a7 ) ) { goto label26; };
  label25: ;
  Any a8 = Bool(false);
  goto label27;
  label26: ;
  a8 = Bool(true);
  label27: ;
  return a8;
}

Any f_bool11 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label28; };
  goto label29;
  label28: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label30; };
  Any a7 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a7 ) ) { goto label30; };
  label29: ;
  Any a8 = Bool(false);
  goto label31;
  label30: ;
  a8 = Bool(true);
  label31: ;
  return a8;
}

Any f_bool12 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label32; };
  goto label33;
  label32: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label34; };
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label34; };
  label33: ;
  Any a8 = Bool(false);
  goto label35;
  label34: ;
  a8 = Bool(true);
  label35: ;
  return a8;
}

Any f_bool13 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label36; };
  goto label37;
  label36: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label38; };
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label38; };
  label37: ;
  Any a8 = Bool(false);
  goto label39;
  label38: ;
  a8 = Bool(true);
  label39: ;
  return a8;
}

Any f_bool14 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label40; };
  goto label41;
  label40: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label42; };
  label41: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label42; };
  Any a8 = Bool(false);
  goto label43;
  label42: ;
  a8 = Bool(true);
  label43: ;
  return a8;
}

Any f_bool15 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label44; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label45; };
  goto label46;
  label45: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label44; };
  label46: ;
  Any a8 = Bool(false);
  goto label47;
  label44: ;
  a8 = Bool(true);
  label47: ;
  return a8;
}

Any f_bool16 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label48; };
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label49; };
  goto label50;
  label49: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label48; };
  label50: ;
  Any a8 = Bool(false);
  goto label51;
  label48: ;
  a8 = Bool(true);
  label51: ;
  return a8;
}

Any f_bool17 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label52; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label52; };
  goto label53;
  label52: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label54; };
  label53: ;
  Any a8 = Bool(false);
  goto label55;
  label54: ;
  a8 = Bool(true);
  label55: ;
  return a8;
}

Any f_bool18 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label56; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label56; };
  goto label57;
  label56: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label58; };
  label57: ;
  Any a8 = Bool(false);
  goto label59;
  label58: ;
  a8 = Bool(true);
  label59: ;
  return a8;
}

Any f_bool19 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label60; };
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label61; };
  goto label62;
  label61: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a7 ) ) { goto label60; };
  label62: ;
  Any a8 = Bool(false);
  goto label63;
  label60: ;
  a8 = Bool(true);
  label63: ;
  return a8;
}

Any f_bool20 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label64; };
  Any a5 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a5 ) ) { goto label65; };
  goto label66;
  label65: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a7 ) ) { goto label64; };
  label66: ;
  Any a8 = Bool(false);
  goto label67;
  label64: ;
  a8 = Bool(true);
  label67: ;
  return a8;
}

Any f_bool21 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label68; };
  goto label69;
  label68: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label70; };
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label70; };
  label69: ;
  Any a8 = Bool(false);
  goto label71;
  label70: ;
  a8 = Bool(true);
  label71: ;
  return a8;
}

Any f_bool22 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label72; };
  goto label73;
  label72: ;
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label74; };
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label74; };
  label73: ;
  Any a8 = Bool(false);
  goto label75;
  label74: ;
  a8 = Bool(true);
  label75: ;
  return a8;
}

Any f_bool23 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label76; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label77; };
  goto label78;
  label77: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label76; };
  label78: ;
  Any a8 = Bool(false);
  goto label79;
  label76: ;
  a8 = Bool(true);
  label79: ;
  return a8;
}

Any f_bool24 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a3 ) ) { goto label80; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label81; };
  goto label82;
  label81: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label80; };
  label82: ;
  Any a8 = Bool(false);
  goto label83;
  label80: ;
  a8 = Bool(true);
  label83: ;
  return a8;
}

Any f_bool25 ( Any a0, Any a1 ){
  Any a3 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a3 ) ) { goto label84; };
  Any a5 = Bool(true);
  if ( dataAsInt( a1 ) == dataAsInt( a5 ) ) { goto label85; };
  goto label86;
  label85: ;
  Any a7 = Bool(true);
  if ( dataAsInt( a0 ) == dataAsInt( a7 ) ) { goto label84; };
  label86: ;
  Any a8 = Bool(false);
  goto label87;
  label84: ;
  a8 = Bool(true);
  label87: ;
  return a8;
}
