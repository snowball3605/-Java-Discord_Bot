package org.example.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    public static byte[] Main(String input) {
        try {
            // 使用SHA-256哈希函數
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // 將輸入數據轉換為字節數組
            byte[] hashedBytes = md.digest(input.getBytes());

            // 將字節數組轉換為十六進制字符串
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) {
                    hexStringBuilder.append('0');
                }
                hexStringBuilder.append(hex);
            }

            // 打印SHA-256哈希值
            return hexStringBuilder.toString().getBytes();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
