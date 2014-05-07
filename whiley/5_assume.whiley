// Whiley Language Spec -> 5_assume


method main(System.Console console):
  
  int x
  x = abs(5)
  console.out.println("returns => " ++ x)
  x = abs(0)
  console.out.println("returns => " ++ x)
  

function abs(int x) => (int y):
  assume x >= 0
  return x


