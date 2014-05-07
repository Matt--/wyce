// Whiley Language Spec -> 5_assert


method main(System.Console console):
  
  any result
  result = abs(5)
  console.out.println("returns => " ++ result)
  result = abs(-5)
  console.out.println("returns => " ++ result)
  result = abs(0)
  console.out.println("returns => " ++ result)

function abs(int x) => int:
  if x < 0:
    x = -x
  assert x >= 0
  return x

