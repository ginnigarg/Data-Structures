public class UnionFind {

    private int[] id;
    private int size;

    public UnionFind(int size) {
        this.size = size;
        this.id = new int[size]; 

        for(int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
    }

    public void union(int p, int q) {
        if(!connected(p, q)) {
            for(int i = 0; i < size; i++) {
                if(id[i] == id[q]) {
                    id[i] = id[p];
                }
            }
        }
    }





}
