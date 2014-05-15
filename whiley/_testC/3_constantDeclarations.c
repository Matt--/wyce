#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
const int anInt = 42 ;
const char aChar = 'c' ;
const char* aString = "hello" ;
const bool aBool = true ;
const double PI = 3.141592654 ;
const double TWO_PI = 6.2831853080 ;


int main (){
  Any a4 = Str("anInt => ");
  Any a5 = Str("42");
  Any a6 = Str( strcat ( a4.s , a5.s ) );
  println ( a6 );
  Any a10 = Str("aChar => ");
  Any a11 = Char('c');
  Any charNowStr = toStr(a11);
  Any a12 = Str( strcat ( a10.s , charNowStr.s ) );
  println ( a12 );
  Any a16 = Str("aString => ");
  Any a17 = Str("hello");
  Any a18 = Str( strcat ( a16.s , a17.s ) );
  println ( a18 );
  Any a22 = Str("aBool => ");
  Any a23 = Str("true");
  Any a24 = Str( strcat ( a22.s , a23.s ) );
  println ( a24 );
  Any a28 = Str("PI real => ");
  Any a29 = Str("3.141592654");
  Any a30 = Str( strcat ( a28.s , a29.s ) );
  println ( a30 );
  Any a34 = Str("TWO_PI, PI * 2 => ");
  Any a35 = Str("6.2831853080");
  Any a36 = Str( strcat ( a34.s , a35.s ) );
  println ( a36 );
  return 0;
}
