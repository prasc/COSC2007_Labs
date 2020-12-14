// Referenced textbook Algorithms 4th edition Robert Sedwick

import java.util.*;

class Graph {
    int vertices;
    LinkedList<Integer> adjacencyList[];            // list will be stored using java's default linked list implementation
    boolean visited[];                              // declare boolean visited area that will be used for searches

    public Graph(int vertices) {                    // constructor requires vertices to initialize linked list for each individual vertex to store edges
        this.vertices = vertices;                   //  initialize vertices based on user input (or main method)
        adjacencyList = new LinkedList[vertices];   //  adjList is a list of linked lists, one for each vertex
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();  // loop through array of vertices and a linked list to represent edges of each vertex in the array
        }
    }

    public void addEdge(int source, int destination) {     // this graph is one directional, so we need a source and a destination
        adjacencyList[source].addFirst(destination);       // go to the specific vertex within adjList and destination to head of linkedlist
    }

    public void dfs(int start) {
        visited = new boolean[vertices];                   // visited starts as array of boolean of size vertices
        dfsSearch(start);                                   // call recursive search method
    }

    public void dfsSearch(int current) {
        visited[current] = true;                        // mark visited true, for current value

        System.out.print(current + " ");                // then print it

        for (int i = 0; i < adjacencyList[current].size(); i++) {   // now loop through length of the linked list at adjList[vertex]
            int dest = adjacencyList[current].get(i);               // destination, is current destination within the linked list at adjList[vertex]
            if (!visited[dest]) {                                   // if this destination was not already visited
                dfsSearch(dest);                                    // recursively search it, until every vertex has been visited
            }
        }
    }

    public void bfs(int current) {
        visited = new boolean[vertices];                            // visited starts as array of boolean of size vertices

        LinkedList<Integer> queue = new LinkedList<Integer>();      // create referenced based queue that will be useful for bfs

        visited[current] = true;                                      // mark current vertex as true
        queue.add(current);                                         // add current vertex to queue

        while (queue.size() != 0) {                                 // for as long as queue.size is greater than 0
            current = queue.poll();                                 // remove front of queue
            System.out.print(current +" ");                         // then print it

            for (int i = 0; i < adjacencyList[current].size(); i++) {     // now loop through length of the linked list at adjList[vertex]
                int dest = adjacencyList[current].get(i);                 // destination, is current destination within the linked list at adjList[vertex]
                if (!visited[dest]) {                                     // if this destination was not already visited
                    visited[dest] = true;                                // mark it as visited
                    queue.add(dest);                                    //then add it to the queue
                }
            }

        }
    }





}


