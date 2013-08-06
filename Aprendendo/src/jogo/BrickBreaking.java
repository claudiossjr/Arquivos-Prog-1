package jogo;

import JPlay.*;




public class BrickBreaking 
{
    private Window Janela = new Window(800,600);
    private GameImage Fundo ;
    private GameImage FundoGameOver;
    private Sprite Bola = new Sprite("Imagens/Bola.png");
    private Sprite BarraInferior = new Sprite("Imagens/Barras/BarraInferior/BarraInferiorM.png");
    private Sprite BarraSuperior = new Sprite("Imagens/Barras/BarraSuperior/BarraSuperiorM.png");
    private Sprite BarraDireita = new Sprite("Imagens/Barras/BarraDireita/BarraDireitaM.png");
    private Sprite BarraEsquerda = new Sprite("Imagens/Barras/BarraEsquerda/BarraEsquerdaM.png"); 
    private Sprite Coracao= new Sprite("Imagens/Coracoes.png",5);
    
    //Bonus
    private Sprite AumentaHorizontal = new Sprite("Imagens/Bonus/setaInferiorMais.png");
    private Sprite DiminuiHorizontal = new Sprite("Imagens/Bonus/setaInferiorMenos.png");
    private Sprite AumentaVertical = new Sprite("Imagens/Bonus/setaVerticalMais.png");
    private Sprite DiminuiVertical = new Sprite("Imagens/Bonus/setaVerticalMenos.png");
    private Sprite Pontos = new Sprite("Imagens/Bonus/BonusPonto.png");
    private boolean DesenhaBonus = false;
    private int Aleatorio=1;
    private boolean peca1=false,peca2=false,peca3=false,peca4=false,peca5=false;
    private boolean AumentaHor = false,DiminuiHor=false,
                    AumentaVer = false,DiminuiVer=false;
    
    //private int Linha1, Coluna1;
    
    private Keyboard Teclado = Janela.getKeyboard();
    private Time Tempo, TimeBonus;
    private boolean Executando = true, Comeca = false;
    private double VelocidadeBolaX ;
    private double VelocidadeBolaY ;
    private float Velocidade;
    
    private int HorFase,MinFase,SegFase;
   
    private int Vida, Linha, Coluna, frames=0, Barra =2, Barra1=2;
    
    private int DesenhaBrickX, DesenhaBrickY;
    private int fase;
    private MatrizBrick matbrick[][];
    private boolean matdeleta[][] ;
   
    private boolean tempoBonus=false;
    
    private int peca;
    
    
    public BrickBreaking(float Velocidade,int Linha, int Coluna,int DesenhaBrickX,int DesenhaBrickY,int fase, int TempoFase)
    {
        this.Linha = Linha;
        this.Coluna = Coluna;
        this.DesenhaBrickX = DesenhaBrickX;
        this.DesenhaBrickY = DesenhaBrickY;
        this.fase = fase;
        matbrick = new MatrizBrick[Linha][Coluna];
        matdeleta = new boolean[Linha][Coluna];
        this.MinFase = TempoFase;
        
        if(this.fase == 1)
        {
          Fundo = new GameImage("Imagens/FundoJogo1.png");  
        }else if(this.fase == 2)
        {
            Fundo = new GameImage("Imagens/FundoJogo2.png");
        }
        
        this.Velocidade = Velocidade;
        this.VelocidadeBolaX = this.Velocidade;
        this.VelocidadeBolaY = this.Velocidade;
        ComecaBol();
        
        peca = this.Linha * this.Coluna;
        
        for (int i = 0; i < Linha; i++) 
        {
            for (int j = 0; j < Coluna; j++) 
            {
                matbrick[i][j] = new MatrizBrick("Imangens/Bola.png",DesenhaBrickX + i*60,DesenhaBrickY + j*30);
            }
        }
        Vida = 4;
        Dimensoes();
        DimensoesTijolos();
        Loop();
    }
    
