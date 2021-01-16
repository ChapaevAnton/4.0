public class App4 {
    public static void main(String[] args) {

        Tank tank = new Tank();
        tank.goForward(10);
        tank.printPosition();
        tank.goForward(50);
        tank.printPosition();
        tank.goBackward(100);
        tank.printPosition();

    }
}
