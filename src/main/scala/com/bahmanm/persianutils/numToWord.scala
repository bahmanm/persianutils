package com.bahmanm.persianutils

/**
 * @author Amir Karimi (karimi AT dev-frame.com)
 * Example: @code numToWord(123)
 */
object numToWord {
  /**
   * Converts the specified number to corresponding words.
   */
  def apply(n: Int): String = apply(n.toLong)
  
  /**
   * Converts the specified number to corresponding words.
   */
  def apply(n: Long): String = n match {
    case 0 => "صفر"
    case _ => numToWords(n, 0)
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
