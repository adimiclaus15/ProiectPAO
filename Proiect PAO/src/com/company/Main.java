package com.company;

public class Main {

    public static void main(String[] args) {
        Service a=new Service();
        Universitate b=new Universitate("UNIBUC",1);
        a.adaugareUniversitate(b);
        Specializare s=new Specializare("Info",1,1,1,1);
        Candidat c1=new CandidatIF("Adi",123,9.0,6.0);
        Candidat c2=new CandidatIF("Cristi",12,9.0,6.01);
        s.adaugareCandidat(c1);
        s.adaugareCandidat(c2);
        Facultate f=new Facultate("FMI",2);
        f.adaugareSpecializare(s);
        Specializare p=f.getSpecializare("Info");
        p.admisiIF();
        f.afisareSpecializari();
        s.asteptareIF();
        Candidat c=s.getCandidat(12);
        System.out.println(c);
    }
}
