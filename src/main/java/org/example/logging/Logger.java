package org.example.logging;

import org.apache.tomcat.jni.Local;
import org.example.model.User;
import org.springframework.security.core.parameters.P;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

public class Logger {

    File log = new File("src\\main\\resources\\log.txt");

    public void logSearch(String searchQuery, String sortIndication, int pageSize, int pageNumber) {
        try (PrintWriter logger = new PrintWriter(
                new FileOutputStream(log, true)
        )) {
            logger.println("Search on " + LocalDateTime.now() + ":");
            logger.println("    Search Query: " + searchQuery);
            logger.println("    Sort Method: " + sortIndication);
            logger.println("    Page Size: " + pageSize);
            logger.println("    Page Number: " + pageNumber);
            logger.println();
        } catch (FileNotFoundException exception) {
            System.err.println("Cannot open the file for writing");
        }
    }

    public void logResponse(String searchQuery, String sortIndication, int pageSize, int pageNumber, List<User> users) {
        try (PrintWriter logger = new PrintWriter(
                new FileOutputStream(log, true)
        )) {
            logger.println("Response on " + LocalDateTime.now() + ":");
            logger.println("    Search Query is now: " + searchQuery);
            logger.println("    Sort Method is now: " + sortIndication);
            logger.println("    Page Size is now: " + pageSize);
            logger.println("    Page Number is now: " + pageNumber);
            logger.println();
            logger.println("    Search Result List: ");
            logger.println();
            for (int i = 0; i < users.size(); i++) {
                logger.println("        Number in List: " + (i + 1));
                logger.println("        User ID: " + users.get(i).getUserId());
                logger.println("        Name: " + users.get(i).getName());
                logger.println("        Phone Number: " + users.get(i).getPhoneNumber());
                logger.println();
            }
            logger.println("        ---END OF RESULTS---");
            logger.println();
        } catch (FileNotFoundException exception) {
            System.err.println("Cannot open the file for writing");
        }
    }
}
