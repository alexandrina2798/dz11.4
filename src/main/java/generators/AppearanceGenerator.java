package generators;


import person.appearance.Appearance;
import person.appearance.templates.FirstAppearance;
import person.appearance.templates.FourthAppearance;
import person.appearance.templates.SecondAppearance;
import person.appearance.templates.ThirdAppearance;
import person.appearance.templates.FifthAppearance;
import person.appearance.templates.SeventhAppearance;
import person.appearance.templates.NinthAppearance;
import person.appearance.templates.DefaultAppearance;

public class AppearanceGenerator implements Generator<Appearance> {

    /**
     * было
     * Внешность генерируется по третьей цифре кода (i):
     * Глаза: по индексу i/2 (=0..4)
     * Длина волос: i
     * Цвет волос: из enum по индексу i-1 при i>0 (=0..8).
     * <p>
     * стало
     * Используется абстрактная фабрика
     * В зависимости от переданного кода определяется один из шаблонов внешности
     * При необходимости добавить новый тип внешности добавляется новый класс-наследник Appearance с реализацией
     * Такой подход позволит минимизировать изменения в генераторе при расширении требований
     * и отказаться от ENUM
     */

    @Override
    public final Appearance buildResponse(final int code) {
        Appearance result;
        final int i = code % 100 / 10;

        switch (i) {
            case 0:
                result = new FirstAppearance();
                break;
            case 1:
                result = new SecondAppearance();
                break;
            case 2:
                result = new ThirdAppearance();
                break;
            case 3:
                result = new FourthAppearance();
                break;
            case 4:
                result = new FifthAppearance();
                break;
            case 7:
                result = new SeventhAppearance();
                break;
            case 9:
                result = new NinthAppearance();
                break;
            default:
                result = new DefaultAppearance();
                break;
        }


        return result;
    }
}

