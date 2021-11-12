package pjatk_materials.client_server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5000;
    public static void main(String[] args) throws IOException {
        final var serverAddress = InetAddress.getByName(SERVER_ADDRESS);
        final var clientSocket = new Socket(serverAddress, SERVER_PORT);
        final var br = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream())
        );
        final var bw = new BufferedWriter(
                new OutputStreamWriter(clientSocket.getOutputStream())
        );
        writeAndFlush(bw, "");
        final var number = Integer.parseInt(br.readLine());
        var flag = false;
        double max = 1;
        while(!flag) {
            var tempSquared = Math.pow(max, 2);
            if(tempSquared >= number) {
                flag=true;
            } else {
                max+=1;
            }
        }
        writeAndFlush(bw, String.valueOf(max - 1));
        final var anotherNumber = br.readLine();
        final var replace = anotherNumber.replace("5", "");
        writeAndFlush(bw, replace);
        writeAndFlush(bw, String.valueOf(SERVER_PORT));
        clientSocket.close();
    }

    public static void writeAndFlush(BufferedWriter bufferedWriter,
                                     String toWrite) throws IOException {
        bufferedWriter.write(toWrite);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
