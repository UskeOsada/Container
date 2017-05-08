package _EXTRA_Othelo;

public class CPU_v01 extends CPU implements Storategy {

    public CPU_v01() {
       super();
    }

    public CPU_v01(int color) {
        super(color);
    }

    public CPU_v01(int x, int y, int color) {
        super(x, y, color);
    }

    @Override
    public String nextPut() {
        return getX() + "," + getY() + "," + color;
    }

    @Override
    public void study() {

    }

}
