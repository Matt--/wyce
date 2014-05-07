// Whiley Language Spec -> recursive types

type Node is { Tree left, Tree right, int data }
type Tree is null | Node

method main(System.Console console):
  
  Tree tree = null
  any result = sizeOf(tree)
  console.out.println("returns => " ++ result)
  
  tree = {left: null, right: null, data: 99}
  result = sizeOf(tree)
  console.out.println("returns => " ++ result)
  tree = {left: null, right: {left: null, right: {left: null, right: null, data: 99}, data: 99}, data: 99}
  result = sizeOf(tree)
  console.out.println("returns => " ++ result)

function sizeOf(Tree t) => int:
  if t == null:
    return 0
  else:
    return 1 + sizeOf(t.left) + sizeOf(t.right)

