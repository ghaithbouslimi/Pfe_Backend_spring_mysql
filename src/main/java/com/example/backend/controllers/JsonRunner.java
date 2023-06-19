//package com.example.backend.controllers;
//
//
//import com.example.backend.ServicesProduction.ServiceUsPicklist;
//import org.springframework.boot.ApplicationArguments;
//        import org.springframework.boot.ApplicationRunner;
//        import org.springframework.stereotype.Component;
//
//@Component
// public class JsonRunner implements ApplicationRunner {
//    private  ServiceUsPicklist ServiceUsPicklist;
//
//    public JsonRunner(ServiceUsPicklist ServiceUsPicklist) {
//        this.ServiceUsPicklist = ServiceUsPicklist;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        String jsonFilePath = "/src/main/json/Uspicklist.json";
//        ServiceUsPicklist.saveUsersFromJsonFile(jsonFilePath);
//    }
//}
