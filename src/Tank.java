public class Tank {
    int sagittal;

    Tank(){
        sagittal=0;
    }

    Tank(int sagittal){
        this.sagittal=sagittal;
    }

    public void goForward(int forward) {
        sagittal += forward;
    }

    public void goBackward(int backward) {
        sagittal -= backward;
    }

    public void printPosition() {
        System.out.println("The Tank is at " + sagittal + " now.");
    }
}
