package CS320_ContactService;

import java.util.ArrayList;

public class ContactService {

    // Private list of contacts
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Getter so the test class can inspect the list
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    // ============================
    // ADD CONTACT
    // ============================
    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }
        contacts.add(contact);
    }

    // ============================
    // DELETE CONTACT
    // ============================
    public void deleteContact(String contactId) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID does not exist");
    }

    // ============================
    // UPDATE FIRST NAME
    // ============================
    public void updateFirstName(String contactId, String newName) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setFirstName(newName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID does not exist");
    }

    // ============================
    // UPDATE LAST NAME
    // ============================
    public void updateLastName(String contactId, String newName) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setLastName(newName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID does not exist");
    }

    // ============================
    // UPDATE PHONE
    // ============================
    public void updatePhone(String contactId, String newPhone) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setPhone(newPhone);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID does not exist");
    }

    // ============================
    // UPDATE ADDRESS
    // ============================
    public void updateAddress(String contactId, String newAddress) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setStreetAddress(newAddress);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID does not exist");
    }
}