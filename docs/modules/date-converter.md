# DateConverter

`com.bahmanm.persianutils.DateConverter` provides high-precision bidirectional conversion between the Gregorian calendar and the Persian (Solar Hijri) calendar.

The conversion logic is a Scala implementation based on the 3,000-year astronomical algorithm described in [The Persian calendar for 3000 years](http://www.astro.uni.torun.pl/~kb/Papers/EMP/PersianC-EMP.htm) by Kazimierz M. Borkowski.

---

### Key Concepts

- Indexing: Months and days are 1-indexed. For example, in the Persian calendar Farvardin is month `1` and Esfand is month `12`. In the Gregorian calendar, January is `1` and December is `12`.
- Immutability: Both `PersianDate` and `GregorianDate` are immutable case classes.
- String Parsing: Persian dates formatted as `YYYY/MM/DD` (e.g. `"1392/09/24"`) can directly initialise a `PersianDate`.

---

### Usage in Scala

```scala
import com.bahmanm.persianutils.DateConverter._
import com.bahmanm.persianutils.{GregorianDate, PersianDate, SimpleDate}

// Convert Gregorian to Persian
val gDate1 = GregorianDate(2013, 12, 11)
val pDate1 = gregorianToPersian(gDate1)
println(pDate1) // PersianDate(1392, 9, 20)

// Convert Persian to Gregorian
val pDate2 = PersianDate(1392, 1, 1)
val gDate2 = persianToGregorian(pDate2)
println(gDate2) // GregorianDate(2013, 3, 21)

// Initialise from formatted string
val pDate3 = PersianDate("1392/09/24")
val gDate3 = persianToGregorian(pDate3)
println(gDate3) // GregorianDate(2013, 12, 15)

// Legacy Java Date interoperability
val legacyDate = java.util.Calendar.getInstance().getTime()
val sDate = SimpleDate(legacyDate)
val pDate4 = gregorianToPersian(sDate)
```

---

### Usage in Java

`DateConverter` exposes static helper methods for straightforward Java interop:

```java
import com.bahmanm.persianutils.DateConverter;
import com.bahmanm.persianutils.GregorianDate;
import com.bahmanm.persianutils.PersianDate;

public class CalendarExample {
    public static void main(String[] args) {
        // Persian to Gregorian
        PersianDate pd = new PersianDate(1392, 11, 11);
        GregorianDate gd = DateConverter.persianToGregorian(pd);
        System.out.println(gd);

        // Gregorian to Persian
        GregorianDate gd2 = new GregorianDate(2014, 2, 4);
        PersianDate pd2 = DateConverter.gregorianToPersian(gd2);
        System.out.println(pd2);
    }
}
```

---

### Leap Year Verification

The library models leap year arithmetic for both calendar systems according to astronomical cycles:

```scala
import com.bahmanm.persianutils.DateConverter._

assert(isPersianLeap(1399))
assert(!isPersianLeap(1400))
```

---

### Navigation

- [Back to Documentation Hub](../index.md)
- [DateToWord Guide](date-to-word.md)
- [NumToWord Guide](num-to-word.md)
- [Interactive Scaladoc API (Scala 3)](../api/scala-3/com/bahmanm/persianutils.html){:target="_blank" rel="noopener"}
