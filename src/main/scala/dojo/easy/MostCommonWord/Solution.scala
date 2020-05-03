package dojo.easy.MostCommonWord

import scala.collection.mutable
import scala.collection.immutable.HashMap

object Solution {
    def mostCommonWord(paragraph: String, banned: Array[String]): String = {
        
        val paragraphWithoutPunctuation = replacePunctuationWithWhiteSpace(paragraph)
        val allWords = getAllWords(paragraphWithoutPunctuation)
        val notBannedWords = getNotBannedWords(allWords, banned)
        val countRepeat = countRepeatWord(notBannedWords)

        val maxRepeatedWord = countRepeat.maxBy(_._2)

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

    def countRepeatWord(words: Array[String]): mutable.HashMap[String, Int] = {
        var countRepeatWord = mutable.HashMap[String, Int]()

        for (word <- words) {
            if (countRepeatWord.contains(word))
            {
                countRepeatWord(word) += 1
            }
            else
            {
                countRepeatWord.addOne(word, 1)
            }
        }

        countRepeatWord
    }

    def getCharOrWhiteSpace(target: Char): Char = {
        val punctuation = "!?',;."

        if (punctuation.contains(target)) ' ' else target
    }

    def getNotBannedWords(words: Array[String], banned: Array[String]): Array[String] = {
        for {
            word <- words
            if banned.contains(word) == false
        } yield word
    }
}
