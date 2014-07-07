#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
bool f_compare1 ( Any , Any );
bool f_compare2 ( Any , Any );
bool f_compare3 ( Any , Any );
bool f_compare4 ( Any , Any );
bool f_compare5 ( Any , Any );
bool f_compare6 ( Any , Any );
bool f_compare7 ( Any , Any , Any );
bool f_compare8 ( Any , Any , Any );

int main (){
  Any a2 = Int(8);
  Any a4 = Int(2);
  Any a6 = Int(8);
  Any a8 = Bool(f_compare1 ( a2, a4 ));
  Any a7 = a8;
  Any a14 = a7;
  println ( a14 );
  Any a15 = Bool(f_compare2 ( a2, a4 ));
  a7 = a15;
  Any a21 = a7;
  println ( a21 );
  Any a22 = Bool(f_compare3 ( a2, a4 ));
  a7 = a22;
  Any a28 = a7;
  println ( a28 );
  Any a29 = Bool(f_compare4 ( a2, a4 ));
  a7 = a29;
  Any a35 = a7;
  println ( a35 );
  Any a36 = Bool(f_compare5 ( a2, a4 ));
  a7 = a36;
  Any a42 = a7;
  println ( a42 );
  Any a43 = Bool(f_compare6 ( a2, a4 ));
  a7 = a43;
  Any a49 = a7;
  println ( a49 );
  Any a50 = Bool(f_compare7 ( a2, a4, a6 ));
  a7 = a50;
  Any a57 = a7;
  println ( a57 );
  Any a58 = Bool(f_compare8 ( a2, a4, a6 ));
  a7 = a58;
  Any a65 = a7;
  println ( a65 );
  return 0;
}

bool f_compare1 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) > dataAsInt( a1 ) ) { goto label0; };
  Any a5 = Bool(false);
  goto label1;
  label0: ;
  a5 = Bool(true);
  label1: ;
  return a5.b;
}

bool f_compare2 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) < dataAsInt( a1 ) ) { goto label2; };
  Any a5 = Bool(false);
  goto label3;
  label2: ;
  a5 = Bool(true);
  label3: ;
  return a5.b;
}

bool f_compare3 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) >= dataAsInt( a1 ) ) { goto label4; };
  Any a5 = Bool(false);
  goto label5;
  label4: ;
  a5 = Bool(true);
  label5: ;
  return a5.b;
}

bool f_compare4 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) <= dataAsInt( a1 ) ) { goto label6; };
  Any a5 = Bool(false);
  goto label7;
  label6: ;
  a5 = Bool(true);
  label7: ;
  return a5.b;
}

bool f_compare5 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) == dataAsInt( a1 ) ) { goto label8; };
  Any a5 = Bool(false);
  goto label9;
  label8: ;
  a5 = Bool(true);
  label9: ;
  return a5.b;
}

bool f_compare6 ( Any a0, Any a1 ){
  if ( dataAsInt( a0 ) != dataAsInt( a1 ) ) { goto label10; };
  Any a5 = Bool(false);
  goto label11;
  label10: ;
  a5 = Bool(true);
  label11: ;
  return a5.b;
}

bool f_compare7 ( Any a0, Any a1, Any a2 ){
  if ( dataAsInt( a0 ) == dataAsInt( a2 ) ) { goto label12; };
  Any a6 = Bool(false);
  goto label13;
  label12: ;
  a6 = Bool(true);
  label13: ;
  return a6.b;
}

bool f_compare8 ( Any a0, Any a1, Any a2 ){
  if ( dataAsInt( a0 ) != dataAsInt( a2 ) ) { goto label14; };
  Any a6 = Bool(false);
  goto label15;
  label14: ;
  a6 = Bool(true);
  label15: ;
  return a6.b;
}
