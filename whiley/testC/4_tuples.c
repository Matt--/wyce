#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any swap ( Any );

int main (){
  Any a2 = Int(4);
  Any a3 = Int(5);
  Any a4 = Tuple( a2, a3);
  Any a1 = a4;
  Any a8 = Str("tuple => ");
  Any a9 = a1;
  a9 = toStr ( a9 );
  Any a10 = Str( strcat ( a8.s , a9.s ) );
  println ( a10 );
  Any a11 = swap ( a4 );
  a1 = a11;
  Any a16 = Str("tuple swapped => ");
  Any a17 = a1;
  a17 = toStr ( a17 );
  Any a18 = Str( strcat ( a16.s , a17.s ) );
  println ( a18 );
  return;
}

Any swap ( Any a0 ){
  Any a3 = Int( ((Any**)a0.ptr)[0]->i);
  Any a4 = Int( ((Any**)a0.ptr)[1]->i);
  Any a7 = Tuple( a4, a3);
  return a7;
}
