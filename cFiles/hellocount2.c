#define LIBRARY_TESTING 0

#include "mattCompiler.h"
#include "mattCompiler_library.c"

Any f_add(Any a, Any b);

int main()
{
    Any x = Int(1);
    Any y = Int(3);
    Any r = f_add(x, y);

    println(r);
}

Any f_add(Any a, Any b)
{
    return Int(a.data.i + b.data.i);
} 


