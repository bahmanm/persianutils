package com.bahmanm.persianutils

/**
 * @author Amir Karimi (karimi AT dev-frame.com)
 */
object NumberWordConverter {
  object Implicits {
    
    implicit class IntToWordConverter(val n: Int) extends AnyVal {
      /**
       * Converts this number to corresponding words.
       */
      def toWords = numberToWords(n.toLong)
    }

    implicit class LongToWordConverter(val n: Long) extends AnyVal {
      /**
       * Converts this number to corresponding words.
       */
      def toWords = numberToWords(n)
    }
  }
  
  /**
   * Converts the specified number to corresponding words.
   */
	def numberToWords(n: Long): String = n match {
    case 0 => "صفر"
    case _ => numberToWords(n, 0)
	}

	/**
	 * Converts the specified number to corresponding words considering the specified thousand power.
	 */
	private def numberToWords(n: Long, powerOfThousand: Int): String = n match {
	  case 0 => ""
	  case _ =>  
    	joinWords(numberToWords(n / 1000, powerOfThousand + 1), hundredsToWords((n % 1000).toInt, powerOfThousand))
	}
	
	/**
	 * Converts hundreds part of the specified number to corresponding words.
	 */
	private def hundredsToWords(n: Int, powerOfThousand: Int): String = {
	  val hundred = n / 100
	  val tens = n % 100
	  
	  joinThousandWords(
	    joinWords(getHundredsWord(hundred), tensToWords(tens)),
      getThousandPowerWord(powerOfThousand)
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
	  val hundredWords = List(
      "", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه", 
      "ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده")
        
    if (n < 20) {      
      hundredWords(n)
    } else {
      joinWords(getTensWord(n / 10), tensToWords(n % 10)) 
    }
	}
	
	/**
	 * Returns the base word for tens numbers. 
	 */
	private def getTensWord(n: Int): String = {
		val words = List("", "ده", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود")
		words(n)
	}

	/**
	 * Returns the base word for hundreds numbers.
	 */
	private def getHundredsWord(n: Int): String = {
		val words = List("", "صد", "دویست", "سیصد", "چهار‌صد", "پانصد", "شش‌صد", "هفت‌صد", "هشت‌صد", "نه‌صد")
		words(n)
	}
	
	/**
	 * Returns the corresponding word of the specified thousand power.  
	 */
	private def getThousandPowerWord(n: Int): String = {
		val words = List("", "هزار", "میلیون", "میلیارد", "هزار میلیارد")
		words(n)
	}
	
	/**
	 * Joins to strings using the specified separator. It doesn't produce extra separator in certain situations ex. When there
	 * is just one string to be joined.
	 */
	private def joinWords(words: String*)(implicit separator: String = " و ") = words.filter(_.nonEmpty).mkString(separator)
}