    //teste de colisao com as barras
    private void MovimentoBola()
    {
       Bola.x += VelocidadeBolaX; 
       Bola.y += VelocidadeBolaY;
       
       //Barra Inferior
       if(Bola.collided(BarraInferior) )
       {
           VelocidadeBolaY = -Velocidade;
           VelocidadeBolaX = 0;
       }
       
       if(Bola.collided(BarraInferior) && Teclado.keyDown(Keyboard.RIGHT_KEY) )
       {
           VelocidadeBolaX = Velocidade/3;
           VelocidadeBolaY = -Velocidade;
       }
       
       if(Bola.collided(BarraInferior) && Teclado.keyDown(Keyboard.LEFT_KEY))
       {
           VelocidadeBolaX = -Velocidade/3;
           VelocidadeBolaY = -Velocidade;
       }
       
       //parte superior
       if(Bola.collided(BarraSuperior) )
       {
           VelocidadeBolaY = Velocidade;
           VelocidadeBolaX = 0;
       }
       
       if(Bola.collided(BarraSuperior) && Teclado.keyDown(Keyboard.RIGHT_KEY))
       {
           VelocidadeBolaX = Velocidade/3;
           VelocidadeBolaY = Velocidade;
       }
       
       if(Bola.collided(BarraSuperior) && Teclado.keyDown(Keyboard.LEFT_KEY))
       {
           VelocidadeBolaX = -Velocidade/3;
           VelocidadeBolaY = Velocidade;
       }
       //fim parte inferior e superior
       
       //Barra Direita e Esquerda
       if(Bola.collided(BarraDireita))
       {
           VelocidadeBolaX = -Velocidade;
           VelocidadeBolaY = 0;
       }
       if(Bola.collided(BarraDireita) && Teclado.keyDown(Keyboard.UP_KEY) )
       {
           VelocidadeBolaX = -Velocidade;
           VelocidadeBolaY = -Velocidade/3;
       }
       
       if(Bola.collided(BarraDireita) && Teclado.keyDown(Keyboard.DOWN_KEY))
       {
           VelocidadeBolaX = -Velocidade;
           VelocidadeBolaY = Velocidade/3;
       }
       //parte esquerda
       if(Bola.collided(BarraEsquerda) )
       {
           VelocidadeBolaX = Velocidade;
           VelocidadeBolaY =0;
       }
       
       if(Bola.collided(BarraEsquerda) && Teclado.keyDown(Keyboard.UP_KEY))
       {
           VelocidadeBolaX = Velocidade;
           VelocidadeBolaY = -Velocidade/3;
       }
       
       if(Bola.collided(BarraEsquerda) && Teclado.keyDown(Keyboard.DOWN_KEY))
       {
           VelocidadeBolaX = Velocidade;
           VelocidadeBolaY = Velocidade/3;
       }
       
       if(Bola.x < 10 || Bola.x+15 > 600 || Bola.y < 10 || Bola.y+15 > 600 )
       {
           Coracao.setCurrFrame(++frames);
           Comeca = false;
           DesenhaBonus = false;
           Vida -- ;
           HorFase = (int) Tempo.getHour();
           MinFase = (int) Tempo.getMinute();
           SegFase = (int) Tempo.getSecond();
           Recomeca();
       }
    }
    
    //tamanho barras e bola
    private void Dimensoes()
    {
        Bola.height = 8;
        Bola.width = 8;
        Bola.x = 296;
        Bola.y = 573; 
        
        //BarraInferior.height = 9;
        //BarraInferior.width = 80;
        BarraInferior.x = 260 ;  
        BarraInferior.y = 581; 
        
        //BarraSuperior.height = 9;
        //BarraSuperior.width = 80;
        BarraSuperior.x = 260 ;  
        BarraSuperior.y = 9;
        
        //BarraDireita.height = 80;
        //BarraDireita.width = 9;
        BarraDireita.x = 581;
        BarraDireita.y = 260;
        
        //BarraEsquerda.height = 80;
        //BarraEsquerda.width = 9;
        BarraEsquerda.x = 9;
        BarraEsquerda.y = 260;
        
        AumentaHorizontal.height = 5;
        AumentaHorizontal.width = 25;
        AumentaVertical.height = 25;
        AumentaVertical.width = 5;
        
        DiminuiHorizontal.height = 5;
        DiminuiHorizontal.width = 25;
        DiminuiVertical.height = 25;
        DiminuiVertical.width = 5;
        
        Pontos.height = 25;
        Pontos.width = 5;
        
        Coracao.x = 625;
        Coracao.y = 290;
    }
    
