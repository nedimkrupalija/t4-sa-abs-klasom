package ba.etf.unsa.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LaptopDaoXmlSerializable extends AbstractLaptopDaoFile {
    private XmlMapper mapper;
    @Override
    protected void setup() {
        this.file = new File("xmlfile.xml");
        this.laptops = new ArrayList<Laptop>();
        try{
            this.mapper = new XmlMapper();
            this.laptops =  mapper.readValue(this.file, new TypeReference<ArrayList<Laptop>>(){});


        }
        catch (Exception e) {
            this.laptops = new ArrayList<Laptop>();
        }
    }

    @Override
    protected void persist() throws IOException {
        this.mapper.writeValue(this.file,this.laptops);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws Exception {
        ArrayList<Laptop> o = mapper.readValue(this.file, new TypeReference<ArrayList<Laptop>>() {});
        return o;
    }
}
