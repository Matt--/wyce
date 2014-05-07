#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define INT_TYPE 1

void println(void *);
int add(int, int);

union Data{
    int i;
		bool b;
    char c[20];
};
struct Any{
    int type;   
    union Data data;
};

int main()
{
    int x = 1;
    int y = 3;
    int r = add(x, y);

    struct Any a;
    a.type = INT_TYPE;
    a.data.i = r;

		void *b = &a; 
    println(b);
}

int add(int x, int y)
{
    int r = x + y;
    return r;
}

void println(void *a)
{
    printf("%d\n", (*(struct Any *)a).data.i);
}

