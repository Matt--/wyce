#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any sum ( Any[] );

int main (){
  Any a3 = Int(3);
  Any a4 = Int(4);
  Any a5 = Int(5);
  Any a6 = Int(6);
  Any a7[] = {a3, a4, a5, a6};
  Any a2 = sum ( a7 );
  Any a1 = a2;
  Any a11 = Str("returns => ");
  Any a12 = a1;
  a12 = toStr ( a12 );
  Any a13 = Str( strcat ( a11.s , a12.s ) );
  println ( a13 );
  return;
}

Any sum ( Any a0[] ){
  Any a2 = Int(0);
  Any a1 = a2;
  Any a4 = Int(0);
  Any a3 = a4;
  label0: ;
  Any a7 = Int( sizeof( a0 ) );
