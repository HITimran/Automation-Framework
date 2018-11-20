package org.adidas.common.utils.Helpers;

import org.apache.commons.lang3.RandomUtils;

public class Common {

    public static String getRandomDigit()
    {
      return RandomUtils.nextInt(100, 1000)+"";
    }
}
