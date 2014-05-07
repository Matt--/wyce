// Whiley Language Spec -> union types

// TODO move this to typeUnion, its confusing as a seperate test!!!


method main(System.Console console):

  [int] list = [3, 4, 5, 6]
  int|null result
  // tests
  result = indexOf(list, 3)
  console.out.println("returns => " ++ result)
  result = indexOf(list, 6)
  console.out.println("returns => " ++ result)
  result = indexOf(list, 7)
  console.out.println("returns => " ++ result)

// Return lowest index of matching item, or null if none
function indexOf([int] items, int value) => int|null:
  int i = 0
  for v in items:
    if v == value:
      // match
      return i
    i = i + 1
  // item not found
  return null

