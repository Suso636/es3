package it.suso.serverecho;



import java.io.*;
import java.net.*;


public class ServerEcho {

        //apre subito le eccezioni se dovessero esserci
    public void avvia() throws IOException{


        ServerSocket Serversocket = new ServerSocket(5000);

        System.out.println("Server in ascolto sulla porta 5000 ...");

    }



}