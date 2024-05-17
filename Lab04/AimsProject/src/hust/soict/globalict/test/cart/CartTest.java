package hust.soict.globalict.test.cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();
        CompactDisc cd = new CompactDisc(1, "The Wall", "Rock", "Pink Floyd", null, 
                                 Arrays.asList(new Track("Another Brick in the Wall Pt. 2",45), 
                                               new Track("Comfortably Numb",45)), 
                                 19.99f);
        List<String> authors = Arrays.asList("Jane Austen");
        Book book = new Book(2, "Pride and Prejudice", "Classic", 12.99f, authors);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Shawshank Redemption", "drama", "Frank Darabont", 144, 14.99f);
        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media media : mediaList) {
            System.out.println(media.toString()); 
        }
        
    }
}
