package generators;
//игнорирую CheckStyle, так как на лекции в примере DTO использовались именно паблик переменные
public class FIO {
    private static String lastName;
    private static String firstName;
    private static String middleName;

    public static String getLastName() {
        return lastName;
    }

    private void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    private void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public static String getMiddleName() {
        return middleName;
    }

    private void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    FIO(final String lastName, final String firstName, final String middleName) {
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
    }
}
