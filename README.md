# 1 Introduction 
[![CI](https://github.com/bahmanm/persianutils/actions/workflows/ci.yml/badge.svg)](https://github.com/bahmanm/persianutils/actions/workflows/ci.yml)
[![Documentation](https://img.shields.io/badge/docs-persianutils.bahmanm.com-007ec6.svg)](https://persianutils.bahmanm.com/)
[![Matrix](https://img.shields.io/matrix/github-bahmanm-persianutils%3Amatrix.org?server_fqdn=matrix.org&style=flat&logo=matrix&logoColor=white&color=0e80c0)](https://matrix.to/#/#github-bahmanm-persianutils:matrix.org)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_3?style=flat&logo=scala&logoColor=white&label=3.x)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_2.13?style=flat&logo=scala&logoColor=white&label=2.13.x)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_2.12?style=flat&logo=scala&logoColor=white&label=2.12.x)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_2.11?style=flat&logo=scala&logoColor=white&label=2.11.x)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils?ref=badge_shield)

A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users.

> Full documentation, tutorials, and interactive Scaladoc API references are published at [persianutils.bahmanm.com](https://persianutils.bahmanm.com/).

<img alt="persianutils logo" src="https://imgur.com/j1cWx7m.png" style="height: 300px; width: 300px; vertical-align: top" /> 

### 1.1  Scala Compatibility

| ⬇ persianutils ❚ scala ➡ | 2.10.x | 2.11.x | 2.12.x | 2.13.x | 3.x  |
|----------------------------|--------|--------|--------|--------|------|
| 6.x _(to be released)_     |   ❌   |   ❌   |  ❌   |   ✅   |  ✅  |
| 5.x                        |   ❌   |   ❌   |  ✅   |   ✅   |  ✅  |
| 4.x                        |   ❌   |   ✅   |  ✅   |   ✅   |  ❌  |
| 3.x                        |   ❌   |   ✅   |  ✅   |   ❌   |  ❌  |
| 2.x                        |   ✅   |   ✅   |  ❌   |   ❌   |  ❌  |

_Note: version 6.x is to be released. For current projects, please use version 5.0._

# 2 Installation 

### 2.1 SBT 

- JVM: `libraryDependencies += "com.bahmanm" %% "persianutils" % "5.0"`
- Scala.js: `libraryDependencies += "com.bahmanm" %%% "persianutils" % "5.0"`

### 2.2 Other Build Tools

See the [Installation Guide](https://persianutils.bahmanm.com/#quick-installation) for Maven, Mill, Scala-CLI, and Gradle setup instructions.


## 3 What Is Included? 

This is a short review of what you will find in _persianutils_:

### 3.1 DateConverter 

`com.bahmanm.persianutils.DateConverter` is the Scala port of the original algorithm (in Fortran) [The Persian calendar for 3000 years](http://www.astro.uni.torun.pl/~kb/Papers/EMP/PersianC-EMP.htm).

_Documentation: [DateConverter Guide](https://persianutils.bahmanm.com/pages/modules/date-converter.html) | [Scaladoc API](https://persianutils.bahmanm.com/api/scala-3/com/bahmanm/persianutils/DateConverter$.html)_

#### 3.1.1 Scala 

```scala
import com.bahmanm.persianutils.DateConverter._

val gDate = GregorianDate(2013, 12, 11)
val pDate = gregorianToPersian(gDate) // PersianDate(1392, 9, 20)

val pDate2 = PersianDate(1392, 1, 1)
val gDate2 = persianToGregorian(pDate2) // GregorianDate(2013, 3, 21)
```

#### 3.1.2 Java 

```java
PersianDate pd = DateConverter.gregorianToPersian(new GregorianDate(2014, 2, 4));   // PersianDate(1392, 11, 15)
GregorianDate gd = DateConverter.persianToGregorian(new PersianDate(1392, 11, 15)); // GregorianDate(2014, 2, 4)
```

### 3.2 NumToWord

Translates numeric values into written Persian words for both cardinal and ordinal numbering.

_Documentation: [NumToWord Guide](https://persianutils.bahmanm.com/pages/modules/num-to-word.html) | [Scaladoc API](https://persianutils.bahmanm.com/api/scala-3/com/bahmanm/persianutils/NumToWord$.html)_

#### 3.2.1 Scala

```scala
import com.bahmanm.persianutils.NumToWord

assert(NumToWord.cardinal(100) == "صد")
assert(NumToWord.ordinal(1) == "یکم")
```

#### 3.2.2 Java

```java
String hundred = NumToWord.cardinal(100); // صد
String first = NumToWord.ordinal(1);      // یکم
```

### 3.3 DateToWord

Converts date objects or date components into full verbal Persian expressions.

_Documentation: [DateToWord Guide](https://persianutils.bahmanm.com/pages/modules/date-to-word.html) | [Scaladoc API](https://persianutils.bahmanm.com/api/scala-3/com/bahmanm/persianutils/DateToWord$.html)_

#### 3.3.1 Scala

```scala
import com.bahmanm.persianutils.PersianDate

val pDate = PersianDate(1361, 3, 3)
assert(pDate.toWords == "سوم خرداد یک هزار و سیصد و شصت و یک")
```

#### 3.3.2 Java

```java
PersianDate pd = new PersianDate(1361, 3, 3);
String words = pd.toWords(); // سوم خرداد یک هزار و سیصد و شصت و یک
```

### 3.4 TextSanitiser

Sanitises and normalises Persian text by standardising character variants (such as Arabic Kaf and Yeh), converting numerals, regularising spacing and zero-width non-joiners (ZWNJ), stripping tatweel, and standardising punctuation.

_Documentation: [TextSanitiser Guide](https://persianutils.bahmanm.com/pages/modules/text-sanitiser.html) | [Scaladoc API](https://persianutils.bahmanm.com/api/scala-3/com/bahmanm/persianutils/TextSanitiser$.html)_

#### 3.4.1 Scala

```scala
import com.bahmanm.persianutils.TextSanitiser

val cleanText = TextSanitiser.sanitise("  كتاب علي 123 و ١٤٠٣, تست?  ")
assert(cleanText == "کتاب علی ۱۲۳ و ۱۴۰۳، تست؟")
```

#### 3.4.2 Java

```java
String cleanText = TextSanitiser.sanitise("كتاب علي 123?", new SanitiserConfig()); // کتاب علی ۱۲۳؟
```

## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils?ref=badge_large)
