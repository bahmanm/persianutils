## 1 Introduction ##

A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users.

## 2 Adding To Your Project ##

### 2.1 SBT ###

```
...
resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
...
libraryDependencies ++= Seq(
    "com.bahmanm" %% "persianutils" % "1.0"
)
```

### 2.2 Maven ###

```xml
...
<repositories>
    <repository>
        <id>sonatypesnapshots</id>
        <name>sonatype-snapshots</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
        <layout>default</layout>
    </repository>
    <repository>
        <id>sonatypereleases</id>
        <name>sonatype-releases</name>
        <url>https://oss.sonatype.org/content/repositories/releases/</url>
        <layout>default</layout>
    </repository>
</repositories>
...
<dependencies>
    <dependency>
        <groupId>com.bahmanm</groupId>
        <artifactId>persianutils_2.10</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```

## 3 What Is Included? ##

This is a short review of what you will find in _persianutils_:

### 3.1 DateConverter ###

`com.bahmanm.persianutils.DateConverter` is the Scala port of the original algorithm (in Fortran) [The Persian calendar for 3000 years](http://www.astro.uni.torun.pl/~kb/Papers/EMP/PersianC-EMP.htm).

#### 3.1.1 Scala ####

_NOTE: _persianutils_ works with Scala 2.10.x series._

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

#### 3.2 Java ####

```java
import com.bahmanm.persianutils.DateConverter;

public class Main {

  public static void main(String[] args) {
    DateConverter.SimpleDate pd = new DateConverter.SimpleDate(1392, 11, 11);
    DateConverter.SimpleDate gd = DateConverter.persianToGregorian(pd);
    System.out.println(gd);
  }

}
```
