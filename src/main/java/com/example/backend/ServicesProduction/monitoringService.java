package com.example.backend.ServicesProduction;

import com.example.backend.Entity.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class monitoringService {
    @Autowired
    private ServiceSocket serviceSocket;
    @Autowired
    private EmailSenderService senderService;
    //@Scheduled(cron = "0 */15 * * * ")
    public boolean monitoring(Long id ) {
        String filePath = "D:/PFE/SocketPana.log";
        String lastTime = XmlService.getLastLineOfFile(filePath); ;
        LocalTime currentTime = LocalTime.now()  ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedcurrentTime = currentTime.format(formatter);
        LocalTime TimeNow = LocalTime.parse(formattedcurrentTime);
        System.out.println(TimeNow);
        LocalTime targetTime = LocalTime.parse(lastTime.substring(14,22));
        System.out.println(targetTime);
        java.time.Duration duration = java.time.Duration.between(TimeNow, targetTime);
        long minutes = duration.toMinutes();
        System.out.println(minutes);
        if (minutes > 15) {
            Socket s = this.serviceSocket.changeStatus(id);
            senderService.sendSimpleEmail("ghaithbouslimi3@gmail.com",
                    "Monitoring of sockets",
                    "le socket du client : "+s.getClient()+"  , d'adresse IP :"
                            +s.getServeur()+"et du Port :/n"+s.getPort()+" s'interompt");
            System.out.println("First time is  greater than 15 minutes from the current time.");
            return true;
        } else {

            System.out.println("First time is not greater than 15 minutes from the current time.");
            return false;
       }
    }

}
