#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any f_string1 ( Any , Any );
Any f_string2 ( Any , Any );

int main (){
  Any a2 = Str("first ");
  Any a4 = Str("next ");
  Any a8 = f_string1 ( a2, a4 );
  Any a7 = a8;
  Any a14 = a7;
  println ( a14 );
  Any a15 = f_string2 ( a2, a4 );
  a7 = a15;
  Any a21 = a7;
  println ( a21 );
  return;
}

Any f_string1 ( Any a0, Any a1 ){
  Any a5 = Str( strcat ( a0.s , a1.s ) );
  return a5;
}

Any f_string2 ( Any a0, Any a1 ){
  Any a4 = Str("inserted ");
  Any a5 = Str( strcat ( a0.s , a4.s ) );
  Any a7 = Str( strcat ( a5.s , a1.s ) );
  return a7;
}
