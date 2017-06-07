package szi.readers.xls;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szi.model.Ism;
import szi.model.Threat;

import java.util.List;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class IsmFromXlsReaderTest {
    private final static Logger logger = LoggerFactory.getLogger(ModuleFromXlsReaderTest.class);
    private final String filePath = "C:\\Users\\NM.Rabotaev\\IdeaProjects\\gaiman\\src\\main\\resources\\threats.xls";
    private final String threatsSheetName = "threats";
    private final String ismSheetName = "ism";

    @Test
    public void read() throws Exception {
        List<Threat> threats = new ThreatFromXlsReader(filePath, threatsSheetName).read();
        List<Ism> isms = new IsmFromXlsReader(filePath, ismSheetName, threats).read();
        isms.forEach(ism -> logger.info(ism.toString()));
    }

}