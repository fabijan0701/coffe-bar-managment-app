package test.data;

import app.data.DataAccess;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessTest {

    @Test
    void connectionNotNull_test() throws SQLException {

        DataAccess dataAccess = new DataAccess();
        Connection connection = null;
        try {
            connection = dataAccess.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(connection);
    }
}