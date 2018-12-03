package app.apptesttask.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Constants {

    private final static String PRIVATE_KEY = "fe8b2507c5ebd9ca83a34b8729fe28096010800b";
    public final static String HASH = "304475049bfcec87c0e7183485b7ac28";
    public final static String PUBLIC_KEY = "5502dd19b20bb1840f20fcfad2a2dfcb";
    public final static int TS = 50;

    public final static String LIKES_ID = "likes_id";

    public final static String FILENAME = "varvel.txt";

    public static String hashTomd5() throws NoSuchAlgorithmException {

        String text = TS+PRIVATE_KEY+PUBLIC_KEY;

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(text.getBytes(), 0, text.length());
        return new BigInteger(1, md5.digest()).toString(32);
    }
}
