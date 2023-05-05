package com.jerry.csvToDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.jerry.csvToDatabase.DataWriter.saveDataToDatabase;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\keddy\\Desktop\\Personal Project\\data\\nutrient.csv";

        try {
            List<Data> dataList = CsvReader.readCsvFile(filePath);
            DataWriter.saveDataToDatabase(dataList);
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error saving data to database: " + e.getMessage());
        }
    }
}
