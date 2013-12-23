## 1. Introduction ##

A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users.

## 2. Using In Your Scala/Java Project ##

Assuming you have [SBT installed](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html):

```
$ cd persianutils
$ sbt package
```

The JAR file is in `target/scala-VERSION`. You can now add it to your project like any other dependency.

## 3. What Is Included? ##

This is a short review of what you will find in _persianutils_:

### 3.1 DateConverter ###

`com.bahmanm.persianutils.DateConverter` is a port of the original algorithm (in Fortran) [The Persian calendar for 3000 years](http://www.astro.uni.torun.pl/~kb/Papers/EMP/PersianC-EMP.htm) by Mr. Borkowski to Scala.

```scala
import com.bahmanm.persianutils.DateConverter._

// NOTE: months and days are 1-indexed, i.e. December is 12 or Farvardin is 1
val gDate1 = SimpleDate(2013, 12, 11) 
val pDate1 = gregorianToPersian(gDate1)
print(pDate1)  // OUTPUT: SimpleDate(1392,9,20) -> 20om Azar 1392


val pDate2 = SimpleDate(1392, 1, 1)
val gDate2 = persianToGregorian(pDate2)
print(gDate2) // OUTPUT: SimpleDate(2013,3,21) -> March 21st 2013


val d = java.util.Calendar.getInstance().getTime()
val gDate3 = SimpleDate(date) // iniatlising from a java.util.Date
val pDate3 = gregorianToPersian(gDate3)


val ds = "1392/09/24"
val pDate4 = SimpleDate(ds) // initialising from a String
val gDate4 = persianToGregorian(pDate4)
```