import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Representing an AddressBook of Contacts, implemented with a Sorted List.
 * @author Gaia Kannan
 * @version 1.0
 */
public class AddressBook {
    private SortedList<Contact> sortedList = new SortedList<>();

    /**
     * The default constructor.
     */
    public AddressBook(){
    }

    /**
     * A constructor taking a Sorted List of Contact type as a parameter.
     * @param sortedList A Sorted List of contact type to construct the Address Book.
     */
    public AddressBook(SortedList<Contact> sortedList){
        this.sortedList = sortedList;
    }

    /**
     * Retrieve a Contact at a given index.
     * @param index The index of the Contact to be retrieved.
     * @return The Contact at the given Index.
     */
    public Contact get(int index){
        return sortedList.get(index);
    }

    /**
     * Find the Index of a Contact in the Address Book.
     * @param contact The Contact to be located.
     * @return The index if it exists, -1 if it does not.
     */
    public int search(Contact contact){
        for (int i = 0; i < size(); i++){
            if(get(i).equals(contact)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Insert a contact into the Address Book, ordered by last name.
     * @param contact Contact to be added to the Address Book.
     */
    public void insert(Contact contact){
        sortedList.insert(contact);
    }

    /**
     * Delete a contact from this Address Book.
     * @param contact The contact to delete.
     */
    public void delete(Contact contact){
        sortedList.delete(getIndex(contact));
    }

    /**
     * Delete a contact at a given index.
     * @param index Index of contact to delete.
     */
    public void delete(int index){
        sortedList.delete(index);
    }

    /**
     * Get the index of a given contact.
     * @param contact Contact to get index of.
     * @return The index of a given Contact.
     */
    public int getIndex(Contact contact){
        int i = 0;
        while (sortedList.get(i) != contact){
            i++;
        }
        return i;
    }

    /**
     * Remove all items from this Address Book.
     */
    public void clear(){
        sortedList.clear();
    }

    /**
     * Determine if this Address Book is empty.
     * @return 1 if empty, 0 if not.
     */
    public boolean isEmpty(){
        return sortedList.isEmpty();
    }

    /**
     * Return the number of contacts in this Address Book.
     * @return
     */
    public int size(){
        return sortedList.size();
    }

    /**
     * Return a list of Contacts in this Address Book who have the same area code.
     * @param areaCode Area code to return Contacts with.
     * @return A list of Contacts with the given area code.
     */
    public SortedList<Contact> AreaCodeList(String areaCode){
        SortedList<Contact> areaCodeList = new SortedList<>();
        for (int i = 0; i < size(); i++){
            Contact contact = sortedList.get(i);
            String compAreaCode = contact.getPhoneNumber().substring(0, 3);
            if (compAreaCode.equals(areaCode)){
                areaCodeList.insert(contact);
            }
        }
        return areaCodeList;
    }

    /**
     * Return a list of Contacts in this Address Book who have the same last name.
     * @param lastName Last Name to return Contacts with.
     * @return A list of Contacts with the given last name.
     */
    public SortedList<Contact> LastNameList(String lastName){
        SortedList<Contact> lastNameList = new SortedList<>();
        for (int i = 0; i < size(); i++){
            Contact contact = sortedList.get(i);
            String compareLast = contact.getLastName();
            if (compareLast.equals(lastName)){
                lastNameList.insert(contact);
            }
        }
        return lastNameList;
    }

    /**
     * Converts a given Address Book to a String.
     * @return String containing Address Book contents.
     */
    @Override
    public String toString(){
        int i = 0;
        String str = new String("");
        if (size() > 0) {
            while (i < size()) {
                str = str + sortedList.get(i).toString();
                if (i == size()-1) {
                    return str;
                }
                else str = str + "\n";
                i++;
            }
        }
        else str = "null";
        return str;
    }

    /**
     * Save this Address Book to a file.
     * @throws IOException
     */
    public void saveBook() throws IOException {
        File file = new File("addressbook.txt");
        FileWriter fw = null;
        try{
            fw = new FileWriter(file);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        fw.write(toString());
        fw.close();
    }

    /**
     * Get the SortedList of this Address Book.
     * @return The SortedList of this Address Book.
     */
    public SortedList<Contact> getSortedList() {
        return sortedList;
    }

    /**
     * Load an Address Book from a file.
     * @throws FileNotFoundException
     */

    public void loadBook() throws FileNotFoundException {
        File file = new File("addressbook.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()){
            scan.useDelimiter("\\n|:\\s|,\\s");
            String lastName = scan.next();
            String firstName = scan.next();
            String phoneNum = scan.next();
            insert(new Contact(firstName, lastName, phoneNum));
        }
    }
    /**
     * Determine if an object o is equal to this AddressBook.
     * @param o Object to be compared to this AddressBook.
     * @return 1 if they are equal, 0 if not.
     */
    @Override
    public boolean equals(Object o){
        return sortedList.equals(o);
    }
}
