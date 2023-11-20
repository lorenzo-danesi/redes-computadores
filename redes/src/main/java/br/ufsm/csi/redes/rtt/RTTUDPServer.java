package br.ufsm.csi.redes.rtt;

import java.net.*;
import java.io.*;

public class RTTUDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);
        byte[] receiveData = new byte[100];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket); // Aguarda o recebimento do pacote UDP

        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println(message + " recebido.");

        // Responde ao cliente (opcional)
        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();
        String response = "PONG";
        byte[] sendData = response.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        socket.send(sendPacket);

        socket.close();
    }
}

