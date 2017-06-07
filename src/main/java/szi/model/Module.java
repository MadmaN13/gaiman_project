package szi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class Module {
    private int id;
    private String name;
    private List<Threat> threats;

    public Module() {
        threats = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getClass().getName()).
                append("---> Id=").append(id)
                .append("; Name=").append(name)
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
    public List<Threat> getThreats() {
        return threats;
    }
}
