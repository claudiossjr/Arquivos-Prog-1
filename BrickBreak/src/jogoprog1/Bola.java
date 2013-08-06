package jogoprog1;

import jplay.Sprite;

public class Bola extends Sprite {

    boolean moverx, movery;
    int velY;

    public Bola(String Imagem, int frames) {

        super(Imagem, frames);
    }

    public Bola(String Imagem) {

        super(Imagem);
    }

    public void BolaX() {

        if (this.x >= 8 && moverx == true) {
            this.x--;
        } else {
            moverx = false;
        }

        if (this.x <= (792 - this.width) && moverx == false) {
            this.x++;
        } else {
            moverx = true;
        }
    }

    public void BolaY() {
        if (this.y >= 57 && movery == true) {
            this.y--;
        } else {
            movery = false;
        }

        if (this.y <= 600 && movery == false) {
            this.y++;
        } else {
            movery = true;
        }
    }
}
