import whiley.lang.System

method main(System.Console console):
    string a = "first "
    string b = "next "
    string c = "last "
    string r
    r = f_string1(a, b)
    console.out.println(r)
    r = f_string2(a, b)
    console.out.println(r)

function f_string1(string x, string y) => string:
    string r = x ++ y
    return r
function f_string2(string x, string y) => string:
    string r = x ++ "inserted "++ y
    return r

