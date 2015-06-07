import com.sun.org.apache.bcel.internal.classfile.FieldOrMethod;

public class Main {
    public static void main(String args[]){
        int n=2000;
        int q=1;
        int r=1000000;
        final int COEFFICIENT1 = 1; //the more value, the less number of edges
        final int COEFFICIENT2 = 10;
//        Graph graph = GraphGenerator.generateGraph(n,m,q,r, COEFFICIENT1);
//        System.out.println(graph.getGraphInfo());
//        graph.printGraph();
        int[][]matrix = {
               {-1,7,9,-1,-1,14},
               {-1,-1,10,15,-1,-1},
               {-1,-1,-1,11,-1,2},
               {-1,-1,-1,-1,-1},
               {-1,-1,-1,6,-1,-1},
               {-1,-1,-1,-1,9,-1}
       };
//        Graph graph = GraphGenerator.generateGraph(n,q,r, COEFFICIENT1);
//        graph.printGraph();
//        Dijkstra dijkstra = new Dijkstra(graph,2,0);
//        //printArr(dijkstra.getDist());
//        dijkstra.runDijkstra();
//        printArr(dijkstra.getDist());

//        Graph graph = new Graph(matrix,9,6);
//        Dijkstra dijkstra = new Dijkstra(graph,2,0);
//        printArr(dijkstra.getDist());
//        dijkstra.runDijkstra();
//        printArr(dijkstra.getDist());


       Graph graph = GraphGenerator.generateGraph(n,q,r, COEFFICIENT1);
//        graph.printGraph();
//        Dijkstra dijkstra = new Dijkstra(graph,2,0);
//        dijkstra.runDijkstra();
        FordBellman fb = new FordBellman(graph,0);
       fb.runFordBellman();
//        printArr(dijkstra.getDist());
//        printArr(fb.getDist());
    }

    static void printArr(int[]arr){
        System.out.println("\nArray:");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
