package nl.joshaprior.futsu.utils;

import nl.joshaprior.futsu.Futsu;
import nl.joshaprior.futsu.data.DataPlayer;

public class TimerUtils {

    private int startTime;
    private DataPlayer data;

    public TimerUtils(DataPlayer data) {
        this.data = data;
        this.reset();
    }

    public static boolean hasPassed(long startTime, long toPass) {
        return (System.currentTimeMillis() - startTime) >= toPass;
    }

    public boolean wasReset() {
        return this.startTime == Futsu.getPlugin().getCurrentTick();
    }

    public void reset() {
        this.startTime = Futsu.getPlugin().getCurrentTick();
    }

    private long getPassed() {
        return Futsu.getPlugin().getCurrentTick() - this.startTime;
    }

    public void add(int amount) {
        this.startTime -= amount;
    }

    public boolean hasPassed(long toPass) {
        return this.getPassed() >= toPass;
    }

    public boolean hasNotPassed(long toPass) {
        return this.getPassed() < toPass;
    }

    public boolean hasPassed(long toPass, boolean reset) {
        boolean passed = this.getPassed() >= toPass;
        if (passed && reset) reset();
        return passed;
    }
}