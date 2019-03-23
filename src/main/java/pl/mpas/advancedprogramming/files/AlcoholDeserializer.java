package pl.mpas.advancedprogramming.files;

import javafx.scene.chart.AxisBuilder;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AlcoholDeserializer implements Closeable {

    private BufferedReader fileReder;
    private String filePath;

    public AlcoholDeserializer(String filePath) throws FileNotFoundException {
        this.filePath= Objects.requireNonNull(filePath, "DO NOT DO THIS - NULL !!");

        fileReder = new BufferedReader(new FileReader(filePath));
    }

    public List<Alcohol> readAlko() throws IOException {

     return readAlcogholsJava7();
    }

    private List<Alcohol> readAlcogholsJava7() throws IOException {
       List<Alcohol> result = new ArrayList<>();
        String line = null;
       while ((line = fileReder.readLine()) != null) {
           Scanner scanner = new Scanner(line);
            String brand = scanner.next();
            String type = scanner.next();

            //5%
            String voltagewithProc = scanner.next();
            //int voltage = scanner.nextInt();
           String patterntoCut = "%";
           int voltage = Integer.parseInt(
           voltagewithProc.substring(0, voltagewithProc.length() - patterntoCut.length()));
            double price = scanner.nextDouble();
            boolean isTasty = scanner.hasNextBoolean();

            result.add(new Alcohol(brand,type,voltage,price,isTasty));

       }
    return result;
    }


    private List<Alcohol> readlcoholJava8(){
        List<Alcohol> result = new ArrayList<>();
        final int branfdIndex = 0;
        final int typeIndex = 1;
        final int voltageIndex = 2;
        final int priceInex = 3;
        final int isTeastyIndex = 4;
        fileReder.lines()
                .filter(line -> line.length()>0)
                .map(s -> s.split("" + " +"))
                .map(o -> {
                    String voltagewithProc = o[voltageIndex];
                    String patterntoCut = "%";
                    int voltage = Integer.parseInt(
                            voltagewithProc.substring(0, voltagewithProc.length() - patterntoCut.length()));

                    return new Alcohol(o[branfdIndex], o[typeIndex], voltage, Double.parseDouble(o[priceInex]), Boolean.parseBoolean(o[isTeastyIndex]));
                }).collect(Collectors.toList());

        return result;
    }




    @Override
    public void close() throws IOException {
        fileReder.close();
    }
}
