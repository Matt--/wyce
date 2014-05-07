// Whiley Language Spec -> 3_Names
// type and function share a name

type Point is { int x, int y }
constant Origin is { x: 0, y: 0 }

method main(System.Console console):
    Point point

    point = Origin
    console.out.println("point => " ++ point)
    console.out.println("point => " ++ point.x)

    point = f(4,5 )
    console.out.println("point => " ++ point)
    console.out.println("point => " ++ point.x)
    
    point = Point(8,3 )
    console.out.println("point => " ++ point)
    console.out.println("point => " ++ point.x)


function f(int x, int y) => Point:
    return {x: x, y: y}
    
function Point(int x, int y) => Point:
    return {x: x, y: y}
