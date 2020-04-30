package Servicii;

import Entitati.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Service {
    private ArrayList<Universitate> listaUniversitati;
    public Service()
    {
        this.listaUniversitati=new ArrayList<>();
    }
    public void adaugareUniversitate(Universitate u) throws IOException
    {
        Servicii.Audit.afisareQuery("adaugareUniversitate");
        this.listaUniversitati.add(u);
    }
    public Iterator<Universitate> getListaUniversitati() throws IOException
    {
        Audit.afisareQuery("getListaUniversitati");
        return listaUniversitati.iterator();
    }
    public Universitate getUniversitate(String s) throws IOException
    {
        Audit.afisareQuery("getUniversitate");
        Universitate univ=null;
        for(Universitate u: this.listaUniversitati){
            if(u.getNume().equals(s))
                univ=u;
        }
        return univ;
    }
    public void afisareUniversitati() throws IOException
    {
        Audit.afisareQuery("afisareUniversitati");
        for(Universitate u: listaUniversitati)
            System.out.println(u);
    }
}
