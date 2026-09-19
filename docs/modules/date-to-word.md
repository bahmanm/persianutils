# DateToWord

`com.bahmanm.persianutils.DateToWord` converts calendar dates into full verbal Persian expressions and natural language strings.

---

### Capabilities

- Full verbal expansion: Converts numeric years, month names, and ordinal day numbers into elegant Persian phrasing.
- Built-in member methods: Provides the `.toWords` method directly on `PersianDate` and `GregorianDate` instances in Scala.
- Multi-calendar support: Supports date transformation for both Persian (Solar Hijri) and Gregorian dates.
- Discrete component conversion: Accepts individual year, month, and day integer arguments directly.

---

### Usage in Scala

```scala
import com.bahmanm.persianutils.DateToWord
import com.bahmanm.persianutils.{GregorianDate, PersianDate}

// Using the built-in .toWords member method on PersianDate
val pDate = PersianDate(1361, 3, 3)
println(pDate.toWords)
// Output: "سوم خرداد یک هزار و سیصد و شصت و یک"

// Using functional apply syntax
val pWords = DateToWord(pDate)
assert(pWords == "سوم خرداد یک هزار و سیصد و شصت و یک")

// Converting Gregorian dates into Persian phrasing
val gDate = GregorianDate(1992, 12, 3)
println(gDate.toWords)
// Output: "سوم دسامبر یک هزار و نه‌صد و نود و دو"

// Using discrete date components
val verbalP = DateToWord.persian(1402, 1, 1)
assert(verbalP == "یکم فروردین یک هزار و چهار‌صد و دو")

val verbalG = DateToWord.gregorian(2023, 3, 21)
assert(verbalG == "بیست و یکم مارس دو هزار و بیست و سه")
```

---

### Usage in Java

`DateToWord` provides explicit static helper methods for Java integration:

```java
import com.bahmanm.persianutils.DateToWord;
import com.bahmanm.persianutils.GregorianDate;
import com.bahmanm.persianutils.PersianDate;

public class DateVerbalExample {
    public static void main(String[] args) {
        // Persian date to words
        PersianDate pd = new PersianDate(1361, 3, 3);
        System.out.println(pd.toWords());
        // Prints: سوم خرداد یک هزار و سیصد و شصت و یک
        System.out.println(DateToWord.persian(pd));

        // Gregorian date to words
        GregorianDate gd = new GregorianDate(1992, 12, 3);
        System.out.println(gd.toWords());
        // Prints: سوم دسامبر یک هزار و نه‌صد و نود و دو
        System.out.println(DateToWord.gregorian(gd));
    }
}
```

---

### Navigation

- [Back to Documentation Hub](../index.md)
- [DateConverter Guide](date-converter.md)
- [NumToWord Guide](num-to-word.md)
- [TextSanitiser Guide](text-sanitiser.md)
- [Interactive Scaladoc API (Scala 3)](../api/scala-3/com/bahmanm/persianutils.html){:target="_blank" rel="noopener"}
