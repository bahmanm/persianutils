package com.bahmanm.persianutils

import java.time.LocalDate

/** Converts date representations into Persian verbal expressions.
  *
  * Example:
  * {{{
  *   DateToWord(PersianDate(1361, 3, 3))    // "سوم خرداد یک هزار و سیصد و شصت و یک"
  *   DateToWord(GregorianDate(1992, 12, 3)) // "سوم دسامبر یک هزار و نه‌صد و نود و دو"
  * }}}
  *
  * @author
  *   Bahman Movaqar (Bahman AT BahmanM.com)
  */
object DateToWord {

  private final val PersianMonths = Vector(
    "",
    "فروردین",
    "اردیبهشت",
    "خرداد",
    "تیر",
    "مرداد",
    "شهریور",
    "مهر",
    "آبان",
    "آذر",
    "دی",
    "بهمن",
    "اسفند"
  )

  private final val GregorianMonths = Vector(
    "",
    "ژانویه",
    "فوریه",
    "مارس",
    "آوریل",
    "مه",
    "ژوئن",
    "ژوئیه",
    "اوت",
    "سپتامبر",
    "اکتبر",
    "نوامبر",
    "دسامبر"
  )

  /** Converts a Persian date to Persian words.
    *
    * @param date
    *   Persian date as PersianDate
    * @return
    *   Verbal Persian expression
    */
  def apply(date: PersianDate): String =
    persian(date.year, date.month, date.day)

  /** Converts a Gregorian date to Persian words.
    *
    * @param date
    *   Gregorian date as GregorianDate
    * @return
    *   Verbal Persian expression
    */
  def apply(date: GregorianDate): String =
    gregorian(date.year, date.month, date.day)

  /** Converts a Persian date to Persian words.
    *
    * @param date
    *   Persian date as ConvertibleDate
    * @return
    *   Verbal Persian expression
    */
  def persian(date: ConvertibleDate): String =
    persian(date.year, date.month, date.day)

  /** Converts a Persian date given year, month, and day components to Persian
    * words.
    *
    * @param year
    *   Calendar year
    * @param month
    *   Calendar month (1-indexed, 1 to 12)
    * @param day
    *   Calendar day (1-indexed, 1 to 31)
    * @return
    *   Verbal Persian expression
    */
  def persian(year: Int, month: Int, day: Int): String = {
    validate(year, month, day)
    format(day, PersianMonths(month), year)
  }

  /** Converts a Gregorian date to Persian words.
    *
    * @param date
    *   Gregorian date as ConvertibleDate
    * @return
    *   Verbal Persian expression
    */
  def gregorian(date: ConvertibleDate): String =
    gregorian(date.year, date.month, date.day)

  /** Converts a Gregorian java.time.LocalDate to Persian words.
    *
    * @param date
    *   Gregorian date as java.time.LocalDate
    * @return
    *   Verbal Persian expression
    */
  def gregorian(date: LocalDate): String =
    gregorian(date.getYear, date.getMonthValue, date.getDayOfMonth)

  /** Converts a Gregorian date given year, month, and day components to Persian
    * words.
    *
    * @param year
    *   Calendar year
    * @param month
    *   Calendar month (1-indexed, 1 to 12)
    * @param day
    *   Calendar day (1-indexed, 1 to 31)
    * @return
    *   Verbal Persian expression
    */
  def gregorian(year: Int, month: Int, day: Int): String = {
    validate(year, month, day)
    format(day, GregorianMonths(month), year)
  }

  private def validate(year: Int, month: Int, day: Int): Unit =
    if (month < 1 || month > 12 || day < 1 || day > 31 || year < 0) {
      throw new InvalidDateException()
    }

  private def format(day: Int, monthName: String, year: Int): String =
    s"${NumToWord.ordinal(day)} $monthName ${NumToWord.cardinal(year)}"

}
