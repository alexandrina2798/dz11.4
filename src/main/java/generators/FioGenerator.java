package generators;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class FioGenerator {

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
        FIO person = new FIO(getLinesFromFile("lastNames_" + sex).get(getDigitsSum(code)),
                getLinesFromFile("names_" + sex).get(getDigitsSum(code / 100)),
                getLinesFromFile("middleNames_" + sex).get(getDigitsSum(code % 100)));
        return person;
    }

}

