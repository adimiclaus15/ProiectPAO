package Entitati;

import Servicii.Audit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Facultate {
    private String nume;
    private int id;
    private ArrayList<Entitati.Specializare> specializari;
    public Facultate(int id,String nume){
        this.nume=nume;
        this.id=id;
        specializari=new ArrayList<>();
    }
    public String getNume(){
        return this.nume;
    }
    public void setNume(String nume){
        this.nume=nume;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Iterator<Entitati.Specializare> getListaSpecializari() throws IOException
    {
        Audit.afisareQuery("getListaSpecializari");
        return specializari.iterator();
    }
    public Entitati.Specializare getSpecializare(String nume) throws IOException
    {
        Audit.afisareQuery("getSpecializare");
        Specializare sp=null;
        for(Specializare s:this.specializari)
        {
            if(s.getNume().equals(nume))
                sp=s;
        }
        return sp;
    }
    public void adaugareSpecializare(Specializare s) throws IOException
    {
        Audit.afisareQuery("adaugareSpecializare");
        specializari.add(s);
    }
    public void afisareSpecializari() throws IOException
    {
        Audit.afisareQuery("afisareSpecializari");
        for(Specializare s: this.specializari)
            System.out.println(s);
    }
    @Override
    public String toString(){
        return this.id+","+this.nume;
    }
}
