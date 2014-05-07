// Whiley Language Spec -> 5_continue

// fails as continue statement is "unrecognised"

// consider extending to show use in do, for, while & switch


method main(System.Console console):
  
  int x
  x = sumNonNegative([3, 4, -5, 6])
  console.out.println("returns => " ++ x)
  

function sumNonNegative([int] xs) => int:
  int i = 0
  int r = 0
  for i in 0 .. |xs|:
    if xs[i] < 0:
      continue
    r = r + xs[i]
  return r

