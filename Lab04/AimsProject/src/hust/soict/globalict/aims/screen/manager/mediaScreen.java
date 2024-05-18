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
    private Media media;
    private JButton playButton = new JButton("Play");
    public mediaScreen(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            container.add(playButton);
        }

        playButton.addActionListener(new ActionListener() {
            @Override
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
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


    private void playCD(CompactDisc media){
        JDialog cdD = new JDialog();

        JPanel cd = new JPanel();
        cd.setLayout(new GridLayout(media.getTrackList().size() + 6, 1));

        JLabel Name = new JLabel("You are playing CD: " + media.getTitle());
        JLabel Artist = new JLabel("Artist: " + media.getArtist());
        JLabel Length = new JLabel("Total length: " + media.getLength());

        cd.add(Name);
        cd.add(Artist);
        cd.add(Length);

        for(int i = 0; i < media.getTrackList().size(); i++){
            JLabel trackName = new JLabel("Track " + (i + 1) + " name: " + media.getTrackList().get(i).getTitle());
            JLabel trackLength = new JLabel("Length of track " + (i + 1) + " : " + media.getTrackList().get(i).getLength());
            cd.add(trackName);
            cd.add(trackLength);
        }

        cd.add(cd);

        cdD.setSize(512, 384);
        cdD.setLocationRelativeTo(null);
        cdD.setVisible(true);
    }
    private void playDVD(DigitalVideoDisc media){
        JDialog dvdD = new JDialog();

        JPanel dvd = new JPanel();
        dvd.setLayout(new GridLayout(2, 1));

        JLabel Name = new JLabel("You are playing DVD: " + media.getTitle());
        JLabel Length = new JLabel("DVD length: " + media.getLength());

        dvd.add(Name);
        dvd.add(Length);

        dvdD.add(dvd);

        dvdD.setSize(350, 200);
        dvdD.setLocationRelativeTo(null);

        dvdD.setVisible(true);

    }
}