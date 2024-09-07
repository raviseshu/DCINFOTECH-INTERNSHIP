package com.example.demo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
//import org.apache.opennlp.tools.tokenize.SimpleTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedalTallyService {

    @Value("${csv.file.path}")
    private String csvFilePath;

    public List<String[]> readCSV() {
        List<String[]> csvData = new ArrayList<>();

        try (Reader in = new FileReader(csvFilePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
            for (CSVRecord record : records) {
                String[] row = new String[record.size()];
                for (int i = 0; i < record.size(); i++) {
                    row[i] = record.get(i);
                }
                csvData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Perform NLP techniques on the CSV data
        for (String[] row : csvData) {
            for (String cell : row) {
                // Tokenization example
                opennlp.tools.tokenize.SimpleTokenizer tokenizer = opennlp.tools.tokenize.SimpleTokenizer.INSTANCE;
                String[] tokens = tokenizer.tokenize(cell);
                System.out.println("Tokens: " + String.join(", ", tokens));
                
                
             // Inside your readCSV method
                
            }
        }

        return csvData;
    }
}