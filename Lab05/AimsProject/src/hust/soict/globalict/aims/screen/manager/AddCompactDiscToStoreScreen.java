package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javafx.collections.ObservableList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends  AddItemToStoreScreen{
    Store store;
    private String artist;
    private ArrayList<Track> tracklist = new ArrayList<>();
    private String director;
    JLabel artistLabel, tracklistLabel, directorLabel, lengthLabel, trackLabel;
    JTextField artistTextField, tracklistTextField, directorTextField, lengthTextField, trackTextField;
    JPanel trackscreen, paneled;
    JTextArea trackList ;
    JButton buttonTrack;

    public AddCompactDiscToStoreScreen(Store store){
        super("CD");
        this.store= store;
        this.addComponents();
        super.createButton();
        addButton.addActionListener(new Listener());
        add(panel);
        setVisible(true);
    }

    public void addComponents(){
        super.addComponents();
        artistLabel = new JLabel("Artist:");
        artistTextField = new JTextField("");
        panel.add(addPanel(artistLabel,artistTextField));

        directorLabel = new JLabel("Director:");
        directorTextField = new JTextField("");
        panel.add(addPanel(directorLabel, directorTextField));
    }

    public void OnOff(boolean stus){
        idTextField.setEditable(stus);
        titleTextField.setEditable(stus);
        categoryTextField.setEditable(stus);
        costTextField.setEditable(stus);
        artistTextField.setEditable(stus);
        directorTextField.setEditable(stus);
    }

    public JPanel TrackScreen(){
        JPanel addTrack = new JPanel();
        addTrack.setLayout(new BoxLayout(addTrack, BoxLayout.X_AXIS));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        addTrack.setPreferredSize(new Dimension(500,90));

        JPanel rightside = new JPanel();
        rightside.setLayout(new BoxLayout(rightside, BoxLayout.Y_AXIS));
        rightside.setPreferredSize(new Dimension(200,90));
        rightside.setBorder(border);

        trackLabel = new JLabel("Track name:");
        trackTextField = new JTextField("");
        rightside.add(addPanel(trackLabel,trackTextField));

        lengthLabel = new JLabel("Length of track:");
        lengthTextField = new JTextField("");
        rightside.add(addPanel(lengthLabel,lengthTextField));

        buttonTrack = new JButton("Add track");
        buttonTrack.addActionListener(new ListenerTrack());
        rightside.add(buttonTrack);

        addTrack.add(rightside);

        addTrack.add(Box.createRigidArea(new Dimension(10,10)));

        trackList = new JTextArea(("Tracklist:"));
        trackList.setBorder(border);
        trackList.setEditable(false);

        addTrack.add(trackList);

        return addTrack;
    }

    public void CreateTrackList(){
        OnOff(false);
        remove(panel);
        panel.remove(buttonPanel);
        panel.add(trackscreen=TrackScreen());

        paneled = new JPanel();
        paneled.setLayout(new BoxLayout(paneled, BoxLayout.X_AXIS));
        paneled.setPreferredSize(new Dimension(400,30));
        JButton buttoned = new JButton("ADD CD");
        buttoned.addActionListener(new Listenered());

        paneled.add(Box.createRigidArea(new Dimension(130,30)));
        paneled.add(buttoned);
        paneled.add(Box.createHorizontalGlue());
        panel.add(paneled);
        add(panel);

        revalidate();
        repaint();
        setVisible(true);
    }

    public class Listener extends AddItemToStoreScreen.Listener {
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
            CreateTrackList();
        }
    }

    public  class ListenerTrack implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String name = new String(trackTextField.getText());
            int leng = Integer.parseInt(lengthTextField.getText());
            tracklist.add(new Track(name,leng));
            trackList.setText(trackList.getText()+"\n"+tracklist.size()+". "+name+" - Length: "+leng);
        }
    }

    public class Listenered extends AddItemToStoreScreen.Listener{
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
            director = new String(directorTextField.getText());
            artist = new String(artistTextField.getText());
            store.addMedia(new CompactDisc(id, title, category, artist, director, (ObservableList<Track>) tracklist, cost));
            restart();
        }
    }

    public void restart(){
        remove(panel);
        panel.remove(trackscreen);
        panel.remove(paneled);
        panel.add(buttonPanel);
        add(panel);
        revalidate();
        repaint();
        setVisible(true);
        OnOff(true);
    }

}