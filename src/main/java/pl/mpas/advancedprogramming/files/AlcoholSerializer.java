package pl.mpas.advancedprogramming.files;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class AlcoholSerializer implements Closeable {

    private static final String RECORD_FORMAT =
            "%20s %10s %4d%% %10.2f %b";


    private PrintWriter fileWriter;
    private String filePath;

    public AlcoholSerializer(String filePath) throws FileNotFoundException {
        this.filePath = Objects.requireNonNull(filePath, "Path cannot be null");

        fileWriter = new PrintWriter(filePath);
    }



    public void serializeAlcohols (List<Alcohol> alcohols){
        alcohols.forEach(alcohol -> fileWriter.format(RECORD_FORMAT,
                alcohol.getBrand(),
                alcohol.getType(),
                alcohol.getVoltage(),
                alcohol.getPrice(),
                alcohol.isTeasty())
                .println());
    }




    @Override
    public void close() throws IOException {
        fileWriter.flush();
        fileWriter.close();
    }
}
