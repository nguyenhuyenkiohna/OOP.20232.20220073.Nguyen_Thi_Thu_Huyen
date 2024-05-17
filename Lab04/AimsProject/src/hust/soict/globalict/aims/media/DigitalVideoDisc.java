package hust.soict.globalict.aims.media;

// import hust.soict.globalict.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
  
    private String director;
    private int length;
    private static int nbDigitalVideoDisc=0;
    
    public void setDirector(String director){
      this.director=director;
    }

    public void setLength(int length){
      this.length=length;
    }

    public String getDirector(){
      return director;
    }

    public int getLenght(){
      return length;
    }

    // public DigitalVideoDisc(int id, String title, String category, String director2, int length2, float cost){
    //   super(title);
    //   nbDigitalVideoDisc+=1;
    //   this.setId(nbDigitalVideoDisc);
    // }

    public DigitalVideoDisc(String title,float cost){
      this.title=title;
      this.cost=cost;
  }
  public DigitalVideoDisc(String title,String category, float cost, String director, Integer length){

  }

    public DigitalVideoDisc(String title, String category , float cost) {
      super(title,category,cost);
      nbDigitalVideoDisc += 1;
      this.setId(nbDigitalVideoDisc);
      this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
      super(title, category, director, cost);
      nbDigitalVideoDisc += 1;
      this.setId(nbDigitalVideoDisc);
      this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
      super(title, category, director, length, cost);
      nbDigitalVideoDisc += 1;
      this.setId(nbDigitalVideoDisc);
      this.setLength(length);
    }

    public DigitalVideoDisc(String string, int i, double d) {
        //TODO Auto-generated constructor stub
    }

    public DigitalVideoDisc(String title, double cost, String director2, String genre) {
        //TODO Auto-generated constructor stub
    }

    public DigitalVideoDisc(int id, String title, String category, String director2, int length2, float cost) {
        //TODO Auto-generated constructor stub
    }

    public DigitalVideoDisc(String string) {
        //TODO Auto-generated constructor stub
    }

    public String toString() {
      return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getLength() + ": " + this.getCost() + "$"; 
  }

  public boolean isMatch(String titleToCompare) {
      return this.getTitle().equalsIgnoreCase(titleToCompare);
  }

  @Override
  public void play()  {
      // TODO Auto-generated method stub
          System.out.println("Playing DVD: " + this.getTitle());
          System.out.println("DVD length: " + this.getLength());      
    }
    
}
