// Whiley Language Spec -> function method types and assignment

type Fun is function(int) => int

method main(System.Console console):
  
  // how do you assign a function ???
  [int] items = [5, 6, 7, 8]
  [int] results = map(items, fn)
  console.out.println("returns => " ++ results)

function map([int] items, Fun fn) => [int]:
  for i in items:
    items[i] = fn(i)
  return items

