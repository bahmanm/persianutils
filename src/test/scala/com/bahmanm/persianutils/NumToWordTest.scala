package com.bahmanm.persianutils

import org.specs2._
import specification._

class NumToWordTest extends mutable.Specification {

  "0" should {
    "صفر" in {
      NumToWord(0) must_== "صفر"
    }
  }

  "5" should {
    "پنج" in {
      NumToWord(5) must_== "پنج"
    }
  }

  "15" should {
    "پانزده" in {
      NumToWord(15) must_== "پانزده"
    }
  }

  "220" should {
    "دویست و بیست" in {
      NumToWord(220) must_== "دویست و بیست"
    }
  }

  "220,983" should {
    "دویست و بیست هزار و نه صد و هشتاد و سه" in {
      NumToWord(220983) must_== "دویست و بیست هزار و نه‌صد و هشتاد و سه"
    }
  }
  
  "100,000" should {
    "صد هزار" in {
      NumToWord(100000) must_== "صد هزار"
    }
  }
  
  "100,000,000" should {
    "صد میلیون" in {
      NumToWord(100000000) must_== "صد میلیون"
    }
  }
  
  "100,000,000,000" should {
    "صد میلیارد" in {
      NumToWord(100000000000L) must_== "صد میلیارد"
    }
  }
  
  "100,000,000,000,000" should {
    "صد هزار میلیارد" in {
      NumToWord(100000000000000L) must_== "صد هزار میلیارد"
    }
  }

  "100,000,233,000,110" should {
    "صد هزار میلیارد و دویست و سی و سه میلیون و صد و ده" in {
      NumToWord(100000233000110L) must_== "صد هزار میلیارد و دویست و سی و سه میلیون و صد و ده"
    }
  }
}
