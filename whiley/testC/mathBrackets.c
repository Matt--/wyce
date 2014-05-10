#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any f_bracket1 ( Any , Any , Any );
Any f_bracket2 ( Any , Any , Any );
Any f_bracket3 ( Any , Any , Any );

int main (){
  Any a2 = Int(8);
  Any a4 = Int(2);
  Any a6 = Int(3);
  Any a8 = f_bracket1 ( a2, a4, a6 );
  Any a7 = a8;
  Any a15 = a7;
  println ( a15 );
  Any a16 = f_bracket2 ( a2, a4, a6 );
  a7 = a16;
  Any a23 = a7;
  println ( a23 );
  Any a24 = f_bracket3 ( a2, a4, a6 );
  a7 = a24;
  Any a31 = a7;
  println ( a31 );
  return 0;
}

Any f_bracket1 ( Any a0, Any a1, Any a2 ){
  Any a6 = add( a0 , a1);
  Any a8 = mul( a6 , a2);
  return a8;
}

Any f_bracket2 ( Any a0, Any a1, Any a2 ){
  Any a7 = add( a1 , a2);
  Any a8 = mul( a0 , a7);
  return a8;
}

Any f_bracket3 ( Any a0, Any a1, Any a2 ){
  Any a7 = add( a1 , a2);
  Any a8 = mul( a0 , a7);
  return a8;
}
