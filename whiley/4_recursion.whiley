// Whiley Language Spec -> recursion

method main(System.Console console):
    
    int r = fib(4, console)
    console.out.println("fibernachi => " ++ r) // comment this println out


// recursion
method fib(int x, System.Console console) => int:
  console.out.println(x)
  if x <= 1:
    return x
  else:
    return fib(x-1, console) + fib(x-2, console)

