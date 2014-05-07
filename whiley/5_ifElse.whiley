// Whiley Language Spec -> 5_ifElse

method main(System.Console console):
  
  int x
  x = max(4, 6)
  console.out.println("returns => " ++ x)
  x = max(7, 7)
  console.out.println("returns => " ++ x)
  x = max(6, 4)
  console.out.println("returns => " ++ x)
  

function max(int x, int y) => int:
  if(x > y):
    return x
  else if(x == y):
    return 0
  else:
    return y