    //o que acontece que as barras
    private void Teclado()
    {
        int max = 590-BarraInferior.width;
            if(Teclado.keyDown(Keyboard.RIGHT_KEY) && BarraInferior.x <= max )
            {
                BarraInferior.x ++;
                BarraSuperior.x ++;
            }
            
            if(Teclado.keyDown(Keyboard.LEFT_KEY) && BarraInferior.x >= 10 )
            {
                BarraInferior.x --;
                BarraSuperior.x --;
            }
            
            if(Teclado.keyDown(Keyboard.UP_KEY) && BarraDireita.y >= 20 )
            {
                BarraDireita.y --;
                BarraEsquerda.y --;
            }
            
            if(Teclado.keyDown(Keyboard.DOWN_KEY) && BarraDireita.y <= 580-BarraDireita.height )
            {
                BarraDireita.y ++;
                BarraEsquerda.y ++;
            }
            
            if(Teclado.keyDown(Keyboard.ESCAPE_KEY))
            {
                Executando = false;
            } 
    }
    
    //desenha imagens
    private void DesenhoImagens()
    {
            Fundo.draw();
            Tempo.draw();
            Coracao.draw();
            BarraInferior.draw();
            BarraSuperior.draw();
            BarraDireita.draw();
            BarraEsquerda.draw();
            Bola.draw();
            
            /*if(DesenhaBonus)
            {
                DesenhaBonus1();
            }*/
            
            for (int i = 0; i < Linha; i++) 
            {
                for (int j = 0; j < Coluna; j++) 
                {
                    if(!(matdeleta[i][j]))
                    matbrick[i][j].Desenha();
                }
            }
    }
    
    private void DesenhaBonus1()
    {
            if(peca1)
            {
                AumentaHorizontal.y+=0.3;
                AumentaHorizontal.draw();
                
            }
            /*if( peca2)
            {
                DiminuiHorizontal.y+=0.3;
                DiminuiHorizontal.draw();
            }
            if( peca3)
            {
                AumentaVertical.x+=0.3;
                AumentaVertical.draw();
            }
            if( peca4)
            {
                DiminuiVertical.x+=0.3;
                DiminuiVertical.draw();
            }*/
    }
    
    //verifica se bonus saiu
    private void Saiu()
    {
        /*
        if(AumentaHorizontal.y > 590)
        {
           peca1=false;
            Aleatorio++;
            AumentaHorizontal.hide();
        }
        
        /*if(DiminuiHorizontal.y > 590)
        {
           peca2=false; 
           Aleatorio++;
           DiminuiHorizontal.hide();
        }
        
        if(AumentaVertical.x > 590)
        {
           peca3=false;
            Aleatorio++;
            AumentaVertical.hide();
        }
        
        if(DiminuiVertical.x > 590)
        {
            peca4=false;
            Aleatorio++;
            DiminuiVertical.hide();
        }
        if(Pontos.x > 590)
        {
            peca5=false;
            Pontos.hide();
        }*/
    }
    
    //desenha imagens pause
    private void DesenhoImagensPause()
    {
            Fundo.draw();
            Tempo.draw();
            Coracao.draw();
            BarraInferior.draw();
            BarraSuperior.draw();
            BarraDireita.draw();
            BarraEsquerda.draw();
            Bola.draw();
            
            for (int i = 0; i < Linha; i++) 
            {
                for (int j = 0; j < Coluna; j++) 
                {
                    if(!(matdeleta[i][j]))
                    matbrick[i][j].Desenha();
                }
            }
            
        if(peca1)
        {
        AumentaHorizontal.draw();
        }
        
        if(peca2)
        {
        DiminuiHorizontal.draw();
        }
        
        if(peca3)
        {
        AumentaVertical.draw();
        }
        
        if(peca4)
        {
        DiminuiVertical.draw();
        }
        
        if(peca5)
        {
        Pontos.draw();
        }
    }
    
