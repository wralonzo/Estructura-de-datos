/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBalanceado;

import java.util.LinkedList;

/**
 *
 * @author Dell PC
 */
public class arbol_avl {
    private nodo_arbol_AVL raiz;
    private int alt, num_nodos;
    public arbol_avl()
    {        
        raiz=null;
        alt = 0;
        num_nodos = 0;
    }

    public nodo_arbol_AVL getRaiz() {
        return raiz;
    }

   
    
    
    //buscar una compra en el arbol
    public nodo_arbol_AVL buscar_compras(int d, nodo_arbol_AVL r)
    {
        if (raiz == null)
        {
            return null;
        }
        else if(r.dato == d)
        {
            return r;
            
        }
        else if(r.dato<d)
        {
            return buscar_compras(d, r.derecha);
        }
        else{
            return buscar_compras(d,r.izquierda);
        }
        
    }
    
    //obtener el factor de equilibrio 
    public int obtenerEquilibrio(nodo_arbol_AVL x)
    {
        if(x==null)
        {
            return -1;
        }
        else{
            return x.factor_equilibrio;
        }
    }
        //rotat hacia la izquierda de manera simple
    public nodo_arbol_AVL rotarIzquierda(nodo_arbol_AVL c)
    {
            nodo_arbol_AVL auxiliar = c.izquierda;
            c.izquierda = auxiliar.derecha;
            auxiliar.derecha = c;
            //calcular factores maximos del arbol
            c.factor_equilibrio=Math.max(obtenerEquilibrio(c.izquierda),obtenerEquilibrio(c.derecha))+1;
            auxiliar.factor_equilibrio = Math.max(obtenerEquilibrio(auxiliar.izquierda),obtenerEquilibrio(auxiliar.derecha))+1;
        return auxiliar;

    }
    
    // rotacion simple derecha copy and paste programacion sustentable
    public nodo_arbol_AVL rotarDerecha(nodo_arbol_AVL c)
    {
            nodo_arbol_AVL auxiliar = c.derecha;
            c.derecha = auxiliar.izquierda;
            auxiliar.izquierda = c;
            //calcular factores maximos del arbol
            c.factor_equilibrio=Math.max(obtenerEquilibrio(c.izquierda),obtenerEquilibrio(c.derecha))+1;
            auxiliar.factor_equilibrio = Math.max(obtenerEquilibrio(auxiliar.izquierda),obtenerEquilibrio(auxiliar.derecha))+1;
        return auxiliar;

    }
    
    //rotacion doble a la derecha
    public nodo_arbol_AVL rotarDobleIzquierda(nodo_arbol_AVL c)
    {
        nodo_arbol_AVL auxiliar;
        c.izquierda = rotarDerecha(c.izquierda);
        auxiliar = rotarIzquierda(c);
        return auxiliar;
    }

//rotacion doble a la derecha
    public nodo_arbol_AVL rotarDobleDerecha(nodo_arbol_AVL c)
    {
        nodo_arbol_AVL auxiliar;
        c.derecha = rotarIzquierda(c.derecha);
        auxiliar = rotarDerecha(c);
        return auxiliar;
    }
        
