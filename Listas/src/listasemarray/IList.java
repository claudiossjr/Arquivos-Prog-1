/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listasemarray;

/**
 *
 * @author claudio
 */
public interface IList {
    public void insereFrente(Object o);
    public void insereAtras(Object o);
    public Object removeFrente();
    public Object removeAtras();
    public boolean isEmpty();
    public void makeEmpty();
    public int size();
    public Object get(int n);
    public void set(int n, Object o);
    public void print();
}
