package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media{
    private List<String> authors=new ArrayList<String>();
    // private static int id = 0;
    
    public Book(int i, String string, String string2, float f, List<String> authors2){

    }
    public Book(String title, String category, float cost, List<String> authors){
        this.title=title;
        this.category=category;
        this.cost=cost;
        this.authors=authors;
        id++;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }else{
            System.out.println("Author already in list");
        }
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
    }

    public String toString(){
        return "Book" + " - " + this.getTitle()+" - "+this.getCategory()+" - "+this.getCost()+"$";
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
