package pl.mpas.advancedprogramming.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExampleAlhohol {

    public static void main(String[] args) throws FileNotFoundException {

        List<Alcohol> alcoholicList = Arrays.asList(
                new Alcohol("Tyskie", "Beer", 5, 25.0, true),
                new Alcohol("Zywiec", "Vodka", 10, 25.0, true),
                new Alcohol("Bols", "Vodka", 80, 25.0, false),
                new Alcohol("Polska", "Vodka", 90, 25.0, false));

        ///System.out.println(File.separator);
        //System.out.println(File.pathSeparator);

        //String filePath = "alco.txt";
        String myPath = File.separator + "users" + File.separator + "pmatysik" + File.separator + "alcohol.txt";
        try (AlcoholSerializer serializer = new AlcoholSerializer(myPath)) {
            serializer.serializeAlcohols(alcoholicList);
        } catch (Exception exc) {

        }

        String path = "alcohol.txt";
            try (AlcoholDeserializer deserializer = new AlcoholDeserializer(path)){
                System.out.println(deserializer.readAlko());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
