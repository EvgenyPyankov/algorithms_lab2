public class Graph {
    int [][]adjacencyMatrix;
    int m;
    int n;

    public Graph(int[][]adjacencyMatrix, int m, int n){
        this.adjacencyMatrix=adjacencyMatrix;
        this.m=m;
        this.n=n;
    }

     void printGraph(){
        System.out.println("Graph:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
        }
    }

    public String getGraphInfo(){
        return "amount of adges = "+m +"\namout of verticies = "+n+"\nmax amout of adges = "+n*(n-1)/2;
    }

    public int getN(){
        return n;
    }

    public int[] getRow(int i){
        return adjacencyMatrix[i];
    }
}
