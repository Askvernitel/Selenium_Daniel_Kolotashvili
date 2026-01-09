package org.homework3.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileUtils {

    public static Map<String, String> getJsonMapFrom(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> resultJsonMap = new HashMap<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(getResource(filePath));
            for (Iterator<String> it = jsonNode.fieldNames(); it.hasNext(); ) {
                String fieldName = it.next();
                resultJsonMap.put(fieldName, jsonNode.get(fieldName).asText());
            }
            return resultJsonMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultJsonMap;
    }


    private static InputStream getResource(String filePath) {
        System.out.println(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)
        );
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
    }
}
