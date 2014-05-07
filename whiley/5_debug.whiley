// Whiley Language Spec -> 5_debug

method main(System.Console console):
  
  int x
  x = f(3)
  console.out.println("returns => " ++ x)
  

function f(int x) => int:
  debug "f(" ++ x ++ ") called\n"
  if x == 1 || x == 0:
    return x
  else:
    return f(x-1) + f(x-2)

