package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import CS320_ContactService.Contact;
import CS320_ContactService.ContactService;

class ContactServiceTest {

    // ------------------------------------------------------
    // ADD CONTACT TESTS
    // ------------------------------------------------------
    @Test
    void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);

        assertEquals(1, service.getContacts().size());
        assertEquals("1", service.getContacts().get(0).getContactId());
    }

    @Test
    void testAddContactDuplicateIdThrowsException() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "444 Elm St");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    // ------------------------------------------------------
    // DELETE CONTACT TESTS
    // ------------------------------------------------------
    @Test
    void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        service.deleteContact("1");

        assertEquals(0, service.getContacts().size());
    }

    @Test
    void testDeleteContactNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    @Test
    void testDeleteContactOnEmptyListThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1"));
    }

    // ------------------------------------------------------
    // UPDATE FIRST NAME TESTS
    // ------------------------------------------------------
    @Test
    void testUpdateFirstNameSuccess() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        service.updateFirstName("1", "Mike");

        assertEquals("Mike", service.getContacts().get(0).getFirstName());
    }

    @Test
    void testUpdateFirstNameInvalidThrowsException() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1", null));
    }

    @Test
    void testUpdateFirstNameIDNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("100", "Mike"));
    }

    // ------------------------------------------------------
    // UPDATE LAST NAME TESTS
    // ------------------------------------------------------
    @Test
    void testUpdateLastNameSuccess() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        service.updateLastName("1", "Smith");

        assertEquals("Smith", service.getContacts().get(0).getLastName());
    }

    @Test
    void testUpdateLastNameInvalidThrowsException() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("1", "NameIsTooLongForTheLimit"));
    }

    @Test
    void testUpdateLastNameIDNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("500", "Smith"));
    }

    // ------------------------------------------------------
    // UPDATE PHONE TESTS
    // ------------------------------------------------------
    @Test
    void testUpdatePhoneSuccess() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        service.updatePhone("1", "0987654321");

        assertEquals("0987654321", service.getContacts().get(0).getPhone());
    }

    @Test
    void testUpdatePhoneInvalidThrowsException() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "1234"));
    }

    @Test
    void testUpdatePhoneIDNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("100", "0987654321"));
    }

    // ------------------------------------------------------
    // UPDATE ADDRESS TESTS
    // ------------------------------------------------------
    @Test
    void testUpdateAddressSuccess() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        service.updateAddress("1", "555 New St");

        assertEquals("555 New St", service.getContacts().get(0).getStreetAddress());
    }

    @Test
    void testUpdateAddressInvalidThrowsException() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Road Ave");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("1",
                "This address is much longer than thirty characters long and should fail");
        });
    }

    @Test
    void testUpdateAddressIDNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("300", "New St"));
    }
}