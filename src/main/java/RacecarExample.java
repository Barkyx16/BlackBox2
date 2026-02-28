/**
 * A class representing a racecar example with fuel management.
 */
public class RacecarExample {

    private static final int DEFAULT_OVERALL_LAPS = 200;
    private static final int DEFAULT_LAPS_COMPLETED = 150;
    private static final double DEFAULT_FUEL_PERCENTAGE = 50.0;

    private static final double FULL_TANK_PERCENTAGE = 100.0;

    private static final int SPEED_FAST = 150;
    private static final int SPEED_MEDIUM = 100;

    private static final double DRAIN_RATE_FAST = 0.20;
    private static final double DRAIN_RATE_MEDIUM = 0.10;
    private static final double DRAIN_RATE_SLOW = 0.05;

    int overallLaps;
    int lapsCompleted;
    double fuelPercentageRemaining;
    boolean needToPit;

    public RacecarExample() {
        setDefaults();
    }

    public void setDefaults() {
        this.overallLaps = DEFAULT_OVERALL_LAPS;
        this.lapsCompleted = DEFAULT_LAPS_COMPLETED;
        this.fuelPercentageRemaining = DEFAULT_FUEL_PERCENTAGE;
        this.needToPit = false;
    }

    public boolean willFinish(int avgSpeed) {
        double fuelDrainRate = fuelDrainRateForSpeed(avgSpeed);

        if (handlePitIfNeeded()) {
            return false;
        }

        applyFuelDrain(fuelDrainRate);
        return canFinishWith(fuelDrainRate);
    }

    private double fuelDrainRateForSpeed(int avgSpeed) {
        if (avgSpeed >= SPEED_FAST) {
            return DRAIN_RATE_FAST;
        }
        if (avgSpeed >= SPEED_MEDIUM) {
            return DRAIN_RATE_MEDIUM;
        }
        return DRAIN_RATE_SLOW;
    }

    private boolean handlePitIfNeeded() {
        if (!needToPit) {
            return false;
        }

        fuelPercentageRemaining = FULL_TANK_PERCENTAGE;

        if (resetNeedToPitAfterPit()) {
            needToPit = false;
        }

        return true;
    }

    /**
     * Hook method: subclasses can change pit behavior.
     * Default matches RacecarExample/RacecarError1 behavior (do NOT reset needToPit).
     */
    protected boolean resetNeedToPitAfterPit() {
        return false;
    }

    private void applyFuelDrain(double fuelDrainRate) {
        fuelPercentageRemaining -= fuelDrainRate * lapsCompleted;
    }

    private boolean canFinishWith(double fuelDrainRate) {
        return fuelPercentageRemaining > fuelDrainRate * lapsRemaining();
    }

    private int lapsRemaining() {
        return overallLaps - lapsCompleted;
    }
}
