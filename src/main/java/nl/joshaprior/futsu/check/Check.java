package nl.joshaprior.futsu.check;

import nl.joshaprior.futsu.Futsu;

import java.util.LinkedList;

public class Check {
    private String name;
    private CheckType checkType;
    private Boolean enabled;
    private int max;
    public LinkedList<Detection> detections = new LinkedList<>();

    public Check(String name, CheckType checkType, Boolean enabled, int max) {
        this.name = name;
        this.checkType = checkType;
        this.enabled = enabled;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public CheckType getType() {
        return checkType;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public int getMax() {
        return max;
    }

    public LinkedList<Detection> getDetections() {
        return detections;
    }
}
