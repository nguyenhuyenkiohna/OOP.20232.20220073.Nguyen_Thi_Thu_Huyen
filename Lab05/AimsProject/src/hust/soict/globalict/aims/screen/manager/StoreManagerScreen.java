package hust.soict.globalict.aims.screen.manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

public class StoreManagerScreen extends JFrame{
    Container cp = getContentPane();
    JPanel center, north, header;
    protected Store store;
    MenuItemListener mil;

    public StoreManagerScreen(Store store){
        this.store = store;
        cp.setLayout(new BorderLayout());
        center = createCenter();
        north = createNorth();
        cp.add(north, BorderLayout.NORTH);
        cp.add(center, BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createNorth(){
        north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    public JMenuBar createMenuBar(){
        mil = new MenuItemListener();
        JMenu menu = new JMenu("Option");
        //View store
        JMenuItem viewstore = new JMenuItem("View store");
        menu.add(viewstore);
        viewstore.addActionListener(e->{
            new StoreManagerScreen(store);
            dispose();
        });

        //Update Store
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        addBook.addActionListener(mil);
        addDVD.addActionListener(mil);
        addCD.addActionListener(mil);

        menu.add(smUpdateStore);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    public class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            JMenuItem po = (JMenuItem) e.getSource();
            String Case = new String(po.getText());
            if(Case.equals("Add Book")){
                SwitchScreen(new AddBookToStoreScreen(store));
            }
            if(Case.equals("Add DVD")){
                SwitchScreen(new AddDigitalVideoDiscToStoreScreen(store));
            }
            if(Case.equals("Add CD")){
                SwitchScreen(new AddCompactDiscToStoreScreen(store));
            }
            if(Case.equals("View store")){
                SwitchScreen(createCenter());
            }
        }
    }

    public void SwitchScreen(JPanel panel){
        getContentPane().remove(center);
        this.center=panel;
        getContentPane().add(center, BorderLayout.CENTER);
        revalidate();
        repaint();
        setVisible(true);
    }

    public JPanel createHeader(){
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }


    public JPanel createCenter(){
        center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int numberMedia = mediaInStore.size();
        if(numberMedia==0)return center;
        for (int i=numberMedia-1;i>=Math.max(numberMedia-9,0);i--){
            mediaScreen cell = new mediaScreen(mediaInStore.get(i));
            center.add(cell);
        }

        center.revalidate();
        center.repaint();
        return center;
    }
}