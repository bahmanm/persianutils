package com.bahmanm.persianutils

import scala.util.matching.Regex

/**
 * Configuration options for [[TextSanitiser]].
 *
 * @param standardiseCharacters replaces Arabic and non-standard character variants with standard Persian characters
 * @param cleanSpacing cleans and canonicalises whitespace, non-breaking spaces, and zero-width non-joiners
 * @param removeTatweel strips Kashida / Tatweel elongation characters
 * @param standardiseDigits converts Western ASCII and Eastern Arabic digits into Persian digits
 * @param standardisePunctuation normalises punctuation symbols into Persian equivalents
 * @param removeDiacritics strips Arabic Tashkeel (harakat) short vowel diacritics
 *
 * @author Bahman Movaqar (Bahman AT BahmanM.com)
 */
final case class SanitiserConfig(
  standardiseCharacters: Boolean = true,
  cleanSpacing: Boolean = true,
  removeTatweel: Boolean = true,
  standardiseDigits: Boolean = true,
  standardisePunctuation: Boolean = true,
  removeDiacritics: Boolean = false
) {

  /**
   * Auxiliary zero-argument constructor for seamless Java interoperability.
   */
  def this() = this(
    standardiseCharacters = true,
    cleanSpacing = true,
    removeTatweel = true,
    standardiseDigits = true,
    standardisePunctuation = true,
    removeDiacritics = false
  )
}

/**
 * Utility for sanitising and normalising Persian text.
 *
 * @author Bahman Movaqar (Bahman AT BahmanM.com)
 */
object TextSanitiser {

  private val ConsecutiveZwnj: Regex = "\u200C{2,}".r
  private val SpacedZwnj: Regex = "(?:[ \t]+\u200C|\u200C[ \t]+)+".r
  private val MultipleSpaces: Regex = "[ \t]{2,}".r
  private val LeadingSpacing: Regex = "^[ \t\u200C]+".r
  private val TrailingSpacing: Regex = "[ \t\u200C]+$".r

  /**
   * Sanitises the given Persian text according to the provided configuration.
   *
   * @param text the input text to sanitise
   * @param config the sanitisation configuration options
   * @return the sanitised text
   */
  def sanitise(text: String, config: SanitiserConfig = SanitiserConfig()): String =
    Option(text).filterNot(_.isEmpty) match {
      case None => ""
      case Some(input) =>
        val steps = List.newBuilder[String => String]
        if (config.standardiseCharacters) steps += standardiseCharacters
        if (config.removeTatweel) steps += removeTatweel
        if (config.removeDiacritics) steps += removeDiacritics
        if (config.standardiseDigits) steps += standardiseDigits
        if (config.standardisePunctuation) steps += standardisePunctuation
        if (config.cleanSpacing) steps += cleanSpacing

        steps.result().foldLeft(input)((acc, step) => step(acc))
    }

  private def standardiseCharacters(text: String): String =
    text.flatMap {
      case '\u0643' => "ک"
      case '\u064A' | '\u0649' => "ی"
      case '\u06BE' | '\u0629' => "ه"
      case '\u06C0' => "هٔ"
      case other => other.toString
    }

  private def removeTatweel(text: String): String =
    text.filterNot(_ == '\u0640')

  private def removeDiacritics(text: String): String =
    text.filterNot(c => c >= '\u064B' && c <= '\u0652')

  private def standardiseDigits(text: String): String =
    text.map {
      case c if c >= '0' && c <= '9' => (c - '0' + '\u06F0').toChar
      case c if c >= '\u0660' && c <= '\u0669' => (c - '\u0660' + '\u06F0').toChar
      case other => other
    }

  private def standardisePunctuation(text: String): String =
    text.map {
      case ',' => '\u060C'
      case ';' => '\u061B'
      case '?' => '\u061F'
      case other => other
    }

  private def cleanSpacing(text: String): String = {
    val normalisedControls = text
      .replace('\u00A0', ' ')
      .replace('\u200B', ' ')
      .filterNot(c => c == '\u200D' || c == '\u00AD')

    normalisedControls.linesWithSeparators.map(cleanLine).mkString
  }

  private def cleanLine(lineWithSeparator: String): String = {
    val content = lineWithSeparator.stripLineEnd
    val separator = lineWithSeparator.substring(content.length)

    val cleanContent = Seq[String => String](
      ConsecutiveZwnj.replaceAllIn(_, "\u200C"),
      SpacedZwnj.replaceAllIn(_, " "),
      MultipleSpaces.replaceAllIn(_, " "),
      LeadingSpacing.replaceAllIn(_, ""),
      TrailingSpacing.replaceAllIn(_, "")
    ).foldLeft(content)((acc, f) => f(acc))

    cleanContent + separator
  }
}
