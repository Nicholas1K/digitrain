package com.digitazon.digitatrain.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digitazon.digitatrain.model.Passenger;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;

@Service
public class CsvService {
    
    public List<Passenger> importDataFromCsv(String filePath) throws CsvValidationException, NumberFormatException {
        List<Passenger> passengerList = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // creare oggetto dalle righe del file CSV
                Passenger passenger = new Passenger(nextLine[0], Integer.parseInt(nextLine[1]), filePath);
                passengerList.add(passenger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengerList;
    }
}
