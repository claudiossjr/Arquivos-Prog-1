package conjunto;

public class testeConjunto
{
    public static void main(String[] args)
    {
        Conjunto c1 = new Conjunto();
        Conjunto c2 = new Conjunto();
        Conjunto teste = new Conjunto();
        Conjunto testeINTER = new Conjunto();
        
        c1.Insere(0);
        c1.Insere(1);
        c1.Insere(2);
        c1.Insere(4);
        c1.Insere(8);
        
        c2.Insere(0);
        c2.Insere(1);
        c2.Insere(3);
        c2.Insere(5);
        c2.Insere(7);
        
        teste = c1.Uniao(c2);
        testeINTER = c1.Intersecao(c2);
        
        for(int i = 0; i < teste.ponteiro; i ++)
            System.out.println(teste.vetor[i]);
        
        System.out.println();
        System.out.println();
        
        for(int i = 0; i < testeINTER.ponteiro; i ++)
            System.out.println(testeINTER.vetor[i]);
    }
}
