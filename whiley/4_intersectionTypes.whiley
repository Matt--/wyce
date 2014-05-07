// Whiley Language Spec -> intersection types

type Reader is {
method read(int) => [byte],
...
}
type Writer is {
method write([byte]) => int,
...
}
type ReaderWriter is Reader & Writer

// internal failure -> not supported yet

method main(System.Console console):
  


