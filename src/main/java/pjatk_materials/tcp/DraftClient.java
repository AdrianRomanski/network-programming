package pjatk_materials.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class DraftClient {
    public static void main(String[] args) throws IOException {

        final var serverPort = 5000; // to dostaniemy
        final var SERVER_ADDRESS = "localhost"; // to dostaniemy
        // Tego potrzebujemy kiedy dostajemy nazwe a nie ip
        final var serverAddress = InetAddress.getByName(SERVER_ADDRESS);
        var socketFromAddress = new Socket(serverAddress, serverPort);
        var socket = new Socket("127.0.0.1", serverPort);

        // tego potrzebujemy aby sie polaczyc z serverem
        // Client-Server
        final var serverPortFromGetter = socket.getPort();
        // ten server utawia dla danego socketu po pierwszym polaczeniu
        // Server-Client
        final var localPortFromGetter = socket.getLocalPort();

        // Client-Server komunikacja
        final var bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()
                )
        );
        // Server-Client komunikacja
        final var bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );


        // wysylamy zmienna opakowana w Stringa
        final var variable = 12;
        bufferedWriter.write(String.valueOf(variable));
        // nowa linia
        bufferedWriter.newLine();
        // spuszczamy wode po sraniu
        bufferedWriter.flush();

        // wszystkie wartosci przychodza jako Stringi, wiec trzeba je parsowac.
        final String s = bufferedReader.readLine();

        final int afterChange = Integer.parseInt(s);
        final double afterChangeDouble = Double.parseDouble(s);
        // itp

        // Powodzenia kek
    }
}
