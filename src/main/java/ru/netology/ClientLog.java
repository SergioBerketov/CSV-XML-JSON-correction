package ru.netology;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientLog {

    private List<String[]> log = new ArrayList<>();
    //private String log = "";

    public void log(int numberOfProduct, int productCount) {
        //log += String.format("%d, %d%n",numberOfProduct, productCount);
        log.add(new String[] {"" + numberOfProduct, "" + productCount});

    }

    public void exportAsCSV(File txtFile) {
        if (!txtFile.exists()) {
            //log = "productNum, amount\n" + log;
            log.add(0, new String[] {"numberOfProduct, productCount"});
        }
//        try (FileWriter writer = new FileWriter(txtFile, true)) {
//            writer.write(log);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(CSVWriter writer = new CSVWriter(new FileWriter(txtFile, true))) {
            writer.writeAll(log);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
