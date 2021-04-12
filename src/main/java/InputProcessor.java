import generators.*;
import person.Person;
import person.Phone;
import person.Physical;
import person.appearance.Appearance;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);

            final FioGenerator fioGenerator = new FioGenerator();
            fioGenerator.generateParams(intCode);
            final String lastName = FIO.getLastName();
            final String firstName = FIO.getFirstName();
            final String middleName = FIO.getMiddleName();

            final PhysGenerator physGenerator = new PhysGenerator();
            final Physical physical = physGenerator.buildResponse(intCode);

            final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
            final Appearance appearance = appearanceGenerator.buildResponse(intCode);

            Phone phone = null;
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                final PhoneGenerator phoneGenerator = new PhoneGenerator();
                phone = phoneGenerator.buildResponse(intCode);
            }

            result = new Person(input,
                    lastName, firstName, middleName,
                    physical,
                    appearance,
                    phone).toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
