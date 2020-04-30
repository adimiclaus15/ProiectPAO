package Servicii;

import Entitati.*;

import java.io.*;
import java.util.Iterator;

public class SpecializareIO
{
    private static SpecializareIO inst=null;
    private SpecializareIO() {}
    public static SpecializareIO getInst()
    {
        if(inst==null)
            inst=new SpecializareIO();
        return inst;
    }
    public void citesteSpecializari(String fisier, Service s) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader(fisier));
        String line="";
        while((line=br.readLine())!=null)
        {
            String[] a=line.split(",");
            Universitate u=s.getUniversitate(a[0]);
            Facultate f=u.getFacultate(a[1]);
            Specializare sp=new Specializare(Integer.parseInt(a[2]),a[3],Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]));
            f.adaugareSpecializare(sp);
        }
        br.close();
    }
    public void salveazaSpecializari(String fisier,Service s) throws IOException
    {
        BufferedWriter br=new BufferedWriter(new FileWriter(fisier));
        Iterator<Universitate> it=s.getListaUniversitati();
        while (it.hasNext())
        {
            Universitate u=it.next();
            Iterator<Facultate> it2=u.getListaFacultati();
            while(it2.hasNext())
            {
                Facultate f=it2.next();
                Iterator<Specializare> it3=f.getListaSpecializari();
                while(it3.hasNext())
                {
                    br.write(u.getNume()+","+f.getNume()+","+it3.next().toString());
                    br.newLine();
                }
            }
        }
        br.close();
    }
}
