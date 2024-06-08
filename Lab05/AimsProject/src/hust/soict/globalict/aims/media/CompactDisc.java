package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    public ObservableList<Track> tracklist = FXCollections.observableArrayList();
    public List<Track> getTracks() {
        return tracklist;
    }
    public String getArtist() {
        return artist;
    }

//    public ObservableList<Track> getTrackList() {
//        for(int i=0;i<tracklist.size();i++){
//            tracklist.get(i).setNo(i+1);
//        }
//        return tracklist;
//    }

    public void addTrack(Track track) {
        if (!tracklist.contains(track)) {
            tracklist.add(track);
            System.out.println("Track '" + track + "' added successfully!");
        } else {
            System.out.println("track '" + track + "' already exists in the list.");
        }
    }

    public void removeTrack(Track track) {
        if (tracklist.contains(track)) {
            tracklist.remove(track);
            System.out.println("track '" + track + "' removed successfully!");
        } else {
            System.out.println("track '" + track + "' not found in the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracklist) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public CompactDisc(int id, String title, String category, String artist, String director, ObservableList<Track> tracklist, float cost) {
        super(id, title, category, director, 0, cost);
        super.setLength(getLength());
        this.artist = artist;
        this.tracklist = tracklist;
    }

    public CompactDisc(int id2, String title2, String category2, float cost2, String artist2) {}
    public String getTracklist() {
        String out = new String("\nList of tracks:\n");
        for(int i=0;i<tracklist.size();i++){
            out += (i+1) +". "+ tracklist.get(i).toString()+"\n";
        }
        return out;
    }

    public String toString() {
        String tracks = new String("\nList of tracks:\n");
        for(int i=0;i<tracklist.size();i++){
            tracks += tracklist.get(i).toString()+"\n";
        }
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength()+ " - " + getCost() +" $" + tracks;
    }

    public void play() throws PlayerException {
        if(this.getLength()>0) {
            String Information = new String("Playing CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getDirector() + " - " + getLength() + ": ");
            System.out.println(Information);
            System.out.println("List of tracks:");
            for (int i = 0; i < tracklist.size(); i++) {
                try {
                    System.out.print(i + ".");
                    tracklist.get(i).play();
                }catch(PlayerException e){
                    throw e;
                }
            }
        }
        else{
            throw new PlayerException("ERROR: CD length is non-posiitive!");
        }
    }
}
