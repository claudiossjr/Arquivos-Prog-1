/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listasArray;

/**
 *
 * @author lcc
 */
public interface IList {

    public void insertAtFront(Object insertItem);
    public void insertAtBack(Object insertItem);
    public Object removeFromFront();
    public Object removeFromBack();
    public boolean isEmpty();
    public void makeEmpty();
    public int size();
    public Object get(int n);
    public void set(int n, Object o);
    public void print();
}