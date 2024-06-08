package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JPanel{
    protected Store store;
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    protected JButton addButton ;
    private JLabel idLabel, titleLabel, categoryLabel, costLabel ;
    protected JTextField idTextField, titleTextField, categoryTextField, costTextField;

    protected JPanel panel = new JPanel();
    protected JPanel buttonPanel;

    public AddItemToStoreScreen(String s){
        setLayout(new FlowLayout());
        setSize(new Dimension(400,500));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400,500));

        JLabel title = new JLabel("Add new " +s +" to store:");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN,30));
        panel.add(title);
    }

    public void createButton (){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setPreferredSize(new Dimension(400,30));
        addButton = new JButton("Add to store");
        buttonPanel.add(Box.createRigidArea(new Dimension(130,30)));
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createHorizontalGlue());
        panel.add(buttonPanel);
    }

    public void addComponents(){
        idLabel = new JLabel("ID: ");
        idTextField = new JTextField("");
        panel.add(addPanel(idLabel,idTextField));

        titleLabel = new JLabel("Title: ");
        titleTextField = new JTextField("");
        panel.add(addPanel(titleLabel,titleTextField));

        categoryLabel = new JLabel("Category: ");
        categoryTextField = new JTextField("");
        panel.add(addPanel(categoryLabel,categoryTextField));

        costLabel = new JLabel("Cost ($): ");
        costTextField = new JTextField("");
        panel.add(addPanel(costLabel,costTextField));
    }

    public JPanel addPanel(JLabel label, JTextField textField){
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setPreferredSize(new Dimension(400,30));

        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(new Dimension(120, 30));
        jPanel.add(label);

        jPanel.add(Box.createRigidArea(new Dimension(10,10)));

        textField.setPreferredSize(new Dimension(250, 30));
        jPanel.add(textField);

        return jPanel;
    }

    public JPanel addPanel1(JLabel label, JTextArea textArea){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.setPreferredSize(new Dimension(400,30));

        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(new Dimension(120, 30));
        jPanel.add(label);

        jPanel.add(Box.createRigidArea(new Dimension(10,10)));

        textArea = new JTextArea("",3,7);

        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setLineWrap(true);
        jPanel.add(scroll);

        return jPanel;
    }

    public class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            id = Integer.parseInt(idTextField.getText());
            title= new String(titleTextField.getText());
            category= new String(categoryTextField.getText());
            cost= Float.parseFloat(costTextField.getText());
        }
    }
}