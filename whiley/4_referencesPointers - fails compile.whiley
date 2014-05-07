// Whiley Language Spec -> references - fails compile


method main(System.Console console):
    
    int x = 1
    int y = 2
//    console.out.println("x, y => " ++ x ++", "++y)
//    swap(x, y)
//    console.out.println("x, y => " ++ x ++", "++y)


method swap(&int pX, &int pY):
  int tmp = *pX
//  *pX = *pY      // uncomment this assignment and you get an internal failure error 
//  *pY = tmp

