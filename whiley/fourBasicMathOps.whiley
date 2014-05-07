import whiley.lang.System

method main(System.Console console):
    int a = 8
    int b = 2
    int r = f_add(a, b)
    console.out.println(r)
    int s = f_subtract(a, b)
    console.out.println(s)
    int t = f_multiply(a, b)
    console.out.println(t)
    int p = f_divide(a, b)
    console.out.println(p)

function f_add(int x, int y) => int:
    int r = x + y
    return r
    
function f_subtract(int x, int y) => int:
    int r = x - y
    return r
    
function f_multiply(int x, int y) => int:
    int r = x * y
    return r
    
function f_divide(int x, int y) => int:
    int r = x / y
    return r

