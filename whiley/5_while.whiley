// Whiley Language Spec -> 5_while

method main(System.Console console):
  
  int x
  x = sum([3, 4, 5, 6])
  console.out.println("returns => " ++ x)
  

function sum([int] xs) => int:
  int r = 0
  int i = 0
  while i < |xs|:
    r = r + xs[i]
    i = i + 1
  return r

