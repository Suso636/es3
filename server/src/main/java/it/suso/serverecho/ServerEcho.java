package it.suso.serverecho;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {

    public void avvia() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server in ascolto sulla porta 5000...");

            // Accetta un client. La connessione resta aperta durante il ciclo.
            try (
                Socket socket = serverSocket.accept();
                BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );
                PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
                )
            ) {
                System.out.println("Client connesso.");

                String messaggio;

                // Continua a leggere dalla stessa socket.
                // Se il client si disconnette, readLine() restituisce null.
                while ((messaggio = input.readLine()) != null) {
                    if (messaggio.trim().equalsIgnoreCase("EXIT")) {
                        output.println("EXIT"); // Conferma al client
                        break;
                    }

                    output.println(messaggio.toUpperCase());
                }
            }
        }

        System.out.println("Server terminato.");
    }
}