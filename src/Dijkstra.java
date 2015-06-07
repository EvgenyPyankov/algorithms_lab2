public class Dijkstra {
    int[] dist;
    int[] up;
    int[] index;
    int[] name;
    int[] key;
    DHeap dheap;
    Graph graph;
    int s;
    int n;

    public Dijkstra( Graph graph, int d, int s ) {
        this.graph = graph;
        n = graph.getN();
        this.s = s;
        dist = new int[n];
        up = new int[n];
        index = new int[n];
        name = new int[n];
        key = new int[n];
        dheap = new DHeap (key,name,index,d,n);
        init ();
    }

    private void init() {
        for ( int i = 0; i < n; i ++ ) {
            up [i] = -1;
            dist [i] = Integer.MAX_VALUE;
            index [i] = i;
            name [i] = i;
            key [i] = Integer.MAX_VALUE;
        }
        key [s] = 0;
        dheap.formDHeap();
    }

    public void runDijkstra() {
        int name0;
        int key0;
        int i;
        int[] adj;
        int jq;
        while ( dheap.n > 0 ) {
            dheap.extractMin( );
            i = dheap.getName0();
            dist [i] = dheap.getKey0();
            adj = graph.getRow (i);
            for (int j = 0; j < adj.length; j ++) {
                if (adj [j] >= 0) {
                    jq = index [j];
                    if (dist [j] == Integer.MAX_VALUE) {
                        if (key [jq] > dist [i] + adj [j]) {
                            key [jq] = dist [i] + adj [j];
                            dheap.SiftUp (jq);
                            up[j] = i;
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

