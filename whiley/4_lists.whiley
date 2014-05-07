// Whiley Language Spec -> lists


method main(System.Console console):
  
  [int] list1 = [1, 2, 3, 4]
  [int] list2 = [4, 3, 2, 1]
  [int] results = add(list1, list2)
  console.out.println("returns => " ++ results)

function add([int] v1, [int] v2) => ([int] v3):
  int i = 0
  while i < |v1|:
    v1[i] = v1[i] + v2[i]
    i = i + 1
  
  return v1

