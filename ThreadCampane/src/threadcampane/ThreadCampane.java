/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadcampane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @author Ballabio Edoardo
 * 
 * Classe che collabora con le altre classi ThDin, ThDon e ThDan
 */
public class ThreadCampane {

    /**@author Ballabio Edoardo
     * 
     * @brief: Metodo che si occupa di far partire il programma permettendo di scegliere se usare lo sleep, lo yield oppure entrambi.
     * 
     * In questo metodo si dichiara una variabile String di nome testo e tre thread di nome th1 e th2.
     * I seguenti thread verrano eseguiti tramite il metodo start() e testo assumerà il valore della stringa inserita dall'utente. 
     * Le variabili sleep e yield assumeranno il valore di true o false salvato in testo. 
     * Quando il programma verrà interrotto verranno confrontate le 3 variabili contatrici dei thread (ContDin, ContDan e ContDon).
     * In base alla scelta del utente e al thread che ha stampato più volte la propria stringa, verrà visualizzata una frase che attesterà la vittoria o la sconfitta dell'utente.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Semaforo sem = new Semaforo(1);
        java.io.BufferedReader console=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String testo;
        String scelta = "";
        boolean sleep, yield;
        CDatiCondivisi dati = new CDatiCondivisi();
        try {           
            sleep = false;
            yield = true;
            ThDin th1 = new ThDin(sleep, yield, dati, sem);
            ThDon th2 = new ThDon(sleep, yield, dati, sem);
            ThDan th3 = new ThDan(sleep, yield, dati, sem);
            
            System.out.println("Inserisci quale campana secondo te suonerà di più");
            scelta = console.readLine();
            
            th1.start();
            th2.start();
            th3.start();
            
            testo = console.readLine();
            
            while(!testo.equals("")) {
                testo = console.readLine();
            }
            th1.interrupt();
            th2.interrupt();
            th3.interrupt();
            
            th1.join();
            th2.join();
            th3.join();
            
            if(scelta.equals("DIN")) {
                if((dati.getContDin()>dati.getContDan()) && (dati.getContDin()>dati.getContDon())) {
                    System.out.println("Hai indovinato!");
                }
                else {
                   System.out.println("Spiacente hai perso");
                }
            }
            
            if(scelta.equals("DON")) {
                if((dati.getContDon()>dati.getContDin()) && (dati.getContDon()>dati.getContDan())) {
                    System.out.println("Hai indovinato!");
                }
                else {
                   System.out.println("Spiacente hai perso");
                }
            }
            
            if(scelta.equals("DAN")) {
                if((dati.getContDan()>dati.getContDin()) && (dati.getContDan()>dati.getContDon())) {
                    System.out.println("Hai indovinato!");
                }
                else {
                   System.out.println("Spiacente hai perso");
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ThreadCampane.class.getName()).log(Level.SEVERE, null, ex);       
        }
    }
}
