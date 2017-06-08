package szi.common.xml;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szi.model.Ism;
import szi.model.Threat;
import szi.model.xml.generated.IsmType;
import szi.model.xml.generated.ObjectFactory;
import szi.readers.xls.IsmFromXlsReader;
import szi.readers.xls.ModuleFromXlsReaderTest;
import szi.readers.xls.ThreatFromXlsReader;
import szi.utils.common.FileUtil;

import javax.xml.bind.JAXBException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by NM.Rabotaev on 08.06.2017.
 */
public class XmlIsmInstanceConstructorTest {
    private final static Logger logger = LoggerFactory.getLogger(ModuleFromXlsReaderTest.class);
    private final static String filePath = "C:\\Users\\NM.Rabotaev\\IdeaProjects\\gaiman\\src\\main\\resources\\threats.xls";
    private final static String reportPath = "C:\\Users\\NM.Rabotaev\\IdeaProjects\\gaiman\\src\\main\\resources\\ismReport.xml";
    private final static String threatsSheetName = "threats";
    private final static String ismSheetName = "ism";
    private final static String packageName = "szi.model.xml.generated";

    private static JAXBMarshaller marshaller;

    @BeforeClass
    public static void init() {
        try {
            marshaller = new JAXBMarshaller(packageName);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ismInstance() {
        List<Threat> threats = new ThreatFromXlsReader(filePath, threatsSheetName).read();
        List<Ism> isms = new IsmFromXlsReader(filePath, ismSheetName, threats).read();
        assertNotNull(marshaller);
        isms.forEach(ism -> {
            IsmType ismType = XmlIsmInstanceConstructor.ismInstance(ism.getId(), ism.getName(), ism.getCost(), ism.getThreats());
            try {
                String ismText = marshaller.marshal(new ObjectFactory().createIsmInstance(ismType));
                FileUtil.appendLineToFile(reportPath, ismText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}