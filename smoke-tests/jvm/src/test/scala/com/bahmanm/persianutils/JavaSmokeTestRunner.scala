package com.bahmanm.persianutils

class JavaSmokeTestRunner extends munit.FunSuite {

  test("Java interoperability: DateConverter") {
    DateConverterJavaSmokeTest.verify()
  }

  test("Java interoperability: NumToWord") {
    NumToWordJavaSmokeTest.verify()
  }

}
