package com.example

import unfiltered.request._
import unfiltered.response._
import java.util.Locale

/** unfiltered plan */
class App extends unfiltered.filter.Plan {

  def intent = {
    case req @ GET(Path("/") & Params(ps)) =>
      val locale =
        ps.get("lang").flatMap(_.headOption).map(new Locale(_)).getOrElse(Locale.ENGLISH)
      Ok ~> HtmlContent ~> Scalate(req, "index.scaml",
        "locale" -> locale
      )
  }
}

/** embedded server */
object Server {
  def main(args: Array[String]) {
    val http = unfiltered.jetty.Http.anylocal
    http.context("/assets") { _.resources(
      new java.net.URL(getClass().getResource("/www/aloha"), ".")
    ) }.filter(new App).run({ svr =>
        unfiltered.util.Browser.open(http.url)
      }, { svr =>
      })
  }
}
