package br.com.tlmacedo.cafeperfeito.service;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class ServiceCryptografia {

    public static String getSALT() {
//        if (SALT == null)
//            generatetSalt();
        return SALT;
    }

    public static Integer DEFAULT_ITERATIONS = getDefaultIterations();
    public static final String ALGORITHM = "pbkdf2_sha256";

    public static void setSALT(String salt) {
        SALT = salt;
    }

    public static Integer KEY_LENGTH = getKeyLength();

    public static Integer getDefaultIterations() {
        if (DEFAULT_ITERATIONS == null)
            setDefaultIterations(260000);
        return DEFAULT_ITERATIONS;
    }

    public static String SALT = getSALT();

    public static String encrypt(String senhaSimples) {
        return encode(senhaSimples);
    }

    public static boolean senhaValida(String senhaSimples, String senhaBD) {
        return checkPassword(senhaSimples, senhaBD);
    }

    public static String getEncodedHash(String password, String salt, int iterations) {
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Could NOT retrieve PBKDF2WithHmacSHA256 algorithm");
            System.exit(1);
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(Charset.forName("UTF-8")), iterations, 256);
        SecretKey secret = null;
        try {
            secret = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            System.out.println("Could NOT generate secret key");
            e.printStackTrace();
        }

        byte[] rawHash = secret.getEncoded();
        byte[] hashBase64 = Base64.getEncoder().encode(rawHash);

        return String.format("%s$%d$%s$%s", ALGORITHM, iterations, salt, new String(hashBase64));
    }

    public static String encode(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return getEncodedHash(password, new String(salt), DEFAULT_ITERATIONS);
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        String[] parts = hashedPassword.split("\\$");
        if (parts.length != 4)
            return false;
        Integer iterations = Integer.parseInt(parts[1]);
        String salt = parts[2];
        String hash = getEncodedHash(password, salt, iterations);
        return hash.equals(hashedPassword);
    }

    public static void setDefaultIterations(Integer defaultIterations) {
        DEFAULT_ITERATIONS = defaultIterations;
    }

    public static Integer getKeyLength() {
        if (KEY_LENGTH == null)
            setKeyLength(32 * 8);
        return KEY_LENGTH;
    }

    public static void setKeyLength(Integer keyLength) {
        KEY_LENGTH = keyLength;
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }


//
//    private static boolean validHash(byte[] hash, byte[] testHash) {
//        int diff = hash.length ^ testHash.length;
//        for (int i = 0; i < hash.length && i < testHash.length; i++) {
//            diff |= hash[i] ^ testHash[i];
//        }
//        return diff == 0;
//    }

}
