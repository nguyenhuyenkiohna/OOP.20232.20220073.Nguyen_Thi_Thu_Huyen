package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainStore {

    public static void main(String[] args){

        Store store = new Store();
        Book book1 = new Book(1, "The Hitchhiker's Guide to the Galaxy", "Science Fiction", 10.0f, Arrays.asList("Douglas Adams", "Bill Joy", "Guy Steele"));
        Book book2 = new Book(2, "Pride and Prejudice", "	Romance", 8.0f, Arrays.asList("Jane Austen", "Bert Bates"));
        Book book3 = new Book(3, "To Kill a Mockingbird", "	Historical Fiction", 12.0f, List.of("Harper Lee"));
        CompactDisc cd1 = new CompactDisc(1, "Twice", "Pop", "Nayeon", "Mina", new ArrayList<>(), 7.7f);
        cd1.addTrack(new Track("Cheer up", 100));
        cd1.addTrack(new Track("Yes Or Yes", 168));
        cd1.addTrack(new Track("Feel Special", 60));

        CompactDisc cd2 = new CompactDisc(2, "Yangzi", "Cpop", "Danglun", "HMin", new ArrayList<>() ,9.0f);
        cd2.addTrack(new Track("Ca Muc Ham Mat", 4120));
        cd2.addTrack(new Track("Vo vi", 3210));
        cd2.addTrack(new Track("Chan", 201));

        CompactDisc cd3 = new CompactDisc(3, "Lam gi day", "VPop",  "Kon", "Lv",new ArrayList<>(), 22.2f);
        cd3.addTrack(new Track("Hoang", 443));
        cd3.addTrack(new Track("Khai", 392));
        cd3.addTrack(new Track("Manh", 673));

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Nguyen", "Thi", "Thu", 842,10.6f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Mot ngay", "Tuyet voi", "Nhieu nang luong", 198,12.9f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Mot con vit", "Fantasy", "Happy", 234, 13.4f);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        new StoreManagerScreen(store);
    }
}