// Whiley Get Started Guide -> prePostconditions

type nat is (int n) where n >= 0
type pos is (int p) where p > 0

method main(System.Console console):  
  nat x
  pos p
  p = 5
  x = f(p)
  console.out.println("returns => " ++ x)
  p = 1
  x = f(p)
  console.out.println("returns => " ++ x)

function f(pos x) => (nat n)
// Return must differ from parameter
ensures n != x:
  return x-1
