
package com.github.fillsky;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileOperator {

    private static String filePath = "D:\\Beeper\\";
    private static String fileName;
    private FileWriter fileWriter = null;
    private BufferedReader fileReader = null;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yy");

    public FileOperator() {

    }

    private boolean createFile() throws IOException {
        fileName = "data_" + LocalDateTime.now().format(dateTimeFormatter) + ".bep";
        File file = new File(filePath + fileName);

        if (file.createNewFile()) {
            System.out.println("Plik o nazwie: " + file.getName() + " został stworzony");
            return true;
        } else {

            System.out.println("Plik o takiej nazwie już istnieje");
            return false;
        }
    }

    public void deleteFile() {

    }

    public List<Beeper> openFile() throws IOException {

        List<Beeper> beepers = new ArrayList<>();
        File file = openFileChooser();
        System.out.println(file.getName());
        try {

            fileReader = new BufferedReader(new FileReader(file));

            String str;
            while ((str = fileReader.readLine()) != null) {

                beepers.add(new Beeper().fromString(str));

            }


        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        System.out.println();
        return beepers;

    }

    public void saveFile(List<Beeper> beepers) throws IOException {

        if (createFile()) {
            System.out.println("Utworzono nowy plik " + filePath);

        } else {
            System.out.println("Nadpisuję poprzedni " + filePath);
        }

        try {
            fileWriter = new FileWriter(filePath + fileName);
            for (Beeper beeper : beepers) {
                fileWriter.write(beeper.toString() + "\n");

            }

        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }


    }

    private File openFileChooser() {

        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".bep files", "bep");

        fc.setFileFilter(filter);

        int returnVal = fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            System.out.println("You chose to open this file: " +
                    file.getName());
        }
        return file;
    }


}
