# TextSanitiser

`com.bahmanm.persianutils.TextSanitiser` sanitises and normalises Persian text across multiple operating systems, keyboard layouts, and encoding formats.

---

### Key Capabilities

- Character standardisation: Replaces Arabic and non-standard character variants (such as Arabic Kaf `ك` and Yeh `ي`/`ى`) with standard Persian characters (`ک` and `ی`).
- Numerals conversion: Standardises Western ASCII digits (`0-9`) and Eastern Arabic digits (`٠-٩`) into standard Persian digits (`۰-۹`).
- Spacing and half-spaces: Collapses duplicate spaces, converts non-breaking spaces, deduplicates zero-width non-joiners (`\u200C` / ZWNJ), strips spaces flanking half-spaces, and strips dangling non-joiners.
- Tatweel removal: Strips typographic elongation / Kashida (`ـ`).
- Punctuation standardisation: Normalises commas, semicolons, and question marks to Persian punctuation marks (`،`, `؛`, `؟`).
- Diacritics stripping: Optionally strips Arabic Tashkeel / Harakat short vowels when configured.

---

### Usage in Scala

```scala
import com.bahmanm.persianutils.TextSanitiser
import com.bahmanm.persianutils.SanitiserConfig

// Default sanitisation
val clean = TextSanitiser.sanitise("  كتاب علي 123 و ١٤٠٣, تست?  ")
assert(clean == "کتاب علی ۱۲۳ و ۱۴۰۳، تست؟")

// Custom configuration
val config = SanitiserConfig(
  standardiseCharacters = true,
  cleanSpacing = true,
  removeTatweel = true,
  standardiseDigits = false,
  standardisePunctuation = false,
  removeDiacritics = true
)
val result = TextSanitiser.sanitise("كِتابِ علي 123?", config)
assert(result == "کتاب علی 123?")
```

---

### Usage in Java

```java
import com.bahmanm.persianutils.TextSanitiser;
import com.bahmanm.persianutils.SanitiserConfig;

public class SanitiserExample {
    public static void main(String[] args) {
        String clean = TextSanitiser.sanitise("كتاب علي 123?", new SanitiserConfig());
        System.out.println(clean); // کتاب علی ۱۲۳؟
    }
}
```

---

### Navigation

- [Back to Documentation Hub](../index.md)
- [DateConverter Guide](date-converter.md)
- [DateToWord Guide](date-to-word.md)
- [NumToWord Guide](num-to-word.md)
- [Interactive Scaladoc API (Scala 3)](../api/scala-3/com/bahmanm/persianutils.html){:target="_blank" rel="noopener"}
