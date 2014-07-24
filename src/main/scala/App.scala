package com.github.tkawachi

import java.io.File

import com.typesafe.config.{ConfigFactory, ConfigRenderOptions}

/** The launched conscript entry point */
class App extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) = {
    Exit(App.run(config.arguments))
  }
}

/**
 * Command to convert HOCON to JSON.
 */
object App {
  private def usage = "Usage: hocon2json [-p] srcFile"

  private def toJSON(file: File, pretty: Boolean): String = {
    val renderOption =
      if (pretty) ConfigRenderOptions.concise().setFormatted(true)
      else ConfigRenderOptions.concise()
    val conf = ConfigFactory.parseFile(file).resolve()
    conf.root().render(renderOption)
  }

  /** Shared by the launched version and the runnable version,
    * returns the process status code */
  def run(args: Array[String]): Int = {
    args match {
      case Array("-p", srcFileName) =>
        println(toJSON(new File(srcFileName), true))
        0
      case Array(srcFileName) =>
        println(toJSON(new File(srcFileName), false))
        0
      case _ =>
        println(usage)
        1
    }
  }

  /** Standard runnable class entrypoint */
  def main(args: Array[String]) {
    System.exit(run(args))
  }
}

case class Exit(code: Int) extends xsbti.Exit
