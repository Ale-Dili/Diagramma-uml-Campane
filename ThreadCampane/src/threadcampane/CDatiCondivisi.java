/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadcampane;

/**
 *
 * @author Ballabio Edoardo
 */
public class CDatiCondivisi {
    private int contDin;
    private int contDon;
    private int contDan;
    private String [] schermo;
    private int primoElem;
    
    public CDatiCondivisi(int ContDin,int ContDon,int ContDan) {
        this.contDin = ContDin;
        this.contDon = ContDon;
        this.contDan = ContDan;
    }
    
    public CDatiCondivisi() {
        contDin = 0;
        contDon = 0;
        contDan = 0;
    }

    public int getContDin() {
        return contDin;
    }

    public void setContDin(int contDin) {
        this.contDin = contDin;
    }

    public int getContDon() {
        return contDon;
    }

    public void setContDon(int contDon) {
        this.contDon = contDon;
    }

    public int getContDan() {
        return contDan;
    }

    public void setContDan(int contDan) {
        this.contDan = contDan;
    }
    
    public String VisualizzaSchermo() {
       String risultato = "";
       for(int i=0; i<1000; i++) {
           if(schermo[i].equals("")) {
               i=1000;
           }
           else {
               return risultato = risultato + schermo[i];
           }
       }
       return risultato;
    }
    
    public void AggiungiStringa(String s) {
        schermo[primoElem]=s;
        primoElem++;
    }   
}
