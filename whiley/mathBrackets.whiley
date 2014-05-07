import whiley.lang.System

method main(System.Console console):
    int a = 8
    int b = 2
    int c = 3
    int r = f_bracket1(a, b, c)
    console.out.println(r)
    r = f_bracket2(a, b, c)
    console.out.println(r)
    r = f_bracket3(a, b, c)
    console.out.println(r)

function f_bracket1(int x, int y, int c) => int:
    int r = (x + y) * c
    return r
function f_bracket2(int x, int y, int c) => int:
    int r = x * (y + c)
    return r
function f_bracket3(int x, int y, int c) => int:
    int r = (x * (y + c))
    return r

