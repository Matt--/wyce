// Whiley Language Spec -> tuples

// TODO extend to do multiple swaps, in case memory locations are over-ridden.
// TODO extend to use other values, char, real, etc



method main(System.Console console):
    
    (int, int) x = (4, 5)
    console.out.println("tuple => " ++ x)
    x = swap(x)
    console.out.println("tuple swapped => " ++ x)


function swap((int, int) z) => (int,int):
    int x, int y = z    // tuple destructuring assignment
    return y, x