    //metodo para insertat de forma balanceada
    public nodo_arbol_AVL insertarAVL(nodo_arbol_AVL nuevo, nodo_arbol_AVL subarbol)
    {
        nodo_arbol_AVL nuevo_padre = subarbol;
        
        if(nuevo.dato<subarbol.dato)
        {
            if(subarbol.izquierda == null)
            {
                subarbol.izquierda = nuevo;
            }
            else
            {
                subarbol.izquierda = insertarAVL(nuevo, subarbol.izquierda);
                if(obtenerEquilibrio(subarbol.izquierda)- obtenerEquilibrio(subarbol.derecha)==2)
                {
                   if(nuevo.dato<subarbol.izquierda.dato)
                   {
                       nuevo_padre = rotarIzquierda(subarbol);                       
                   }
                   else
                   {
                    nuevo_padre = rotarDobleIzquierda(subarbol);    
                   }
                }
            }
        }
        else if(nuevo.dato>subarbol.dato)
        {
            if(subarbol.derecha==null)
            {
                subarbol.derecha=nuevo;
            }
            else{
                subarbol.derecha =insertarAVL(nuevo, subarbol.derecha);
                if(obtenerEquilibrio(subarbol.derecha)-obtenerEquilibrio(subarbol.izquierda)==2)
                {
                    if(nuevo.dato > subarbol.derecha.dato){
                        nuevo_padre= rotarDerecha(subarbol);
                    }
                    else
                    {
                        nuevo_padre= rotarDobleDerecha(subarbol);
                    }
                }
            }
        }
        else
        {
            System.out.println("nodo duplicado");
        }
        ///actualizar la altura con el factoe equilibreio
        if((subarbol.izquierda == null)&&(subarbol.derecha != null))
        {
            subarbol.factor_equilibrio = subarbol.derecha.factor_equilibrio+1;
        }
        else if((subarbol.derecha == null)&&(subarbol.izquierda != null))
        {
            subarbol.factor_equilibrio = subarbol.izquierda.factor_equilibrio+1;
        }
        else
        {
            subarbol.factor_equilibrio = Math.max(obtenerEquilibrio(subarbol.izquierda),obtenerEquilibrio(subarbol.derecha))+1;
        }
        return nuevo_padre;
    }
    
    public void insertar(int d)
    {
        nodo_arbol_AVL nuevo = new nodo_arbol_AVL(d);
        if(raiz ==null)
        {
            raiz=nuevo;
        }
        else
        {
            raiz = insertarAVL(nuevo,raiz);
    }
        
    }
    
   public void preorden(nodo_arbol_AVL aux,LinkedList recorrido){
          if (aux != null)
          {
              recorrido.add(aux.getDato());
              preorden (aux.getIzquierda(),recorrido);
              preorden (aux.getDerecha(),recorrido);
          }
    }
    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void inorden(nodo_arbol_AVL aux,LinkedList recorrido){
          if (aux != null)
          {
              inorden (aux.getIzquierda(),recorrido);
              recorrido.add(aux.getDato());
              inorden (aux.getDerecha(),recorrido);
          }
    }
    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void postorden(nodo_arbol_AVL aux,LinkedList recorrido){
          if (aux != null)
          {
              postorden (aux.getIzquierda(),recorrido);
              postorden (aux.getDerecha(),recorrido);
              recorrido.add(aux.getDato());
          }
    }
    //Recorrido por nivel, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void porNivel(nodo_arbol_AVL aux,LinkedList recorrido){
        LinkedList<nodo_arbol_AVL> cola = new LinkedList<nodo_arbol_AVL>();
        cola.addLast(aux);
        while(cola.size()> 0){
            nodo_arbol_AVL tmp = cola.pollFirst();
            recorrido.add(tmp.getDato());
            if(tmp.getIzquierda()!=null){
                cola.addLast(tmp.getIzquierda());
            }
            if(tmp.getDerecha()!=null){
                cola.addLast(tmp.getDerecha());
            } 
        }
    }
    
    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        nodo_arbol_AVL aux = raiz;
        while (aux!=null) {
            if (dato==aux.getDato())
                return true;
            else
                if (dato>aux.getDato())
                    aux=aux.getDerecha();
                else
                    aux=aux.getIzquierda();
        }
        return false;
    }
    
    
    private void altura (nodo_arbol_AVL aux,int nivel)  {
        if (aux != null) {    
            altura(aux.getIzquierda(),nivel+1);
            alt = nivel;
            altura(aux.getDerecha(),nivel+1);
        }
    }
    //Devuleve la altura del arbol
    public int getAltura(){
        altura(raiz,1);
        return alt;
    }
}
