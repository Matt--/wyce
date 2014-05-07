// Whiley Language Spec -> 5:blocks


method main(System.Console console):
  
  [int] list = [3, 4, 5, 6]
  any result = sum(list)
  console.out.println("returns => " ++ result)

function sum([int] items) => int:
  // outer block begins
  int r = 0
  int i = 0
  while i < |items|:
    // inner block begins
    r = r + items[i]
    i = i + 1
    // inner block ends
  return r
  // outer block ends

