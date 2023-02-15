import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * A class for creating a GUI for the Address Book. It can add contacts, maintain a list in alphabetical order by last
 * name, save the Address Book to a text file, and clear the Address Book.
 * @author Gaia Kannan
 * @version 1.0
 */
public class AddressGUI {
    public AddressBook addressBook = new AddressBook();

    public Contact[] contacts;
    private JList<Contact> ContactList;

    /**
     * The constructor for the Address GUI.
     */
    public AddressGUI() {
        /**
         * A method for adding a contact to the address book and sorting it in alphabetical order by surname.
         */

        createContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact(enterFirstName.getText(), enterLastName.getText(), enterPhone.getText());
                addressBook.insert(contact);
                contacts = new Contact[addressBook.size()];
                int i = 0;
                while (i < addressBook.size()) {
                    contacts[i] = addressBook.get(i);
                    i++;
                }
                enterLastName.setText("");
                enterPhone.setText("");
                enterFirstName.setText("");
                ContactList.setListData(contacts);
            }
        });

        /**
         * A method for saving the Address Book to a text file named for the current time.
         */
        saveBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws RuntimeException{
                try {
                    addressBook.saveBook();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        /**
         * A method for clearing the Address Book.
         */
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addressBook.clear();
                contacts = new Contact[0];
                ContactList.setListData(contacts);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ContactList.isSelectionEmpty()) {
                    int selected = ContactList.getSelectedIndex();
                    addressBook.delete(selected);
                    contacts = new Contact[addressBook.size()];
                    int i = 0;
                    while (i < addressBook.size()) {
                        contacts[i] = addressBook.get(i);
                        i++;
                    }
                    ContactList.setListData(contacts);
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addressBook.loadBook();
                    contacts = new Contact[addressBook.size()];
                    int i = 0;
                    while (i < addressBook.size()) {
                        contacts[i] = addressBook.get(i);
                        i++;
                    }
                    ContactList.setListData(contacts);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * The main method where the Address Book GUI is executed from.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Address Book");
        frame.setContentPane(new AddressGUI().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private JPanel Panel;
    private JLabel FirstName;
    private JLabel Phone;
    private JLabel LastName;
    private JButton createContactButton;
    private JTextField enterLastName;
    private JTextField enterFirstName;
    private JTextField enterPhone;
    private JPanel AddContact;
    private JPanel ViewPanel;
    private JButton saveBook;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton loadButton;
    private JLabel label;

}
