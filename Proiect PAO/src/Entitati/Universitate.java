package Entitati;

import Servicii.Audit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Universitate {
    private String nume;
    private int id;
    private String adresa;
    private ArrayList<Facultate> listaFacultati;
    public Universitate(int id,String nume,String adresa)
    {
        this.nume=nume;
        this.id=id;
        this.adresa=adresa;
        listaFacultati=new ArrayList<Facultate>();
    }
    public String getAdresa() throws IOException
    {
        return this.adresa;
    }
    public void setAdresa(String adresa) throws IOException
    {
        this.adresa=adresa;
    }
    public String getNume() throws IOException{
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
    public Iterator<Facultate> getListaFacultati() throws IOException
    {
        Audit.afisareQuery("getListaFacultati");
        return listaFacultati.iterator();
    }
    public void adaugareFacultate(Facultate f) throws IOException
    {
        Audit.afisareQuery("adaugareFacultate");
        this.listaFacultati.add(f);
    }
    public void afisareFacultati() throws IOException
    {
        Audit.afisareQuery("afisareFacultati");
        for(Facultate f : listaFacultati)
            System.out.println(f);
    }
    public Facultate getFacultate(String s) throws IOException
    {
        Audit.afisareQuery("getFacultate");
        Facultate fac=null;
        for(Facultate f: this.listaFacultati){
            if(f.getNume().equals(s))
                fac=f;
        }
        return fac;
    }
    @Override
    public String toString() {
        return this.id+","+this.nume+","+this.adresa;
    }
}
