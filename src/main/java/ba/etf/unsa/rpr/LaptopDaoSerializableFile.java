package ba.etf.unsa.rpr;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LaptopDaoSerializableFile extends AbstractLaptopDaoFile{


    protected void persist() throws IOException{
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(this.file));
        output.writeObject(this.laptops);
        output.close();
    }
    protected void setup()  {
        this.file = new File("binarna.txt");
        this.laptops = new ArrayList<Laptop>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(this.file));

            this.laptops = (ArrayList<Laptop>) input.readObject();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws Exception{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.file));
        ArrayList<Laptop> o = (ArrayList<Laptop>) inputStream.readObject();
        return o;
    }

}
