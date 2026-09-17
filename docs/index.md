---
layout: default
title: "persianutils"
---

# persianutils

A robust collection of utilities for Scala and Java developers targeting Persian (Farsi) speaking users, cross-compiled for both JVM and Scala.js environments.

---

### Key Capabilities

- DateConverter: Precision conversion between Gregorian and Persian (Solar Hijri) calendars based on astronomical algorithms covering a 3,000-year epoch.
- DateToWord: Converts calendar dates into natural Persian verbal expressions and text representations.
- NumToWord: Converts cardinal numbers and integers into written Persian words.
- Cross-Platform & Dual-Ecosystem: Native support for Scala 2.13 and Scala 3.x across the JVM and Scala.js, with seamless Java interop.

---

### Documentation & Guides

#### Core Modules

- [DateConverter Guide](./pages/modules/date-converter.html): Detailed algorithmic background, date representations, and dual-calendar conversion recipes.
- [DateToWord Guide](./pages/modules/date-to-word.html): Transforming Persian calendar dates into spoken and written words.
- [NumToWord Guide](./pages/modules/num-to-word.html): Cardinal number to Persian word conversions.

#### Reference & API

- [API Reference (Scala 3)](./api/scala-3/index.html): Interactive Scaladoc for the Scala 3 build.
- [API Reference (Scala 2.13)](./api/scala-2.13/index.html): Interactive Scaladoc for the Scala 2.13 build.
- [Compatibility Matrix](./pages/reference/compatibility.html): Platform and runtime matrix across Scala 2.11 through 3.x and Java LTS releases.

---

### Quick Installation

#### SBT

For JVM projects:

```scala
libraryDependencies ++= Seq(
  "com.bahmanm" %% "persianutils" % "5.0"
)
```

For Scala.js projects:

```scala
libraryDependencies ++= Seq(
  "com.bahmanm" %%% "persianutils" % "6.0"
)
```

#### Maven

With Scala 3.x:

```xml
<dependency>
  <groupId>com.bahmanm</groupId>
  <artifactId>persianutils_3</artifactId>
  <version>5.0</version>
</dependency>
```

With Scala 2.13.x:

```xml
<dependency>
  <groupId>com.bahmanm</groupId>
  <artifactId>persianutils_2.13</artifactId>
  <version>5.0</version>
</dependency>
```

---

### Quick Example

```scala
import com.bahmanm.persianutils.DateConverter._

// Months and days are 1-indexed (e.g. Farvardin is 1, Esfand is 12)
val gDate = GregorianDate(2026, 3, 21)
val pDate = gregorianToPersian(gDate)

println(pDate) // PersianDate(1405, 1, 1)
```

For comprehensive recipes in both Scala and Java, consult the [individual module guides](./pages/modules/date-converter.html).
