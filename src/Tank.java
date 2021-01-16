//QUESTION Нехватает рисунка танка на плосткости для однозначного понимания задания.
public class Tank {
    private int horizontalX;
    private int horizontalY;
    private int rotation;

    Tank() {
        horizontalX = 0;
        horizontalY = 0;
        rotation = 0;
    }

    Tank(int horizontalX, int horizontalY) {
        this.horizontalX = horizontalX;
        this.horizontalY = horizontalY;
    }

    Tank(int horizontalX, int horizontalY, int rotation) {
        this(horizontalX, horizontalY);
        this.rotation = rotation;
    }

    /**
     * @param move - axis offset units
     * @return
     * @see Tank#goForward(int)
     * {@link #rotation}
     * Y axis
     * rotation = 0 - forward - default
     * rotation = 180 - back
     * X axis
     * rotation = 90 - right
     * rotation = 270 - left
     */
    public void goForward(int move) {
        if (rotation == 0) horizontalY += move;
        else if (rotation == 180) horizontalY -= move;
        else if (rotation == 90) horizontalX += move;
        else if (rotation == 270) horizontalX -= move;

    }

    public void goBackward(int move) {
        goForward(-move);
    }

    public void turnRight() {
        rotation += 90;
        if (rotation == 360) rotation = 0;
    }

    public void turnLeft() {
        rotation -= 90;
        if (rotation == -90) rotation = 270;
    }

    public void printPosition() {
        System.out.println("The Tank is at " + horizontalY + ", " + horizontalX + " now.");
    }
}
