package servicecentermanagementfx.old_gui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5 {

    public static String getMD5(String string) {
        MessageDigest md;
        String digested = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            digested = new String(md.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digested;
    }
}
