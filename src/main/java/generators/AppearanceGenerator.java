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

    private String eyes;
    private int hairLength;
    private String hairColor;

    /**
     * было
     * Внешность генерируется по третьей цифре кода (i):
     * Глаза: по индексу i/2 (=0..4)
     * Длина волос: i
     * Цвет волос: из enum по индексу i-1 при i>0 (=0..8).

     * стало
     * Используется абстрактная фабрика
     * В зависимости от переданного кода определяется один из шаблонов внешности
     * При необходимости добавить новый тип внешности добавляется новый класс-наследник Appearance с реализацией
     * Такой подход позволит минимизировать изменения в генераторе при расширении требований
     *и отказаться от ENUM
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

        /*switch (i / 2) {
            case 0:
                eyes = EyesColor.BLUE;
                break;
            case 1:
                eyes = EyesColor.GREEN;
                break;
            case 2:
                eyes = EyesColor.BROWN;
                break;
            case 3:
                eyes = EyesColor.GRAY;
                break;
            case 4:
                eyes = EyesColor.DIFF;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i / 2);
        }
        hairLength = i;

        final HashMap<Integer, String> hairColorMap = new HashMap<>() {{
            put(1, "чёрные");
            put(2, "каштановые");
            put(3, "рыжие");
            put(4, "светлые");
            put(5, "седые");
            put(6, "розовые");
            put(7, "зелёные");
            put(8, "фиолетовые");
            put(9, "синие");
        }};
        if (i > 0) {
            hairColor = hairColorMap.get(i);
        }

        if (hairLength > 0) {
            hair = (hairLength > 4) ? new LongHair(hairColor) : new ShortHair(hairColor);
        } else {
            hair = new NoHair();
        }
        return new Appearance(eyes, hair);*/
        return result;
    }
}

