package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    Store store;
    private String director;
    private int length;
    JLabel directorLabel, lengthLabel;
    JTextField directorTextField, lengthTextField;
    Listener buLis = new Listener();

    public AddDigitalVideoDiscToStoreScreen(Store store){
        super("Add new DVD");
        this.store= store;
        this.addComponents();
        super.createButton();
        addButton.addActionListener(new Listener());
        add(panel);
        add(Box.createGlue());
        setVisible(true);
    }

    public void addComponents(){
        super.addComponents();
        directorLabel = new JLabel("Director: ");
        directorTextField = new JTextField("");
        panel.add(addPanel(directorLabel,directorTextField));

        lengthLabel = new JLabel("Length :");
        lengthTextField = new JTextField("");
        panel.add(addPanel(lengthLabel,lengthTextField));
    }

    public class Listener extends AddItemToStoreScreen.Listener {
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
            director = new String(directorTextField.getText());
            length = Integer.parseInt(lengthLabel.getText());
            store.addMedia(new DigitalVideoDisc(id, title, category, director, length, cost ));
        }
    }
}