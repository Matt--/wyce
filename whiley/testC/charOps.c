#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any f_char1 ( Any , Any );
Any f_char2 ( Any , Any );
Any f_char3 ( Any , Any );
Any f_char4 ( Any , Any );
Any f_char5 ( Any , Any );
Any f_char6 ( Any , Any );
Any f_char7 ( Any , Any );
Any f_char8 ( Any , Any );
Any f_char9 ( Any , Any );
Any f_char10 ( Any , Any );

int main (){
  Any a2 = Char('m');
  Any a4 = Char('n');
  Any a8 = f_char1 ( a2, a4 );
  Any a7 = a8;
  Any a14 = a7;
  println ( a14 );
  Any a18 = f_char2 ( a2, a4 );
  println ( a18 );
  Any a24 = f_char3 ( a2, a4 );
  println ( a24 );
  Any a30 = f_char4 ( a2, a4 );
  println ( a30 );
  Any a36 = f_char5 ( a2, a4 );
  println ( a36 );
  Any a42 = f_char6 ( a2, a4 );
  println ( a42 );
  Any a48 = f_char7 ( a2, a4 );
  println ( a48 );
  Any a54 = f_char8 ( a2, a4 );
  println ( a54 );
  Any a60 = f_char9 ( a2, a4 );
  println ( a60 );
  Any a66 = f_char10 ( a2, a4 );
  println ( a66 );
  return 0;
}

Any f_char1 ( Any a0, Any a1 ){
  Any a4 = Char('0');
  if ( dataAsInt( a0 ) > dataAsInt( a4 ) ) { goto label0; };
  Any a5 = Bool(false);
  goto label1;
  label0: ;
  a5 = Bool(true);
  label1: ;
  return a5;
}

Any f_char2 ( Any a0, Any a1 ){
  Any a3 = Char('0');
  if ( dataAsInt( a0 ) > dataAsInt( a3 ) ) { goto label2; };
  Any a4 = Bool(false);
  goto label3;
  label2: ;
  a4 = Bool(true);
  label3: ;
  return a4;
}

Any f_char3 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) == dataAsInt( a1 ) ) { goto label4; };
  Any a4 = Bool(false);
  goto label5;
  label4: ;
  a4 = Bool(true);
  label5: ;
  return a4;
}

Any f_char4 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) != dataAsInt( a1 ) ) { goto label6; };
  Any a4 = Bool(false);
  goto label7;
  label6: ;
  a4 = Bool(true);
  label7: ;
  return a4;
}

Any f_char5 ( Any a0, Any a1 ){
  Any a3 = Char('0');
  if ( dataAsInt( a0 ) < dataAsInt( a3 ) ) { goto label8; };
  Any a4 = Bool(false);
  goto label9;
  label8: ;
  a4 = Bool(true);
  label9: ;
  return a4;
}

Any f_char6 ( Any a0, Any a1 ){
  Any a3 = Char('z');
  if ( dataAsInt( a0 ) < dataAsInt( a3 ) ) { goto label10; };
  Any a4 = Bool(false);
  goto label11;
  label10: ;
  a4 = Bool(true);
  label11: ;
  return a4;
}

Any f_char7 ( Any a0, Any a1 ){
  Any a3 = Char('z');
  if ( dataAsInt( a0 ) > dataAsInt( a3 ) ) { goto label12; };
  Any a4 = Bool(false);
  goto label13;
  label12: ;
  a4 = Bool(true);
  label13: ;
  return a4;
}

Any f_char8 ( Any a0, Any a1 ){
  Any a2 = Char('a');
  if ( dataAsInt( a2 ) >= dataAsInt( a0 ) ) { goto label14; };
  Any a5 = Char('z');
  if ( dataAsInt( a0 ) < dataAsInt( a5 ) ) { goto label15; };
  label14: ;
  Any a6 = Bool(false);
  goto label16;
  label15: ;
  a6 = Bool(true);
  label16: ;
  return a6;
}

Any f_char9 ( Any a0, Any a1 ){
  Any a3 = Char('0');
  if ( dataAsInt( a0 ) <= dataAsInt( a3 ) ) { goto label17; };
  Any a5 = Char('z');
  if ( dataAsInt( a0 ) >= dataAsInt( a5 ) ) { goto label17; };
  if ( dataAsInt( a0 ) < dataAsInt( a1 ) ) { goto label18; };
  label17: ;
  Any a8 = Bool(false);
  goto label19;
  label18: ;
  a8 = Bool(true);
  label19: ;
  return a8;
}

Any f_char10 ( Any a0, Any a1 ){
  Any a3 = Char('0');
  if ( dataAsInt( a0 ) <= dataAsInt( a3 ) ) { goto label20; };
  Any a5 = Char('z');
  if ( dataAsInt( a0 ) >= dataAsInt( a5 ) ) { goto label20; };
  if ( dataAsInt( a0 ) < dataAsInt( a1 ) ) { goto label21; };
  label20: ;
  Any a8 = Bool(false);
  goto label22;
  label21: ;
  a8 = Bool(true);
  label22: ;
  return a8;
}
