#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
int f_add ( Any , Any );

int main (){
  Any a2 = Int(1);
  Any a4 = Int(3);
  Any a6 = Int(f_add ( a2, a4 ));
  Any a5 = a6;
  Any a12 = a5;
  println ( a12 );
  return 0;
}

int f_add ( Any a0, Any a1 ){
  Any a5 = add( a0 , a1);
  return a5.i;
}
