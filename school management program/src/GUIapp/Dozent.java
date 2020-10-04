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

public class Dozent extends Person {

    private String akadimischerTitel = "";
    private String TC_nummer = "";
    private Vector<LV> ZugewieseneLV = new Vector<>();

    // Hier sind die Konstruktoren
    public Dozent(String tc) {
        this.TC_nummer = tc;
    }

    public Vector<LV> getZugewieseneLV() {
        return ZugewieseneLV;
    }

    public void setZugewieseneLV(Vector<LV> ZugewieseneLV) {
        this.ZugewieseneLV = ZugewieseneLV;
    }

    public Dozent(String d, String dd) {
        this.name = d;
        this.nachname = dd;
    }

    public Dozent(String d, String dd, String ad) {
        this.name = d;
        this.nachname = dd;
        this.akadimischerTitel = ad;
    }

    public Dozent(String tc, String d, String dd, String ad, String adr, String id, String tel, String em, String go, String gt) {
        this.TC_nummer = tc;
        this.name = d;
        this.nachname = dd;
        this.akadimischerTitel = ad;
        this.adresse = adr;
        this.id = id;
        this.telefonNummer = tel;
        this.e_mail = em;
        this.geburtsort = go;
        this.geburtstag = gt;

    }

    // Hier sind die Methoden
    public void addLVA(LV l) {
        ZugewieseneLV.add(l);
    }

    public void alleLVAenAuflisten() {
        for (int i = 0; i < this.ZugewieseneLV.size(); i++) {
            System.out.println((i + 1) + ". " + this.ZugewieseneLV.elementAt(i));
        }
    }

    public static int istGueltig(String tc) {
        if (tc.length() == 11) {
            for (int i = 0; i < 11; i++) {
                // von ASCII Table String t soll zwischen 48<= number <= 57 sein
                if ((tc.charAt(i) >= 48) && (tc.charAt(i) <= 57)) {

                } else {
                    return 1;
                }
            }
        } else {
            return 2;
        }
        return 0;
    }

    void abmelden(LV lv) {
        ZugewieseneLV.remove(lv);
    }

    public boolean DoCheck() {
        return ZugewieseneLV.isEmpty();
    }

    // Hier sind Overrides
    @Override
    public String toString() {
        String q = this.name.toLowerCase();
        char b = q.charAt(0);
        b = Character.toUpperCase(b);

        return b + q.substring(1, q.length()) + " " + this.getNachname().toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        Dozent d = (Dozent) o;
        return this.toString().compareTo(d.toString()) == 0;
    }

    // Hier sind set und get Methoden
    public String getAkadimischerTitel() {
        return akadimischerTitel;
    }

    public void setAkadimischerTitel(String akadimischerTitel) {
        this.akadimischerTitel = akadimischerTitel;
    }

    public String getTC_nummer() {
        return TC_nummer;
    }

    public void setTC_nummer(String TC_nummer) {
        this.TC_nummer = TC_nummer;
    }

}
