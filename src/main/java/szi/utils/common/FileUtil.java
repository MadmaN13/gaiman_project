package szi.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by NM.Rabotaev on 08.06.2017.
 */
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void appendLineToFile(String fileName, String line) {
        try(FileWriter writer = new FileWriter(new File(fileName), true)) {
            writer.write(new StringBuilder(line).append("\r\n").toString());
        } catch (IOException e) {
            logFileWritingError(fileName,e);
        }
    }

    private static void logFileWritingError(String fileName, IOException e) {
        StringBuilder b = new StringBuilder();
        b.append("Error while writing to file: ").append(fileName)
                .append(". Error message")
                .append(e.getMessage());
        logger.error(b.toString());
    }

}
