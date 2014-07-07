#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"

int main (){
  Any a2 = Int(3);
  Any a3 = Int(4);
  Any a4 = Int(5);
  Any a5[] = {a2, a3, a4};
  Any a10 = Int(0);
  Any a71 = Int(0);
  Any a72 = Int( sizeof( a5 ) / sizeof( a5[0] ) );
  Any a11 = a5[a10.i];
  println ( a11 );
  Any a16 = Int(1);
  a71 = Int(0);
  a72 = Int( sizeof( a5 ) / sizeof( a5[0] ) );
  Any a17 = a5[a16.i];
  println ( a17 );
  Any a22 = Int(2);
  a71 = Int(0);
  a72 = Int( sizeof( a5 ) / sizeof( a5[0] ) );
  Any a23 = a5[a22.i];
  println ( a23 );
  Any a26 = Int(0);
  a71 = Int(0);
  a72 = Int( sizeof( a5 ) / sizeof( a5[0] ) );
  Any a27 = a5[a26.i];
  Any a29 = Int(2);
  a71 = Int(0);
  a72 = Int( sizeof( a5 ) / sizeof( a5[0] ) );
  Any a30 = a5[a29.i];
  Any a31 = add( a27 , a30);
  Any a24 = a31;
  Any a35 = a24;
  println ( a35 );
  Any a37 = Real(11.0);
  Any a38 = Real(11.5);
  Any a39 = Real(24.9067);
  Any a40[] = {a37, a38, a39};
  Any a45 = Int(0);
  a71 = Int(0);
  a72 = Int( sizeof( a40 ) / sizeof( a40[0] ) );
  Any a46 = a40[a45.i];
  println ( a46 );
  Any a51 = Int(1);
  a71 = Int(0);
  a72 = Int( sizeof( a40 ) / sizeof( a40[0] ) );
  Any a52 = a40[a51.i];
  println ( a52 );
  Any a57 = Int(2);
  a71 = Int(0);
  a72 = Int( sizeof( a40 ) / sizeof( a40[0] ) );
  Any a58 = a40[a57.i];
  println ( a58 );
  Any a61 = Int(0);
  a71 = Int(0);
  a72 = Int( sizeof( a40 ) / sizeof( a40[0] ) );
  Any a62 = a40[a61.i];
  Any a64 = Int(2);
  a71 = Int(0);
  a72 = Int( sizeof( a40 ) / sizeof( a40[0] ) );
  Any a65 = a40[a64.i];
  Any a66 = add( a62 , a65);
  Any a59 = a66;
  Any a70 = a59;
  println ( a70 );
  return 0;
}
