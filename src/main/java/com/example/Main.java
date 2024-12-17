package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {

       // scelgo l'host e su quale porta mettermi in ascolto
       Socket s = new Socket("localhost", 3000);

       System.out.println("client connesso");;


       // canali
       BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
       DataOutputStream out = new DataOutputStream(s.getOutputStream());


       do{
        System.out.println("Inserisci la parola: ");
        Scanner scan = new Scanner(System.in); // scan prende caratteri in input

        String stringa = scan.nextLine();
        // inserisco in stringa ciò che ho inserito in input

        if(stringa.equals("exit")){
            System.out.println("Il cliente termina");
            out.writeBytes("!" + "\n");
            // mando il punto esclamativo che da il segnale al server di terminare
            break;
        }
        out.writeBytes(stringa + "\n");
        String stringaRicevutadalServer = in.readLine();
        // leggo ciò che il server mi ha mandato

        
        System.out.println("il server ha risposto: "+ stringaRicevutadalServer);

       }while(true);
    }
}