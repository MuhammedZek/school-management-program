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

public class LV {

    private String name = "";
    private String code = "";
    private Vector<Student> angemeldeteStudenten = new Vector<>();
    private Vector<Dozent> zugewieseneDozenten = new Vector<>();

    // Hier sind die Konstruktoren
    public LV(String c) {
        this.code = c;
    }

    public LV(String c, String n) {
        this.code = c;
        this.name = n;
    }

    // Hier sind die Methoden 
    public void addStudent(Student s1) {
        angemeldeteStudenten.add(s1);
    }

    public void addDozent(Dozent d) {
        zugewieseneDozenten.add(d);
    }

    public void alleStudentenAuflisten() {
        if (this.angemeldeteStudenten.isEmpty()) {
            System.out.println("Es gibt keine Studenten, die zu dieser LVA angemeldet sind. ");
        } else {
            for (int i = 0; i < this.angemeldeteStudenten.size(); i++) {
                System.out.println((i + 1) + ". " + angemeldeteStudenten.elementAt(i).toString());
            }
        }
    }

    public void alleDozentenAuflisten() {
        if (this.zugewieseneDozenten.isEmpty()) {
            System.out.println("Es gibt keine Dozenten, die zu dieser LVA zugewiesen sind. ");
        } else {
            for (int i = 0; i < this.zugewieseneDozenten.size(); i++) {
                System.out.println((i + 1) + ". " + zugewieseneDozenten.elementAt(i).toString());
            }
        }

    }

    public LV() {
    }
    

    public static int istGueltig(String c) {
        if (c.length() == 6) {
            for (int i = 0; i < 3; i++) {
                // von ASCII Table String c soll zwischen 65<= gross <= 90 sein
                if ((c.charAt(i) >= 65) && (c.charAt(i) <= 90)) {

                } else {
                    return 1;
                }
            }
            for (int s = 3; s < 6; s++) {
                // von ASCII Table String c soll zwischen 48<= number <= 57 sein
                if ((c.charAt(s) >= 48) && (c.charAt(s) <= 57)) {

                } else {
                    return 1;
                }
            }
        } else {
            return 2;
        }
        return 0;
    }

    void loeschen(Student s) {
        angemeldeteStudenten.remove(s);
    }

    void loeaschen2(Dozent d) {
        zugewieseneDozenten.remove(d);
    }

     // Hier sind Override 
    @Override
    public String toString() {
        String s = this.getName().toLowerCase();
        char c = s.charAt(0);
        c = Character.toUpperCase(c);
        return this.getCode().toUpperCase() + " " + c + s.substring(1, s.length());
    }

    public Vector<Student> getAngemeldeteStudenten() {
        return angemeldeteStudenten;
    }

    public void setAngemeldeteStudenten(Vector<Student> angemeldeteStudenten) {
        this.angemeldeteStudenten = angemeldeteStudenten;
    }

    public Vector<Dozent> getZugewieseneDozenten() {
        return zugewieseneDozenten;
    }

    public void setZugewieseneDozenten(Vector<Dozent> zugewieseneDozenten) {
        this.zugewieseneDozenten = zugewieseneDozenten;
    }

    @Override
    public boolean equals(Object o) {
        LV l = (LV) o;
        return this.getCode().compareTo(l.getCode()) == 0;
    }

    // Hier sind set und get Methoden
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
