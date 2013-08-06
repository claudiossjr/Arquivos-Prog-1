package jogoprog1;

import JPlay.Window;
import JPlay.GameImage;
import JPlay.Keyboard;
import java.awt.Color;
import java.awt.Font;

public class Jogo2 {

    Window janela;
    Keyboard keyboard;
    GameImage fundo2;
    Barra barra;
    Bola bola;
    Font fonte;
    Bloco[][] bloco;
    int vidas;
    int pontos;
    int fase3;

    public Jogo2() {
    }

    void carregar(Window janela) {
        this.janela = janela;
        fundo2 = new GameImage("inicio1.jpg");
        keyboard = new Keyboard();
        keyboard = janela.getKeyboard();
        barra = new Barra("Paddle.gif");
        bola = new Bola("bola.gif");
        vidas = 0;
        pontos = 0;
        fonte = new Font("Calibri", Font.BOLD, 20);
        bloco = new Bloco[15][8];
        for (int i = 0; i < 15; i++) {
            bloco[i][0] = new Bloco("1.jpg");
            bloco[i][1] = new Bloco("2.jpg");
            bloco[i][2] = new Bloco("3.jpg");
            bloco[i][3] = new Bloco("2.jpg");
            bloco[i][4] = new Bloco("1.jpg");
            bloco[i][5] = new Bloco("2.jpg");
            bloco[i][6] = new Bloco("3.jpg");
            bloco[i][7] = new Bloco("2.jpg");
        }

    }

    void desenha() {
        fundo2.draw();
        barra.draw();
        bola.draw();
        janela.drawText(Integer.toString(pontos), 710, 33, Color.red, fonte);
        janela.drawText(Integer.toString(vidas), 248, 32, Color.red, fonte);

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 8; j++) {

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
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 8; j++) {
                bloco[i][j].x = 25 + (i * 50);
                bloco[i][j].y = 35 + bloco[i][j].height + (j * 35);
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
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 8; j++) {
                    if (bola.collided(bloco[i][j])) {
                        bloco[i][j] = new Bloco("bola.gif");
                        bloco[i][j].hide();

                        pontos += 10;
                        fase3++;
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
                barra.x = 350;
                bola.x = 200;
                bola.y = 380;
                janela.delay(1000);
            }

            if (vidas == 0) {
                GameOver jogo = new GameOver();
            }
            if (pontos == 1000) {
                vidas++;
                pontos = 0;
            }
            if (fase3 >= 120) {
                Jogo3 jogo = new Jogo3();
                jogo.carregar(janela);
                jogo.inicializar();
                jogo.vidas = vidas;
                jogo.pontos = pontos;
                jogo.loop();
            }
        }
    }
}
