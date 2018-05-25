/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analisis;


public class Analisis {
  int[] Arreglo; 
  int tam;

    public int[] getArreglo() {
        return Arreglo;
    }

    public void setArreglo(int[] Arreglo) {
        this.Arreglo = Arreglo;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public Analisis(int[] Arreglo, int tam) {
        this.Arreglo = Arreglo;
        this.tam = tam;
    }

    @Override
    public String toString() {
        return "Analisis{" + "Arreglo=" + Arreglo + ", tam=" + tam + '}';
    }
  
    /**
     * @param args the command line arguments
     */
}
