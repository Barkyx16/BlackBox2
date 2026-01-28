public class Main {

    public static void main(String[] args) {
        RacecarExample racecar = new RacecarExample();
        int avgSpeed = 100;
        boolean result = racecar.willFinish(avgSpeed);
        System.out.println("return: " + result);
    }
}
