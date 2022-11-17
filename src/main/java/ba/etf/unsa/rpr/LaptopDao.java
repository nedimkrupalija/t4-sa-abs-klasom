package ba.etf.unsa.rpr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface LaptopDao  {
    void dodajLaptopUListu(Laptop laptop);
    void dodajLaptopUFile(Laptop laptop) throws IOException;
    Laptop getLaptop(String procesor);
    void napuniListu(ArrayList<Laptop> laptopi);
    ArrayList<Laptop> vratiPodatkeIzDatoteke() throws Exception;
}
