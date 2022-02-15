package com.example.doctorappointment.MainClasses;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Functions {

	// Encode a String to Hash-SHA256
	public static String encodeSha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            final StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                final String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    // Generate salt
    public static String generateSalt(){
        int n = 7;
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

//    public static String generateVerificationCode(){
//        int n = 6;
//        // chose a Character random from this String
//        String AlphaNumericString = "123456789";
//
//        // create StringBuffer size of AlphaNumericString
//        StringBuilder sb = new StringBuilder(n);
//
//        for (int i = 0; i < n; i++) {
//
//            // generate a random number between
//            // 0 to AlphaNumericString variable length
//            int index
//                    = (int)(AlphaNumericString.length()
//                    * Math.random());
//
//            // add Character one by one in end of sb
//            sb.append(AlphaNumericString
//                    .charAt(index));
//        }
//
//        return sb.toString();
//    }

//    public static void sendVerificationCode(String email){
//        System.out.println("Email: " + email);
//    }
}
