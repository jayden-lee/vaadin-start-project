package com.jayden.admin.service.business;

import com.jayden.admin.model.Business;
import com.jayden.admin.view.dashboard.sample.SearchGridTest;
import com.vaadin.flow.component.notification.Notification;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Business Sample Data
 * https://www.stats.govt.nz/large-datasets/csv-files-for-download/
 */
@Service
public class BusinessService {

    private Stream<Business> loadData() {
        List<Business> businesses = new ArrayList<>();

        try {
            Reader reader = new FileReader(getFileFromResources("data/grid-sample-data.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());

            for (CSVRecord csvRecord : csvParser) {
                businesses.add(
                    Business.builder()
                        .Year(csvRecord.get("Year"))
                        .Industry_aggregation_NZSIOC(csvRecord.get("Industry_aggregation_NZSIOC"))
                        .Industry_code_NZSIOC(csvRecord.get("Industry_code_NZSIOC"))
                        .Industry_name_NZSIOC(csvRecord.get("Industry_name_NZSIOC"))
                        .Units(csvRecord.get("Units"))
                        .Variable_code(csvRecord.get("Variable_code"))
                        .Variable_name(csvRecord.get("Variable_name"))
                        .Variable_category(csvRecord.get("Variable_category"))
                        .Value(csvRecord.get("Value"))
                        .Industry_code_ANZSIC06(csvRecord.get("Industry_code_ANZSIC06"))
                        .build());
            }

            return businesses.stream();
        } catch (Exception e) {
            Notification.show(e.getMessage());
            return businesses.stream();
        }
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = SearchGridTest.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public Stream<Business> fetchAll() {
        return loadData();
    }
}
