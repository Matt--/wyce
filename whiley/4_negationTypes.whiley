// Whiley Language Spec -> negation types

method main(System.Console console):
  
  any result
  result = f(5)
  console.out.println("returns => " ++ result)
  result = f(null)
  console.out.println("returns => " ++ result)

function f(any item) => !null:
  if item is null:
    return 0
  else:
    return item

