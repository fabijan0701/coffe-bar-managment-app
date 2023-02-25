package app.data;

import app.entities.Employee;
import app.entities.exceptions.UserNotExistException;

import java.sql.*;

public class DataQuery {

    private final DataAccess dataObj;

    public DataQuery(DataAccess obj) {
        dataObj = obj;
    }

    public Employee getEmployee(int id, String accessKey) throws SQLException, ClassNotFoundException, UserNotExistException {

        Employee employee = null;

        String sqlQuery = String.format(
                "select * from employee where id = %d and accesskey = '%s' ",
                id, accessKey
        );

        Connection connection = dataObj.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        if (!resultSet.next()) {
            throw new UserNotExistException();
        }

        int empId = resultSet.getInt(1);
        String empFirstName = resultSet.getString(2);
        String empLastName = resultSet.getString(3);
        Date empBirthDate = resultSet.getDate(4);
        String empAccessKey = resultSet.getString(5);

        employee = new Employee(
                empId,
                empFirstName,
                empLastName,
                empBirthDate.toLocalDate(),
                empAccessKey
        );

        connection.close();
        return employee;
    }
}
