package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media{
    private List<String> authors=new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
          authors.add(authorName);
        }
      }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public String toString(){
        return "Book" + " - " + this.getTitle()+" - "+this.getCategory()+" - "+this.getCost()+"$";
    }
    
    
    // @Override
    // public boolean checkType() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'checkType'");
    // }
    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
