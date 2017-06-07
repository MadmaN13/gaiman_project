package szi.readers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szi.model.Threat;
import szi.readers.xls.ThreatFromXlsReader;

import java.util.List;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class ThreatFromXlsReaderTest {
    private final static Logger logger = LoggerFactory.getLogger(ThreatFromXlsReaderTest.class);

    private final String filePath = "C:\\Users\\NM.Rabotaev\\IdeaProjects\\gaiman\\src\\main\\resources\\threats.xls";
    private final String sheetName = "threats";


    @Test
    public void read() throws Exception {
        ThreatFromXlsReader reader = new ThreatFromXlsReader(filePath, sheetName);
        List<Threat> threats = reader.read();
        threats.forEach(t-> logger.info(t.toString()));
    }

}