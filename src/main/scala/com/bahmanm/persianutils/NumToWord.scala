package com.bahmanm.persianutils

/**
 * @author Amir Karimi (karimi AT dev-frame.com)
 * @author Bahman Movaqar (Bahman AT BahmanM.com)
 *
 * Example: @code NumToWord.cardinal(123)
 */
object NumToWord {

  /**
   * Converts the specified number to corresponding words.
   *
   * @deprecated Use [[cardinal]] instead. Scheduled for removal in version 7.0.0.
   */
  @deprecated("Use cardinal instead; will be removed in version 7.0.0", "6.0.0")
  def apply(n: Int): String = cardinal(n)

  /**
   * Converts the specified number to corresponding words.
   *
   * @deprecated Use [[cardinal]] instead. Scheduled for removal in version 7.0.0.
   */
  @deprecated("Use cardinal instead; will be removed in version 7.0.0", "6.0.0")
  def apply(n: Long): String = cardinal(n)

  /**
   * Converts the specified number to corresponding cardinal words.
   */
  def cardinal(n: Int): String = cardinal(n.toLong)

  /**
   * Converts the specified number to corresponding cardinal words.
   */
  def cardinal(n: Long): String = n match {
    case 0 => "صفر"
    case _ => numToWords(n, 0)
  }

  /**
   * Converts the specified number to corresponding ordinal words.
   */
  def ordinal(n: Int): String = ordinal(n.toLong)

  /**
   * Converts the specified number to corresponding ordinal words.
   */
  def ordinal(n: Long): String = toOrdinal(cardinal(n))

  private def toOrdinal(cardinalText: String): String = {
    if (cardinalText == "سه" || cardinalText.endsWith(" سه"))
      cardinalText.substring(0, cardinalText.length - 2) + "سوم"
    else if (cardinalText == "سی" || cardinalText.endsWith(" سی"))
      cardinalText + "\u200Cام"
    else
      cardinalText + "م"
  }

  private final val hundredWords = List(
      "", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه", 
      "ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده")
  private final val tensWords = List("", "ده", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود")
  private final val hundredsWords = List("", "صد", "دویست", "سیصد", "چهار‌صد", "پانصد", "شش‌صد", "هفت‌صد", "هشت‌صد", "نه‌صد")
  private final val thousandPowerWords = List("", "هزار", "میلیون", "میلیارد", "هزار میلیارد")
  
  /**
   * Converts the specified number to corresponding words considering the specified thousand power.
   */
  private def numToWords(n: Long, powerOfThousand: Int): String = n match {
    case 0 => ""
    case _ =>  
      joinWords(numToWords(n / 1000, powerOfThousand + 1), hundredsToWords((n % 1000).toInt, powerOfThousand))
  }
  
  /**
   * Converts hundreds part of the specified number to corresponding words.
   */
  private def hundredsToWords(n: Int, powerOfThousand: Int): String = {
    val hundred = n / 100
    val tens = n % 100
    
    joinThousandWords(
      joinWords(hundredsWords(hundred), tensToWords(tens)),
      thousandPowerWords(powerOfThousand)
    )
  }
  
  /**
   * Joins the number word and thousand power word together in such way that no extra space and power word is produced.
   */
  private def joinThousandWords(prefix: String, powerWord: String) = prefix match {
    case "" => ""
    case _ => joinWords(prefix, powerWord)(" ")
  }
  
  /**
   * Converts tens part of the specified number to corresponding words.
   */
  private def tensToWords(n: Int): String = {
    if (n < 20) {      
      hundredWords(n)
    } else {
      joinWords(tensWords(n / 10), tensToWords(n % 10)) 
    }
  }
  
  /**
   * Joins strings using the specified separator. It doesn't produce extra separator in certain situations ex. When there
   * is just one string to be joined.
   */
  private def joinWords(words: String*)(implicit separator: String = " و ") = words.filter(_.nonEmpty).mkString(separator)
}
