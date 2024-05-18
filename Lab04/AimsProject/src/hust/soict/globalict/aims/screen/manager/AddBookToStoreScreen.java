package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JLabel authorLabel;
    private JTextArea authorTextArea;
    private List<String> authors = new ArrayList<>(); 

    public AddBookToStoreScreen(Store store) {
        super(" Add new BOOK"); 

        this.store = store;
        addComponents(); 
        createButton(); 
        addButton.addActionListener(new Listener()); 
        add(panel); 
        setVisible(true); 
    }

    public void addComponents() {
        super.addComponents();
        authorLabel = new JLabel("Author(s): "); 
        authorTextArea = new JTextArea("");
        authorTextArea.setPreferredSize(new Dimension(500, 200));
        panel.add(addPanel1(authorLabel, authorTextArea)); 
    }

    public class Listener extends AddItemToStoreScreen.Listener {
        public void actionPerformed(ActionEvent e) {
            super.actionPerformed(e); 
            authors = Arrays.asList(authorTextArea.getText().split("\\S+\n"));
            store.addMedia(new Book(id, title, category, cost, authors));
        }
    }
}