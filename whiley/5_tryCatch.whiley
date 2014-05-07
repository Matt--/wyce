// Whiley Language Spec -> 5_tryCatch

// name not found: SyntaxError...

method main(System.Console console):
  int|string|null x
  x = parse("cat")
  console.out.println("returns => " ++ x)

function parse(string input) => int|string|null:
  try:
    if Char.isDigit(input[0]):
      // must be integer
      return Int.parse(input)
    else:
      // must be string
      return input
  catch(SyntaxError ex):
    // We can get here from Int.parse()
    return null
