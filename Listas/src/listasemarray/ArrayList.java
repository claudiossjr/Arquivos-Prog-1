/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listasemarray;

/**
 *
 * @author claudio
 */
public class ArrayList implements IList {

    protected Object arr[];
    protected int inicio, fim;
    private static final int TAMANHO_ARRAY = 10;

    public ArrayList() {
        arr = new Object[TAMANHO_ARRAY];
        inicio = fim = TAMANHO_ARRAY / 2;
    }

    @Override
    public void insereFrente(Object o) {
        resize(inicio - 1);
        arr[inicio - 1] = o;
        inicio--;
    }

    @Override
    public void insereAtras(Object o) {
        resize(fim);
        arr[fim] = o;
        fim++;
    }

    @Override
    public Object removeFrente() {
        if (!isEmpty()) {
            Object temp = arr[inicio];
            arr[inicio] = null;
            inicio++;
            return temp;
        }
        return null;
    }

    @Override
    public Object removeAtras() {
        if (!isEmpty()) {
            Object temp = arr[fim - 1];
            arr[fim - 1] = null;
            fim--;
            return temp;
        }
        return null;
    }

    @Override
    public int size() {
        return (fim - inicio);
    }

    @Override
    public void print() {
        for (int i = inicio; i < fim; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println("");
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void makeEmpty() {
        for (int i = inicio; i < fim; i++) {
            arr[i] = null;
        }
        arr = new Object[TAMANHO_ARRAY];
        inicio = fim = arr.length / 2;
    }

    public void resize(int pos) {
        if ((pos < 0) || (pos > (arr.length - 1))) {
            Object[] temp = new Object[arr.length * 2];
            int start1 = (temp.length / 2) - (arr.length / 2);

            for (int i = 0; i < arr.length; i++) {
                temp[start1 + i] = arr[i];
            }

            this.inicio = start1;
            this.fim = start1 + arr.length;
            this.arr = temp;
        }
    }

    @Override
    public Object get(int n) {
        return arr[inicio + n];
    }

    @Override
    public void set(int n, Object o) {
        arr[inicio + n] = o;
    }
}
