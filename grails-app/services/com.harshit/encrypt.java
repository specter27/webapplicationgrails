package com.harshit;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encrypt {

    public static String encryptThisString(String input) throws NoSuchAlgorithmException {
        String hashtext = null;
        try {
            // getInstance() method is called with algorithm MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashtext;
    }
}
