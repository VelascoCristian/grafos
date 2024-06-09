public class GrafoMatriz {
    int numVerts;
    Vertice[] verts;
    int[][] matAd;

    public GrafoMatriz() {
    }

    public GrafoMatriz(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = 0;
            }
        }
        numVerts = 0;
    }

    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    public int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        for (int i = 0; i < numVerts; i++) {
            if (verts[i].equals(v)) {
                return i;
            }
        }
        return -1;
    }

    public void nuevoArco(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va == -1 || vb == -1) throw new Exception("Vértice no existe");
        matAd[va][vb] = 1;
    }

    public boolean adyacente(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va == -1 || vb == -1) throw new Exception("Vértice no existe");
        return matAd[va][vb] == 1;
    }

    public int getNumVerts() {
        return numVerts;
    }

    public void setNumVerts(int numVerts) {
        this.numVerts = numVerts;
    }

    public Vertice[] getVerts() {
        return verts;
    }

    public void setVerts(Vertice[] verts) {
        this.verts = verts;
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }
}