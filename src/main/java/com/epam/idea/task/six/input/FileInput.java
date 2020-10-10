package com.epam.idea.task.six.input;

import com.epam.idea.task.six.exception.DataException;
import org.apache.log4j.Logger;

import java.io.*;


public class FileInput {
    private final static Logger LOGGER = Logger.getLogger(FileInput.class);

    private final String fileName;

    public FileInput(String fileName) {
        this.fileName = fileName;
    }

    public String readInput() throws DataException {
        FileReader reader = null;
        StringBuilder data = new StringBuilder();
        char[] symbol = new char[1];

        try {
            reader = new FileReader(fileName);
            while (reader.read(symbol) != (-1)) {
                data.append(symbol);
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

