package CS320_ContactService;

public class Contact {

    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String streetAddress;

    public Contact(String contactId, String firstName, String lastName, String phone, String streetAddress) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (streetAddress == null || streetAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.streetAddress = streetAddress;
    }

    // ======================
    // GETTERS
    // ======================
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getStreetAddress() { return streetAddress; }

    // ======================
    // SETTERS (for updates)
    // ======================
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setStreetAddress(String streetAddress) {
        if (streetAddress == null || streetAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.streetAddress = streetAddress;
    }
}