#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
Any id ( Any );
Any id2 ( Any );
Any id3 ( Any );

int main (){
  Any a4 = Str("id take null => ");
  Any a6 = Null();
  
  Any a5 = id ( a6 );
  a5 = toStr ( a5 );
  Any a7 = Str( strcat ( a4.s , a5.s ) );
  println ( a7 );
  Any a11 = Str("id take int => ");
  Any a13 = Int(42);
  
  Any a12 = id ( a13 );
  a12 = toStr ( a12 );
  Any a14 = Str( strcat ( a11.s , a12.s ) );
  println ( a14 );
  Any a18 = Str("id2 take char => ");
  Any a20 = Char('c');
  
  Any a19 = id2 ( a20 );
  a19 = toStr ( a19 );
  Any a21 = Str( strcat ( a18.s , a19.s ) );
  println ( a21 );
  Any a25 = Str("id2 take int => ");
  Any a27 = Int(42);
  
  Any a26 = id2 ( a27 );
  a26 = toStr ( a26 );
  Any a28 = Str( strcat ( a25.s , a26.s ) );
  println ( a28 );
  Any a32 = Str("id3 take char => ");
  Any a34 = Char('c');
  
  Any a33 = id3 ( a34 );
  a33 = toStr ( a33 );
  Any a35 = Str( strcat ( a32.s , a33.s ) );
  println ( a35 );
  Any a39 = Str("id3 take int => ");
  Any a41 = Bool(true);
  
  Any a40 = id3 ( a41 );
  a40 = toStr ( a40 );
  Any a42 = Str( strcat ( a39.s , a40.s ) );
  println ( a42 );
  return 0;
}

Any id ( Any a0 ){
  return a0;
}

Any id2 ( Any a0 ){
  return a0;
}

Any id3 ( Any a0 ){
  return a0;
}
