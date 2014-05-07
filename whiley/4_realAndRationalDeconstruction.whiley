// Whiley Language Spec -> real and rational deconstruction assignment

method main(System.Console console):
    
    real x = 8.256
    console.out.println("real 8.256 => " ++ x)
    real y = 1.2
    real z
    z = x + y
    console.out.println("real 8.256 + 1.2 => " ++ z)
    z = x - y
    console.out.println("real 8.256 - 1.2 => " ++ z)
    z = x * y
    console.out.println("real 8.256 * 1.2 => " ++ z)
    z = x / y
    console.out.println("real 8.256 / 1.2 => " ++ z)
    console.out.println(" ==> next one appears to ignore the bodmas rule?")
    z = x * x - y
    console.out.println("real 8.256 * 8.256 - 1.2 => " ++ z)
    z = (x * x) - y
    console.out.println("real (8.256 * 8.256) - 1.2 => " ++ z)
    z = x * (x - y)
    console.out.println("real 8.256 * (8.256 - 1.2) => " ++ z)
    
    int r = floor(6.2)
    console.out.println("floor of 6.2 => " ++ r)


function floor(real x) => int:
  int num / int den = x // extract numerator and denominator
  int r = num / den // integer division
  if x < 0.0 && den != 1:
    return r - 1
  else:
    return r

