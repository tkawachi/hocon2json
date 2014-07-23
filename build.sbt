seq(conscriptSettings :_*)

organization := "com.github.tkawachi"

name := "hocon2json"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.2.1"
)

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

scmInfo := Some(ScmInfo(
  url("https://github.com/tkawachi/hocon2json/"),
  "scm:git:github.com:tkawachi/hocon2json.git"
))
