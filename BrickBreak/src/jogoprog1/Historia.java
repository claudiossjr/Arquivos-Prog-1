package jogoprog1;

import JPlay.Window;
import JPlay.GameImage;
import JPlay.Keyboard;

public class Historia {

    Window janela;
    GameImage fundo;
    Keyboard teclado;

    public Historia(Window janela) {
        carregar(janela);
        loop();
    }

    void carregar(Window janela) {
        this.janela = janela;
        fundo = new GameImage("historia.jpg");
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
