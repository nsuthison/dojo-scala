package dojo.leetcode.easy.subdomain_visit_count.solutions

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import matchers.should.Matchers._

class SolutionTest extends AnyWordSpec {
  "subdomainVisits" when {
    "Given array of cpDomain which contain number of visit and domain" should {

      val cpDomains = Array[String] { "9001 discuss.leetcode.com" }

      "Return most frequent word" in {
        val result = Solution.subdomainVisits(cpDomains)

        result.length shouldEqual 3

        result.contains("9001 discuss.leetcode.com") shouldBe true
        result.contains("9001 leetcode.com") shouldBe true
        result.contains("9001 com") shouldBe true

      }
    }
  }
}
