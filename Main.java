import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ServiceGrafo service = new ServiceGrafo();
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1. Crear Matriz");
            System.out.println("2. Agregar Vertice");
            System.out.println("3. Agregar Arco");
            System.out.println("4. Recorrer en Profundidad");
            System.out.println("5. Recorrer en Anchura");
            System.out.println("6. Verificar Adyacencia");
            System.out.println("7. Imprimir Matriz de Adyacencia");
            System.out.println("8. Crear Matriz de Prueba");
            System.out.println("9. Crear Matriz de Prueba2 Libro");
            System.out.println("10. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    service.crearMatriz();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del vértice: ");
                    String vertice = leer.nextLine();
                    service.g.nuevoVertice(vertice);
                    break;
                case 3:
                    System.out.print("Ingrese el vértice origen: ");
                    String origen = leer.nextLine();
                    System.out.print("Ingrese el vértice destino: ");
                    String destino = leer.nextLine();
                    try {
                        service.g.nuevoArco(origen, destino);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el vértice origen para el recorrido en profundidad: ");
                    String verticeProfundidad = leer.nextLine();
                    try {
                        service.recorrerProfundidad(verticeProfundidad);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el vértice origen para el recorrido en anchura: ");
                    String verticeAnchura = leer.nextLine();
                    try {
                        service.recorrerAnchura(verticeAnchura);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el vértice a: ");
                    String verticeA = leer.nextLine();
                    System.out.print("Ingrese el vértice b: ");
                    String verticeB = leer.nextLine();
                    try {
                        boolean adyacente = service.g.adyacente(verticeA, verticeB);
                        System.out.println("Adyacente: " + adyacente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    service.imprimirMatriz();
                    break;
                case 8:
                    service.crearMatrizPrueba();
                    break;
                case 9:
                    service.crearMatrizPrueba2();
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 10);
    }
}