// Whiley Language Spec -> 5_assignment


method main(System.Console console):
  
  int y = 5
  int x
  x = y // variable assignment
  console.out.println("returns => " ++ x)
  {int f, int g} x1 = {f: 0, g: 0}
  x1.f = y // field assignment
  console.out.println("returns => " ++ x1.f)
  [int] x2 = [0, 0, 0, 0]
  x2[2] = y // list assignment
  console.out.println("returns => " ++ x2[2])
  [{int f, int g}] x3 = [{f: 0, g: 0}, {f: 0, g: 0}, {f: 0, g: 0}, {f: 0, g: 0}]
  x3[1].f = y // compound assignment
  console.out.println("returns => " ++ x3[1].f)


