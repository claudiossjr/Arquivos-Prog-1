package conjunto;

public class Conjunto {

    private final int iTamanho = 100;
    public int iPonteiro = 0;
    public int[] vetor = new int[iTamanho];

    public Conjunto()
    {
        iPonteiro = 0;
    }

    public boolean cheio()
    {
        return (iPonteiro == iTamanho);
    }

    public boolean Vazio()
    {
        return (iPonteiro == 0);
    }

    public boolean Pertence(int iElemento) 
    {
        for (int i = 0; i < iPonteiro; i++) {
            if (vetor[i] == iElemento) {
                return true;
            }
        }
        return false;
    }

    public void Insere(int iElemento) 
    {
        if (!(Pertence(iElemento))) {
            vetor[iPonteiro] = iElemento;
            iPonteiro++;
        }
    }

    public void Remove(int iElemento)
    {
        if (Pertence(iElemento)) {
            for (int i = 0; i < iPonteiro; i++) {
                if (vetor[i] == iElemento) {
                    vetor[i] = vetor[iPonteiro];
                }
            }
            iPonteiro--;
        }
    }

    public Conjunto Uniao(Conjunto c) 
    {
        Conjunto c3 = new Conjunto();
        for (int i = 0; i < iPonteiro; i++) {
            c3.Insere(vetor[i]);
        }

        for (int i = 0; i < c.iPonteiro; i++) {
            c3.Insere(c.vetor[i]);
        }

        return c3;
    }

    public Conjunto Intersecao(Conjunto c) 
    {

        Conjunto c3 = new Conjunto();
        for (int i = 0; i < iPonteiro; i++) 
        {
            if (Pertence(c.vetor[i])) 
            {
                c3.Insere(c.vetor[i]);
            }
        }
        return c3;
    }
}