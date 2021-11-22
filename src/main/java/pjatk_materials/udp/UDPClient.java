package pjatk_materials.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        final var clientSocket = new DatagramSocket();
        final var IPAddress = InetAddress.getByName("localhost");
        final var sentence = "coca cola";
        final var sendData = sentence.getBytes();
        final var sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        final var receiveData = new byte[1024];
        final var receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        final var serverResponse = new String(
                receivePacket.getData()).replace("\u0000", "");
        System.out.printf("Response from server: %s", serverResponse);
        clientSocket.close();
    }
}
