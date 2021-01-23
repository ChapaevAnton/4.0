//TODO Test ssh key
//TODO Test git push console
//QUESTION Нехватает рисунка танка на плосткости для однозначного понимания задания.
public class Tank {

    private static final String MODEL = "T34";
    private static int serialNumber = 1;

    private int horizontalX;
    private int horizontalY;
    private int rotation = 90;
    private int fuel;
    private int serialNumberCurrent;

    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int horizontalX, int horizontalY) {
        this(horizontalX, horizontalY, 100);
    }

    public Tank(int horizontalX, int horizontalY, int fuel) {
        this.horizontalX = horizontalX;
        this.horizontalY = horizontalY;
        this.fuel = fuel;
        serialNumberCurrent = serialNumber++;
    }

    @Override
    public String toString() {
        return String.format("Tank %s-%d current position X%d:Y%d, fuel %d, turned on %d",
                MODEL, serialNumberCurrent, horizontalX, horizontalY, fuel, rotation);
    }

    private void setPosition(int horizontalX, int horizontalY) {
        this.horizontalX = horizontalX;
        this.horizontalY = horizontalY;
    }

    private void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    public void setFuel(int fuel) {
        this.fuel += fuel;
    }

    public int getFuel() {
        return fuel;
    }

    /**
     * @param move - axis offset units
     * @return
     * @see Tank#goForward(int)
     * {@link #rotation}
     * Y axis
     * rotation = 0 - forward
     * rotation = 180 - back
     * X axis
     * rotation = 90 - right - default
     * rotation = 270 - left
     */
    public void goForward(int move) {
        //TODO
        // The Tank is at 100, 0 now
        // The Tank is at 110, 10 now.
        // The Tank is at 220, 30 now.
        if (move < 0 && fuel < Math.abs(move)) {
            move = -fuel;
            fuel = 0;
        } else if (move > 0 && fuel < Math.abs(move)) {
            move = fuel;
            fuel = 0;
        } else if (fuel > Math.abs(move)) {
            fuel -= Math.abs(move);
        }

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
        System.out.println("The Tank " + MODEL + "-" + serialNumberCurrent + " is at " + horizontalX + ", " + horizontalY + " now.");
    }


}
