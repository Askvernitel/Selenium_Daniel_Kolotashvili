package org.homework3.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public static Map<String, String> getJsonMapFrom(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> resultJsonMap = new HashMap<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(getResource(filePath));

            resultJsonMap.put("firstName", jsonNode.get("firstName").asText());
            resultJsonMap.put("lastName", jsonNode.get("lastName").asText());
            resultJsonMap.put("email", jsonNode.get("email").asText());
            resultJsonMap.put("gender", jsonNode.get("gender").asText());
            resultJsonMap.put("phoneNumber", jsonNode.get("phoneNumber").asText());
            resultJsonMap.put("subject", jsonNode.get("subject").asText());
            resultJsonMap.put("hobby", jsonNode.get("hobby").asText());
            resultJsonMap.put("currentAddress", jsonNode.get("currentAddress").asText());
            resultJsonMap.put("state", jsonNode.get("state").asText());
            resultJsonMap.put("city", jsonNode.get("city").asText());

            return resultJsonMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultJsonMap;
    }

    public static Object[][] getObjectArrayFrom(String filePath) {
        try {
            String unparsedFileString = getFileStringFrom(filePath);

            String[] partiallyParsedFileStringArray = unparsedFileString.split("\\R");

            List<Object[]> parsedRowList = new ArrayList<Object[]>();

            for (String row : partiallyParsedFileStringArray) {
                parsedRowList.add(row.split(","));
            }

            return parsedRowList.toArray(new Object[0][]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String getFileStringFrom(String filePath) throws IOException {
        InputStream fileInputStream = getResource(filePath);
        return new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    private static InputStream getResource(String filePath) {
        System.out.println(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)
        );
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
    }
}
