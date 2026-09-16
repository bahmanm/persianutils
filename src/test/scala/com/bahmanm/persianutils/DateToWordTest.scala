package com.bahmanm.persianutils

import java.time.LocalDate

class DateToWordTest extends munit.FunSuite {

  // Canonical Issue #4 Persian example
  test("persian: PersianDate(1361, 3, 3) converts to words") {
    val date = PersianDate(1361, 3, 3)
    val expected = "سوم خرداد یک هزار و سیصد و شصت و یک"
    assertEquals(DateToWord(date), expected)
    assertEquals(date.toWords, expected)
    assertEquals(DateToWord.persian(date), expected)
    assertEquals(DateToWord.persian(1361, 3, 3), expected)
  }

  // Canonical Issue #4 Gregorian example
  test("gregorian: GregorianDate(1992, 12, 3) converts to words") {
    val date = GregorianDate(1992, 12, 3)
    val expected = "سوم دسامبر یک هزار و نه‌صد و نود و دو"
    assertEquals(DateToWord(date), expected)
    assertEquals(date.toWords, expected)
    assertEquals(DateToWord.gregorian(date), expected)
    assertEquals(DateToWord.gregorian(1992, 12, 3), expected)
    assertEquals(DateToWord.gregorian(LocalDate.of(1992, 12, 3)), expected)
  }

  // Persian months enumeration
  test("persian: all 12 Persian months") {
    assertEquals(DateToWord.persian(1400, 1, 1), "یکم فروردین یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 2, 2), "دوم اردیبهشت یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 3, 3), "سوم خرداد یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 4, 4), "چهارم تیر یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 5, 5), "پنجم مرداد یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 6, 6), "ششم شهریور یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 7, 7), "هفتم مهر یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 8, 8), "هشتم آبان یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 9, 9), "نهم آذر یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 10, 10), "دهم دی یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 11, 11), "یازدهم بهمن یک هزار و چهار‌صد")
    assertEquals(DateToWord.persian(1400, 12, 12), "دوازدهم اسفند یک هزار و چهار‌صد")
  }

  // Gregorian months enumeration in Persian
  test("gregorian: all 12 Gregorian months in Persian") {
    assertEquals(DateToWord.gregorian(2026, 1, 1), "یکم ژانویه دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 2, 2), "دوم فوریه دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 3, 3), "سوم مارس دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 4, 4), "چهارم آوریل دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 5, 5), "پنجم مه دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 6, 6), "ششم ژوئن دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 7, 7), "هفتم ژوئیه دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 8, 8), "هشتم اوت دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 9, 9), "نهم سپتامبر دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 10, 10), "دهم اکتبر دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 11, 11), "یازدهم نوامبر دو هزار و بیست و شش")
    assertEquals(DateToWord.gregorian(2026, 12, 12), "دوازدهم دسامبر دو هزار و بیست و شش")
  }

  // Ordinal day variations
  test("ordinal days representation") {
    assertEquals(DateToWord.persian(1390, 1, 1), "یکم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 2), "دوم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 3), "سوم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 10), "دهم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 20), "بیستم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 21), "بیست و یکم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 22), "بیست و دوم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 23), "بیست و سوم فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 30), "سی\u200Cام فروردین یک هزار و سیصد و نود")
    assertEquals(DateToWord.persian(1390, 1, 31), "سی و یکم فروردین یک هزار و سیصد و نود")
  }

  // Parsed date strings
  test("parsed date strings conversion to words") {
    assertEquals(PersianDate("1392/09/24").toWords, "بیست و چهارم آذر یک هزار و سیصد و نود و دو")
    assertEquals(GregorianDate("2013/12/15").toWords, "پانزدهم دسامبر دو هزار و سیزده")
  }

  // SimpleDate backwards compatibility
  test("SimpleDate to words") {
    val simple = DateConverter.SimpleDate(1361, 3, 3)
    assertEquals(simple.toWords, "سوم خرداد یک هزار و سیصد و شصت و یک")
    assertEquals(DateToWord.persian(simple), "سوم خرداد یک هزار و سیصد و شصت و یک")
    assertEquals(DateToWord.gregorian(DateConverter.SimpleDate(1992, 12, 3)), "سوم دسامبر یک هزار و نه‌صد و نود و دو")
  }

  // Validation errors
  test("validation: month out of range throws InvalidDateException") {
    intercept[InvalidDateException] {
      DateToWord.persian(1390, 0, 10)
    }
    intercept[InvalidDateException] {
      DateToWord.persian(1390, 13, 10)
    }
    intercept[InvalidDateException] {
      DateToWord.gregorian(2020, 0, 10)
    }
    intercept[InvalidDateException] {
      DateToWord.gregorian(2020, 13, 10)
    }
  }

  test("validation: day out of range throws InvalidDateException") {
    intercept[InvalidDateException] {
      DateToWord.persian(1390, 1, 0)
    }
    intercept[InvalidDateException] {
      DateToWord.persian(1390, 1, 32)
    }
    intercept[InvalidDateException] {
      DateToWord.gregorian(2020, 1, 0)
    }
    intercept[InvalidDateException] {
      DateToWord.gregorian(2020, 1, 32)
    }
  }

  test("validation: negative year throws InvalidDateException") {
    intercept[InvalidDateException] {
      DateToWord.persian(-1, 1, 1)
    }
    intercept[InvalidDateException] {
      DateToWord.gregorian(-1, 1, 1)
    }
  }

  test("validation: toWords member forwards exceptions") {
    intercept[InvalidDateException] {
      PersianDate(1390, 13, 10).toWords
    }
    intercept[InvalidDateException] {
      GregorianDate(2020, 0, 10).toWords
    }
  }

}
