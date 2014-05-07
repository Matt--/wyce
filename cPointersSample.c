#define LIBRARY_TESTING 0

#include "cCompiler/mattCompiler.h"
#include "cCompiler/mattCompiler_library.c"

Any jump(int x, int y, int z){
	Any a = Int(x);
	printf("a => %d\n", a.data.i);
	Any b = Int(y);
	printf("b => %d\n", b.data.i);
	Any c = Int(z);
	printf("c => %d\n", c.data.i);
	Any d = Tuple3(a, b, c);

	Any** f = d.data.ptr;
	printf("f => %d\n", f[0]->data.i);

	printf("d(a) => %d\n", ((Any**)d.data.ptr)[0]->data.i);
	return d;
}


Any swap ( Any );

int main (){
	Any d = jump(5, 6, 7);

	printf("%d, %d, %d\n", ((Any**)d.data.ptr)[0]->data.i, ((Any**)d.data.ptr)[1]->data.i, ((Any**)d.data.ptr)[2]->data.i);
}

