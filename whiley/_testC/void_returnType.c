#define LIBRARY_TESTING true

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
void meth ( Any );

int main (){
  Any a2 = Str("Hello World");
  Any a1 = a2;
  Any a3 = a1;
  meth ( a3 );
  Any a7 = a1;
  println ( a7 );
  return 0;
}

void meth ( Any a0 ){
}
