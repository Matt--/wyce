// Whiley Language Spec -> function declarations

method main(System.Console console):
    
    int x
    x = lessThan(4,6)
    console.out.println("lessThan {4, 6} => " ++ x)
    x = max(5,7)
    console.out.println("max {5, 7} => " ++ x)
    x = max(7,5)
    console.out.println("max {7, 5} => " ++ x)

function lessThan(int x, int y) => int
ensures x < 5:									// FIXME
    return x

function max(int x, int y) => (int z)
// return must be greater than either parameter
ensures x <= z && y <= z
// return must equal one of the parmaeters
ensures x == z || y == z:
// implementation
    if x > y:
        return x
    else:
        return y
