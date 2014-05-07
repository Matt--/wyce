// Whiley Language Spec -> 5_skip

method main(System.Console console):
  
  int x
  x = abs(5)
  console.out.println("returns => " ++ x)
  x = abs(-5)
  console.out.println("returns => " ++ x)

function abs(int x) => (int y):
  if x >= 0:
    skip
  else:
    x = -x
  return x

