/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import listasemarray.ArrayList;

/**
 *
 * @author claudio
 */
public class TesteListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList integer = new ArrayList();
        System.out.println(integer.size());
        System.out.println("");
        
        int j = 100,k =100;
        for (int i = 0; i < 100; i++) {
            integer.insereAtras(++k);
            integer.insereFrente(j--);
        }
        System.out.println("");
        System.out.println(integer.size());
        System.out.println("");
        integer.print();
    }
}
