#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any contains ( Any[] , Any , Any );

int main (){
  Any a2 = Int(1);
  Any a3 = Int(2);
  Any a4 = Int(3);
  Any a5 = Int(4);
  Any a6 = Int(5);
  Any a7 = Int(6);
  Any a8[] = {a2, a3, a4, a5, a6, a7};
  Any a13 = Int( sizeof( a8 ) / sizeof( a8[0] ) );
  Any a14 = Int(1);
  Any a10 = contains ( a8, a13, a14 );
  Any a9 = a10;
  Any a18 = Str("list contains 1 => ");
  Any a19 = a9;
  a19 = toStr ( a19 );
  Any a20 = Str( strcat ( a18.s , a19.s ) );
  println ( a20 );
  Any a24 = Int( sizeof( a8 ) / sizeof( a8[0] ) );
  Any a25 = Int(6);
  Any a21 = contains ( a8, a24, a25 );
  a9 = a21;
  Any a29 = Str("list contains 6 => ");
  Any a30 = a9;
  a30 = toStr ( a30 );
  Any a31 = Str( strcat ( a29.s , a30.s ) );
  println ( a31 );
  Any a35 = Int( sizeof( a8 ) / sizeof( a8[0] ) );
  Any a36 = Int(0);
  Any a32 = contains ( a8, a35, a36 );
  a9 = a32;
  Any a40 = Str("list contains 0 => ");
  Any a41 = a9;
  a41 = toStr ( a41 );
  Any a42 = Str( strcat ( a40.s , a41.s ) );
  println ( a42 );
  Any a46 = Int( sizeof( a8 ) / sizeof( a8[0] ) );
  Any a47 = Int(7);
  Any a43 = contains ( a8, a46, a47 );
  a9 = a43;
  Any a51 = Str("list contains 7 => ");
  Any a52 = a9;
  a52 = toStr ( a52 );
  Any a53 = Str( strcat ( a51.s , a52.s ) );
  println ( a53 );
  return 0;
}

Any contains ( Any a0[], Any arraySize, Any a2 ){
  int count = 0;
  loop_start_label0: ;
  if(count == arraySize.i ){ goto label0; }
  Any a4 = a0[count];
  count++;
  if ( dataAsInt( a4 ) != dataAsInt( a2 ) ) { goto label1; };
  Any a7 = Bool(true);
  return a7;
  label1: ;
  goto loop_start_label0;
  label0: ;
  Any a8 = Bool(false);
  return a8;
}
