package generators;
//игнорирую CheckStyle, так как на лекции в примере DTO использовались именно паблик переменные
public class FIO {
    public String lastName;
    public String firstName;
    public String middleName;

    FIO(final String lastName, final String firstName, final String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}
