package generators;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class FioGenerator {

    private String lastName;
    private String firstName;
    private String middleName;

    /**
     * ФИО берутся из соответствующих файлов по индексу в листе:
     * Фамилия - сумма цифр в коде
     * Имя - сумма первых двух цифр
     * Отчество - сумма последних двух цифр.
     *
     * @param code код для генерации
     * @return Экземпляр DTO
     */

    public final FIO generateParams(final int code) {
        final int lastNameIndex = getDigitsSum(code);
        final String sex = (lastNameIndex % 2 == 0) ? "f" : "m";
        lastName = getLinesFromFile("lastNames_" + sex).get(getDigitsSum(code));
        firstName = getLinesFromFile("names_" + sex).get(getDigitsSum(code / 100));
        middleName = getLinesFromFile("middleNames_" + sex).get(getDigitsSum(code % 100));
        return new FIO(lastName, firstName, middleName);
    }

}

