package com.cds.ccle.management.luca.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

//Nuevo comentario

public class LucaUtils {

	private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

	public static boolean isNullOrEmpty(String validateString) {
		if (validateString == null || validateString.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isNullOrZero(Integer validateInteger) {
		if (validateInteger == null || validateInteger == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrZero(Long validateLong) {
		if (validateLong == null || validateLong == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean validateHexColor(String colorCode) {
		if (isNullOrEmpty(colorCode)) {
			return false;
		}
		Pattern pattern = Pattern.compile(HEX_PATTERN);
		Matcher matcher = pattern.matcher(colorCode);
	    return matcher.matches();
	}
		
	public static boolean isValidEmailAddress(String email) {
	   boolean result = true;
	   try {
	      InternetAddress emailAddr = new InternetAddress(email);
	      emailAddr.validate();
	   } catch (AddressException ex) {
	      result = false;
	   }
	   return result;
	}
	
    public static <T> List<T> removeListDuplicates(List<T> list) { 
        List<T> newList = new ArrayList<T>(); 
        for (T element : list) { 
            if (!newList.contains(element)) { 
            	newList.add(element); 
            } 
        } 
        return newList; 
    }
    
	public static String durationToHHMMSS(Duration duration) {
        if (duration == null) {
        	return null;
        }
        StringBuilder resultDurationParsed = new StringBuilder();
        String hours = Long.toString(duration.toHours());
        resultDurationParsed.append(roundStringHour(hours)).append(":");
        String minutes = Long.toString(duration.toMinutes() % 60);
        resultDurationParsed.append(roundStringHour(minutes)).append(":");
        String seconds = Long.toString(duration.getSeconds() % 60);
        resultDurationParsed.append(roundStringHour(seconds));
        return resultDurationParsed.toString();
	}
	
}
