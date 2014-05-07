// Whiley Get Started Guide -> prePostconditions

method main(System.Console console):  
  int x
  x = decrement(5)
  console.out.println("returns => " ++ x)
  x = decrement(1)
  console.out.println("returns => " ++ x)

function decrement(int x) => (int y)
// Parameter x must be greater than zero
requires x > 0 && x <= 5
// Return must be greater or equal to zero
ensures y >= 0 && y < 5:
  return x - 1
