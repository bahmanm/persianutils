# NumToWord

`com.bahmanm.persianutils.NumToWord` translates numeric values into written Persian words for both cardinal and ordinal numbering.

---

### Key Capabilities

- Cardinal numbers: Converts small numbers up to large astronomical figures into natural Persian words.
- Ordinal numbers: Converts numeric counts into their ordinal Persian equivalents (e.g. `1 -> "یکم"`).
- Typographic correctness: Accurately places Persian conjunctions ("و") and spaces.

---

### Usage in Scala

```scala
import com.bahmanm.persianutils.NumToWord

// Cardinal numbers
assert(NumToWord.cardinal(100) == "صد")
assert(NumToWord.cardinal(299792458) == "دویست و نود و نه میلیون و هفتصد و نود و دو هزار و چهارصد و پنجاه و هشت")

// Negative numbers and zero
assert(NumToWord.cardinal(0) == "صفر")
assert(NumToWord.cardinal(-42) == "منفی چهل و دو")

// Ordinal numbers
assert(NumToWord.ordinal(1) == "یکم")
assert(NumToWord.ordinal(235) == "دویست و سی و پنجم")
```

---

### Usage in Java

```java
import com.bahmanm.persianutils.NumToWord;

public class NumberWordExample {
    public static void main(String[] args) {
        String hundred = NumToWord.cardinal(100);
        System.out.println(hundred); // صد

        String first = NumToWord.ordinal(1);
        System.out.println(first); // یکم
    }
}
```

---

### Navigation

- [Back to Documentation Hub](../index.md)
- [DateConverter Guide](date-converter.md)
- [DateToWord Guide](date-to-word.md)
- [Interactive Scaladoc API (Scala 3)](../api/scala-3/com/bahmanm/persianutils.html){:target="_blank" rel="noopener"}
