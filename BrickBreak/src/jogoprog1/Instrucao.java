/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoprog1;

import JPlay.Window;
import JPlay.GameImage;
import JPlay.Keyboard;

public class Instrucao {

    Window janela;
    GameImage fundo;
    Keyboard teclado;

    public Instrucao(Window janela) {
        carregar(janela);
        loop();
    }

    void carregar(Window janela) {
        this.janela = janela;
        fundo = new GameImage("instruçao.jpg");
        teclado = janela.getKeyboard();
    }

    void desenha() {
        fundo.draw();
        janela.display();
    }

    void loop() {
        boolean executando = true;
        while (executando) {
            desenha();
            if (teclado.keyDown(Keyboard.ESCAPE_KEY) == true) {
                executando = false;
            }
        }
    }
}
