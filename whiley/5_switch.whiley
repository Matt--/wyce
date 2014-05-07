// Whiley Language Spec -> 5_switch

method main(System.Console console):
  int x
  x = legs("cat")
  console.out.println("returns => " ++ x)
  x = legs("stool")
  console.out.println("returns => " ++ x)
  x = legs("ladder")
  console.out.println("returns => " ++ x)

function legs(string legged) => (int y):
  switch(legged):
    case("cat"):
      return 4
    case("ladder"):
      return 2
    case("stool"):
      return 3
    default:
      return 0

