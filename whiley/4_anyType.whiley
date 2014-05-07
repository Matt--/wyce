// Whiley Language Spec -> anyType

method main(System.Console console):
    any x = 8.256
    console.out.println("any 8.256 => " ++ x) // 8.256
    int y = toInt(5)
    console.out.println("any 5 toInt => " ++ y) // 5 
    y = toInt(x)
    console.out.println("any 8.256 toInt => " ++ y) // 8 
    y = toInt("no")
    console.out.println("any \"no\" toInt => " ++ y) // 0
    y = toInt('c')
    console.out.println("any 'c' toInt => " ++ y) // 0

method toInt(any val) => int:
  if val is int:
    return val
  else if val is real:
    return Math.floor(val)
  else:
    return 0 // default value

