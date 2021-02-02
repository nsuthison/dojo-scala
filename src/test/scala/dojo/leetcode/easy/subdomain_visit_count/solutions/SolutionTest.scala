package dojo.leetcode.easy.subdomain_visit_count.solutions

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import matchers.should.Matchers._

class SolutionTest extends AnyWordSpec {

  "subdomainVisits" when {
    "Given array of cpDomain which contain number of visit and domain" should {

      val testCases = Seq(
        SubdomainVisitCountTestCase(
          cpDomainInput = Array("9001 discuss.leetcode.com"),
          expectedResult =
            Array("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com")
        ),
        SubdomainVisitCountTestCase(
          cpDomainInput = Array(
            "900 google.mail.com",
            "50 yahoo.com",
            "1 intel.mail.com",
            "5 wiki.org"
          ),
          expectedResult = Array(
            "901 mail.com",
            "50 yahoo.com",
            "900 google.mail.com",
            "5 wiki.org",
            "5 org",
            "1 intel.mail.com",
            "951 com"
          )
        )
      )

      "Return most frequent word" in {

        for (testCase <- testCases) {

          val subdomainCounts = Solution.subdomainVisits(testCase.cpDomainInput)

          subdomainCounts.length shouldEqual testCase.expectedResult.length

          for (subdomainCount <- subdomainCounts) {
            testCase.expectedResult.contains(subdomainCount) shouldBe (true)
          }
        }
      }
    }
  }
}
