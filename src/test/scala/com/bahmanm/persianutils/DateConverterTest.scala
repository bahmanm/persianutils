package com.bahmanm.persianutils

import org.specs2._
import com.bahmanm.persianutils.DateConverter._

class DateConverterTest extends mutable.Specification {

  "Feb 29th, 2012" should {
    "equal 10om Esfand 1390" in {
      gregorianToPersian(SimpleDate(2012, 2, 29)) must_== SimpleDate(1390, 12, 10)
    }
  }

  "Feb 29th, 3292" should {
    "equal to 11om Esfand 2670" in {
      gregorianToPersian(SimpleDate(3292, 2, 29)) must_== SimpleDate(2670, 12, 11)
    }
  }

  "30om Esfand 1391" should {
    "equal March 20th, 2013" in {
      persianToGregorian(SimpleDate(1391, 12, 30)) must_== SimpleDate(2013, 3, 20)
    }
  }

  "30om Esfand 1453" should {
    "equal March 20th, 2075" in {
      persianToGregorian(SimpleDate(1453, 12, 30)) must_== SimpleDate(2075, 3, 20)
    }
  }

  "11om Day 1346" should {
    "equal January 1st, 1968" in {
      persianToGregorian(SimpleDate(1346, 10, 11)) must_== SimpleDate(1968, 1, 1)
    }
  }

  "Jan 1st, 1968" should {
    "equal 11om Day 1346" in {
      gregorianToPersian(SimpleDate(1968, 1, 1)) must_== SimpleDate(1346, 10, 11)
    }
  }

  "Jan 2nd, 1968" should {
    "equal 12om Day 1346" in {
      gregorianToPersian(SimpleDate(1968, 1, 2)) must_== SimpleDate(1346, 10, 12)
    }
  }

  "Jan 1st, 1996" should {
    "equal 11om Day 1374" in {
      gregorianToPersian(SimpleDate(1996, 1, 1)) must_== SimpleDate(1374, 10, 11)
    }
  }

  "March 20th, 2030" should {
    "equal 30om Esfand 1408" in {
      gregorianToPersian(SimpleDate(2030, 3, 20)) must_== SimpleDate(1408, 12, 30)
    }
  }

}
