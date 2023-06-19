package com.example.backend.ServicesProduction;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class XmlService {

        public static String getLastLineOfFile(String filePath) {
            String lastLine = null;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lastLine = line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return lastLine;
        }
}
