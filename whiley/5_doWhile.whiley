// Whiley Language Spec -> 5_doWhile

method main(System.Console console):
  
  int x
  x = sum([3, 4, 5, 6])
  console.out.println("returns => " ++ x)
  

function sum([int] xs) => int:
  int r = 0
  int i = 0
  do:
    r = r + xs[i]
    i = i + 1
  while i < |xs|
  return r

