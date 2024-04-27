package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.disc.Disc;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track>tracks = new ArrayList<Track>();
    private int length=0;

    public String getArtist(){
        return artist;
    }
    public CompactDisc(int id, String title, String category, String string, String director, List<Track> list, float f){
        super(id,title,category,string,0,director);
        this.artist=artist;
        this.tracks=tracks;
    }

    public CompactDisc(String artist, List<Track> tracks){
        this.artist=artist;
        this.tracks=tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist){

    }

    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
        }
    }

    public int getLenght(){
        for(Track track:tracks){
            length+=track.getLength();
        }
        return length;
    }

    public String toString(){
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + " - " + this.getCost();
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("Information about disc: ");
        System.out.println("Artist" + this.getArtist());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public boolean checkType() {
        // TODO Auto-generated method stub
        return true;
    }
}
