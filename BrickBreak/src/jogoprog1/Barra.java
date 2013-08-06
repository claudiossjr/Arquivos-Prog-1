package jogoprog1;

import jplay.Sprite;
import jplay.Keyboard;

public class Barra extends Sprite {

    public Barra(String imagem, int frames) {
        super(imagem, frames);
    }

    public Barra(String imagem) {
        super(imagem);
    }
    boolean direita, esquerda;

    public void moveX(Keyboard keyboard, int direita, int esquerda) {

        if (keyboard.keyDown(direita) && ((this.x + this.width) <= 792)) {
            this.x += 2;
        }

        if (keyboard.keyDown(esquerda) && (this.x) >= 8) {
            this.x -= 2;
        }

    }
}
