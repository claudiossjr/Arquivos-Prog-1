package teste;

import conjunto.Conjunto;


public class Teste {

    
    public static void main(String[] args) {
       Conjunto c1 = new Conjunto();
        Conjunto c2 = new Conjunto();
        Conjunto c3 = new Conjunto();
        Conjunto c4 = new Conjunto();
        
        c1.Insere(1);
        c1.Insere(2);
        c1.Insere(3);
        c1.Insere(4);
        
        c2.Insere(1);
        c2.Insere(2);
        c2.Insere(3);
        c2.Insere(4);
        c2.Insere(5);
        c2.Insere(10);
        
        c3 = c1.Uniao(c2);
        c4 = c1.Intersecao(c2);
        
        for(int i =0; i< c3.iPonteiro ; i++)
        {
            System.out.println(c3.vetor[i]);
        }
        
        System.out.println();
        System.out.println();
        
        for(int i =0; i< c4.iPonteiro ; i++)
        {
            System.out.println(c4.vetor[i]);
        }
    }
}
