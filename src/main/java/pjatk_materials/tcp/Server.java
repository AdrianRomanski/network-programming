package pjatk_materials.tcp;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    private static final int SERVER_PORT = 5000;
    public static void main(String[] args) throws IOException {
        final var welcomeSocket = new ServerSocket(SERVER_PORT);
        final var clientSocket = welcomeSocket.accept();
        final var clientPort = clientSocket.getLocalPort();

        final var br = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream())
        );
        final var bw = new BufferedWriter(
                new OutputStreamWriter(clientSocket.getOutputStream())
        );
        br.readLine();
        writeAndFlush(bw, "99");
        final var request2 = br.readLine();
        if (request2.equals("9.0")) {
            System.out.println("Zwyciestwo");
            writeAndFlush(bw, "14556633");
            final var request3 = br.readLine();
            if(request3.equals("146633")) {
                System.out.println("Zwyciestwo");
                final var request4 = br.readLine();
                if(request4.equals(String.valueOf(clientPort))) {
                    System.out.println("KURWAAAA WYGRALES");
                    welcomeSocket.close();
                } else {
                    System.out.println("Na sam koniec zjebales");
                }
            } else {
                System.out.println("Zjebales");
                welcomeSocket.close();
            }
        } else {
            bw.write("Zjebales");
            welcomeSocket.close();
        }
    }

    public static void writeAndFlush(BufferedWriter bufferedWriter,
                                     String toWrite) throws IOException {
        bufferedWriter.write(toWrite);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
