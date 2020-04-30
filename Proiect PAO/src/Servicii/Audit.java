package Servicii;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Audit
{
    private Audit(){}
    public static void afisareQuery(String s) throws IOException
    {
        BufferedWriter br=new BufferedWriter(new FileWriter("audit.csv",true));
        LocalDateTime t=LocalDateTime.now();
        br.write(s+","+t);
        br.newLine();
        br.close();
    }
}
