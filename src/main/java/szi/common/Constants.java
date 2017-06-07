package szi.common;

/**
 * Created by NM.Rabotaev on 06.06.2017.
 */
public enum Constants {

    ACTUALITY_THRESHOLD("1.5"),
    XLS_THREAT_SEPARATOR(";");

    private String value;

    private Constants(String value) {
        this.value = value;
    }

    public String getValue() {return this.value;}
}
