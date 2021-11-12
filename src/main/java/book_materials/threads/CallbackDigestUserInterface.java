package book_materials.threads;

import java.util.Arrays;

public class CallbackDigestUserInterface {
    public static void receiveDigest(byte[] digest, String name) {
        String result = name + ": " +
                Arrays.toString(digest);
        System.out.println(result);
    }
    public static void main(String[] args) {
        for (String filename : args) {
        CallbackDigest cb = new CallbackDigest(filename);
        Thread t = new Thread(cb);
        t.start();
        }
    }
}
