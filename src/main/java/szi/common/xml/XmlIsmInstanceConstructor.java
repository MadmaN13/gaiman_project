package szi.common.xml;

import szi.model.Threat;
import szi.model.xml.generated.IsmType;
import szi.model.xml.generated.ThreatList;
import szi.model.xml.generated.ThreatType;

import java.util.List;

/**
 * Created by NM.Rabotaev on 08.06.2017.
 */
public class XmlIsmInstanceConstructor {

    public static IsmType ismInstance(int id, String name, double cost, List<Threat> threats) {
        IsmType ismType = new IsmType();
        ismType.setId(id);
        ismType.setName(name);
        ismType.setCost(cost);
        ThreatList threatList = listOfThreats(threats);
        ismType.setThreatList(threatList);
        return ismType;
    }

    private static ThreatList listOfThreats(List<Threat> threats) {
        ThreatList threatList = new ThreatList();
        List<ThreatType> threatTypes = XmlThreatInstanceConstructor.listOfTypes(threats);
        threatList.getThreat().addAll(threatTypes);
        return threatList;
    }
}
