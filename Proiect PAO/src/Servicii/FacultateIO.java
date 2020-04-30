package Servicii;

import Entitati.*;

import java.io.*;
import java.util.Iterator;

public class FacultateIO
{
    private static FacultateIO inst=null;
    private FacultateIO() {}
    public static FacultateIO getInst()
    {
        if(inst==null)
            inst=new FacultateIO();
        return inst;
    }
    public void citesteFacultati(String fisier, Service s) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader(fisier));
        String line="";
        while((line=br.readLine())!=null)
        {
            String[] a=line.split(",");
            Universitate u=s.getUniversitate(a[0]);
            Facultate f=new Facultate(Integer.parseInt(a[1]),a[2]);
            u.adaugareFacultate(f);
        }
        br.close();
    }
    public void salveazaFacultati(String fisier,Service s) throws IOException
    {
        BufferedWriter br=new BufferedWriter(new FileWriter(fisier));
        Iterator<Universitate> it=s.getListaUniversitati();
        while (it.hasNext())
        {
            Universitate u=it.next();
            Iterator<Facultate> it2=u.getListaFacultati();
            while(it2.hasNext())
            {
                br.write(u.getNume()+","+it2.next().toString());
                br.newLine();
            }
        }
        br.close();
    }
}
