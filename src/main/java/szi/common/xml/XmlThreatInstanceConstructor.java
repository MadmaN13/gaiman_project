package szi.common.xml;

import szi.model.Threat;
import szi.model.xml.generated.ThreatType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NM.Rabotaev on 08.06.2017.
 */
public class XmlThreatInstanceConstructor {

    public static List<ThreatType> listOfTypes(List<Threat> threats) {
        List<ThreatType> types = new ArrayList<>();
        threats.forEach(t-> types.add(threatType(t)));
        return types;
    }

    public static ThreatType threatType(Threat t) {
        ThreatType threat = new ThreatType();
        threat.setId(t.getId());
        threat.setName(t.getName());
        threat.setHazard(t.getHazard());
        threat.setPossibility(t.getPossibility());
        threat.setIsActual(t.isActual());
        return threat;
    }
}
