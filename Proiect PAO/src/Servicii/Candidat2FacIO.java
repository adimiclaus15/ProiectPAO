package Servicii;

import Entitati.*;

import java.io.*;
import java.util.Iterator;

public class Candidat2FacIO {
    private static Candidat2FacIO inst=null;
    private Candidat2FacIO() {}
    public static Candidat2FacIO getInst()
    {
        if(inst==null)
            inst=new Candidat2FacIO();
        return inst;
    }
    public void citesteCandidati2Fac(String fisier, Service s) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader(fisier));
        String line="";
        while((line=br.readLine())!=null)
        {
            String[] a=line.split(",");
            Universitate u=s.getUniversitate(a[0]);
            Facultate f=u.getFacultate(a[1]);
            Specializare sp=f.getSpecializare(a[2]);
            Candidat c=new Candidat2Fac(a[3],Long.parseLong(a[4]),Double.parseDouble(a[5]),Double.parseDouble(a[6]));
            sp.adaugareCandidat(c);
        }
        br.close();
    }
    public void salveazaCandidati2Fac(String fisier,Service s) throws IOException
    {
        BufferedWriter br=new BufferedWriter(new FileWriter(fisier));
        Iterator<Universitate> it=s.getListaUniversitati();
        while (it.hasNext())
        {
            Universitate u = it.next();
            Iterator<Facultate> it2 = u.getListaFacultati();
            while (it2.hasNext())
            {
                Facultate f = it2.next();
                Iterator<Specializare> it3 = f.getListaSpecializari();
                while (it3.hasNext())
                {
                    Specializare sp = it3.next();
                    Iterator<Candidat2Fac> it4 = sp.getListaCandidati2FAC();
                    while (it4.hasNext())
                    {
                        Candidat2Fac c = it4.next();
                        br.write(u.getNume() + "," + f.getNume() + "," + sp.getNume() + "," + c.getNume() + ","+c.getCnp()+"," + c.getMedieBac() + "," + c.getMedieFac());
                        br.newLine();
                    }
                }
            }
        }
        br.close();
    }
}
