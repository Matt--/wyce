


native method bMethod(int b, int c, int d) => int
native method nMethod(int b, int c, int d, int e) => void


export method stabilizerInit():
  int r = aMethod(654, 200, 0, 2)
//  bMethod(654, 200, 0)
//  int q = bMethod(654, 200, 0)


method aMethod(int b, int c, int d, int e) => int:
  int x = b
  return x
