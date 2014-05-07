// Whiley Language Spec -> 5_for

// currently fails due to "for i, v..." bit

method main(System.Console console):
  
  int x
  x = max([3, 4, 5, 6])
  console.out.println("returns => " ++ x)
  

function max([int] items) => int:
  int r = items[0]
  for i,v in items:
    r = Math.max(r,v)
  return v

