import java.util.*;

public class GraphGenerator {
    static Graph generateGraph(int n,  int q, int r, int coefficient) {
        int[][] adjacencyMatrix = new int[n][n];
        int edgesAmount=0;

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            adjacencyMatrix[i][i]=-1;
            for (int j = i+1; j < n; j++) {
                if (rand.nextInt(coefficient)==0) {
                    if (rand.nextInt(2)==0) {
                        adjacencyMatrix[i][j] = rand.nextInt(r-q) + q;
                        adjacencyMatrix[j][i] = -1;
                    }
                    else {
                        adjacencyMatrix[j][i] = rand.nextInt(r-q) + q;
                        adjacencyMatrix[i][j] = -1;
                    }
                    edgesAmount++;
                }
                else {
                    adjacencyMatrix[i][j] = adjacencyMatrix[j][i]= -1;
                }
            }
        }
        return new Graph(adjacencyMatrix, edgesAmount,n);
    }
}
