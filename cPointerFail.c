#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"
//Any swap ( Any );

int main (){
  Any a2 = Int(4);
  Any a3 = Int(5);
  Any a4 = Tuple( a2, a3);
//  Any a1 = a4;
//  Any a8 = Str("tuple => ");
//  Any a9 = a1;


//  printf("   => here a4 (%d, %d)\n", ((Any**)a4.ptr)[0]->i, ((Any**)a4.ptr)[1]->i );
//  printf("   => here a9 (%d, %d)\n", ((Any**)a9.ptr)[0]->i, ((Any**)a9.ptr)[1]->i );

  	printf("\n\n");
	Any* x_address = ((Any**)a4.ptr)[0];
		printf ("x address is %d\n", x_address);
		printf ("x is %d\n", x_address->i);
//	int y = ((Any**)a9.ptr)[1]->i;
//		printf ("y is %d\n", y);
//	printf("type is : %d\n", a9.type);
//	printf("ptr size is : %d\n", sizeof(a9.ptr));

  printf("-----enter method-----\n");
  Any a99 = toStr ( a4 );
  printf("-----exit method-----\n");


//  printf("   => here a4 (%d, %d)\n", ((Any**)a4.ptr)[0]->i, ((Any**)a4.ptr)[1]->i );
//  printf("   => here a9 %s\n", a9.s);

//  Any a10 = Str( strcat ( a8.s , a9.s ) );
//  println ( a10 );
//
//
//  Any a11 = swap ( a4 );
//  a1 = a11;
//  Any a16 = Str("tuple swapped => ");
//  Any a17 = a1;
//  a17 = toStr ( a17 );
//  Any a18 = Str( strcat ( a16.s , a17.s ) );
//  println ( a18 );
  return;
}

