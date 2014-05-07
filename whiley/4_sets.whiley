// Whiley Language Spec -> sets

// Adjacency list representation
type Graph is ([{int}] es)

method main(System.Console console):
    
    Graph graph = [{0, 2, 3}, {0, 4}, {0, 2}, {1}, {}]
    {int} visited = depthFirstSearch(console, 3, graph, {-1})
    console.out.println("returns => " ++ visited)

function depthFirstSearch(System.Console console, int v, Graph graph, {int} visited) => {int}:
  visited = visited + {v}
  console.out.println("depthFirstSearch => " ++ v)
  console.out.println("visited => " ++ visited)
  console.out.println("graph["++v++"] => " ++ graph[v])
  // Traverse edges not yet visited
  for w in graph[v]:
    console.out.println("w in graph, visited => " ++ visited)
    console.out.println("w in graph["++v++"] => " ++ w)
    console.out.println("!(w in visited) => " ++ !(w in visited))
    if !(w in visited):
      visited = depthFirstSearch(console, w,graph,visited)
  // Done
  return visited

