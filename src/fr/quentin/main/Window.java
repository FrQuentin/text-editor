package fr.quentin.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;

    FileActionListener fileActionListener = new FileActionListener(this);

    public Window() {
        createJFrame();
        createJTextArea();
        createJMenuBar();
        createJMenu();
        createJMenuItem();

        window.setVisible(true);
    }

    public void createJFrame() {
        window = new JFrame("Text Editor");

        window.setSize(1000, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
    }

    public void createJTextArea() {
        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    public void createJMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
    }

    public void createJMenu() {
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
    }

    public void createJMenuItem() {
        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("itemNew");
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("itemOpen");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("itemSave");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("Save As");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("itemSaveAs");
        menuFile.add(itemSaveAs);

        menuFile.addSeparator();

        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("itemExit");
        menuFile.add(itemExit);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String COMMAND = e.getActionCommand();

        switch (COMMAND) {
            case "itemNew":
                fileActionListener.newFile();
                break;
            case "itemOpen":
                fileActionListener.openFile();
                break;
            case "itemSave":
                fileActionListener.saveFile();
                break;
            case "itemSaveAs":
                fileActionListener.saveAsFile();
                break;
            case "itemExit":
                fileActionListener.exit();
                break;
        }
    }
}
