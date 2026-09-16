package com.bahmanm.persianutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public final class DateToWordJavaSmokeTest {

  private DateToWordJavaSmokeTest() {}

  public static void verify() {
    PersianDate pd1 = new PersianDate(1361, 3, 3);
    assertEquals("سوم خرداد یک هزار و سیصد و شصت و یک", pd1.toWords());
    assertEquals("سوم خرداد یک هزار و سیصد و شصت و یک", DateToWord.apply(pd1));
    assertEquals("سوم خرداد یک هزار و سیصد و شصت و یک", DateToWord.persian(pd1));
    assertEquals("سوم خرداد یک هزار و سیصد و شصت و یک", DateToWord.persian(1361, 3, 3));

    GregorianDate gd1 = new GregorianDate(1992, 12, 3);
    assertEquals("سوم دسامبر یک هزار و نه‌صد و نود و دو", gd1.toWords());
    assertEquals("سوم دسامبر یک هزار و نه‌صد و نود و دو", DateToWord.apply(gd1));
    assertEquals("سوم دسامبر یک هزار و نه‌صد و نود و دو", DateToWord.gregorian(gd1));
    assertEquals("سوم دسامبر یک هزار و نه‌صد و نود و دو", DateToWord.gregorian(1992, 12, 3));
    assertEquals("سوم دسامبر یک هزار و نه‌صد و نود و دو", DateToWord.gregorian(LocalDate.of(1992, 12, 3)));
  }
}
