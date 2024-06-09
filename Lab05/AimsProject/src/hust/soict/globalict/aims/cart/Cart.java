package hust.soict.globalict.aims.cart;


import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED=20;
//    private ArrayList<Media> itemOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemOrdered =
        FXCollections.observableArrayList();

    public void addMedia(Media disc) throws PlayerException {
        if(itemOrdered.size()<MAX_NUMBERS_ORDERED&&!itemOrdered.contains(disc)){
            itemOrdered.add(disc);
            System.out.println("Media \""+disc.getTitle()+"\" added to cart.");
        } else {
            throw new PlayerException("Cart is full. Could not add \""+disc.getTitle()+"\".");
        }
    }

    public void removeMedia(Media disc){
        boolean found=false;
        for(int i=0;i<itemOrdered.size();i++){
            if(itemOrdered.get(i)==disc){
                found=true;
                itemOrdered.remove(i);
                System.out.println("Media \"" + disc.getTitle() + "\" removed from cart.");
//                if(disc instanceof DigitalVideoDisc)numberofDVD--;
                break;
            }
        }
        if(!found){
            System.out.println("Media \"" + disc.getTitle() + "\" not found in cart.");
        }
    }
    
    public void print(){
        System.out.println("********************************CART********************************\nOrdered items:");
        for(int i = 0; i < itemOrdered.size(); i++){
            System.out.printf("%d.%s\n",i+1,itemOrdered.get(i).toString());
        }
        System.out.println("Total cost: "+totalCost()+"$");
        System.out.println("**********************************************************************");
    }

    public float totalCost() {
        float tong = 0;
        for (int i = 0; i < itemOrdered.size(); i++) {
            tong += itemOrdered.get(i).getCost();
        }
        return tong;


        public ObservableList<Media> SearchByTitle(String title) {
            ObservableList<Media> results = FXCollections.observableArrayList();
            System.out.println("Search results for title: " + title);
            for (int i = 0; i < itemOrdered.size(); i++) {
                if (itemOrdered.get(i).isMatch(title)) {
                    results.add(itemOrdered.get(i));
                }
            }
            if (results.isEmpty()) {
                System.out.println("No matching media found with title: " + title);
            }
            return results;
        }

    }

    public ObservableList<Media> SearchByID(int id){
        ObservableList<Media> results = FXCollections.observableArrayList();
        System.out.println("Search results for id: " + id);
        for (int i=0; i< itemOrdered.size(); i++) {
            if (itemOrdered.get(i).isMatch(id)){
                results.add(itemOrdered.get(i));
            }
        }
        if (results.isEmpty()){
            System.out.println("No matching media found with ID: " + id);
        }
        return results;
    }

    public void SortByCost(){
        Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("List of medias sorted by cost in cart:");
        for(int i=0 ;i<itemOrdered.size();i++){
            System.out.println((i+1)+itemOrdered.get(i).toString());
        }
    }

    public void SortByTitle(){
        Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);    
        System.out.println("List of medias sorted by title in cart:");
        for(int i=0 ;i<itemOrdered.size();i++){
            System.out.println((i+1)+itemOrdered.get(i).toString());
        }
    }

    public void clear(){itemOrdered.clear();}

    public ObservableList<Media> getItemsOrdered() {
        return itemOrdered;
    }

}
