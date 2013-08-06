package jogoprog1;

import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import java.awt.event.KeyEvent;

public class Menu {

    Window janela;
    GameImage fundo;
    Keyboard teclado;
    Mouse mouse;
    boolean executando = true;

    public Menu() {
        carregar();
        loop();
    }

    void carregar() {
        janela = new Window(800, 600);
        fundo = new GameImage("menu.jpg");
        teclado = janela.getKeyboard();
        teclado.addKey(KeyEvent.VK_1);
        teclado.addKey(KeyEvent.VK_2);
        teclado.addKey(KeyEvent.VK_3);
        teclado.addKey(KeyEvent.VK_4);
    }

    void desenha() {
        fundo.draw();
        janela.display();
    }

    void loop() {
        while (executando) {

            desenha();
            if (teclado.keyDown(KeyEvent.VK_1) == true) {
                Jogo1 jogo = new Jogo1(janela);
            }
            if (teclado.keyDown(KeyEvent.VK_2) == true) {
                Instrucao jogo = new Instrucao(janela);
            }
            if (teclado.keyDown(KeyEvent.VK_3) == true) {
                Historia jogo = new Historia(janela);
            }
            if (teclado.keyDown(KeyEvent.VK_4) == true) {
                Creditos jogo = new Creditos(janela);
            }
            if (teclado.keyDown(Keyboard.ESCAPE_KEY) == true) {
                janela.exit();
            }

        }
    }
}
