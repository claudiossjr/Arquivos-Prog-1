/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaEncadeada;

/**
 *
 * @author lcc
 */
public class ListNode {
    protected Object data;
    protected ListNode nextNode;

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
    
    public ListNode (Object object){
        this.data = object;
    }
    
    public ListNode (Object object, ListNode node){
        this.data = object;
        this.nextNode = node;
    }
    
    public Object getObject(){
        return  data;
    }
    
    public ListNode  getNext(){
        return nextNode;
    }
}
