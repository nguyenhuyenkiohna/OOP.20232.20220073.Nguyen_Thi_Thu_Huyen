package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.Objects;

public class Track implements Playable{
    private String title;
    private int length;
    private int no;

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
//    public String toString(){
//        return  getNo() + " - " + getTitle() + " - " + getLength();
//    }
//    public String toString(){
//        return  getTitle() + " - " + getLength();
//    }
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
    public void play() throws PlayerException{
        if(this.getLength()>0){
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else{
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
}
