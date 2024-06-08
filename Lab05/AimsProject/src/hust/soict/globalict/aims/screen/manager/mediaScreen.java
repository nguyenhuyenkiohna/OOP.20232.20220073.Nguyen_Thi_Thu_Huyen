package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mediaScreen extends JPanel {
    private JButton playButton = new JButton("Play");

    public mediaScreen(Media media) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel contain = new JPanel();
        contain.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            contain.add(playButton);
        }

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (media instanceof DigitalVideoDisc){
                    playDVD((DigitalVideoDisc) media);
                    System.out.println("Play a DVD");
                }
                else {
                    playCD((CompactDisc) media);
                    System.out.println("Play a CD");
                }
            }
        });

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(contain);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


    private void playCD(CompactDisc media){
        JDialog CD = new JDialog();
        JPanel cd = new JPanel();
        cd.setLayout(new GridLayout(media.getTracks().size() + 6, 1));

        JLabel Name = new JLabel("CD: " + media.getTitle());
        cd.add(Name);
        JLabel Artist = new JLabel("Artist: " + media.getArtist());
        cd.add(Artist);
        JLabel Length = new JLabel("Total length: " + media.getLength());
        cd.add(Length);

        for(int i = 0; i < media.getTracks().size(); i++){
            JLabel trackName = new JLabel("Track " + (i + 1) + " name: " + media.getTracks().get(i).getTitle());
            JLabel trackLength = new JLabel("Length of track " + (i + 1) + " : " + media.getTracks().get(i).getLength());
            cd.add(trackName);
            cd.add(trackLength);
        }

        CD.add(cd);
        CD.setSize(512, 384);
        CD.setLocationRelativeTo(null);
        CD.setVisible(true);
    }
    private void playDVD(DigitalVideoDisc media){
        JDialog DVD = new JDialog();
        JPanel dvd = new JPanel();
        dvd.setLayout(new GridLayout(2, 1));

        JLabel Name = new JLabel("DVD: " + media.getTitle());
        dvd.add(Name);

        JLabel Length = new JLabel("DVD length: " + media.getLength());
        dvd.add(Length);
        
        DVD.add(dvd);
        DVD.setSize(350, 200);
        DVD.setLocationRelativeTo(null);
        DVD.setVisible(true);
    }
}