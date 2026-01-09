package org.homework3.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class GeneralUtils {


    public static Date getDateFrom(String input){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(input);
        }catch (ParseException e){
            System.err.println("Date Parse Error");
            e.printStackTrace();
        }
        return new Date();
    }
    public static String getLongDateFormatFrom(Date input){
        LocalDate localDate = input.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        return localDate.format(formatter);
    }
}
