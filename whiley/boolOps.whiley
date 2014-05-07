method main(System.Console console):
    bool a = true
    bool b = false
    bool r
    r = f_bool1(a, b)
    console.out.println(r)
    console.out.println( f_bool2(a, b) )
    console.out.println( f_bool3(a, b) )
    console.out.println( f_bool4(a, b) )
    console.out.println( f_bool5(a, b) )
    console.out.println( f_bool6(a, b) )
    console.out.println( f_bool7(a, b) )
    console.out.println( f_bool8(a, b) )
    console.out.println( f_bool9(a, b) )
    console.out.println( "10" )
    console.out.println( f_bool10(a, b) )
    console.out.println( f_bool11(a, b) )
    console.out.println( f_bool12(a, b) )
    console.out.println( f_bool13(a, b) )
    console.out.println( f_bool14(a, b) )
    console.out.println( "15" )
    console.out.println( f_bool15(a, b) )
    console.out.println( f_bool16(a, b) )
    console.out.println( f_bool17(a, b) )
    console.out.println( f_bool18(a, b) )
    console.out.println( f_bool19(a, b) )
    console.out.println( "20" )
    console.out.println( f_bool20(a, b) )
    console.out.println( f_bool21(a, b) )
    console.out.println( f_bool22(a, b) )
    console.out.println( f_bool23(a, b) )
    console.out.println( f_bool24(a, b) )
    console.out.println( "25" )
    console.out.println( f_bool25(a, b) )
    

function f_bool1(bool x, bool y) => bool: // false
    bool r = x == y
    return r
// function repeated, assignment removed
function f_bool2(bool x, bool y) => bool: // false
    return x == y
function f_bool3(bool x, bool y) => bool: // true
    return x != y
function f_bool4(bool x, bool y) => bool: // true
    return x || y
function f_bool5(bool x, bool y) => bool: // false
    return x && y
function f_bool6(bool x, bool y) => bool: // true
    return x || x
function f_bool7(bool x, bool y) => bool: // true
    return x && x
function f_bool8(bool x, bool y) => bool: // false
    return y || y
function f_bool9(bool x, bool y) => bool: // false
    return y && y
    
function f_bool10(bool x, bool y) => bool: // true
    return x && x || y
function f_bool11(bool x, bool y) => bool: // false
    return y && x || y
function f_bool12(bool x, bool y) => bool: // true
    return x && y || x
function f_bool13(bool x, bool y) => bool: // false
    return y && y || x
function f_bool14(bool x, bool y) => bool: // true
    return (x && y) || x
    
function f_bool15(bool x, bool y) => bool: // true
    return x || y && x
function f_bool16(bool x, bool y) => bool: // true
    return y || x && x
function f_bool17(bool x, bool y) => bool: // true
    return (x || y) && x
function f_bool18(bool x, bool y) => bool: // false
    return (y || y) && x
function f_bool19(bool x, bool y) => bool: // true
    return x || x && y

function f_bool20(bool x, bool y) => bool: // false
    return y || x && y
function f_bool21(bool x, bool y) => bool: // true
    return x && (y || x)
function f_bool22(bool x, bool y) => bool: // false
    return y && (y || x)
function f_bool23(bool x, bool y) => bool: // true
    return x || (y && x)
function f_bool24(bool x, bool y) => bool: // true
    return (x || (y && x))
    
function f_bool25(bool x, bool y) => bool: // false
    return y || (y && x)

