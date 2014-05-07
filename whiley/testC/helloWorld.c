#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"

int main (){
  Any a4 = Str("Hello World");
  println ( a4 );
  return;
}
