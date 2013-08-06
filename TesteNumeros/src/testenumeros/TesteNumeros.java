package testenumeros;

public class TesteNumeros 
{

    public static void main(String[] args) 
    {
        int aleatorio = (int)(((10*(Math.random()+1))/2)-4);
        if (aleatorio < 0)
        {
            aleatorio *= -1;
        }
        
        System.out.println(aleatorio);
    }
}
