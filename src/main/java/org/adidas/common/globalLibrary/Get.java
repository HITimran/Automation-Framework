package org.adidas.common.globalLibrary;

import org.adidas.common.utils.Steps;
import org.adidas.common.utils.Validator;
import org.adidas.common.utils.checkpoints.CheckPoints;

import static java.util.Objects.isNull;

public class Get {
    private static Steps step = null;
    private static CheckPoints cp = null;
    private static Validator validator = null;

    public static Steps steps() {
        if (isNull(step)) {
            step = new Steps();
        }
        return step;
    }

    public static CheckPoints chkPoints() {
        if (isNull(cp)) {
            cp = new CheckPoints();
        }
        return cp;
    }

    public static Validator validator() {
        if (isNull(validator)) {
            validator = new Validator();
        }
        return validator;
    }


}
