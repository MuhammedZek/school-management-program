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
import java.util.Vector;

public class Universitaet {
    private String name = "";
    private Vector <Student> studenten = new Vector<>();
    private Vector <Dozent>  dozenten  = new Vector<>();
    private Vector <LV>  LVs  = new Vector<>();
    
     // Hier sind die Konstruktoren
    
    public Universitaet(String name){
        this.name = name ;
    }

    
    // Mehtoden von Studenten
    

    public void StudentHinzufugen(Student s){
        studenten.add(s);
    }
    
    public void StudentenAuflisten() {
        if (studenten.isEmpty()== true){
            System.out.println("Es gibt keine Studenten in dieser Universität.");
        }else{
            for (int i=0; i < studenten.size(); i++){
                Student s = studenten.elementAt(i);
                System.out.println((i+1)+". "+s.toString());
            }
        }
    }
    
    public void StudentSuchen(String ma){
        Student s1 = new Student(ma);
        boolean j = true;
        for (int i=0; i < studenten.size(); i++){
            Student s2 = studenten.elementAt(i);
            if( s2.getMatrikelnummer().compareTo(s1.getMatrikelnummer()) == 0){
                System.out.println(s2.toString());
                j = false;
                break;
            }
        }
        if(j){
            System.out.println("Es existiert kein Student mit dieser Matrikelnumemr.");
        }
    }
    
    public void StudentLoeschen(String ma){
        Student s1 = new Student (ma);
        boolean j = true;
        for (int i=0; i < studenten.size(); i++){
            if(s1.getMatrikelnummer().compareTo(studenten.elementAt(i).getMatrikelnummer())== 0){
               studenten.remove(s1); 
                System.out.println("Erfolgreich gelöscht.");
                j = false;
                break;
            }
        }
        if(j){
            System.out.println("Es existiert keine Student mit dieser Matrikelnumemr.");
        }
    }
    
      public boolean checkStudent(String ma){
        Student s = new Student(ma);
        return studenten.contains(s);
    }
      
      public void LVZuStudent(String code, String ma){
        LV lv = new LV(code);
        Student s = new Student(ma);
        for(int i = 0; i < studenten.size(); i++){
            if (s.getMatrikelnummer().compareTo(studenten.elementAt(i).getMatrikelnummer()) == 0){
                for(int j = 0; j < LVs.size(); j++){
                    if (lv.getCode().compareTo(LVs.elementAt(j).getCode()) == 0){
                        studenten.elementAt(i).addLVA(LVs.elementAt(j));
                        LVs.elementAt(j).addStudent(studenten.elementAt(i));
                        
                    }
                }      
            }
        }
        
    }
      
      public void StudentVonLvaAbmelden(String code, String ma){
        LV lv = new LV(code);
        Student s = new Student(ma);
        for(int i = 0; i < studenten.size(); i++){
            if (s.getMatrikelnummer().compareTo(studenten.elementAt(i).getMatrikelnummer()) == 0){
                for(int j = 0; j < LVs.size(); j++){
                    if (lv.getCode().compareTo(LVs.elementAt(j).getCode()) == 0){
                        studenten.elementAt(i).Abmelden(LVs.elementAt(j));
                        LVs.elementAt(j).loeschen(studenten.elementAt(i));
                        
                    }
                }      
            }
        }
        
    }
   
      public void alleLVAseinesStudenten(String ma){
        Student s = new Student(ma);
        for(int i = 0; i < studenten.size(); i++){
            if (s.getMatrikelnummer().compareTo(studenten.elementAt(i).getMatrikelnummer()) == 0){
                studenten.elementAt(i).alleLVAenAuflisten();
            }
        }
    }
      public boolean StleerCheck(String ma){
        Student s = new Student(ma);
        boolean r=false;
        for(int i = 0; i < studenten.size(); i++){
            if (s.getMatrikelnummer().compareTo(studenten.elementAt(i).getMatrikelnummer()) == 0){
                r = studenten.elementAt(i).StCheck();
            }
            
        }
        return r;
      }
  
      
      
       // Methoden von Dozenten

        
     public boolean checkDozent(String tc){
        Dozent d1 = new Dozent(tc) ;
        return  dozenten.contains(d1);
        
    }
    
    public void Dozent_einfugen(Dozent d){
        dozenten.add(d);
    }
    
    public void Alle_Dozenten_liste() {
        if (dozenten.isEmpty() == true){
            System.out.println("Es gibt keine Dozenten in dieser Universität.");          
        }else{
            for (int i=0; i < dozenten.size(); i++){
                Dozent d = dozenten.elementAt(i);
                System.out.println((i+1)+ ". "+d.getTC_nummer()+" "+ d.getAkadimischerTitel() + " " + d.toString());
            }
        }
    }
    
