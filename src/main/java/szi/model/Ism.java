package szi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class Ism {

    private int id;
    private String name;
    private double cost;
    private List<Threat> threats;

    public Ism() {
        threats = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getClass().getName()).
                append("---> Id=").append(id)
                .append("; Name=").append(name)
                .append("; Cost=").append(cost)
                .append("; Threats={\r\n");
        threats.forEach(t-> b.append(t.toString()).append("\r\n"));
        b.append("}");
        return b.toString();
    }

    // ACCESSORS
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
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public List<Threat> getThreats() {
        return threats;
    }
}
