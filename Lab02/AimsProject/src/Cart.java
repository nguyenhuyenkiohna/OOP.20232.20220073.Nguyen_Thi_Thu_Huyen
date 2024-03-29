public class Cart {
    public static final int MAX_NUMBERS_ORDERED=20;
    public DigitalVideoDisc itemOrdered[]= new DigitalVideoDisc[20];
    private int qtyOrdered=0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
          itemOrdered[qtyOrdered] = disc;
          qtyOrdered++;
          System.out.println("Disc \"" + disc.getTitle() + "\" added to cart.");
        } else {
          System.out.println("Cart is full. Could not add \"" + disc.getTitle() + "\".");
        }
    }   
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i]==disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++)  itemOrdered[j] = itemOrdered[j + 1];
                qtyOrdered--;
                System.out.println("Disc \"" + disc.getTitle() + "\" removed from cart.");
                break;
            }
        }
        if (!found) {
          System.out.println("Disc \"" + disc.getTitle() + "\" not found in cart.");
        }
    }

    public void List(){
        System.out.println("Items in cart:");
        for(int i = 0; i < this.qtyOrdered; i++){
            System.out.println(this.itemOrdered[i].getTitle());
        }
    }

    public float totalCost(){
        float sum=0;
        for (int i = 0; i < qtyOrdered; i++){
            sum+= itemOrdered[i].getCost();
        }
        return sum;
    }
    
}

