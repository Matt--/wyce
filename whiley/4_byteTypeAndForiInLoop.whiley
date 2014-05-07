// Whiley Language Spec -> byte type and for_i_in loop


// TODO rewrite to remove (or seperate out) the byte operations.
// have replaced toString as it is a java concept, with byteString

method main(System.Console console):    
    byte b
    b = 10111b
    console.out.println("byte 10111b => " ++ byteString(b))

// convert a byte into a string
function byteString(byte b) => string:
  string r = "b"
  for i in 0..8:
    if (b & 00000001b) == 00000001b:
      r = "1" ++ r
    else:
      r = "0" ++ r
    b = b >> 1
  return r

