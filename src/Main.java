
public class Main {
    public static void main(String args[]){
        int n=2000;
        int q=1;
        int r=1000000;
        int d=2;
        int s=0;
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

        int n1=1;
        int n2=1002;
        int step=100;

        while(n1<n2){
            Graph graph1 = GraphGenerator.generateGraph(n1,q,r,COEFFICIENT2);
            Graph graph2 = GraphGenerator.generateGraph(n1,q,r,COEFFICIENT1);
            Dijkstra dijkstra1 = new Dijkstra(graph1,d,s);
            Dijkstra dijkstra2 = new Dijkstra(graph2,d,s);
            FordBellman fb1 = new FordBellman(graph1,0);
            FordBellman fb2 = new FordBellman(graph2,0);

            long start1 = System.currentTimeMillis();
            dijkstra1.runDijkstra();
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            fb1.runFordBellman();
            long end2 = System.currentTimeMillis();

            long start3 = System.currentTimeMillis();
            dijkstra2.runDijkstra();
            long end3 = System.currentTimeMillis();

            long start4 = System.currentTimeMillis();
            fb2.runFordBellman();
            long end4 = System.currentTimeMillis();

            System.out.println(n1+": "+(end1-start1)+"  "+(end2-start2)+"  "+(end3-start3)+"  "+(end4-start4));
            n1+=step;
        }
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


       //Graph graph = GraphGenerator.generateGraph(n,q,r, COEFFICIENT1);
//        graph.printGraph();
//        Dijkstra dijkstra = new Dijkstra(graph,2,0);
//        dijkstra.runDijkstra();
//        FordBellman fb = new FordBellman(graph,0);
//       fb.runFordBellman();
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
