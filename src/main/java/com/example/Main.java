package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Server avviato");

        ServerSocket ss = new ServerSocket(3000); //metto in ascolto sulla porta 3000

        do{
            Socket s = ss.accept(); // metto il server in ascolto
            System.out.println("client collegato");
            MyThread t = new MyThread(s); //creo il tread e lo aggiungo al server
            t.start(); // faccio partire il mio thread
        }while(true);

    
       // s.close(); // chiudo il server
       // ss.close();

    }
}