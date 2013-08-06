package jogoprog1;

import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;

public class Fim {

    Window janela;
    GameImage fundo;
    Keyboard teclado;

    public Fim(Window janela) {
        carregar(janela);
        loop();
    }

    void carregar(Window janela) {
        this.janela = janela;
        fundo = new GameImage("fim.jpg");
        teclado = janela.getKeyboard();
    }

    void desenha() {
        fundo.draw();
        janela.display();
    }

    void loop() {
        while (true) {
            desenha();
            if (teclado.keyDown(Keyboard.ESCAPE_KEY) == true) {
                Menu jogo = new Menu();
            }
        }
    }
}
