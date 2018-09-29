public class WeightedQuickUnion {

    private int[] id;
    private int[] sz;
    private int size;

    public UnionFind(int size) {
        this.size = size;
        this.id = new int[size]; 
        this.sz = new int[size];
        for(int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p) {
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return (find(p) == find(q));
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);

        if(rootp == rootq) return;

        if(sz[rootp] > sz[rootq]) {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        } else {
           id[rootp] = rootq;
           sz[rootq] = sz[rootp]; 
        }

    }





}
