// Whiley Language Spec -> 8_loopInvariant

method main(System.Console console):
  
  int x
  x = sum([3, 4, 5, 6])
  console.out.println("returns => " ++ x)
  

function sum([int] xs) => int:
  int r = 0
  int i = 0
  while i < |xs| where i >= 0:
    r = r + xs[i]
    i = i + 1
  return r

