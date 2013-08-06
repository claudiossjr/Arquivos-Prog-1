/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import JPlay.*;

public class TelaInicial {
        private Window janela = new Window(800, 600);
        private Mouse mouse = janela.getMouse();
        private GameImage background = new GameImage("Imagens/menu1.png");
        private BrickBreaking game;

    private void Menu() {
        
        boolean Executando = true,botao;

        //inicio do loop do menu
        while (Executando) {
            background.draw();
            janela.display();
            
            
            //teste do mouse
            botao = mouse.isLeftButtonPressed();
            if (botao && mouse.isOverArea(284, 426, 510, 483)) 
            {
                game = new BrickBreaking(0.3f ,7 ,10 ,100 ,100 ,1 ,4 );
                
            }
             
            if (botao && mouse.isOverArea(284, 497, 510, 553)) {
                Executando = false;
            }

        }
        janela.exit();//fechando a janela
    }
    
    public TelaInicial()
    {
        Menu();
    }
}