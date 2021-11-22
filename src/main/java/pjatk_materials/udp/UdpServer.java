package pjatk_materials.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String args[]) throws Exception
    {
        final var serverSocket = new DatagramSocket(9876);
        var receiveData = new byte[1024];
        var sendData = new byte[1024];
        while(true) {
            final var receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            final var sentence = new String(receivePacket.getData());
            System.out.printf("Received: %s from client", sentence);
            final var IPAddress = receivePacket.getAddress();
            final var port = receivePacket.getPort();
            final var capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            final var sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}

