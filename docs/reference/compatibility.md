# Compatibility Matrix & Runtimes

This document outlines the binary and source compatibility guarantees of `persianutils` across Scala and Java releases.

---

### Scala Matrix

| persianutils Release | Scala 2.10 | Scala 2.11 | Scala 2.12 | Scala 2.13 | Scala 3.x |
| :--- | :---: | :---: | :---: | :---: | :---: |
| 6.x _(upcoming)_ | ❌ | ❌ | ❌ | ✅ | ✅ |
| 5.x | ❌ | ❌ | ✅ | ✅ | ✅ |
| 4.x | ❌ | ✅ | ✅ | ✅ | ❌ |
| 3.x | ❌ | ✅ | ✅ | ❌ | ❌ |
| 2.x | ✅ | ✅ | ❌ | ❌ | ❌ |

---

### Platform Targets

- JVM: Compatible with Java 8, 11, 17, 21, and 25 LTS releases.
- Scala.js: Cross-compiled for Scala.js 1.x with standard browser and Node.js runtime compatibility.

---

### Navigation

- [Back to Documentation Hub](../index.md)
- [DateConverter Guide](../modules/date-converter.md)
- [DateToWord Guide](../modules/date-to-word.md)
- [NumToWord Guide](../modules/num-to-word.md)
- [Interactive Scaladoc API (Scala 3)](../api/scala-3/com/bahmanm/persianutils.html){:target="_blank" rel="noopener"}