    //comeca o jogo
    private void Comeca()
    {
        
                if(Teclado.keyDown(Keyboard.RIGHT_KEY) && BarraInferior.x <= 590-BarraInferior.width )
                {
                    BarraInferior.x ++;
                    BarraSuperior.x ++;
                    Bola.x ++;
                }
            
                if(Teclado.keyDown(Keyboard.LEFT_KEY) && BarraInferior.x >= 10 )
                {
                    BarraInferior.x --;
                    BarraSuperior.x --;
                    Bola.x --;
                }
            
                if(Teclado.keyDown(Keyboard.UP_KEY) && BarraDireita.y >= 20 )
                {
                    BarraDireita.y --;
                    BarraEsquerda.y --;
                }
            
                if(Teclado.keyDown(Keyboard.DOWN_KEY) && BarraDireita.y <= 580-BarraDireita.height )
                {
                    BarraDireita.y ++;
                    BarraEsquerda.y ++;
                }
            
                if(Teclado.keyDown(Keyboard.SPACE_KEY))
                {
                    Comeca = true;
                }
                
                if(Teclado.keyDown(Keyboard.ESCAPE_KEY))
                {
                    Executando = false;
                }
   }
    
    //Recomeca o jogo quando a bola sai da tela
    private void Recomeca()
    {
        VelocidadeBolaX = Velocidade;
        VelocidadeBolaY = Velocidade;
        Dimensoes();
        Loop();
    }
    
    //Dimensoes dos tijolos
    private void DimensoesTijolos()
    {
        for (int i = 0; i < Linha; i++) 
        {
            for (int j = 0; j < Coluna; j++) 
            {
                matbrick[i][j].height = 20;
                matbrick[i][j].width = 50;
            }
        }
    }
    
    //colisao Bola Tijolo
    private void Colisoes()
    {
        for (int i = 0; i < Linha; i++) 
        {
            for (int j = 0; j < Coluna; j++) 
            {
                if(!(matdeleta[i][j]))
                {
                    //Inicio Inferior
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaX > 0 && VelocidadeBolaY < 0)
                        {
                            VelocidadeBolaY *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaX < 0 && VelocidadeBolaY < 0)
                        {
                            VelocidadeBolaY *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        //Fim Inferior
                        
                        //Inicio Superior
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaX > 0 && VelocidadeBolaY > 0)
                        {
                            VelocidadeBolaY *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaX < 0 && VelocidadeBolaY > 0)
                        {
                            VelocidadeBolaY *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        //Fim Superior
                        
                        //bola reta
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaY < 0)
                        {
                            VelocidadeBolaY *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaY > 0)
                        {
                            VelocidadeBolaY *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaX < 0)
                        {
                            VelocidadeBolaX *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        
                        if(Bola.collided(matbrick[i][j].Tijolo) && VelocidadeBolaX > 0)
                        {
                            VelocidadeBolaX *= -1;
                            matbrick[i][j].Deleta();
                            matdeleta[i][j] = true;
                            peca--;
                        }
                        //fim Bola Reta
                        
                        /*Linha1=i;
                        Coluna1=j;
                        */
                        
                        
                }
            }
        }
    }
    
