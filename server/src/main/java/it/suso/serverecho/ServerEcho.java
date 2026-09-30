package it.suso.serverecho;



import java.io.*;
import java.net.*;


public class ServerEcho {




    public void avvia() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server in ascolto sulla porta 5000...");

        Socket socket = serverSocket.accept();

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        String messaggio = input.readLine();

        String risposta = messaggio.toUpperCase();

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(),
            true
        );

        output.println(risposta);

        socket.close();
        serverSocket.close();

        System.out.println("Server terminato.");
    }


}