scalaVersion in ThisBuild := "2.11.12"

val akkaVersion       = "10.1.7"
val circeVersion      = "0.11.0"
val catsVersion       = "0.5.0"
val http4sVersion     = "0.19.0"

lazy val akka = (project in file("modules/akka"))
  .settings(
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"           % akkaVersion,
      "com.typesafe.akka" %% "akka-http-testkit"   % akkaVersion,
      "io.circe"          %% "circe-core"          % circeVersion,
      "io.circe"          %% "circe-generic"       % circeVersion,
      "io.circe"          %% "circe-java8"         % circeVersion,
      "io.circe"          %% "circe-parser"        % circeVersion,
      "org.typelevel"     %% "cats-core"           % catsVersion
    ),
    guardrailTasks in Compile := List(
      Client.defaults(imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/polymorphism.yaml"), pkg="polymorphism.client.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/polymorphism.yaml"), pkg="polymorphism.server.akkaHttp", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/petstore.json"), pkg="clients.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/petstore.json"), pkg="servers.akkaHttp", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/plain.json"), pkg="tests.dtos.akkaHttp", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/contentType-textPlain.yaml"), pkg="tests.contentTypes.textPlain.client.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/contentType-textPlain.yaml"), pkg="tests.contentTypes.textPlain.server.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/raw-response.yaml"), pkg="raw.server.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/test/resources/server1.yaml"), pkg="tracer.servers.akkaHttp", tracing=true, imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/test/resources/server1.yaml"), pkg="tracer.clients.akkaHttp", tracing=true, imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/test/resources/server2.yaml"), pkg="tracer.servers.akkaHttp", tracing=true, imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/test/resources/server2.yaml"), pkg="tracer.clients.akkaHttp", tracing=true, imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/alias.yaml"), pkg="alias.client.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/alias.yaml"), pkg="alias.server.akkaHttp", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/edgecases/defaults.yaml"), pkg="edgecases.defaults.akkaHttp", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/custom-header-type.yaml"), pkg="tests.customTypes.customHeader.client.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/custom-header-type.yaml"), pkg="tests.customTypes.customHeader.server.akkaHttp", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/formData.yaml"), pkg="form.client.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/formData.yaml"), pkg="form.server.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/issues/issue127.yaml"), pkg="issues.issue127", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/issues/issue143.yaml"), pkg="issues.issue143", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/issues/issue148.yaml"), pkg="issues.issue148.client.akkaHttp", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/issues/issue148.yaml"), pkg="issues.issue148.server.akkaHttp", imports = List("support.PositiveLong"))
    )
  )

lazy val http4s = (project in file("modules/http4s"))
  .settings(
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= Seq(
      "org.http4s"        %% "http4s-blaze-client" % http4sVersion,
      "org.http4s"        %% "http4s-blaze-server" % http4sVersion,
      "org.http4s"        %% "http4s-circe"        % http4sVersion,
      "org.http4s"        %% "http4s-dsl"          % http4sVersion,
      "io.circe"          %% "circe-core"          % circeVersion,
      "io.circe"          %% "circe-generic"       % circeVersion,
      "io.circe"          %% "circe-java8"         % circeVersion,
      "io.circe"          %% "circe-parser"        % circeVersion,
      "org.typelevel"     %% "cats-core"           % catsVersion
    ),
    guardrailTasks in Compile := List(
      Client(file("guardrail/modules/sample/src/main/resources/polymorphism.yaml"), pkg="polymorphism.client.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/polymorphism.yaml"), pkg="polymorphism.server.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/petstore.json"), pkg="clients.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/petstore.json"), pkg="servers.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/plain.json"), pkg="tests.dtos.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/contentType-textPlain.yaml"), pkg="tests.contentTypes.textPlain.client.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/contentType-textPlain.yaml"), pkg="tests.contentTypes.textPlain.server.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/raw-response.yaml"), pkg="raw.server.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/test/resources/server1.yaml"), pkg="tracer.servers.http4s", framework="http4s", tracing=true, imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/test/resources/server1.yaml"), pkg="tracer.clients.http4s", framework="http4s", tracing=true, imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/test/resources/server2.yaml"), pkg="tracer.servers.http4s", framework="http4s", tracing=true, imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/test/resources/server2.yaml"), pkg="tracer.clients.http4s", framework="http4s", tracing=true, imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/alias.yaml"), pkg="alias.client.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/alias.yaml"), pkg="alias.server.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/edgecases/defaults.yaml"), pkg="edgecases.defaults.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/custom-header-type.yaml"), pkg="tests.customTypes.customHeader.client.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/custom-header-type.yaml"), pkg="tests.customTypes.customHeader.server.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/formData.yaml"), pkg="form.client.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/formData.yaml"), pkg="form.server.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Client(file("guardrail/modules/sample/src/main/resources/issues/issue148.yaml"), pkg="issues.issue148.client.http4s", framework="http4s", imports = List("support.PositiveLong")),
      Server(file("guardrail/modules/sample/src/main/resources/issues/issue148.yaml"), pkg="issues.issue148.server.http4s", framework="http4s", imports = List("support.PositiveLong"))
    )
  )

scalacOptions += "-Ypartial-unification"
