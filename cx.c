// HEADER
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define INT_TYPE 1
#define STR_TYPE 4
#define TUPLE_TYPE 7
#define MAXCHAR 40

typedef struct {
    int type;
    union{
    	int i;
    	char s[MAXCHAR+1];
    	void *ptr;
    };
} Any;

Any Int(int);
Any Str(char*);
Any Tuple(Any, Any);
void toStr(Any);
// end HEADER


int main (){
  Any a2, a3, a4;
	a2 = Int(4);
  a3 = Int(5);
  a4 = Tuple( a2, a3);

	// current state of a2, pointed to by a4.ptr[0]
 	printf("\n\n");
	Any* x_address = ((Any**)a4.ptr)[0];
		printf ("x address is %d\n", x_address);
		printf ("x is %d\n", x_address->i);

	//==========================================
	// the method pass
	//==========================================
  printf("-----enter method-----\n");
  toStr ( a4 );
  printf("\n\n\n");

  return;
}

//==============================================
// method being passed to
// =============================================
void toStr(Any a){
	Any* x_address = ((Any**)a.ptr)[0];
		printf ("x address is %d\n", x_address);
		printf ("x is %d\n", x_address->i);
}

//=============================================
// Constructors
//=============================================
Any Int(int i)
{
	Any a;
	a.i = i;
	a.type = INT_TYPE;
	return a;
}

Any Str(char* s)
{
	Any a;
	strcpy(a.s, s);
	a.type = STR_TYPE;
	return a;
}

Any Tuple(Any a, Any b)
{
	Any d;
	d.type = TUPLE_TYPE;
	d.ptr = malloc( sizeof(d.ptr) * 2 );
	Any** any = (Any**)d.ptr;
	static Any x; x = a;
	static Any y; y = b;
	any[0] = &x;
	any[1] = &y;
	return d;
}

