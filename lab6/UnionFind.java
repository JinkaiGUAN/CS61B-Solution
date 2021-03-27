public class UnionFind {
    /*In this class, we just return the index of the array, while not the value of the corresponding index.*/
    int [] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        // set all elements in the original set to -1, i.e. disjoint sets
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if ((vertex >= parent.length) || (vertex < 0)) {
            throw new IllegalArgumentException();
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        this.validate(v1);
        int root = this.find(v1);
        return Math.abs(parent[root]);
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        this.validate(v1);
        if (parent[v1] < 0) {
            return parent[v1];
        } else {
            return find(v1);
        }
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // Check the index is valid or not
        this.validate(v1);
        this.validate(v2);
        return this.find(v1) == this.find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        this.validate(v1);
        this.validate(v2);
        if (this.connected(v1, v2)) {
            // Nothing
        } else{
            int root1 = this.find(v1);
            int root2 = this.find(v2);
            int size1 = Math.abs(this.sizeOf(v1));
            int size2 = Math.abs(this.sizeOf(v2));
            if (size1 > size2 || (size1 == size2 && root1 < root2)) {
                parent[root1] -= size2;
                parent[root2] = root1;
            } else if (size1 < size2 || root1 > root2) {
                parent[root2] -= size1;
                parent[root1] = root2;
            }
        }

    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // return the index of the root of the set that vertes belongs to
        this.validate(vertex);
        int root = vertex;
        while (this.parent(root) >= 0) {
            root = this.parent(root);
        }
        return root;
    }

}
