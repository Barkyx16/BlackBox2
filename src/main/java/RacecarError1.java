public class RacecarError1 extends RacecarExample {

    public RacecarError1() {
        super();
    }

    @Override
    public boolean willFinish(int avgSpeed) {
        double fuelDrainRate;

        if (avgSpeed >= 150) {
            fuelDrainRate = 0.20;
        } else if (avgSpeed >= 100) {
            fuelDrainRate = 0.10;
        } else {
            fuelDrainRate = 0.05;
        }

        // first check if car already needs to pit
        if (needToPit) {
            // reset fuel to full when pitting
            fuelPercentageRemaining = 100.0;
            return false;
        }

        // update fuelPercentageRemaining
        fuelPercentageRemaining -= fuelDrainRate * lapsCompleted;

        // calculate whether the car can finish the race
        int lapsRemaining = overallLaps - lapsCompleted;
        return fuelPercentageRemaining > fuelDrainRate * lapsRemaining;
    }
}

