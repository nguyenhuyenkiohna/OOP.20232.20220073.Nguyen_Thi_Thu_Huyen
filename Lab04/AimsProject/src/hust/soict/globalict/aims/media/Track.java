package hust.soict.globalict.aims.media;

import java.util.Objects;

public class Track implements Playable{
    private String title;
    private int length;

    public String toString(){
        return  getTitle() + " - " + getLength(); 
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public void setLength(int length) {
        this.length=length;
    }
    public boolean equals(Object obj){
        // if(obj instanceof Track){
        //     Track track = (Track) obj;
        //     return (track.getTitle()==this.getTitle()&&track.getLength()==this.getLength());
        // } else {
        //     return false;
        // }
        if (this == obj) return true;
        if (!(obj instanceof Track that)) return false;
        return Objects.equals(getTitle(), that.getTitle()) && getLength() == that.getLength();
    }
    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
