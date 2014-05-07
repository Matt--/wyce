// Whiley Language Spec -> 5_throws

// infinate loop, not sure why...

method main(System.Console console):
  int|string|null x
  x = parse(2, "cat")
  console.out.println("returns => " ++ x)

function parseInt(int pos, string input) => (int,int)
// Throws a syntax error if the string is malformed
throws SyntaxError:
  int start = pos
  // check for negative input
  if pos < |input| && input[pos] == ’-’:
    pos = pos + 1
    // match remainder
  while pos < |input| && Char.isDigit(input[pos]):
    pos = pos + 1
    // check for error
  if pos == start:
    throw SyntaxError("Missing number",start,pos)
  // done
  return Int.parse(input[start..pos]),pos
