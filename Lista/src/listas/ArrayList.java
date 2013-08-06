/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author lcc
 */
public class ArrayList implements IList {

    protected Object[] arr;
    protected int start, end;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        start = end = DEFAULT_CAPACITY / 2;
    }

    public void resize(int pos) {
        if ((pos < 0 || pos > arr.length - 1)) {
            Object[] temp = new Object[arr.length * 2];
            int start1 = (temp.length / 2) - (arr.length / 2);

            for (int i = 0; i < arr.length; i++) {
                temp[start1 + i] = arr[i];
            }

            this.start = start1;
            this.end = start1 + arr.length;
            arr = temp;
        }
    }

    @Override
    public void insertAtFront(Object insertItem) {
        resize(start - 1);
        arr[start - 1] = insertItem;
        start--;
    }

    @Override
    public void insertAtBack(Object insertItem) {
        resize(end);
        arr[end] = insertItem;
        end++;
    }

    @Override
    public Object removeFromFront() {
        if (!(isEmpty())) {
            Object temp = arr[start];
            arr[start] = null;
            start ++;
            return temp;
        }
        return null;
    }

    @Override
    public Object removeFromBack() {
        if (!(isEmpty())) {
            Object temp = arr[end - 1];
            arr[end - 1] = null;
            end --;
            return temp;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void makeEmpty() {
    }

    @Override
    public int size() {
        return ((end - start));
    }

    @Override
    public Object get(int n) {
        if (n >= start && n <= end) {
            return arr[start + n];
        }
        return null;
    }

    @Override
    public void set(int n, Object o) {
        if (n >= start && n <= end) {
            int pos = start + n;
            resize(pos);
            arr[pos] = o;
        }
    }

    @Override
    public void print() {
        for (int i = start; i < end; i++) {
            System.out.print("Elemento " + i + " : ");
            System.out.println(arr[i]);
        }
    }
    
    public void printARR(){
        System.out.println("Tamanho do Arr: "+ arr.length);
    }
}
