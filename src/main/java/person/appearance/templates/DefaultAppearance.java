package person.appearance.templates;

import person.appearance.Appearance;
import person.appearance.hair.ShortHair;

public class DefaultAppearance extends Appearance {

    public DefaultAppearance() {
        super("голубые", new ShortHair("светлые"));
    }
}
