#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
int f_add ( Any , Any );
int f_subtract ( Any , Any );
int f_multiply ( Any , Any );
int f_divide ( Any , Any );

int main (){
  Any a2 = Int(8);
  Any a4 = Int(2);
  Any a6 = Int(f_add ( a2, a4 ));
  Any a5 = a6;
  Any a12 = a5;
  println ( a12 );
  Any a14 = Int(f_subtract ( a2, a4 ));
  Any a13 = a14;
  Any a20 = a13;
  println ( a20 );
  Any a22 = Int(f_multiply ( a2, a4 ));
  Any a21 = a22;
  Any a28 = a21;
  println ( a28 );
  Any a30 = Int(f_divide ( a2, a4 ));
  Any a29 = a30;
  Any a36 = a29;
  println ( a36 );
  return 0;
}

int f_add ( Any a0, Any a1 ){
  Any a5 = add( a0 , a1);
  return a5.i;
}

int f_subtract ( Any a0, Any a1 ){
  Any a5 = sub( a0 , a1);
  return a5.i;
}

int f_multiply ( Any a0, Any a1 ){
  Any a5 = mul( a0 , a1);
  return a5.i;
}

int f_divide ( Any a0, Any a1 ){
  Any a7 = Int(0);
  Any a5 = div_wyce( a0 , a1);
  return a5.i;
}
