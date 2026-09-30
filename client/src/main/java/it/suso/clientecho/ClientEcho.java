package it.suso.clientecho;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEcho {

    public void avvia() throws IOException {
        try (
            Socket socket = new Socket("localhost", 5000);
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );
            Scanner tastiera = new Scanner(System.in)
        ) {
            while (true) {
                System.out.print("Scrivi una frase (EXIT per uscire): ");

                if (!tastiera.hasNextLine()) {
                    break;
                }

                String frase = tastiera.nextLine();

                // Invia una riga al server.
                output.println(frase);

                // Aspetta la risposta relativa a questa riga.
                String risposta = input.readLine();

                if (risposta == null) {
                    System.out.println("Il server ha chiuso la connessione.");
                    break;
                }

                if (risposta.equalsIgnoreCase("EXIT")) {
                    System.out.println("Connessione terminata.");
                    break;
                }

                System.out.println("Risposta dal Server: " + risposta);
            }
        }
    }
}
