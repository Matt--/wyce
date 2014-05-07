#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any contains ( Any[] , Any );

int main (){
  Any a2 = Int(1);
  Any a3 = Int(2);
  Any a4 = Int(3);
  Any a5 = Int(4);
  Any a6 = Int(5);
  Any a7 = Int(6);
  Any a8[] = {a2, a3, a4, a5, a6, a7};
  Any a12 = Int(1);
  Any a10 = contains ( a8, a12 );
  Any a9 = a10;
  Any a16 = Str("list conatains 1 => ");
  Any a17 = a9;
  a17 = toStr ( a17 );
  Any a18 = Str( strcat ( a16.s , a17.s ) );
  println ( a18 );
  Any a21 = Int(6);
  Any a19 = contains ( a8, a21 );
  a9 = a19;
  Any a25 = Str("list conatains 6 => ");
  Any a26 = a9;
  a26 = toStr ( a26 );
  Any a27 = Str( strcat ( a25.s , a26.s ) );
  println ( a27 );
  Any a30 = Int(0);
  Any a28 = contains ( a8, a30 );
  a9 = a28;
  Any a34 = Str("list conatains 0 => ");
  Any a35 = a9;
  a35 = toStr ( a35 );
  Any a36 = Str( strcat ( a34.s , a35.s ) );
  println ( a36 );
  Any a39 = Int(7);
  Any a37 = contains ( a8, a39 );
  a9 = a37;
  Any a43 = Str("list conatains 7 => ");
  Any a44 = a9;
  a44 = toStr ( a44 );
  Any a45 = Str( strcat ( a43.s , a44.s ) );
  println ( a45 );
  return;
}

Any contains ( Any a0[], Any a1 ){
  int count = 0;
  label0: ;
  if(count == sizeof(a0)-1 ){ goto labelEnd; }
  Any a3 = a0[count];
  count++;
  if ( dataAsInt( a3 ) != dataAsInt( a1 ) ) { goto label1; };
  Any a6 = Bool(true);
  return a6;
  label1: ;
  goto label0;
  labelEnd: ;
  Any a7 = Bool(false);
  return a7;
}
