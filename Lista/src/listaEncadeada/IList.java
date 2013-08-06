/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaEncadeada;

/**
 *
 * @author lcc
 */
public interface IList {
    public void insertAtFront(Object o);
    public void insertAtBack(Object o);
    public Object removeFromBack ();
    public Object removeFromFront();
    public boolean isEmpty();
    public void makeEmpty();
}
