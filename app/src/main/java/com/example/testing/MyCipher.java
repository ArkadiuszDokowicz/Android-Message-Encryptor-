package com.example.testing;


import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MyCipher {
    public static enum Mode {
        CBC("CBC"), OFB("OFB"), CFB("CFB"), CTR("CTR");
        private final String text;
        Mode(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    //public static String key = "aesEncryptionKey";
    //public static String initVector = "encryptionIntVec";

    public static String AESencrypt(String value,Mode mode, String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/"+mode.toString()+"/PKCS5PADDING");
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            return Base64.encodeToString(encrypted,Base64.DEFAULT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String AESdecrypt(String encrypted,Mode mode, String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/"+mode.toString()+"/PKCS5PADDING");
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decode(encrypted,Base64.DEFAULT));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    /*
    @Deprecated
    public static String AESencryptModeOFB(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/OFB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeToString(encrypted,Base64.DEFAULT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Deprecated
    public static String AESdecryptModeOFB(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/OFB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decode(encrypted,Base64.DEFAULT));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
*/
/*
    public static String AESencryptModeECB(String input) {
        byte[] crypted = null;
        try {

            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();

        return encoder.encodeToString(crypted);
    }
    public static String AESdecryptModeECB(String input) {
        byte[] output = null;
        try {
            java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(decoder.decode(input));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new String(output);
    }
*/
}
