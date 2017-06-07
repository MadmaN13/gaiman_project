package szi.readers.xls;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szi.model.Module;
import szi.model.Threat;

import java.util.List;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class ModuleFromXlsReaderTest {
    private final static Logger logger = LoggerFactory.getLogger(ModuleFromXlsReaderTest.class);
    private final String filePath = "C:\\Users\\NM.Rabotaev\\IdeaProjects\\gaiman\\src\\main\\resources\\threats.xls";
    private final String threatsSheetName = "threats";
    private final String modulesSheetName = "modules";

    @Test
    public void read() throws Exception {
        List<Threat> threats = new ThreatFromXlsReader(filePath, threatsSheetName).read();
        List<Module> modules = new ModuleFromXlsReader(filePath, modulesSheetName, threats).read();
        modules.forEach(m -> logger.info(m.toString()));
    }

}