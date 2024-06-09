import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ServiceGrafo {
    Stack<Integer> pila = new Stack<>();
    Queue<Integer> cola = new LinkedList<>();
    GrafoMatriz g = new GrafoMatriz();
    final Scanner leer = new Scanner(System.in);
    final int CLAVE = -1;

    public void crearMatriz() {
        System.out.println("Ingrese el tamaño de la matriz");
        int mx = leer.nextInt();
        g.setMatAd(new int[mx][mx]);
        g.setVerts(new Vertice[mx]);
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                g.getMatAd()[i][j] = 0;
            }
        }
        g.setNumVerts(0);
    }

    public void crearMatrizPrueba() {
        int mx = 5; // Tamaño de la matriz de prueba
        g.setMatAd(new int[mx][mx]);
        g.setVerts(new Vertice[mx]);
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                g.getMatAd()[i][j] = 0;
            }
        }
        g.setNumVerts(0);

        // Agregar vértices
        g.nuevoVertice("A");
        g.nuevoVertice("B");
        g.nuevoVertice("C");
        g.nuevoVertice("D");
        g.nuevoVertice("E");

        // Agregar arcos
        try {
            g.nuevoArco("A", "B");
            g.nuevoArco("A", "C");
            g.nuevoArco("B", "D");
            g.nuevoArco("C", "D");
            g.nuevoArco("D", "E");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearMatrizPrueba2() {
        int mx = 7; // Tamaño de la matriz de prueba
        g.setMatAd(new int[mx][mx]);
        g.setVerts(new Vertice[mx]);
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                g.getMatAd()[i][j] = 0;
            }
        }
        g.setNumVerts(0);

        // Agregar vértices
        g.nuevoVertice("A");
        g.nuevoVertice("B");
        g.nuevoVertice("C");
        g.nuevoVertice("D");
        g.nuevoVertice("H");
        g.nuevoVertice("T");
        g.nuevoVertice("R");

        // Agregar arcos
        try {
            g.nuevoArco("H", "A");
            g.nuevoArco("H", "T");
            g.nuevoArco("B", "H");
            g.nuevoArco("H", "D");
            g.nuevoArco("D", "B");
            g.nuevoArco("D", "C");
            g.nuevoArco("C", "R");
            g.nuevoArco("R", "H");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Recorrido en profundidad
    public int[] recorrerProfundidad(String org) throws Exception {
        int v, w; //Variables para almacenar indices de vertices
        int[] m; //Vrtices visitados
        m = new int[g.getNumVerts()];

        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");

        for (int i = 0; i < g.getNumVerts(); i++) {
            m[i] = -1;
        } //Seteo al principio en -1 para indicar que ningun vertice se visito
        m[v] = 0; //Marco el vertice de origen como visitado
        pila.add(v);

        while (!pila.isEmpty()) {
            w = pila.pop();
            System.out.println("Vértice " + g.getVerts()[w] + " visitado"); //imprimo w

            for (int u = 0; u < g.getNumVerts(); u++) {
                if ((g.getMatAd()[w][u] == 1) && (m[u] == -1)) { //mientras tenga un arco y no esté en la lista
                    pila.add(u);
                    m[u] = 1;
                }
            }
        }
        return m;
    }

    // Recorrido en amplitud
    public int[] recorrerAnchura(String org) throws Exception {
        int w, v;
        int[] m;

        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");

        m = new int[g.getNumVerts()];
        for (int i = 0; i < g.getNumVerts(); i++) {
            m[i] = CLAVE;
        }
        m[v] = 0;
        cola.add(v);

        while (!cola.isEmpty()) {
            w = cola.poll();
            System.out.println("Vértice " + g.getVerts()[w] + " visitado");

            for (int u = 0; u < g.getNumVerts(); u++) {
                if ((g.getMatAd()[w][u] == 1) && (m[u] == CLAVE)) {
                    m[u] = m[w] + 1;
                    cola.add(u);
                }
            }
        }
        return m;
    }

    // Imprimir matriz de adyacencia
    public void imprimirMatriz() {
        int[][] matAd = g.getMatAd();
        for (int i = 0; i < matAd.length; i++) {
            for (int j = 0; j < matAd[i].length; j++) {
                System.out.print(matAd[i][j] + " ");
            }
            System.out.println();
        }
    }
}