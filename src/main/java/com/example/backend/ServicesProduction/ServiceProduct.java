package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Product;
import com.example.backend.Entity.Us_Picklist;
import com.example.backend.repositoryProduction.RepProduct;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduct {

    @Autowired
    private RepProduct repositoryProduct ;

    public List<Product> getAllProduct()
    {
        return repositoryProduct.findAll();
    }

    public Optional<Product> getOne(Long id)
    {
        return repositoryProduct.findById(id);
    }
    
    public Product findByid(Long id)
    {
        return repositoryProduct.findById(id).get();
    }

    public Product saveProduct(Product product)
    {
        return repositoryProduct.save(product);
    }
    public Product updateProduct(Product product)
    {
        return repositoryProduct.save(product);
    }

    public boolean exsitById(Long id )
    {
        return repositoryProduct.existsById(id);
    }
    public void DeleteProduct(Long id)
    {
        Product product = findByid(id);
        repositoryProduct.delete(product);
    }

    public void saveExcelData(MultipartFile file) throws IOException {
        List<Product> produit = new ArrayList<>();
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
                    Product productnew = new Product();
                      productnew.setCodeProduit(row.getCell(0).getDateCellValue().getTime());
                    produit.add(productnew);
                }
            }
            repositoryProduct.saveAll(produit);
        } catch ( IOException e) {

        }
    }
}
