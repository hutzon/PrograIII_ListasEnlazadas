package prograiii_listasenlazadas;

import java.util.Scanner;

public class PrograIII_ListasEnlazadas {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int numero;
        int numero2;
        int numero3;
        int datos;
        List lista = new List();

        do {
            System.out.println("Selecione las siguientes opciones:\n"
                    + "1. Insertar elementos en la lista.\n"
                    + "2. Eliminar elementos de la lista.\n"
                    + "3. Buscar elementos de la lista.\n"
                    + "4. Recorrer la lista enlazada y mostrarla.\n"
                    + "5. Comprobar si la lista está vacía.\n"
                    + "6. Mostrar tamaño de la lista.\n"
                    + "7. Salir.\n");

            numero = entrada.nextInt();

            switch (numero) {
                case 1:
                    System.out.print("\nAgregar el valor: ");
                    datos = entrada.nextInt();
                    lista.agregarAlFinal(datos);
                    System.out.println("");
                    break;

                case 2:
                    do {

                        System.out.println("\nSelecione las siguientes opciones:\n"
                                + "1. Elimina el nodo con el valor.\n"
                                + "2. Elimina el nodo en la posición.\n"
                                + "3. Salir.");

                        numero2 = entrada.nextInt();

                        switch (numero2) {
                            case 1:

                                System.out.print("\nIngrese el valor del valor a eliminar: ");
                                datos = entrada.nextInt();
                                lista.removerPorReferencia(datos);
                                System.out.print("Lista resultante: ");
                                lista.listar();
                                System.out.println(lista.getSize());

                                break;

                            case 2:

                                System.out.print("\nIngrese la posicion del nodo a eliminar: ");
                                datos = entrada.nextInt();
                                lista.removerPorPosicion(datos);
                                System.out.print("Lista resultante: ");
                                lista.listar();
                                System.out.println(lista.getSize());

                                break;

                        }

                    } while (numero2 != 3);
                    System.out.println("\n");
                    break;

                case 3:
                    do {

                        System.out.println("\nSelecione las siguientes opciones:\n"
                                + "1. Obtener el valor del nodo en la posicion solicitada.\n"
                                + "2. Consulta la posicion del valor.\n"
                                + "3. Salir.");

                        numero3 = entrada.nextInt();

                        switch (numero3) {
                            case 1:

                                System.out.print("\nObtener el valor del nodo en la posicion: ");
                                datos = entrada.nextInt();
                                System.out.println("El valor es: " + lista.getValor(datos));
                                System.out.println("");
                                break;

                            case 2:
                                System.out.print("\nConsulta la posicion del valor: ");
                                datos = entrada.nextInt();
                                System.out.println("Posición #: " + lista.getPosicion(datos));
                                System.out.println("");
                                break;

                        }

                    } while (numero3 != 3);

                    break;

                case 4:

                    System.out.println("Lista");
                    lista.listar();
                    System.out.println("\n");

                    break;

                case 5:
                    System.out.print("\nResultado: ");
                    System.out.println(lista.nodoVacio());
                    System.out.println("");
                    break;

                case 6:
                    System.out.print("El tamaño de la lista es de: ");
                    System.out.println(lista.getSize());
                    System.out.println("");
                    break;

            }

        } while (numero != 7);

    }

}
