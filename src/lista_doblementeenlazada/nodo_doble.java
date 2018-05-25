/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_doblementeenlazada;

/**
 *
 * @author Dell PC
 */
public class nodo_doble extends lista_doble{
    public int dato;
    nodo_doble siguiente, anterior;

    public nodo_doble(int dato) {
        this(dato, null,null);
    }
//constructor
    public nodo_doble(int dato, nodo_doble siguiente, nodo_doble anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public int getDato() {
        return dato;
    }

      
}
