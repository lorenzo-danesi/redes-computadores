package br.ufsm.csi.redes.rtt;

import java.net.*;
import java.io.*;

public class RTTUDPClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 8080;

        String message = "PING";
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

        long startTime = System.currentTimeMillis();
        socket.send(sendPacket);

        // Aguarda a resposta do servidor (opcional)
        byte[] receiveData = new byte[100];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        long endTime = System.currentTimeMillis();

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Resposta do servidor: " + response);

        // Calcula o RTT
        long rtt = endTime - startTime;
        System.out.println("RTT: " + rtt + "ms.");

        socket.close();
    }
}

