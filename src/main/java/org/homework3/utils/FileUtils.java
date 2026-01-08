package org.homework3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Object[][] getObjectArrayFrom(String filePath){
        try {
            String unparsedFileString = getCsvStringFrom(filePath);

            String[] partiallyParsedFileStringArray = unparsedFileString.split("\\R");

            List<Object[]> parsedRowList = new ArrayList<Object[]>();

            for(String row : partiallyParsedFileStringArray){
                parsedRowList.add(row.split(","));
            }

            return parsedRowList.toArray(new Object[0][]);
        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String getCsvStringFrom(String filePath) throws IOException {
        InputStream csvFileInputStream = getResource(filePath);
        return new String(csvFileInputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    private static InputStream getResource(String filePath){
        System.out.println(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)
        );
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
    }
}
