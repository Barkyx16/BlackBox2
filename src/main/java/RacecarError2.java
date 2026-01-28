public class RacecarError2 extends RacecarExample{

    public RacecarError2() {
        super();
    }

    public boolean willFinish(int avgSpeed){
        double fuelDrainRate;

        if (avgSpeed >= 150) {
            fuelDrainRate = 0.20;
        } else if (avgSpeed >= 100) {
            fuelDrainRate = 0.10;
        } else {
            fuelDrainRate = 0.05;
        }

        //-----first check if car already needs to pit
        if (needToPit) {
            //reset percentages
            fuelPercentageRemaining = 100.0;
            return false; //because it can't finish the race without pitting if it needs to pit
        }

        //-----second update fuelPercentageRemaining
        fuelPercentageRemaining = fuelDrainRate * lapsCompleted; //ERROR: = instead of -=

        //-----third calculate whether the car can finish the race based on remaining fuel level
        int lapsRemaining = overallLaps - lapsCompleted;
        return fuelPercentageRemaining > fuelDrainRate * lapsRemaining;
    }
}
