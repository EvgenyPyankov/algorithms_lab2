public class FordBellman {
    int[] dist;
    int[] up;
    Graph graph;
    int s;
    int n;
    int maxValue=9999999;

    public FordBellman( Graph graph, int s ) {
        this.graph = graph;
        n = graph.getN();
        this.s = s;
        dist = new int[n];
        up = new int[n];
        init ();
    }

    private void init() {
        for (int i = 0; i < n; i ++) {
            up [i] = -1;
            dist [i] = maxValue;
        }
        dist [s] = 0;
    }

    public void runFordBellman() {
        int[][] adjacencyMatrix = graph.adjacencyMatrix;
        for ( int k = 0; k < n - 1; k ++ ) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (adjacencyMatrix[i][j] != -1 && j != s) {
                        if (dist [j] > dist [i] + adjacencyMatrix[i][j]) {
                            dist [j] = dist [i] + adjacencyMatrix[i][j];
                            up [j] = i;
                        }
                    }
                }
            }
        }
    }

    public int[] getDist() {
         return dist;
    }

    public int[] getUp() {
         return up;
    }
}
