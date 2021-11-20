package Draw;

import Utils.ConsoleColors;

public abstract class Drawable {
    public String[][] composition;
    public int x = 0;
    public int y = 0;

    public Drawable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(){

        for (String[] strings : composition) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }

    public String[][] getComposition() {
        return composition;
    }

    public void setComposition(String[][] composition) {
        this.composition = composition;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
