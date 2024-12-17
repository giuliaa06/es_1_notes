package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread {
    Socket s;

    //costruttore
    public MyThread(Socket s){
        this.s = s;
    }

    public void run(){
        try{
            // canali dove passano i dati
           BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream()); 

            do{
                //leggo la prima riga che ricevo e la inserisco nella stringa
                String stringaRicevuta = in.readLine();
                if ( stringaRicevuta.equals("!")) //ricevuto dal client
                {
                    System.out.println("il client vuole chiudere");

                    s.close(); // ho chiuso la socket su cui ero collegato
                    break;
                }
                System.out.println("Stringa ricevuta "+ Thread.currentThread().getName() + " ");
                    //currentThread mi restituisce il numero del thread

                String trasformata = stringaRicevuta.toUpperCase();
                //trasformo la sringa che ho ricevuto in stampato maiuscolo

                out.writeBytes(trasformata + "\n");
                // mando sul canale la stringa trasformata



            }while (true);
            
        } catch (Exception e) {
            e.printStackTrace(); //individua la riga 
                                 // esatta in cui il metodo ha sollevato 
                                 // l'eccezione.
        }
    }
    

}
