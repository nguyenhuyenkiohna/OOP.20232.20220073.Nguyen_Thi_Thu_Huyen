package hust.soict.globalict.aims.media;

// import hust.soict.globalict.aims.media.Media;

public class Disc extends Media{
    private int length;
    private String director;

    public int getLength(){
        return length;
    }
    public String getDirector(){
        return director;
    }

    public Disc(int id, String title, String category, String string, int length, String director){
        this.id=id;
        this.title=title;
        this.category=category;
        this.cost=cost;
        this.length=length;
        this.director=director;
    }
    public Disc(){

    }
    public Disc(String title){
        this.title=title;
    }
    public Disc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Disc(String title,String category,String director,float cost){
        this.title=title;
        this.category=category;
        this.cost=cost;
        this.director=director;
    }
    public Disc(String title, String category, String director,int length,float cost){
        this.title=title;
        this.category=category;
        this.cost=cost;
        this.director=director;
        this.length=length;
    }
    
    @Override
    public boolean checkType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkType'");
    }
    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
