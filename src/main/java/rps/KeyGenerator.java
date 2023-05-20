package rps;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {
    private final SecureRandom secureRandom;

    public KeyGenerator() throws NoSuchAlgorithmException {
        this.secureRandom = SecureRandom.getInstanceStrong();
    }

    public String generateKey() {
        byte[] key = new byte[32];
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    public String generateHmac(String key, String message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac signer = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "HmacSHA256");
        signer.init(keySpec);
        byte[] hmac = signer.doFinal(message.getBytes());
        return bytesToHex(hmac);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}