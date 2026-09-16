package com.bahmanm.persianutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public final class DateConverterJavaSmokeTest {

  private DateConverterJavaSmokeTest() {}

  public static void verify() {
    PersianDate pd1 = new PersianDate(1392, 11, 11);
    GregorianDate gd1 = DateConverter.persianToGregorian(pd1);
    assertEquals(2014, gd1.year());
    assertEquals(1, gd1.month());
    assertEquals(31, gd1.day());

    GregorianDate gd2 = new GregorianDate(2014, 2, 4);
    PersianDate pd2 = DateConverter.gregorianToPersian(gd2);
    assertEquals(1392, pd2.year());
    assertEquals(11, pd2.month());
    assertEquals(15, pd2.day());

    LocalDate ld1 = pd1.asLocalDate();
    assertEquals(LocalDate.of(2014, 1, 31), ld1);

    LocalDate ld2 = gd2.asLocalDate();
    assertEquals(LocalDate.of(2014, 2, 4), ld2);
  }
}
