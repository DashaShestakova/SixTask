package com.epam.idea.task.six.input;

import com.epam.idea.task.six.exception.DataException;
import org.apache.log4j.Logger;

import java.io.*;


public class FileInput {
    private final static Logger LOGGER = Logger.getLogger(FileInput.class);

    public static final String FILE_PATH = "src/main/resources/input.txt";

    public String readInput() throws DataException {
        BufferedReader reader = null;
        StringBuilder data = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            String sCurrentLine;
            while ((sCurrentLine = reader.readLine()) != null) {
                data.append(sCurrentLine);
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return new String(data);
    }
}
