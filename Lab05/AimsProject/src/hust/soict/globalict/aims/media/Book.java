package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors=new ArrayList<>();

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String Name) {
        if (!authors.contains(Name)) {
          authors.add(Name);
          System.out.println("Author '" + Name + "' added successfully!");
        } else{
            System.out.println("Author '" + Name + "' already exists in the list.");
        }
      }

    public void removeAuthor(String Name){
        if(authors.contains(Name)){
            authors.remove(Name);
            System.out.println("Author '" + Name + "' removed successfully!");
        } else{
            System.out.println("Author '" + Name + "' not found in the list.");
        }
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public String toString(){
        return "Book" + " - " + getTitle()+" - "+getCategory()+" - "+getCost()+"$";
    }
   
    public void play() {}
}
