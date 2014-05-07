// Whiley Get Started Guide pg12 -> coercions

type Link is {int data, LinkedList next}
type LinkedList is null | Link
type OrderedList is null | {
  int data, int order, OrderedList next
  }

method main(System.Console console):
  
  console.out.println("returns => " ++ 5)

function sum(LinkedList l) => int:
  if l is null:
    return 0
  else:
    return l.data + sum(l.next)

function sum2(OrderedList l) => int:
  return sum((LinkedList) l)
