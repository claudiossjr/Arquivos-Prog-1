package jogoprog1;

import JPlay.Window;
import JPlay.GameImage;
import JPlay.Keyboard;

public class GameOver {

    Window janela;
    GameImage fundo;
    Keyboard teclado;

    public GameOver() {
        carregar();
        loop();
    }

    void carregar() {
        janela = new Window(800, 600);
        fundo = new GameImage("gameover.jpg");
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
