package listaEncadeada;

public class LinkedList implements IList {

    protected ListNode firstNode;
    protected ListNode lastNode;

    public LinkedList() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void insertAtFront(Object o) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(o, null);
        } else {
            firstNode = new ListNode(o, firstNode);
        }
    }

    @Override
    public void insertAtBack(Object o) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(o, null);
        } else {
            ListNode ln = new ListNode(o, null);
            lastNode.setNextNode(ln);
            lastNode = ln;
        }
    }

    @Override
    public Object removeFromBack() {
        if (!(isEmpty())) {
            if (firstNode == lastNode) {
                firstNode = lastNode = null;
            } else {
                ListNode ln = firstNode;
                boolean executando = true;
                while(executando)
                {
                    if(ln.getNext() == lastNode){
                        ListNode ln2 = lastNode;
                        lastNode = ln;
                        ln.setNextNode(null);
                        return ln2;
                    }
                    ln = ln.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public Object removeFromFront() {
        if (!(isEmpty())) {
            if (firstNode == lastNode) {
                firstNode = lastNode = null;
            } else {
                ListNode ln = firstNode;
                firstNode = firstNode.getNext();
                return ln;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null && lastNode == null);
    }

    @Override
    public void makeEmpty() {
        firstNode = lastNode = null;
    }

    public Object getFront() {
        return firstNode;
    }

    public Object getBack() {
        return lastNode;
    }

    public void printListNode() {
        ListNode ln = firstNode;
        if (isEmpty()) {
            System.out.println("a Lista esta vazia");
        } else {
            while (ln != null) {
                System.out.println(ln.getObject());
                ln = ln.getNext();
            }
        }
    }
}
