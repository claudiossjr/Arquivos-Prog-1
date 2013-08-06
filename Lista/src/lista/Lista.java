/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import listaEncadeada.LinkedList;
import listasArray.ArrayList;

/**
 *
 * @author lcc
 */
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ArrayList integer = new ArrayList();
        System.out.println("Tamanho do array: " + integer.size());
        int cont = 100,cont1 =100;
        for (int i = 0; i < 100; i++) {
            integer.insertAtFront(cont1--);
            integer.insertAtBack(++cont);
        }
        
        System.out.println("Tamanho do array: " + integer.size());
        integer.print();
        integer.printARR();
         integer.removeFromBack();
         integer.removeFromFront();
         integer.print();*/
        
        LinkedList ll = new LinkedList();
        ll.insertAtBack(2);
        ll.insertAtFront(1);
        ll.insertAtBack(5);
        ll.printListNode();
        
        //System.out.println("");
        //ll.removeFromFront();
        //ll.removeFromBack();
        //ll.printListNode();
    }
}
