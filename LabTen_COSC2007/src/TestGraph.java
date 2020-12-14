public class TestGraph {
    public static void main(String[] args) {
        //create a graph object and add edges to it
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 2);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);

        System.out.print("dfs search: ");
        g.dfs(0);
        System.out.println();

        System.out.print("bfs search: ");
        g.bfs(0);

    }
}
