package com.kakaopay.feel.util;

import java.security.MessageDigest;
import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean validateEmail(String email) {
        String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String GeneratorCouponNo(String email) throws Exception {
        return CouponGenerator.execute(sha256(email));
    }

    public static Date getCurrentTimeStamp() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    private static String sha256(String email) throws Exception {
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        sh.update(email.getBytes());
        byte byteData[] = sh.digest();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }


}
