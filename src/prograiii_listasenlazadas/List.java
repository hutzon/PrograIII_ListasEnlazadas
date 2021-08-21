package prograiii_listasenlazadas;

public class List {

    private Nodos inicio;

    private int size;

    public void List() {
        inicio = null;
        size = 0;
    }

    public boolean nodoVacio() {
        return inicio == null;
    }

    public int getSize() {
        return size;
    }

//metodo agregar al final
    public void agregarAlFinal(int valor) {
        Nodos nuevo = new Nodos();
        nuevo.setValor(valor);
        if (nodoVacio()) {
            inicio = nuevo;
        } else {
            Nodos aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }

        size++;
    }

//metodo agregar al inicio     
    public void agregarAlInicio(int valor) {
        Nodos nuevo = new Nodos();
        nuevo.setValor(valor);
        if (nodoVacio()) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        size++;
    }

//insertar nuevo nodo despues de otro, se ubica por el valor que contiene el nodo
    public void insertarPorReferencia(int referencia, int valor) {
        Nodos nuevo = new Nodos();
        nuevo.setValor(valor);
        if (!nodoVacio()) {
            if (buscar(referencia)) {
                Nodos aux = inicio;
                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                Nodos siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                size++;
            }
        }
    }

//Inserta un nuevo nodo despues en una posición determinada.
    public void insrtarPorPosicion(int posicion, int valor) {
        if (posicion >= 0 && posicion <= size) {
            Nodos nuevo = new Nodos();
            nuevo.setValor(valor);

            if (posicion == 0) {

                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else {

                if (posicion == size) {
                    Nodos aux = inicio;
                    while (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo);
                } else {
                    Nodos aux = inicio;
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodos siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
            }

            size++;
        }
    }

//Metodo que obtiene el valor de un nodo en una determinada posición.
    public int getValor(int posicion) throws Exception {
        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                return inicio.getValor();
            } else {
                Nodos aux = inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getValor();
            }
        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }

//metodos para buscar si exite un valor en la lista
    public boolean buscar(int referencia) {
        Nodos aux = inicio;
        boolean localizado = false;

        while (aux != null && localizado != true) {

            if (referencia == aux.getValor()) {
                localizado = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return localizado;
    }

//Metodo para consultar la posicion de un elemento que esta en la lista
    public int getPosicion(int referencia) throws Exception {

        if (buscar(referencia)) {
            Nodos aux = inicio;
            int i = 0;
            while (referencia != aux.getValor()) {
                i++;
                aux = aux.getSiguiente();
            }
            return i;
        } else {
            throw new Exception("Valor o existe dentro de la lista.");
        }
    }

    /* Metodo que actualiza el valor de un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.*/
    public void editarPorReferencia(int referencia, int valor) {

        if (buscar(referencia)) {
            Nodos aux = inicio;
            while (aux.getValor() != referencia) {
                aux = aux.getSiguiente();
            }
            aux.setValor(valor);
        }
    }

    /* Metodo que actualiza el valor de un nodo que se encuentre en la lista ubicado
     por su posición.*/
    public void editarPorPosicion(int posicion, int valor) {

        if (posicion >= 0 && posicion < size) {

            if (posicion == 0) {

                inicio.setValor(valor);
            } else {

                Nodos aux = inicio;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }

                aux.setValor(valor);
            }
        }
    }


    /*Metodo para elimina un nodo que se encuentre en la lista ubicado
     por un valor de referencia.*/
    public void removerPorReferencia(int referencia) {

        if (buscar(referencia)) {
            if (inicio.getValor() == referencia) {
                inicio = inicio.getSiguiente();
            } else {
                Nodos aux = inicio;
                while (aux.getSiguiente().getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                Nodos siguiente = aux.getSiguiente().getSiguiente();
                aux.setSiguiente(siguiente);
            }
            size--;
        }
    }

    /*Metodo para eliminar un nodo que se encuentre en la lista ubicado
      por su posición. */
    public void removerPorPosicion(int posicion) {

        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                inicio = inicio.getSiguiente();
            } else {
                Nodos aux = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                Nodos siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            }
            size--;
        }
    }

    /*Metodo para eliminar la lista */
    public void eliminar() {
        inicio = null;
        size = 0;
    }

    /* Este metodo muestra en pantalla los elementos de la lista.*/
    public void listar() {
        if (!nodoVacio()) {
            Nodos aux = inicio;
            int i = 0;
            while (aux != null) {
                System.out.print(i + ".[ " + aux.getValor() + " ]" + " -->  ");
                aux = aux.getSiguiente();
                i++;
            }
        }
    }

}
