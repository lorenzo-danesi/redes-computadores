package br.ufsm.csi.redes.rtt;

import java.io.IOException;
import java.net.Socket;

public class RTTTCPClient {

    public static void main(String[] args) throws IOException {
        long milis = System.currentTimeMillis();
        Socket socket = new Socket("localhost", 8080);
        socket.getOutputStream().write("PING".getBytes());
        byte[] resposta = new byte[100];
        socket.getInputStream().read(resposta);
        System.out.println("RTT: " + ((System.currentTimeMillis() - milis)/2.0) + "ms.");
        socket.close();
    }

}
