import Entitati.*;
import Servicii.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
        //citim datele din csv-uri
        Service s=new Servicii.Service();
        UniversitateIO u=UniversitateIO.getInst();
        u.citesteUniversitati("data/universitati.csv",s);

        FacultateIO f=FacultateIO.getInst();
        f.citesteFacultati("data/facultati.csv",s);

        SpecializareIO sp=SpecializareIO.getInst();
        sp.citesteSpecializari("data/specializari.csv",s);

        CandidatIFIO r=CandidatIFIO.getInst();
        r.citesteCandidatiIF("data/candidatiIF.csv",s);

        CandidatIDIO p= CandidatIDIO.getInst();
        p.citesteCandidatiID("data/candidatiID.csv",s);

        Candidat2FacIO t=Candidat2FacIO.getInst();
        t.citesteCandidati2Fac("data/candidati2FAC.csv",s);

        //efectuam query-uri asupra datelor si modificam datele pentru a testa clasa audit + functiile de salvare
        System.out.println("Lista universitati:");
        s.afisareUniversitati();
        Universitate a=new Universitate(4,"UMF","adresa4");
        s.adaugareUniversitate(a);

        a=s.getUniversitate("Universitatea Bucuresti");
        System.out.println("Lista facultati din UNIBUC:");
        a.afisareFacultati();
        Facultate b=new Facultate(10,"Facultatea de Drept");
        a.adaugareFacultate(b);

        b=a.getFacultate("Facultatea de Matematica si Informatica");
        System.out.println("Lista specializari din FMI:");
        b.afisareSpecializari();
        Specializare q=new Specializare(20,"CTI",50,100,50);
        b.adaugareSpecializare(q);

        q=b.getSpecializare("Informatica");
        System.out.println("Lista candidati informatica frecventa FMI:");
        q.afisareCandidatiIF();
        Candidat c=new CandidatIF("Alabala",14652341241L,8.5,9.0);
        q.adaugareCandidat(c);

        q=b.getSpecializare("Informatica");
        System.out.println("Lista candidati informatica distanta FMI:");
        q.afisareCandidatiID();
        c=new CandidatID("tttt",14691141241L,6.0,5.0);
        q.adaugareCandidat(c);

        q=b.getSpecializare("Matematica");
        System.out.println("Lista candidati matematica a 2-a facultate FMI:");
        q.afisareCandidati2FAC();
        c=new Candidat2Fac("rrrr",146523341241L,9.0,9.9);
        q.adaugareCandidat(c);

        //salvam in fisierele de unde am citit modificarile facute
        u.salveazaUniversitati("data/universitati.csv",s);
        f.salveazaFacultati("data/facultati.csv",s);
        sp.salveazaSpecializari("data/specializari.csv",s);
        r.salveazaCandidatiIF("data/candidatiIF.csv",s);
        p.salveazaCandidatiID("data/candidatiID.csv",s);
        t.salveazaCandidati2Fac("data/candidati2FAC.csv",s);
    }
}