import scala.collection.mutable

object Solution {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {

    var results = mutable.HashMap[String, Int]()

    for {
        cpDomain <- separateDomainAndVisitedCount(cpdomains)
        cpSubDomain <- seprateSubdomainAndVisitedCount(cpDomain)
    }
    
    if (results.contains(cpSubDomain.domain)) {
        results(cpSubDomain.domain) += cpSubDomain.visitedCount
    } else {
        results.addOne(cpSubDomain.domain, cpSubDomain.visitedCount)
    }

    val toReturn = for {
        result <- results
    } yield {
        result._2 + " " + result._1
    }

    toReturn.toList
  }

  private def separateDomainAndVisitedCount(cpDomains: Array[String]): Array[CpDomain] = {
    for {
      cpDomain <- cpDomains
    } yield {
      val c = cpDomain.split(" ")
      CpDomain(c(1), c(0).toInt)
    }
  }

  private def seprateSubdomainAndVisitedCount(cpDomain: CpDomain): Array[CpDomain] = {

    var toReturn = mutable.ArrayBuffer[CpDomain]()

    val subdomain = cpDomain.domain.split('.')
    val lastSubdomainIndex = subdomain.length - 1

    var currentDomain:String = ""
    var i = lastSubdomainIndex

    while(i >= 0) {
        currentDomain = getDomain(currentDomain, subdomain(i))
        toReturn.addOne(CpDomain(currentDomain, cpDomain.visitedCount))
        i -= 1
    }

    toReturn.toArray
  }

  private def getDomain(domain: String, currentSubdomain: String): String = {
      if (domain.isEmpty())
      {
          return currentSubdomain
      }
      else
      {
          return s"$currentSubdomain.$domain"
      }
  }
}

case class CpDomain(domain: String, visitedCount: Int)
