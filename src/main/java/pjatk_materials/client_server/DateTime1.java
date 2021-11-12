package pjatk_materials.client_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateTime1 {

    public static void main(String[] args) {
        int port = 13;
        final var host = "time.nist.gov";
        try {
            final var socket = new Socket(host, port);
            // alternative
            final var br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    ));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            socket.close();
        } catch (UnknownHostException exc) {
            System.out.println("Unknown host: " + host);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
