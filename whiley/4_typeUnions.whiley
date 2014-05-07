// Whiley Language Spec -> types overview


method main(System.Console console):
    
    console.out.println("id take null => " ++ id(null))
    console.out.println("id take int => " ++  id(42))
    
    console.out.println("id2 take char => " ++ id2('c'))
    console.out.println("id2 take int => " ++  id2(42))
    
    console.out.println("id3 take char => " ++ id3('c'))
    console.out.println("id3 take int => " ++  id3(true))


function id(null|int x) => int|null:
    return x

function id2(char|int x) => int|char:
    return x

function id3(char|bool x) => char|bool:
    return x
