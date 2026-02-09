/**
 * A class representing a racecar example with fuel management.
 */
public class RacecarExample {

    int overallLaps;
    int lapsCompleted;
    double fuelPercentageRemaining;
    boolean needToPit;

    public RacecarExample() {
        this.overallLaps = 200;
        this.lapsCompleted = 150;
        this.fuelPercentageRemaining = 50.0;
        this.needToPit = false;
    }

    public void setDefaults() {
        this.overallLaps = 200;
        this.lapsCompleted = 150;
        this.fuelPercentageRemaining = 50.0;
        this.needToPit = false;
    }

    /**
     * Determines if the racecar will finish the race based on laps remaining, laps run, and average speed.
     *
     * The method first sets a fuel drain rate based on the car's average speed (avgSpeed).
     * If avgSpeed >= 150, then the fuel drain rate gets set to 0.20 (20%).
     * If 150 > avgSpeed >= 100, then the fuel drain rate is set to 0.10 (10%).
     * If avgSpeed < 100, the fuel drain rate is set to 0.05 (5%).
     *
     * Next, the method looks at whether the car already needs to pit.
     * If needToPit is set to true, then fuelPercentageRemaining is set to 100.0
     * and the method returns false.
     *
     * If needToPit is false, the method continues.
     * First it subtracts the fuel drain rate multiplied by lapsCompleted from fuelPercentageRemaining.
     * It then calculates the number of laps remaining (overallLaps - lapsCompleted).
     * Lastly, the method returns true if fuelPercentageRemaining is greater than the drain rate
     * multiplied by the number of laps remaining, and false if it is not.
     *
     * @param avgSpeed the average speed of the racecar
     * @return true if the racecar will finish the race, false otherwise
     */
    public boolean willFinish(int avgSpeed) {
        double fuelDrainRate;

        if (avgSpeed >= 150) {
            fuelDrainRate = 0.20;
        } else if (avgSpeed >= 100) {
            fuelDrainRate = 0.10;
        } else {
            fuelDrainRate = 0.05;
        }

        // First check if car already needs to pit
        if (needToPit) {
            fuelPercentageRemaining = 100.0;
            return false;
        }

        // Update fuelPercentageRemaining
        fuelPercentageRemaining -= fuelDrainRate * lapsCompleted;

        // Calculate whether the car can finish the race
        int lapsRemaining = overallLaps - lapsCompleted;
        return fuelPercentageRemaining > fuelDrainRate * lapsRemaining;
    }
}

