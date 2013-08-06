package jogoprog1;

import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;

public class Creditos {

    Window janela;
    GameImage fundo;
    Keyboard teclado;

    public Creditos(Window janela) {
        carregar(janela);
        loop();
    }

    void carregar(Window janela) {
        this.janela = janela;
        fundo = new GameImage("creditos.jpg");
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
