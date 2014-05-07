// Whiley Language Spec -> null and tree

type Tree is null | { int data, Tree left, Tree right }

method main(System.Console console):
    
    Tree tree = null
    console.out.println("tree height => " ++ height(tree))
    tree = {data: 1, left: null, right: null}
    console.out.println("tree height => " ++ height(tree))
    // height 3, right branch
    tree = {data: 1, left: null, right: {data: 2, left: null, right: {data: 3, left: null, right: null}}}
    console.out.println("tree height => " ++ height(tree))
    // height 5, left branch added to lvl 3
    tree = {data: 1, left: null, right: {data: 2, left: null, right: {data: 3, left: {data: 4, left: {data: 5, left: null, right: null}, right: null}, right: null}}}
    console.out.println("tree height => " ++ height(tree))


function height(Tree t) => int:
    if t is null:
        // height of empty tree is zero
        return 0
    else:
        // height is this node plus maximum height of subtrees
        return 1 + max(height(t.left), height(t.right))
        
function max(int x, int y) => int:
    if(x > y):
        return x
    return y