    public void suche_Dozent(String tc){
          Dozent d2 = new Dozent(tc);
        boolean j2 = true;
        for (int i=0; i < dozenten.size(); i++){
            Dozent d3 = dozenten.elementAt(i);
            if( d3.getTC_nummer().compareTo(d2.getTC_nummer()) == 0){
                System.out.println(d3.toString());
                j2 = false;
                break;
            }
        }
        if(j2){
            System.out.println("Es existiert keine Dozenten mit dieser TC_nummer.");
        }
        }
        
     
    public void dozent_Loschen(String tc){
        Dozent d1 = new Dozent(tc);
        boolean j = true;
        for (int i=0; i < dozenten.size(); i++){
            Dozent d2 = dozenten.elementAt(i);
            if(d1.getTC_nummer().compareTo(d2.getTC_nummer())== 0){
                dozenten.remove(d2);
                System.out.println("Erfolgreich gelöscht.");
                j = false;
                break;
            }
        }
        if(j){
            System.out.println("Es existiert keine Dozenten mit dieser TC_nummer.");
        }
    }
    
    public void DozentZurLvazuweisen(String code, String tc){
        LV lv = new LV(code);
        Dozent d = new Dozent(tc);
        for (int i = 0; i < dozenten.size(); i++ ){
            if(d.getTC_nummer().compareTo(dozenten.elementAt(i).getTC_nummer()) == 0){
                for(int j = 0; j < LVs.size(); j++){
                    if (lv.getCode().compareTo(LVs.elementAt(j).getCode()) == 0){
                        dozenten.elementAt(i).addLVA(LVs.elementAt(j));
                        LVs.elementAt(j).addDozent(dozenten.elementAt(i));
                        
                    }
                }
            }
        }
    }
    
    public void alleLVAsdesDozentenanzeigen(String tc){
        Dozent d = new Dozent(tc);
        for (int i = 0; i < dozenten.size(); i++ ){
            if(d.getTC_nummer().compareTo(dozenten.elementAt(i).getTC_nummer()) == 0){
               dozenten.elementAt(i).alleLVAenAuflisten();
            }
        }    
    }
    public void DozentVonLvaAbmelden(String code, String tc){
        LV lv = new LV(code);
        Dozent d = new Dozent(tc);
        for (int i = 0; i < dozenten.size(); i++ ){
            if(d.getTC_nummer().compareTo(dozenten.elementAt(i).getTC_nummer()) == 0){
                for(int j = 0; j < LVs.size(); j++){
                    if (lv.getCode().compareTo(LVs.elementAt(j).getCode()) == 0){
                        dozenten.elementAt(i).abmelden(LVs.elementAt(j));
                        LVs.elementAt(j).loeaschen2(dozenten.elementAt(i));
                        
                    }
                }
            }
        }
    }
        public boolean DoleerCheck(String tc){
        Dozent d = new Dozent(tc);
        boolean r=false;
        for(int i = 0; i < studenten.size(); i++){
            if (d.getTC_nummer().compareTo(dozenten.elementAt(i).getTC_nummer()) == 0){
                r = dozenten.elementAt(i).DoCheck();
            }
            
        }
        return r;
      }
    
// Methoden von LVen
    
    public boolean check_LV(String c){
        LV l = new LV(c);
        return LVs.contains(l);
    }
    
    public void LV_einfugen(LV l){
        LVs.add(l);
    }
    
    public void Alle_LV_liste() {
        
            for (int i=0; i < LVs.size(); i++){
                LV l = LVs.elementAt(i);
                System.out.println((1+i)+". " + l.toString());
            
        }
    }
    
    public void suche_LV(String code){
        LV l = new LV(code);
        boolean j = false;
        for(int i= 0; i<LVs.size(); i++){
            LV l2 = LVs.elementAt(i);
            if (l.getCode().compareTo(l2.getCode()) ==0){
                System.out.println(l2.toString());
                j = false;
                break;
            }
        }
        if(j){
            System.out.println("Es existiert kein LV diesem Code.");
        }
    }
    
    public void LVALoeschen(String c){
        LV l = new LV (c);
        boolean j = true;
        for (int i=0; i < LVs.size(); i++){
            if(l.getCode().compareTo(LVs.elementAt(i).getCode()) == 0){
                LVs.remove(l);
                System.out.println("Erfolgreich gelöscht.");
                j = false;
                break;
            }
        }
        if(j){
            System.out.println("Es existiert keine LV mit diesem Code.");
        }
    }
    
    public void alleangemeldetenStudentenderLVAauflisten(String code){
        LV l = new LV(code);
        for(int j = 0; j < LVs.size(); j++){
            if (l.getCode().compareTo(LVs.elementAt(j).getCode()) == 0){
                LVs.elementAt(j).alleStudentenAuflisten();
            }
        }
    }
    
    public void alleverantwortlichenDozentenderLVAaufliste (String code){
        LV l = new LV(code);
        for(int j = 0; j < LVs.size(); j++){
            if (l.getCode().compareTo(LVs.elementAt(j).getCode()) == 0){
                LVs.elementAt(j).alleDozentenAuflisten();
            }
        }
    }
    
    

       // Hier sind set und get Methoden
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Vector<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(Vector<Student> studenten) {
        this.studenten = studenten;
    }

    public Vector<Dozent> getDozenten() {
        return dozenten;
    }

    public void setDozenten(Vector<Dozent> dozenten) {
        this.dozenten = dozenten;
    }

    public Vector<LV> getLVs() {
        return LVs;
    }

    public void setLVs(Vector<LV> LVs) {
        this.LVs = LVs;
    }
    
}
