package book_materials.threads;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.*;
import java.util.Arrays;

public class DigestThread extends Thread {
    private String filename;

    public DigestThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != -1) {
                din.close();
                byte[] digest = sha.digest();
                String result = filename + ": " +
                        (Arrays.toString(digest));
                System.out.println(result);
            }
        } catch (IOException | NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }


    public static void main(String[] args) {
        for (String filename : args) {
        Thread t = new DigestThread(filename);
        t.start();
        }
    }
}
