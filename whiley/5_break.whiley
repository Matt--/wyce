// Whiley Language Spec -> 5_break

method main(System.Console console):
  
  [int] x
  x = remove([3, 4, 5, 6], 5)
  console.out.println("returns => " ++ x)
  

// Remove lowest element holding x from xs
function remove([int] xs, int x) => [int]:
  int i = 0
  while i < |xs|:
    if xs[i] == x:
      break
    else:
      i = i + 1
  return xs[0..i] ++ xs[i+1..]

