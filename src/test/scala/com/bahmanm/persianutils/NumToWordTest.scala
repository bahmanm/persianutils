package com.bahmanm.persianutils

import org.specs2._
import specification._

class NumToWordTest extends mutable.Specification {

  "0" should {
    "صفر" in {
      numToWord(0) must_== "صفر"
    }
  }

  "5" should {
    "پنج" in {
      numToWord(5) must_== "پنج"
    }
  }

  "15" should {
    "پانزده" in {
      numToWord(15) must_== "پانزده"
    }
  }

  "220" should {
    "دویست و بیست" in {
      numToWord(220) must_== "دویست و بیست"
    }
  }

  "220,983" should {
    "دویست و بیست هزار و نه صد و هشتاد و سه" in {
      numToWord(220983) must_== "دویست و بیست هزار و نه‌صد و هشتاد و سه"
    }
  }
  
  "100,000" should {
    "صد هزار" in {
      numToWord(100000) must_== "صد هزار"
    }
  }
  
  "100,000,000" should {
    "صد میلیون" in {
      numToWord(100000000) must_== "صد میلیون"
    }
  }
  
  "100,000,000,000" should {
    "صد میلیارد" in {
      numToWord(100000000000L) must_== "صد میلیارد"
    }
  }
  
  "100,000,000,000,000" should {
    "صد هزار میلیارد" in {
      numToWord(100000000000000L) must_== "صد هزار میلیارد"
    }
  }
}
