package fr.quentin.main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileActionListener {

    Window window;

    String FILE_NAME;
    String FILE_ADDRESS;

    public FileActionListener(Window window) {
        this.window = window;
    }

    public void newFile() {
        window.window.setTitle("New");
        window.textArea.setText("");

        FILE_NAME = null;
        FILE_ADDRESS = null;
    }

    public void openFile() {
        FileDialog fileDialog = new FileDialog(window.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            FILE_NAME = fileDialog.getFile();
            FILE_ADDRESS = fileDialog.getDirectory();
            window.window.setTitle(FILE_NAME);
        }
        // Debug
        System.out.println("File address: " + FILE_ADDRESS + "\n" + "File name: " + FILE_NAME);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_ADDRESS + FILE_NAME));
            window.textArea.setText("");

            String LINE = null;

            while ((LINE = bufferedReader.readLine()) != null) {
                window.textArea.append(LINE + "\n");
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    public void saveFile() {
        if (FILE_NAME == null) {
            saveAsFile();
        } else {
            try {
                FileWriter fileWriter = new FileWriter(FILE_ADDRESS + FILE_NAME);
                fileWriter.write(window.textArea.getText());
                window.window.setTitle(FILE_NAME);
                fileWriter.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveAsFile() {
        FileDialog fileDialog = new FileDialog(window.window, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            FILE_NAME = fileDialog.getFile();
            FILE_ADDRESS = fileDialog.getDirectory();
            window.window.setTitle(FILE_NAME);
        }

        try {
            FileWriter fileWriter = new FileWriter(FILE_ADDRESS + FILE_NAME);
            fileWriter.write(window.textArea.getText());
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exit(){
        System.exit(0);
    }
}
