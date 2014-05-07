// Whiley Get Started Guide -> subtyping

// A circle is defined by its position and radius
type Circle is { int x, int y, int radius }
// A rectangle is defined by its position and dimensions
type Rectangle is { int x, int y, int width, int height }
// A shape is either a circle or a rectangle
type Shape is Circle | Rectangle

method main(System.Console console):  
  Circle c = {x: 3, y: 4, radius: 5}
  Rectangle r = {x: 3, y: 4, width: 4, height: 6}
  
  Shape s
  real x
  s = c
  x = area(s)
  console.out.println("returns => " ++ x)
  s = r
  x = area(s)
  console.out.println("returns => " ++ x)


// Determine the area of a shape
function area(Shape s) => real:
  if s is Rectangle:
    // case for rectangle
    return s.width * s.height
  else:
    // case for circle
    return 3.14 * s.radius * s.radius
