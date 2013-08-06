package conjunto;

public class Conjunto
{
    private final int tamanho = 100;
    public int ponteiro;
    
    public int[] vetor = new int[tamanho];
    
    public Conjunto()
    {
        ponteiro = 0;
    }
    
    public boolean Cheio()
    {        
        return (ponteiro == tamanho);
    }
    public boolean Vazio()
    {
        return (ponteiro == 0);
    }
    
    public boolean Insere(int elemento)
    {
        if(Pertence(elemento))
        {
            return false;
        }
        else
        {
            vetor[ponteiro] = elemento;
            ponteiro++;
            return true;
        }
    }
    public boolean Remove(int elemento)
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
            return true;
        }
    }
    public boolean Pertence(int elemento)
    {
        for(int i = 0; i < ponteiro; i++)
        {
            if(vetor[i] == elemento)
            {
                return true;
            }
        }
        return false;
    }
    public Conjunto Intersecao(Conjunto c2)
    {
        Conjunto c3 = new Conjunto();
        for(int a = 0; a < ponteiro; a++)
        {
            for(int b = 0; b < c2.ponteiro; b++)
            {
                if((vetor[a] == c2.vetor[b]))
                {
                    c3.Insere(vetor[a]);
                }    
            }
        }
        return c3;
    }
    public Conjunto Uniao(Conjunto c2)
    {
        Conjunto c3 = new Conjunto();
        
        for(int a = 0; a < ponteiro; a++)
        {
            c3.Insere(vetor[a]);
        }
        
        for(int b = 0; b < c2.ponteiro; b++)
        {
            if(!(c3.Pertence(c2.vetor[b])))
            {
                c3.Insere(c2.vetor[b]);
            }       
        }
        
        return c3;
    }
}
