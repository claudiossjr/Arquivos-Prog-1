package conjunto;

public class Conjunto
{
    final int tamanho = 100;
    int ponteiro;
    
    int[] vetor = new int[tamanho];
    
    public Conjunto()
    {
        ponteiro = 0;
    }
    
    boolean Cheio()
    {        
        return (ponteiro == tamanho);
    }
    boolean Vazio()
    {
        return (ponteiro == 0);
    }
    
    boolean Insere(int elemento)
    {
        if(Pertence(elemento))
        {
            return false;
        }
        else
        {
            vetor[ponteiro] = elemento;
            ponteiro++;
        }
        return false;
    }
    boolean Remove(int elemento)
    {
        if(!Pertence(elemento))
            return false;
        else
        {
            for(int i = 0; i == ponteiro; i++)
            {
                if(vetor[i] == elemento)
                {
                    vetor[i] = vetor[ponteiro-1];
                    ponteiro--;
                    return true;
                }
            }
        }
        return false;
    }
    boolean Pertence(int elemento)
    {
        for(int i = 0; i == ponteiro; i++)
        {
            if(vetor[i] == elemento)
            {
                return true;
            }
        }
        return false;
    }
    void Intersecao(Conjunto c1, Conjunto c2)
    {
        Conjunto c3 = new Conjunto();
        for(int a = 0; a == c1.ponteiro; a++)
        {
            for(int b = 0; b == c2.ponteiro; b++)
            {
                if(c1.vetor[a] == c2.vetor[b])
                {
                    c3.vetor[c3.ponteiro] = c1.vetor[a];
                    c3.ponteiro++;
                }    
            }
        }
    }
    void Uniao(Conjunto c1,Conjunto c2)
    {
        Conjunto c3 = new Conjunto();
        for(int a = 0; a == c1.ponteiro; a++)
        {
            c3.vetor[c3.ponteiro] = c1.vetor[a];
            c3.ponteiro++;
        }
        for(int b = 0; b == c2.ponteiro; b++)
        {
            if(c3.Pertence(c2.vetor[b]))
            {
            }
            else
            {
                c3.vetor[c3.ponteiro] = c2.vetor[b];
                c3.ponteiro++;
            }       
        }
    }
}
