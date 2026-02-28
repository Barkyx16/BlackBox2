public class Main {

    public static void main(String[] args) {
        RacecarExample racecar = new RacecarExample();
        int avgSpeed = 100;
        boolean result = racecar.willFinish(avgSpeed);

        displayResult(result);
    }

    private static void displayResult(boolean result) {
        System.out.println("return: " + result);
    }
}