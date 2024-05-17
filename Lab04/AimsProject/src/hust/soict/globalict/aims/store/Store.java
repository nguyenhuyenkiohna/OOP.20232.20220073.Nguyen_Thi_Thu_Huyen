package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore=new ArrayList<Media>();

    public void addMedia(Media media){
        if(!itemsInStore.contains(media)){
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
        }
    }

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }

    public void display(){
        for(Media media: itemsInStore){
            System.out.println(media);
        }
    }
    
    public Media SearchByTitle(String title){
        for(int i = 0; i < itemsInStore.size();i++){
            if(itemsInStore.get(i).getTitle()==title){
                System.out.println("The information of media containing the keyword:\n");
                System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        System.out.println("The information of media containing the keyword:\n");
        return null;
    }

}
