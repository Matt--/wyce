// Whiley Language Spec -> type declarations


// Define the type of natural numbers
// where clause is a boolean AND IGNORED IN wyce COMPILER
// as the checks will have been completed in the wyc compiler, 
// getting to bytecode
type nat is (int x) where x >= 0

type clamp is (int x) where (x >= 0 && x <= 5)

// Define a simple point type
type Point is { int x, int y }

method main(System.Console console):
    Point point
    point = f(6,8)
    console.out.println("point => " ++ point)
    console.out.println("point => " ++ point.x)

    // point = c(6,8) throws an error
    point = c(3,5)
    console.out.println("point => " ++ point)
    console.out.println("point => " ++ point.x)


function f(nat x, nat y) => Point:
    return {x: x, y: y}
    
function c(clamp x, clamp y) => Point:
    return {x: x, y: y}

