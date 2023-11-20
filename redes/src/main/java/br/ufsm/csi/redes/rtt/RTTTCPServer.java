package br.ufsm.csi.redes.rtt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

public class RTTTCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();
        byte[] buffer = new byte[100];
        int nBytes = socket.getInputStream().read(buffer);
        System.out.println(new String(buffer, 0, nBytes) + " recebido.");
        socket.getOutputStream().write("PONG".getBytes());
        socket.close();
    }

}
