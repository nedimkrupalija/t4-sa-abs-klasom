package ba.etf.unsa.rpr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public abstract class AbstractLaptopDaoFile implements LaptopDao{

   protected File file;
   protected ArrayList<Laptop> laptops;

   public AbstractLaptopDaoFile(){
       setup();
   }
   protected abstract void setup();

   protected abstract void persist() throws IOException;
   @Override
   public void dodajLaptopUListu(Laptop laptop) {
       laptops.add(laptop);
   }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        this.laptops.add(laptop);
        persist();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop x : laptops){
            if(x.getProcesor().equals(procesor))
                return x;
        }
        throw new NeodgovarajuciLaptopException("Laptop not found");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptops.addAll(laptopi);
    }

    @Override
    public abstract ArrayList<Laptop> vratiPodatkeIzDatoteke() throws Exception;

}
