package ba.etf.unsa.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;

public class LaptopDaoJSONSerializable  extends AbstractLaptopDaoFile {
    private ObjectMapper mapper;
    protected void setup(){
        this.file = new File("jsonfile.json");
        try{
            this.mapper = new ObjectMapper();
            this.laptops = new ArrayList<Laptop>();
            this.laptops = mapper.readValue(this.file, new TypeReference<ArrayList<Laptop>>(){});
        }
        catch (Exception e){
            this.laptops = new ArrayList<Laptop>();
        }
    }
    protected void persist() throws IOException{
        this.mapper.writeValue(this.file,this.laptops);
    }

    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> o = (ArrayList<Laptop>) mapper.readValue(this.file, new TypeReference<ArrayList<Laptop>>(){});
        return o;
    }
}
