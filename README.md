# 1 Introduction 
[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/UMKeFZ8ns9T9vi5aquTfVT/BwGU1tm7aeza7w99ccaEMW/tree/master.svg?style=svg&circle-token=CCIPRJ_SpcW3fS7iXjTT8gJQcYhei_ad25651fdb49ac759b7725219d8c85b88907fe39)](https://dl.circleci.com/status-badge/redirect/circleci/UMKeFZ8ns9T9vi5aquTfVT/BwGU1tm7aeza7w99ccaEMW/tree/master)
[![Matrix](https://img.shields.io/matrix/github-bahmanm-persianutils%3Amatrix.org?server_fqdn=matrix.org&style=flat&logo=matrix&logoColor=white&color=0e80c0)](https://matrix.to/#/#github-bahmanm-persianutils:matrix.org)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_3?style=flat&logo=scala&logoColor=white&label=3.x)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_2.13?style=flat&logo=scala&logoColor=white&label=2.13.x)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_2.12?style=flat&logo=scala&logoColor=white&label=2.12.x)
![Maven Central Version](https://img.shields.io/maven-central/v/com.bahmanm/persianutils_2.11?style=flat&logo=scala&logoColor=white&label=2.11.x)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils?ref=badge_shield)

A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users.

<img alt="persianutils logo" src="https://imgur.com/j1cWx7m.png" style="height: 300px; width: 300px; vertical-align: top" /> 

### 1.1  Scala Compatibility

| ⬇ persianutils ❚ scala ➡ | 2.10.x | 2.11.x | 2.12.x | 2.13.x | 3.x  |
|----------------------------|--------|--------|--------|--------|------|
| 5.x                        |   ❌   |   ❌   |  ✅   |   ✅   |  ✅  |
| 4.x                        |   ❌   |   ✅   |  ✅   |   ✅   |  ❌  |
| 3.x                        |   ❌   |   ✅   |  ✅   |   ❌   |  ❌  |
| 2.x                        |   ✅   |   ✅   |  ❌   |   ❌   |  ❌  |

# 2 Adding To Your Project 

### 2.1 SBT 

```scala
libraryDependencies ++= Seq(
    "com.bahmanm" %% "persianutils" % "5.0"
)
```

### 2.2 Maven 

With Scala 3.x:

```xml
<dependencies>
    <dependency>
        <groupId>com.bahmanm</groupId>
        <artifactId>persianutils_3</artifactId>
        <version>5.0</version>
    </dependency>
</dependencies>
```

With Scala 2.13.x:

```xml
<dependencies>
    <dependency>
        <groupId>com.bahmanm</groupId>
        <artifactId>persianutils_2.13</artifactId>
        <version>5.0</version>
    </dependency>
</dependencies>
```

With Scala 2.12.x:

```xml
<dependencies>
    <dependency>
        <groupId>com.bahmanm</groupId>
        <artifactId>persianutils_2.12</artifactId>
        <version>5.0</version>
    </dependency>
</dependencies>
```

## 3 What Is Included? 

This is a short review of what you will find in _persianutils_:

### 3.1 DateConverter 

`com.bahmanm.persianutils.DateConverter` is the Scala port of the original algorithm (in Fortran) [The Persian calendar for 3000 years](http://www.astro.uni.torun.pl/~kb/Papers/EMP/PersianC-EMP.htm).

#### 3.1.1 Scala 

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

#### 3.1.2 Java 

```java
import com.bahmanm.persianutils.DateConverter;

public class Main {

  public static void main(String[] args) {
    DateConverter.SimpleDate pd1 = new DateConverter.SimpleDate(1392, 11, 11);
    DateConverter.SimpleDate gd1 = DateConverter.persianToGregorian(pd1);
    System.out.println(gd1);

    DateConverter.SimpleDate gd2 = new DateConverter.SimpleDate(2014, 2, 4);
    DateConverter.SimpleDate pd2 = DateConverter.gregorianToPersian(gd2);
    System.out.println(pd2);
  }

}
```

### 3.2 NumToWord

```scala
import com.bahmanm.persianutils.NumToWord

assert(NumToWord(100) == "صد")
assert(NumToWord(299792458) == "دویست و نود و نه میلیون و هفتصد و نود و دو هزار و چهارصد و پنجاه و هشت")
```




## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fbahmanm%2Fpersianutils?ref=badge_large)