/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBalanceado;

/**
 *
 * @author Dell PC
 */
public class nodo_arbol_AVL {

    /**
     * @param args the command line arguments
     */
  public int dato, factor_equilibrio;  
  nodo_arbol_AVL izquierda, derecha;
  
  public nodo_arbol_AVL(int dato)
  {
      this.dato = dato;
      this.factor_equilibrio = 0;
      this.izquierda = null;
      this.derecha = null;
    
}

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFactor_equilibrio() {
        return factor_equilibrio;
    }

    public void setFactor_equilibrio(int factor_equilibrio) {
        this.factor_equilibrio = factor_equilibrio;
    }

    public nodo_arbol_AVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(nodo_arbol_AVL izquierda) {
        this.izquierda = izquierda;
    }

    public nodo_arbol_AVL getDerecha() {
        return derecha;
    }

    public void setDerecha(nodo_arbol_AVL derecha) {
        this.derecha = derecha;
    }

  
}
