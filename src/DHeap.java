public class DHeap {
    int[] name;
    int[] key;
    int[] index;
    int d;
    int n;

    public DHeap(int[]key,int[]name,int[]index,int d, int n){
        this.key=key;
        this.name=name;
        this.index=index;
        this.d=d;
        this.n=n;
    }

    void formDHeap(){
        for (int i=n-1; i>=0; i--){
            siftDown(i);
        }
    }
    void siftDown(int i){
        int key0 = key [i];
        int name0 = name [i];
        int c = minChild(i);
        while (c != i && key0 > key[c]) {
            key [i] = key [c];
            name [i] = name [c];
            index [name [i]] = i;
            i = c;
            c = minChild(i);
        }
        key [i] = key0;
        name [i] = name0;
        index [name [i]] = i;
    }

    public void SiftUp( int i ) {
        int key0 = key [i];
        int name0 = name [i];
        int p = father (i);
        while ( i != 0 && key[p] > key0 ) {
            key[i] = key[p];
            name[i] = name[p];
            index [name [i]] = i;
            i = p;
            p = father( i );
        }
        key[i] = key0;
        name[i] = name0;
        index [name [i]] = i;
    }

    int minChild(int i){
        int minchild;
        int kf = firstChild(i);
        if ( kf == 0 )
            minchild = i;
        else {
            int kl = lastChild(i);
            int min_key = key [kf];
            minchild = kf;
            for ( int j = kf + 1; j <= kl; j ++ ) {
                if ( key[j] < min_key ) {
                    min_key = key[j];
                    minchild = j;
                }
            }
        }
        return minchild;
    }

    int firstChild( int i){
        int k = i * d + 1;
        if (k >= n)
            return 0;
        return k;
    }

    int lastChild(int i){
        int k = firstChild (i);
        if (k == 0)
            return 0;
        return Math.min (k + d - 1, n - 1);
    }

    private int father( int i ) {
        return (i - 1) / d;
    }

    public void extractMin( ) {
        int name0 = name [0];
        int key0 = key[0];
        name [0] = name [n-1];
        key [0] = key [n-1];
        name[n-1] = name0;
        key[n-1] = key0;
        n = n - 1;
        if (n >= 1)
            siftDown (0);
    }

    public int getName0(){
        return name[n];
    }

    public int getKey0(){
        return key[n];
    }

    void printDHeap(){
        System.out.println();
        for (int i=0; i<n; i++){
            System.out.print(key[i]+" ");
        }
    }
}
