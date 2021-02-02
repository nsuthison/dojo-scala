package dojo.leetcode.easy.most_common_word.solutions

// Question: https://leetcode.com/problems/most-common-word/
object Solution {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {

    val paragraphWithoutPunctuation = replacePunctuationWithWhiteSpaceIn(
      paragraph
    )
    val allWords = getAllWordsFrom(paragraphWithoutPunctuation)
    val notBannedWords = getNotBannedWordsFrom(allWords, banned)
    val countRepeat = countRepeatWordIn(notBannedWords)

    val maxRepeatedWord = countRepeat.foldLeft("" -> 0)((left, right) => {
      if (left._2 > right._2) left else right
    })

    maxRepeatedWord._1
  }

  def getAllWordsFrom(paragraph: String): Array[String] = {
    paragraph.split("\\s+")
  }

  def replacePunctuationWithWhiteSpaceIn(word: String): String = {
    for {
      alphabet <- word
    } yield getCharOrWhiteSpace(alphabet.toLower)
  }

  def getCharOrWhiteSpace(target: Char): Char = {
    val punctuation = "!?',;."

    if (punctuation.contains(target)) ' ' else target
  }

  def countRepeatWordIn(words: Array[String]): Map[String, Int] = {
    words.groupBy(word => word).map(x => (x._1 -> x._2.length))
  }

  def getNotBannedWordsFrom(
      words: Array[String],
      banned: Array[String]
  ): Array[String] = {
    for {
      word <- words
      if banned.contains(word) == false
    } yield word
  }
}
