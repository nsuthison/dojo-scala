package dojo.leetcode.easy.most_common_word.solutions

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import matchers.should.Matchers._

class SolutionTest extends AnyWordSpec {
  "mostCommonWord" when {
    "Given word without given banned word" should {

      val givenWord = "Bob hit a ball, the hit ball flew far after it was hit."
      val bannedWord = Array[String]()

      "Return most frequent word" in {
        val result = Solution.mostCommonWord(givenWord, bannedWord)

        result shouldEqual "hit"
      }
    }

    "Given word with banned word" should {

      val givenWord = "Bob hit a ball, the hit ball flew far after it was hit."
      val bannedWord = Array[String] { "hit" }

      "Return most frequent word but not the banned one" in {
        val result = Solution.mostCommonWord(givenWord, bannedWord)

        result shouldEqual "ball"
      }
    }
  }
}
