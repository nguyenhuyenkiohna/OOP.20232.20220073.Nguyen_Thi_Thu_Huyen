package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors=new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String Name) {
        if (!authors.contains(Name)) {
          authors.add(Name);
        }
      }

    public void removeAuthor(String Name){
        if(authors.contains(Name)){
            authors.remove(Name);
        }
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public String toString(){
        return "Book" + " - " + this.getTitle()+" - "+this.getCategory()+" - "+this.getCost()+"$";
    }
   
    public void play() {}
}
