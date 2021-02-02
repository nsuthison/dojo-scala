package dojo.leetcode.easy.most_common_word.solutions

import scala.collection.immutable.HashMap

// Question: https://leetcode.com/problems/most-common-word/
object Solution {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {

    val paragraphWithoutPunctuation = replacePunctuationWithWhiteSpace(
      paragraph
    )
    val allWords = getAllWords(paragraphWithoutPunctuation)
    val notBannedWords = getNotBannedWords(allWords, banned)
    val countRepeat = countRepeatWord(notBannedWords)

    val maxRepeatedWord = countRepeat.foldLeft("" -> 0)((left, right) => {
      if (left._2 > right._2) left else right
    })

    maxRepeatedWord._1
  }

  def getAllWords(paragraph: String): Array[String] = {
    paragraph.split("\\s+")
  }

  def replacePunctuationWithWhiteSpace(word: String): String = {
    for {
      alphabet <- word
    } yield getCharOrWhiteSpace(alphabet.toLower)
  }

  def countRepeatWord(words: Array[String]): Map[String, Int] = {
    words.groupBy(word => word).map(x => (x._1 -> x._2.length))
  }

  def getCharOrWhiteSpace(target: Char): Char = {
    val punctuation = "!?',;."

    if (punctuation.contains(target)) ' ' else target
  }

  def getNotBannedWords(
      words: Array[String],
      banned: Array[String]
  ): Array[String] = {
    for {
      word <- words
      if banned.contains(word) == false
    } yield word
  }
}
