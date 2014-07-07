import whiley.lang.System

method main(System.Console console):
  string s = "Hello World"
  meth(s)
  console.out.println( s )

method meth(string s) => void:
  s = "does nothing."