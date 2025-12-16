package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import CS320_ContactService.Contact;

class ContactTest {

    // ==================================================
    // VALID CASE
    // ==================================================
    @Test
    void testAllInBounds() {
        Contact contact = new Contact(
            "123456789",
            "Davis",
            "Schwartz",
            "9379263297",
            "12345 Apple street dayton, OH"
        );

        assertEquals("123456789", contact.getContactId());
        assertEquals("Davis", contact.getFirstName());
        assertEquals("Schwartz", contact.getLastName());
        assertEquals("9379263297", contact.getPhone());
        assertEquals("12345 Apple street dayton, OH", contact.getStreetAddress());
    }

    // ==================================================
    // CONTACT ID TESTS
    // ==================================================
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ABCDEFGHIJKL", "Davis", "Schwartz", "9379263297", "123 Street");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Davis", "Schwartz", "9379263297", "123 Street");
        });
    }

    // ==================================================
    // FIRST NAME TESTS
    // ==================================================
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "DavisTheGreatXX", "Schwartz", "9379263297", "123 Street");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Schwartz", "9379263297", "123 Street");
        });
    }

    // Setter coverage
    @Test
    void testSetFirstNameValid() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");
        contact.setFirstName("Mike");
        assertEquals("Mike", contact.getFirstName());
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ABCDEFGHIJKLMNOP");
        });
    }

    @Test
    void testSetFirstNameNull() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // ==================================================
    // LAST NAME TESTS
    // ==================================================
    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartzenegger", "9379263297", "123 Street");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", null, "9379263297", "123 Street");
        });
    }

    // Setter coverage
    @Test
    void testSetLastNameValid() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ABCDEFGHIJKLMNOP");
        });
    }

    @Test
    void testSetLastNameNull() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // ==================================================
    // PHONE TESTS
    // ==================================================
    @Test
    void testPhoneNotTenDigitsShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartz", "123", "123 Street");
        });
    }

    @Test
    void testPhoneNotTenDigitsLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartz", "123456789012345", "123 Street");
        });
    }

    @Test
    void testPhoneContainsLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartz", "93A9263297", "123 Street");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartz", null, "123 Street");
        });
    }

    // Setter coverage
    @Test
    void testSetPhoneValid() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");
        contact.setPhone("1112223333");
        assertEquals("1112223333", contact.getPhone());
    }

    @Test
    void testSetPhoneInvalid() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("ABCDEF1234");
        });
    }

    // ==================================================
    // ADDRESS TESTS
    // ==================================================
    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartz", "9379263297",
                "12345678901234567890123456789000000000");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Davis", "Schwartz", "9379263297", null);
        });
    }

    // Setter coverage
    @Test
    void testSetAddressValid() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");
        contact.setStreetAddress("999 New Ave");
        assertEquals("999 New Ave", contact.getStreetAddress());
    }

    @Test
    void testSetAddressTooLongSetter() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setStreetAddress("This address is way tooooooooooooooooooooooooooooo long");
        });
    }

    @Test
    void testSetAddressNullSetter() {
        Contact contact = new Contact("12345", "Davis", "Schwartz", "9379263297", "123 Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setStreetAddress(null);
        });
    }
}