method main(System.Console console):
    char a = 'm'
    char b = 'n'
    char c = 'q'
    bool r
    r = f_char1(a, b)
    console.out.println(r)
    console.out.println( f_char2(a, b) )
    console.out.println( f_char3(a, b) )
    console.out.println( f_char4(a, b) )
    console.out.println( f_char5(a, b) )
    console.out.println( f_char6(a, b) )
    console.out.println( f_char7(a, b) )
    console.out.println( f_char8(a, b) )
    console.out.println( f_char9(a, b) )
    console.out.println( f_char10(a, b) )
   
//===//===//===//===//=== 
// TODO change '0' to 'a'

function f_char1(char x, char y) => bool: // true
    bool r = x > '0'
    return r
// function repeated, assignment removed
function f_char2(char x, char y) => bool: // true
    return x > '0'
function f_char3(char x, char y) => bool: // false
    return x == y
function f_char4(char x, char y) => bool: // true
    return x != y
function f_char5(char x, char y) => bool: // false
    return x < '0'
function f_char6(char x, char y) => bool: // true
    return x < 'z'
function f_char7(char x, char y) => bool: // false
    return x > 'z'
function f_char8(char x, char y) => bool: // true
    return 'a' < x && x < 'z'
function f_char9(char x, char y) => bool: // true
    return x > '0' && x < 'z' && x < y
function f_char10(char x, char y) => bool: // true
    return x > '0' && x < 'z' && x < y

