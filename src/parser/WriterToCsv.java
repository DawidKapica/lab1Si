package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriterToCsv {

    private String CSV_FILE_NAME;
    private List<String> dataLines = new ArrayList<>();

    public WriterToCsv(String fileName) {
        CSV_FILE_NAME = fileName;
    }

    public WriterToCsv() {
        CSV_FILE_NAME = "exampleFileName.csv";
    }

    public void createCsv() throws IOException {
        FileWriter csvWriter = new FileWriter(CSV_FILE_NAME);
        for (int i = 0; i < dataLines.size(); i++) {
            csvWriter.append(dataLines.get(i));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public void addTextToConvert(String text){
        dataLines.add(text);
    }

}
