// Whiley Language Spec -> bool type and Array use

method main(System.Console console):
    
    [int] list = [1, 2, 3, 4, 5, 6]
    bool b
    b = contains(list, 1)
    console.out.println("list contains 1 => " ++ b)
    
    b = contains(list, 6)
    console.out.println("list contains 6 => " ++ b)
    
    b = contains(list, 0)
    console.out.println("list contains 0 => " ++ b)
    
    b = contains(list, 7)
    console.out.println("list contains 7 => " ++ b)

function contains([int] list, int item) => bool:
  // examine every element of list
  for l in list:
    if l == item:
      return true
  // done
  return false

