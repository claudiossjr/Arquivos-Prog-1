/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoprog1;

import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;
import java.awt.Color;
import java.awt.Font;

public class Jogo1 {

    Window janela;
    Keyboard keyboard;
    GameImage fundo1;
    Barra barra;
    Bola bola;
    Font fonte;
    Bloco[][] bloco;
    int vidas;
    int pontos;
    int fase2;

    public Jogo1(Window janela) {
        carregar(janela);
        inicializar();
        loop();
    }

    void carregar(Window janela) {
        this.janela = janela;
        fundo1 = new GameImage("inicio1.jpg");
        keyboard = new Keyboard();
        keyboard = janela.getKeyboard();
        barra = new Barra("Paddle.gif");
        bola = new Bola("bola.gif");
        vidas = 5;
        pontos = 0;
        fase2 = 0;
        fonte = new Font("Calibri", Font.BOLD, 20);
        bloco = new Bloco[10][7];
        for (int i = 0; i < 10; i++) {
            bloco[i][0] = new Bloco("1.jpg");
            bloco[i][1] = new Bloco("2.jpg");
            bloco[i][2] = new Bloco("3.jpg");
            bloco[i][3] = new Bloco("4.jpg");
            bloco[i][4] = new Bloco("5.jpg");
            bloco[i][5] = new Bloco("6.jpg");
            bloco[i][6] = new Bloco("7.jpg");
        }
    }

    void desenha() {
        fundo1.draw();
        barra.draw();
        bola.draw();
        janela.drawText(Integer.toString(pontos), 710, 33, Color.red, fonte);
        janela.drawText(Integer.toString(vidas), 248, 32, Color.red, fonte);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {

                if (!bloco[i][j].equals("bola.gif")) {
                    bloco[i][j].draw();
                }
            }
        }
        janela.display();
        janela.delay(1);
    }

    void inicializar() {
        barra.x = 350;
        barra.y = 580;
        bola.x = 200;
        bola.y = 380;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                bloco[i][j].x = 150 + (i * 50);
                bloco[i][j].y = 100 + bloco[i][j].height + (j * 25);
            }
        }


    }

    void loop() {

        while (true) {
            desenha();
            barra.moveX(keyboard, Keyboard.RIGHT_KEY, Keyboard.LEFT_KEY);
            bola.BolaX();
            bola.BolaY();

            if (bola.collided(barra)) {
                bola.movery = true;
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 7; j++) {
                    if (bola.collided(bloco[i][j])) {
                        bloco[i][j] = new Bloco("bola.gif");
                        bloco[i][j].hide();

                        pontos += 10;
                        fase2++;
                        if (bola.moverx == true) {
                            bola.moverx = false;
                        }

                        if (bola.moverx == false) {
                            bola.moverx = true;
                        }
                        if (bola.movery == true) {
                            bola.movery = false;
                        } else if (bola.movery == false) {
                            bola.movery = true;
                        }


                    }
                }
            }


            if (bola.y == 600) {
                bola.moverx = false;
                vidas--;
                bola.velY = 0;
                barra.x = 350;
                bola.x = 200;
                bola.y = 380;
                janela.delay(1000);

            }
            if (vidas == 0) {
                GameOver jogo = new GameOver();
                janela = null;
            }
            if (pontos == 1000) {
                vidas++;
                pontos = 0;
            }
            if (fase2 >= 70) {
                Jogo2 jogo = new Jogo2();
                jogo.carregar(janela);
                jogo.inicializar();
                jogo.vidas = vidas;
                jogo.pontos = pontos;
                jogo.loop();
            }

        }
    }
}
