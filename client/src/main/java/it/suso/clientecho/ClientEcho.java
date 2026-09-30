package it.suso.clientecho;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ClientEcho {
    
    public void avvia() throws IOException {
        Socket socket = new Socket("localhost", 5000);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una frase: ");
        String frase = scanner.nextLine();

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(),
            true
        );

        output.println(frase);

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        String risposta = input.readLine();

        System.out.println("Risposta dal Server: " + risposta);

        socket.close();
        scanner.close();
    }
}
