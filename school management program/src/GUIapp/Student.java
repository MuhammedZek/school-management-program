/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIapp;

/**
 *
 * @author m.m pc
 */
import java.util.*;


public class Student extends Person {

    private String matrikelnummer = "";
    private String fachbereich = "";
    private Vector <LV> angemeldeteLV = new Vector <>();
    
    // Hier sind die Konstruktoren


    public Student(String ma) {
        this.matrikelnummer = ma;
    }
    public Student(String ma, String n, String nn) {
        this.matrikelnummer = ma;
        this.name = n;
        this.nachname = nn;
    }

    public Student(String ma, String n, String nn, String ad, String id, String tel, String em, String go, String gt,String f) {
        this.matrikelnummer = ma;
        this.name = n;
        this.nachname = nn;
        this.adresse = ad;
        this.id = id;
        this.telefonNummer = tel;
        this.e_mail = em;
        this.geburtsort = go;
        this.geburtstag = gt;
        this.fachbereich = f;
    }
    // Methoden von Student
    
    public void addLVA(LV l1){
        angemeldeteLV.add(l1);
    }
    
    public void alleLVAenAuflisten(){
        for (int i = 0; i < this.angemeldeteLV.size(); i++){
            System.out.println((i+1)+ ". " +this.angemeldeteLV.get(i));
        }
    }

    public Vector<LV> getAngemeldeteLV() {
        return angemeldeteLV;
    }

    public void setAngemeldeteLV(Vector<LV> angemeldeteLV) {
        this.angemeldeteLV = angemeldeteLV;
    }
    
    
    public static int istGueltig(String ma){ 
        if (ma.length() == 7){
            for(int i =0; i< 7 ; i++){
                // von ASCII Table String ma soll zwischen 48<= number <= 57 sein
                if ((ma.charAt(i) >= 48) && (ma.charAt(i) <= 57) ){
                    if (i == 0){
                        if(ma.charAt(i) == 48){                            
                            return 1;
                        }
                    }
                }else {
                    return 2;
                }
            }
        }else {
            return 3;
        }
        return 0;
    }
    void Abmelden(LV lv) {
        angemeldeteLV.remove(lv);
    }
    public boolean StCheck(){
       return angemeldeteLV.isEmpty();
    }

    
    // Hier sind Overrides
    
    @Override
    public String toString(){
        String v = this.name.toLowerCase();
        char c =  v.charAt(0);
        c = Character.toUpperCase(c);
        
        return this.getMatrikelnummer() + " " + c+v.substring(1, v.length()) +" "+ this.getNachname().toUpperCase();
    }    
    @Override
    public boolean equals(Object o){
        Student s = (Student) o;
        return this.matrikelnummer.compareTo(s.matrikelnummer) == 0;
    }
    
    // Hier sind set und get Methoden
    
   
    
    public String getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String getFachbereich(){
    return fachbereich;
    }

    public void setFachbereich(String fachbereich) {
        this.fachbereich = fachbereich;
    }

    

    

    
}
