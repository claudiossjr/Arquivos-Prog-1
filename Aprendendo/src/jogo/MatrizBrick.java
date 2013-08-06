package jogo;

import JPlay.Sprite;

public class MatrizBrick extends Sprite
{
    private int CordX,CordY;
    Sprite Tijolo = new Sprite("Imagens/Blocos/Bloco1.png");
    public MatrizBrick(String FileName,int CordX,int CordY)
    {
        super(FileName,1);
        this.CordX = CordX;
        this.CordY = CordY;
    }
    
    public void Desenha()
    {
        Tijolo.x = CordX;
        Tijolo.y = CordY;
        Tijolo.draw();
    }
    
    public void Deleta()
    {
        Tijolo = new Sprite("");
    }
}