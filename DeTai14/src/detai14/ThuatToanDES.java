/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detai14;

import static javax.crypto.Cipher.SECRET_KEY;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author USER
 */
public class ThuatToanDES {
    private static String mySecret_key = "12345678";
    private static String byteToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length);
        String sTemp;
        for (byte aByte : bytes) {
            sTemp = Integer.toHexString(0xFF & aByte);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    private static byte[] hexToByteArray(String inHex) {
        int hexLen = inHex.length();
        byte[] result;
        if (hexLen % 2 == 1) {
            hexLen++;
            result = new byte[(hexLen / 2)];
            inHex = "0" + inHex;
        } else {
            result = new byte[(hexLen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexLen; i += 2) {
            result[j] = (byte) Integer.parseInt(inHex.substring(i, i + 2), 16);
            j++;
        }
        return result;
    }

   
    public String MaHoaDES(String chuoiPhanSo)
    {
        String encrypted = "";
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(mySecret_key.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] byteEncrypted = cipher.doFinal(chuoiPhanSo.getBytes());
            encrypted =  byteToHexString(byteEncrypted);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể thực hiện mã hóa");
            return null;
        }
        return encrypted;
    }
    
    public String GiaiMaDES(String chuoiMa)
    {
        String decrypted = "";
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(mySecret_key.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] byteDecrypted = cipher.doFinal(hexToByteArray(chuoiMa));
            decrypted = new String(byteDecrypted); 
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể thực hiện giải mã");
            return null;
        }
        return decrypted;
    }
}
