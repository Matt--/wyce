import whiley.lang.System

method main(System.Console console):
    int a = 8
    int b = 2
    int c = 8
    bool r = f_compare1(a, b)
    console.out.println(r)
    r = f_compare2(a, b)
    console.out.println(r)
    r = f_compare3(a, b)
    console.out.println(r)
    r = f_compare4(a, b)
    console.out.println(r)
    r = f_compare5(a, b)
    console.out.println(r)
    r = f_compare6(a, b)
    console.out.println(r)
    r = f_compare7(a, b, c)
    console.out.println(r)
    r = f_compare8(a, b, c)
    console.out.println(r)

function f_compare1(int x, int y) => bool: // true
    bool r = x > y
    return r
function f_compare2(int x, int y) => bool: // false
    bool r = x < y
    return r
function f_compare3(int x, int y) => bool: // true
    bool r = x >= y
    return r
function f_compare4(int x, int y) => bool: // false
    bool r = x <= y
    return r
function f_compare5(int x, int y) => bool: // false
    bool r = x == y
    return r
function f_compare6(int x, int y) => bool: // true
    bool r = x != y
    return r
function f_compare7(int x, int y, int z) => bool: // true
    bool r = x == z
    return r
function f_compare8(int x, int y, int z) => bool: // false
    bool r = x != z
    return r

