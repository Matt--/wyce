// Whiley Language Spec -> constant declarations

/*
 *  Ques: is this functionality needed in the wyce, after passing through Whiley to bite code?
 *  It seems (& seems logical that) constant values replace the variable names during wyc.
 *  making constants redundent for wyce
 */

// just an int
constant anInt is 42
constant aChar is 'c'
constant aString is "hello"
constant aBool is true
// Define the well-known mathematical constant to 10 decimal places.
constant PI is 3.141592654
// Define a constant expression which is twice PI
constant TWO_PI is PI * 2.0

method main(System.Console console):

    console.out.println("anInt => " ++ anInt)
    console.out.println("aChar => " ++ aChar)
    console.out.println("aString => " ++ aString)
    console.out.println("aBool => " ++ aBool)
    
    console.out.println("PI real => " ++ PI)
    console.out.println("TWO_PI, PI * 2 => " ++ TWO_PI)


