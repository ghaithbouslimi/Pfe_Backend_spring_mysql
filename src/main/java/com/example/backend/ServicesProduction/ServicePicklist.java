package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Us_Picklist;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.Entity.Picklists;
import com.example.backend.repositoryProduction.RepPicklists;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class ServicePicklist {

    @Autowired
     private RepPicklists repPicklists ; 

    public List <Picklists> getAllPicklists(){
        return repPicklists.findAll(); 
    }

    public Optional <Picklists> getOne(Long id) {
        return repPicklists.findById(id); 
    }

    public Picklists  savePicklists(Picklists picklist) {
        return repPicklists.save(picklist);
    } 
    
    public Picklists updatePicklists(Picklists picklist){
        return repPicklists.save(picklist); 
    }

    public Picklists findByid(Long id)
    {
        return repPicklists.findById(id).get();
    }

    public void deletePicklist(Long id) {
      Picklists picklist = findByid(id); 
      repPicklists.delete(picklist);
    }

    public void saveExcelData(MultipartFile file) throws IOException {
        List<Picklists> us = new ArrayList<>();
        try {
            InputStream inputStream = file.getInputStream() ;{
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.rowIterator();
                while ( rowIterator.hasNext()){
                    Row row = rowIterator.next();
                    if(row.getRowNum()== 0 ){
                        //skip header row
                        continue ;
                    }
                    Picklists Picklist = new Picklists();
                   Picklist.setId_PickList((long)row.getCell(0).getNumericCellValue()) ;

                    us.add(Picklist);
                }
            }
            repPicklists.saveAll(us);
        } catch ( IOException e) {

        }
    }






}
