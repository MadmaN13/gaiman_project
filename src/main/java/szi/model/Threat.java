package szi.model;

import szi.common.Constants;

/**
 * Created by NM.Rabotaev on 06.06.2017.
 */
public class Threat {
    private int id;
    private String name;
    private double possibility;
    private int hazard;
    private boolean isActual;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getClass().getName()).
                append("---> Id=").append(id)
                .append("; Name=").append(name)
                .append("; Possibility=").append(possibility)
                .append("; Hazard=").append(hazard)
                .append("; IsActual=").append(isActual);
        return b.toString();
    }

    //ACCESSORS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPossibility() {
        return possibility;
    }
    public void setPossibility(double possibility) {
        this.possibility = possibility;
    }
    public int getHazard() {
        return hazard;
    }
    public void setHazard(int hazard) {
        this.hazard = hazard;
    }
    public boolean isActual() {
        return isActual;
    }
    public void setIsActual() {
        isActual = possibility * hazard >= Double.valueOf(Constants.ACTUALITY_THRESHOLD.getValue());
    }
}
