package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public void play() {}

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
      super.setId(id);
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
      super.setDirector(director);
      super.setLength(length);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
      super.setDirector(director);
      super.setLength(length);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
      super.setDirector(director); 
    }

    public DigitalVideoDisc(String title, String category, float cost) {
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
    }

    public DigitalVideoDisc(String title) {
      super.setTitle(title);
    }

    public String toString() {
      return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost()+" $";
    }
  
}