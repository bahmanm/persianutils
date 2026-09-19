# persianutils

<img src="assets/img/logo-256x256.png" alt="persianutils Logo" align="left" width="25%" style="max-width: 25%; margin-right: 1.5rem; margin-bottom: 1rem;" />

`persianutils` is a robust collection of utilities for Scala and Java developers targeting Persian (Farsi) speaking users, cross-compiled for both JVM and Scala.js environments.

<div style="clear: both;"></div>

---

### Key Capabilities

- DateConverter: Precision conversion between Gregorian and Persian (Solar Hijri) calendars based on astronomical algorithms covering a 3,000-year epoch.
- DateToWord: Converts calendar dates into natural Persian verbal expressions and text representations.
- NumToWord: Converts cardinal numbers and integers into written Persian words.
- TextSanitiser: Automated typography normalisation, character variant standardisation, digit unification, and whitespace/ZWNJ sanitisation.
- Cross-Platform & Dual-Ecosystem: Native support for Scala 2.13 and Scala 3.x across the JVM and Scala.js, with seamless Java interop.

---

### Documentation & Guides

#### Core Modules

- [DateConverter Guide](modules/date-converter.md): Detailed algorithmic background, date representations, and dual-calendar conversion recipes.
- [DateToWord Guide](modules/date-to-word.md): Transforming Persian calendar dates into spoken and written words.
- [NumToWord Guide](modules/num-to-word.md): Cardinal number to Persian word conversions.
- [TextSanitiser Guide](modules/text-sanitiser.md): Normalising Persian text, standardising Arabic letter variants, converting digits, cleaning non-breaking spaces, and deduplicating zero-width non-joiners (ZWNJ).

#### Reference & API

- [API Reference (Scala 3)](api/scala-3/com/bahmanm/persianutils.html){:target="_blank" rel="noopener"}: Interactive Scaladoc for the Scala 3 build.
- [API Reference (Scala 2.13)](api/scala-2.13/com/bahmanm/persianutils/index.html){:target="_blank" rel="noopener"}: Interactive Scaladoc for the Scala 2.13 build.
- [Compatibility Matrix](reference/compatibility.md): Platform and runtime matrix across Scala 2.11 through 3.x and Java LTS releases.

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

For comprehensive recipes in both Scala and Java, consult the [individual module guides](modules/date-converter.md).
