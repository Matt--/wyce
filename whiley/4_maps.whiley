// Whiley Language Spec -> records - fails compile

type Writer is {
method write([byte]) => int,
...
}
type PrintWriter is {
method write([byte]) => int,
method println(string) => void,
...
}

method main(System.Console console):
    
    (int, int) x = (4, 5)
    console.out.println("tuple => " ++ x)

// Create print writer if not already one
function create(Writer writer) => PrintWriter:
  if writer is PrintWriter:
    return writer
  else:
    return {method(string) => void println, writer.write}//, } 

