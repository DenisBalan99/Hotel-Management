package com.example.booking.Service;

import com.example.booking.Entity.csvObj;
import com.example.booking.Repository.CsvObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    CsvObjRepository csvObjRepository;

    public List<csvObj> getEmp() {
        return csvObjRepository.findAll();
    }

    public void uploadCsv(MultipartFile csvFile) {

        try {

            String line;
            BufferedReader bufferedReader;
            InputStream inputStream = csvFile.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int firstline = 0;

            while ((line = bufferedReader.readLine()) != null) {

                // sar peste prima linie
                if (firstline == 0) {
                    firstline++;
                    continue;
                }

                // parsez fiecare linie dupa ","
                String[] values = line.split(",");
                csvObj emp = new csvObj();
                emp.setId(Long.parseLong(values[0]));
                emp.setFirstName(values[1]);
                emp.setLastName(values[2]);
                emp.setFunction(values[3]);
                emp.setSalary(Long.parseLong(values[4]));

                csvObjRepository.save(emp);
            }

            System.out.println(csvObjRepository.findAll());

        }
        catch (Exception e) {
            System.out.println("nu merge");
            e.printStackTrace();
        }
    }
}
