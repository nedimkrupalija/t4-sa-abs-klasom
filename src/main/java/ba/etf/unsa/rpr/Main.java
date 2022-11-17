package ba.etf.unsa.rpr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LaptopDao laptop = new LaptopDaoXmlSerializable();
        Laptop l = new Laptop("jabuka",125.,5,5,5,"intel","nvidia");

        laptop.dodajLaptopUListu(l);
        try {
            laptop.dodajLaptopUFile(l);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}