    //colisao Barra Bonus
    private void ColisaoBonus()
    {
        if(AumentaHorizontal.collided(BarraInferior) && (Barra == 1))
        {
            BarraInferior = new Sprite("Imagens/Barras/BarraInferior/BarraInferiorM.png");
            BarraInferior.x = 260;  
            BarraInferior.y = 581;
            
            BarraSuperior = new Sprite("Imagens/Barras/BarraSuperior/BarraSuperiorM.png");
            BarraSuperior.x = 260;  
            BarraSuperior.y = 9;
            
            Aleatorio++;
            peca1=false;
            Barra++;
        }
        if(AumentaHorizontal.collided(BarraInferior) && (Barra == 2))
        {
            BarraInferior = new Sprite("Imagens/Barras/BarraInferior/BarraInferiorG.png");
            BarraInferior.x = 260;  
            BarraInferior.y = 581;
            
            BarraSuperior = new Sprite("Imagens/Barras/BarraSuperior/BarraSuperiorG.png");
            BarraSuperior.x = 260;  
            BarraSuperior.y = 9;
            
            Aleatorio++;
            peca1=false;
            Barra++;
        }
        
        if(DiminuiHorizontal.collided(BarraInferior) && (Barra == 2))
        {
            BarraInferior = new Sprite("Imagens/Barras/BarraInferior/BarraInferiorP.png");
            BarraInferior.x = 260;  
            BarraInferior.y = 581;
            
            BarraSuperior = new Sprite("Imagens/Barras/BarraSuperior/BarraSuperiorP.png");
            BarraSuperior.x = 260;  
            BarraSuperior.y = 9;
            
            Aleatorio++;
            peca2=false;
            Barra--;
        }
        if(DiminuiHorizontal.collided(BarraInferior)&& (Barra == 3))
        {
            BarraInferior = new Sprite("Imagens/Barras/BarraInferior/BarraInferiorM.png");
            BarraInferior.x = 260;  
            BarraInferior.y = 581;
            
            BarraSuperior = new Sprite("Imagens/Barras/BarraSuperior/BarraSuperiorM.png");
            BarraSuperior.x = 260;  
            BarraSuperior.y = 9;
            
            Aleatorio++;
            peca2=false;
            Barra--;
        }
        
        if(AumentaVertical.collided(BarraDireita) && (Barra1 == 1))
        {
            BarraDireita = new Sprite("Imagens/Barras/BarraDireita/BarraDireitaM.png"); 
            BarraDireita.x = 581;
            BarraDireita.y = 260;
            
            BarraEsquerda = new Sprite("Imagens/Barras/BarraEsquerda/BarraEsquerdaM.png"); 
            BarraEsquerda.x = 9;
            BarraEsquerda.y = 260;
            
            Aleatorio++;
            peca3=false;
            Barra1++;
        }
        if(AumentaVertical.collided(BarraDireita) && (Barra1 == 2))
        {
            BarraDireita = new Sprite("Imagens/Barras/BarraDireita/BarraDireitaG.png"); 
            BarraDireita.x = 581;
            BarraDireita.y = 260;
            
            BarraEsquerda = new Sprite("Imagens/Barras/BarraEsquerda/BarraEsquerdaG.png"); 
            BarraEsquerda.x = 9;
            BarraEsquerda.y = 260;
            
            Aleatorio++;
            peca3=false;
            Barra1++;
        }
        
        
        if(DiminuiVertical.collided(BarraDireita) && (Barra1 == 2))
        {
            BarraDireita = new Sprite("Imagens/Barras/BarraDireita/BarraDireitaP.png"); 
            BarraDireita.x = 581;
            BarraDireita.y = 260;
            
            BarraEsquerda = new Sprite("Imagens/Barras/BarraEsquerda/BarraEsquerdaP.png"); 
            BarraEsquerda.x = 9;
            BarraEsquerda.y = 260;
            
            Aleatorio++;
            peca4=false;
            Barra1--;
        }
        if(DiminuiVertical.collided(BarraDireita) && (Barra1 == 3))
        {
            BarraDireita = new Sprite("Imagens/Barras/BarraDireita/BarraDireitaM.png"); 
            BarraDireita.x = 581;
            BarraDireita.y = 260;
            
            BarraEsquerda = new Sprite("Imagens/Barras/BarraEsquerda/BarraEsquerdaM.png"); 
            BarraEsquerda.x = 9;
            BarraEsquerda.y = 260;
            
            Aleatorio++;
            peca4=false;
            Barra1--;
        }
    }
    
    //inicializando a matriz de de boolean para desenhar os tijolos
    private void ComecaBol()
    {
        for (int i = 0; i < Linha; i++) 
        {
            for (int j = 0; j < Coluna; j++) 
            {
                matdeleta[i][j] = false;
            }
        }
    }
    
    //tela de game over
    private void TelaPerdeu()
    {
        boolean Exec = true;
        FundoGameOver = new GameImage("Imagens/GameOver.png");
        while(Exec)
        {
            if(Teclado.keyDown(Keyboard.ESCAPE_KEY))
            {
              new TelaInicial();
            }
            
            FundoGameOver.draw();
            Janela.display();
        }
    }
    
