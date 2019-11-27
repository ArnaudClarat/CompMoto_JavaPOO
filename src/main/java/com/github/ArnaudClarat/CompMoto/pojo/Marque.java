package com.github.ArnaudClarat.CompMoto.pojo;

import org.apache.commons.lang3.EnumUtils;

/**
 * Enum
 */

public enum Marque {
    Aprilia,
    Benelli,
    BMW,
    Brixton,
    Bullit,
    Ducati,
    Guzzi,
    HarleyDavidson,
    Honda,
    Husqvarna,
    Indian,
    Kawasaki,
    KTM,
    Mash,
    Norton,
    RoyalEnfield,
    Suzuki,
    Triumph,
    Yamaha,
    Zero;

    public static boolean contains(String test) {
        return EnumUtils.isValidEnum(Marque.class, test);
    }

    public static Marque getMarque(String test) {
        return EnumUtils.getEnum(Marque.class, test);
    }
}
