package com.jerry.csvToDatabase;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Data> readCsvFile(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader); // 컬럼
        List<Data> dataList = new ArrayList<>();

        for (CSVRecord record : records) {
            Data data = new Data();
            data.setNo(record.get("NO"));
            data.setFoodCode(record.get("식품코드"));
            data.setFoodName(record.get("식품명"));
            data.setFoodLC(record.get("식품대분류"));
            data.setFoodDC(record.get("식품상세분류"));
            data.setServeSize(record.get("1회제공량"));
            data.setUnit(record.get("내용량_단위"));
            data.setKcal(record.get("에너지(㎉)"));
            data.setWater(record.get("수분(g)"));
            data.setProtein(record.get("단백질(g)"));
            data.setFat(record.get("지방(g)"));
            data.setCarbohydrate(record.get("탄수화물(g)"));
            data.setTotalSugar(record.get("총당류(g)"));
            data.setSodium(record.get("나트륨(㎎)"));
            data.setSourceFrom(record.get("성분표출처"));
            data.setAgency(record.get("발행기관"));
            dataList.add(data);
        }

        reader.close();
        return dataList;
    }
}
