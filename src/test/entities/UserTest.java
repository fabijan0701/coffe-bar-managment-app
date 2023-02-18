package test.entities;

import app.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User u1 = new User();
    User u2 = new User(1122, "Ante", "Antić", "ante1111");
    User u3 = new User("Marko", "Marić", "marko2222");

    @Test
    public void getId_test1() {
        int actualId = u1.getId();
        int expectedId = -1;
        assertEquals(actualId, expectedId);
    }

    @Test
    public void getId_test2() {
        int actualId = u2.getId();
        int expectedId = 1122;
        assertEquals(actualId, expectedId);
    }

    @Test
    public void getId_test3() {
        assertEquals(u1.getId(), u3.getId());
    }

    @Test
    public void getId_test4() {
        assertNotEquals(u2.getId(), u3.getId());
    }

    @Test
    public void getFirstName_test1() {
        String actualName = u1.getFirstName();
        String expectedName = "Unknown";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void getFirstName_test2() {
        String actualName = u2.getFirstName();
        String expectedName = "Ante";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void setFirstName_test() {
        u1.setFirstName("Mate");
        String actualName = u1.getFirstName();
        String expectedName = "Mate";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void getLastName_test1() {
        String actualName = u1.getLastName();
        String expectedName = "Unknown";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void getLastName_test2() {
        String actualName = u2.getLastName();
        String expectedName = "Antić";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void setLastName_test() {
        u1.setLastName("Matić");
        String actualName = u1.getLastName();
        String expectedName = "Matić";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void getAccessKey_test1() {
        String actualKey = u1.getAccessKey();
        String expectedKey = "Unknown";
        assertEquals(actualKey, expectedKey);
    }

    @Test
    public void getAccessKey_test2() {
        String actualKey = u2.getAccessKey();
        String expectedKey = "ante1111";
        assertEquals(actualKey, expectedKey);
    }

    @Test
    public void setAccessKey_test() {
        u1.setAccessKey("aaaa");
        String actualName = u1.getAccessKey();
        String expectedName = "aaaa";
        assertEquals(actualName, expectedName);
    }
}