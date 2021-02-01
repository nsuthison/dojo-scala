package dojo.leetcode.easy.subdomain_visit_count.solutions

// Question: https://leetcode.com/problems/subdomain-visit-count/
object Solution {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {

    val cpSubDomains = for {
      cpDomain <- separateDomainAndVisitedCount(cpdomains)
      cpSubDomain <- seprateSubdomainAndVisitedCount(cpDomain)
    } yield {
      cpSubDomain
    }

    val results =
      cpSubDomains.groupBy(_.domain).view.mapValues(_.map(_.visitedCount).sum)

    val toReturn = for {
      result <- results
    } yield {
      s"${result._2} ${result._1}"
    }

    toReturn.toList
  }

  private def separateDomainAndVisitedCount(
      cpDomains: Array[String]
  ): Array[CpDomain] = {
    for {
      cpDomain <- cpDomains
    } yield {
      val c = cpDomain.split(" ")
      CpDomain(c(1), c(0).toInt)
    }
  }

  private def seprateSubdomainAndVisitedCount(
      cpDomain: CpDomain
  ): Array[CpDomain] = {

    val subdomains = cpDomain.domain.split('.')

    val toReturn =
      subdomains.foldRight(List[CpDomain]())((currentSubdomain, rs) => {

        val previousDomain = rs.headOption.getOrElse(CpDomain("", 0)).domain

        CpDomain(
          domain = getDomain(previousDomain, currentSubdomain),
          visitedCount = cpDomain.visitedCount
        ) :: rs
      })

    toReturn.toArray
  }

  private def getDomain(domain: String, currentSubdomain: String): String = {
    if (domain.isEmpty()) {
      return currentSubdomain
    } else {
      return s"$currentSubdomain.$domain"
    }
  }
}

case class CpDomain(domain: String, visitedCount: Int)
