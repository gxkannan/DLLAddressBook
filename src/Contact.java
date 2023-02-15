/**
 * Representing a Contact with a First Name, a Last Name, and a Phone Number.
 * @author Gaia Kannan
 * @version 1.0
 */
public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     * The default constructor.
     */
    public Contact(){
    }

    /**
     * A constructor taking a first name, a last name, and a phone number.
     * @param firstName The Contact's first name.
     * @param lastName The Contact's last name.
     * @param phoneNumber The Contact's phone number.
     */
    public Contact(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the Contact's first name.
     * @return The contact's first name.
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Returns the Contact's last name.
     * @return The contact's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the Contact's phone number.
     * @return The contact's phone number.
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     * Returns a Contact as a String.
     * @return  A Contact as a String in the format of "LastName, FirstName, PhoneNumber"
     */
    @Override
    public String toString(){
        String str = "";
        return str = str + lastName + ", " + firstName + ": " + phoneNumber;
    }

    /**
     * Compares two Contact objects based on their last names.
     * @param o A contact object to be compared to this.
     * @return Comparison values for last names; if they are the same,
     * comparison values for first names.
     */
    public int compareTo(Contact o) {
        int compare = this.lastName.compareTo(o.getLastName());
        if (compare == 0){
            compare = this.firstName.compareTo(o.getFirstName());
        }
        return compare;
    }

    /**
     * A method to check if two Contact objects are equal.
     * @param o A Contact to be compared to This.
     * @return 1 if equal, 0 if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Contact contact = (Contact) o;
        return firstName.equals(contact.firstName) &&
               lastName.equals(contact.lastName) &&
               phoneNumber.equals(contact.phoneNumber);
    }
}
