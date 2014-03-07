package com.bahmanm.persianutils

import org.specs2._
import specification._
import com.bahmanm.persianutils.NumberWordConverter._
import com.bahmanm.persianutils.NumberWordConverter.Implicits._

class NumberWordConverterTest extends mutable.Specification {

  "0" should {
    "صفر" in {
      numberToWords(0) must_== "صفر"
    }
  }

  "5" should {
    "پنج" in {
      numberToWords(5) must_== "پنج"
    }
  }

  "15" should {
    "پانزده" in {
      numberToWords(15) must_== "پانزده"
    }
  }

  "220" should {
    "دویست و بیست" in {
      numberToWords(220) must_== "دویست و بیست"
    }
  }

  "220,983" should {
    "دویست و بیست هزار و نه صد و هشتاد و سه" in {
      numberToWords(220983) must_== "دویست و بیست هزار و نه‌صد و هشتاد و سه"
    }
  }
  
  "100,000" should {
    "صد هزار" in {
      numberToWords(100000) must_== "صد هزار"
    }
  }
  
  "100,000,000" should {
    "صد میلیون" in {
      numberToWords(100000000) must_== "صد میلیون"
    }
  }
  
  "100,000,000,000" should {
    "صد میلیارد" in {
      numberToWords(100000000000L) must_== "صد میلیارد"
    }
  }
  
  "100,000,000,000,000" should {
    "صد هزار میلیارد" in {
      numberToWords(100000000000000L) must_== "صد هزار میلیارد"
    }
  }
  
  "123,456" should {
    "صد و بیست و سه هزار و چهار‌صد و پنجاه و شش" in {
      123456.toWords must_== "صد و بیست و سه هزار و چهار‌صد و پنجاه و شش"
    }
  }
}