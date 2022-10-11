package org.example.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {

    File searchLog = new File("src\\main\\resources\\search-log.txt");

    public void logSearch(String searchQuery, String sortIndication, int pageSize, int pageNumber) {
        try (PrintWriter logger = new PrintWriter(
                new FileOutputStream(searchLog, true)
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
}
