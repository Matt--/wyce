// Whiley Language Spec -> method declarations, includes pointer

// Define the well-known concept of a linked list
type LinkedList is null | { &LinkedList next, int data }

method main(System.Console console):
    
    LinkedList list
    list = {next: null, data: 1}
    console.out.println("linked list => " ++ list)
    insertAfter(list, 1)
    console.out.println("linked list => " ++ list)
    console.out.println("linked list => " ++ list.data)

// Define a method which inserts a new item onto the end of the list
method insertAfter(&LinkedList list, int item):
    if *list is null:
        // reached the end of the list, so allocate new node
        *list = new { next: null, data: item }
    else:
        // continue traversing the list
        insertAfter(list->next, item)
