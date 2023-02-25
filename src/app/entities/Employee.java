package app.entities;

import com.mysql.cj.util.StringInspector;

import java.security.PublicKey;
import java.sql.Date;
import java.time.LocalDate;

public class Employee extends User{

    private LocalDate birthDate;

    /**
     * Returns the current value of employee's date of birth
     * @return LocalDate instance that represents the current value of employee's date of birth
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Constructor that takes zero arguments and sets unkonwn values to "unknown" and
     * id to value of -1
     */
    public Employee() {
        super();
        birthDate = null;
    }

    /**
     * Constructor which takes 4 arguments and sets the unknown value of id to -1
     */
    public Employee(String firstName, String lastName, LocalDate birthDate, String accKey){
        super(firstName, lastName, accKey);
        setBirthDate(birthDate);
    }

    /**
     * Constructor that takes all 5 arguments
     */
    public Employee(int id, String firstName, String lastName, LocalDate birthDate, String accKey){
        super(id, firstName, lastName, accKey);
        setBirthDate(birthDate);
    }

    /**
     * Sets the epmloyee's date of birth. Argument can be either LocalDate type or
     * sql Date type that will be converted to LocalDate.
     */
    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    /**
     * Sets the epmloyee's date of birth. Argument can be either LocalDate type or
     * sql Date type that will be converted to LocalDate.
     */
    public void setBirthDate(Date date) {
        this.birthDate = date.toLocalDate();
    }


}
