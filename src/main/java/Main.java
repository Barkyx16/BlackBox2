public class Main {

    public static boolean run() {
        RacecarExample racecar = new RacecarExample();
        int avgSpeed = 100;
        return racecar.willFinish(avgSpeed);
    }

    public static void main(String[] args) {
        run();
    }
}