    //Para Mudar as Barras do jogo
    private void BarrasJogo(int Numero, int Numero1)
    {
        if(Numero == 1)
        {
        BarraInferior.height = 9;
        BarraInferior.width = 55;
        BarraSuperior.height = 9;
        BarraSuperior.width = 55;
        }
        if(Numero1 == 1)
        {
        BarraDireita.height = 55;
        BarraDireita.width = 9;
        BarraEsquerda.height = 55;
        BarraEsquerda.width = 9;
        }
        
        if(Numero == 2)
        {
        BarraInferior.height = 9;
        BarraInferior.width = 80;
        BarraSuperior.height = 9;
        BarraSuperior.width = 80;
        }
        
        if(Numero1 == 2)
        {
        BarraDireita.height = 80;
        BarraDireita.width = 9;
        BarraEsquerda.height = 80;
        BarraEsquerda.width = 9;
        }
        
        if (Numero == 3)
        {
        BarraInferior.height = 9;
        BarraInferior.width = 159;
        BarraSuperior.height = 9;
        BarraSuperior.width = 159;
        }
        if(Numero1==3)
        {
        BarraDireita.height = 159;
        BarraDireita.width = 9;
        BarraEsquerda.height = 159;
        BarraEsquerda.width = 9;    
        }
    }
    
    //bonus
    private void Bonus()
    {
        /*
        
        if(Aleatorio == 1)
        {
        AumentaHorizontal.x = 300;   
        AumentaHorizontal.y = 300; 
        peca1=true;
        DesenhaBonus=true;
        //Aleatorio++;
        } 
        
         * else if(Aleatorio == 2)
        {
        DiminuiHorizontal.x = 300;   
        DiminuiHorizontal.y = 300;
        peca2 =true;
        DesenhaBonus=true;
        //Aleatorio++;
        }else if(Aleatorio == 3)
        {
        AumentaVertical.x = 300;   
        AumentaVertical.y = 300;
        peca3=true;
        DesenhaBonus=true;
        //Aleatorio++;
        }else if(Aleatorio == 4)
        {
        DiminuiVertical.x = 300;   
        DiminuiVertical.y = 300;
        peca4 = true;
        DesenhaBonus=true;
        //Aleatorio++;
        }
        
        if(Aleatorio == 5)
        {
        Pontos.x = 300;   
        Pontos.y = 300;
        peca5 = true;
        //Aleatorio++;
        }
        
        if (Aleatorio > 4)
        {
            Aleatorio = 0;
        }*/
    }
    
    //loop do jogo
    public void Loop()
    {
        boolean pause = false;
        Tempo = new Time( HorFase, MinFase, SegFase, 690, 450, false);
        while(Executando)
        {
            /*if (!(tempoBonus))
            {
            TimeBonus = new Time(0,0,10,-40,-50,false);
            tempoBonus = true;    
            }
            
            if(TimeBonus.timeEnded())
            {
                tempoBonus = false;
                Bonus();
            }*/
            BarrasJogo(Barra,Barra1);
            
            if(Teclado.keyDown(Keyboard.ENTER_KEY))
            {
                pause = true;
            }
            DesenhoImagens();
            Colisoes();
            ColisaoBonus();
            Janela.display();
            
            
            if(!(Comeca))
            {
            Comeca();
            }
            else
            {
            Teclado();
            MovimentoBola();
            }
            Saiu();
            
            
            
            while (pause)
            {
                HorFase = (int) Tempo.getHour();
                MinFase = (int) Tempo.getMinute();
                SegFase = (int) Tempo.getSecond();
                Tempo = new Time( HorFase, MinFase, SegFase, 690, 450, false);
                if(Teclado.keyDown(Keyboard.ENTER_KEY))
                {
                    pause = false;
                }
                DesenhoImagensPause();
                Janela.display();
            }
            
            
            if (Vida <= 0)
            {
                TelaPerdeu();
            }
            
            if(Tempo.timeEnded())
            {
                TelaPerdeu();
            }
            
            if(peca <= 0)
            {
             new BrickBreaking(0.4f,7 ,10, 100, 120, ++fase, 5);
            }
            
        }
    new TelaInicial();                  
    } 
}