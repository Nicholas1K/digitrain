package com.digitazon.digitatrain.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digitazon.digitatrain.model.Passenger;
import com.digitazon.digitatrain.repository.PassengerRepository;
import com.digitazon.digitatrain.service.CsvService;
import com.opencsv.exceptions.CsvValidationException;

@RestController
@RequestMapping("/api/csv")
@CrossOrigin
public class CsvController {
    
    @Autowired
    private CsvService csvService;

    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping("/upload-csv-data")
    public String uploadCsvData(@RequestParam("file") MultipartFile file) throws CsvValidationException, NumberFormatException {
        String fileName = file.getOriginalFilename();
        String filePath = "path/to/csv/files/" + fileName;
        try {
            file.transferTo(new File(filePath));
            List<Passenger> passengerList = csvService.importDataFromCsv(filePath);
            passengerRepository.saveAll(passengerList);
            return "Data imported successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to import data";
        }
    }
}
