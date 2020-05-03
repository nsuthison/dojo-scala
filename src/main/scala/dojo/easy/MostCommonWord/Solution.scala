package dojo.easy.MostCommonWord

import scala.collection.mutable
import scala.collection.immutable.HashMap

object Solution {
    def mostCommonWord(paragraph: String, banned: Array[String]): String = {
        val allWords = getAllWords(paragraph)
        val countRepeat = countRepeatWord(allWords)

        

        ???
    }

    def getAllWords(paragraph: String): Array[String] = {
        paragraph.split(' ').map(x => removePunctuation(x))
    }

    def removePunctuation(word: String): String = {
        val punctuation = "!?',;."

        for {
            alphabet <- word
            if punctuation.contains(alphabet) == false
        } yield alphabet
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

    def isBanWord(word: String, banned: Array[String]): String = {
        ???
    }
}
