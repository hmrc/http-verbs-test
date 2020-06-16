http-verbs-test
===============

[![Build Status](https://travis-ci.org/hmrc/http-verbs-test.svg)](https://travis-ci.org/hmrc/http-verbs-test) [ ![Download](https://api.bintray.com/packages/hmrc/releases/http-verbs-test/images/download.svg) ](https://bintray.com/hmrc/releases/http-verbs-test/_latestVersion)

## This library is deprecated
### All classes from this library have been migrated to [http-verbs](https://github.com/hmrc/http-verbs). This is available for Play 2.5, 2.6, and 2.7. Please replace with the following dependency:
```scala
libraryDependencies += "uk.gov.hmrc" %% "http-verbs-test-play-xx" % "x.x.x"
```
---------------

http-verbs-test is a Scala library providing some useful logic for testing http-related code.

## Adding to your build

In your SBT build add:

```scala
resolvers += Resolver.bintrayRepo("hmrc", "releases")

libraryDependencies += "uk.gov.hmrc" %% "http-verbs-test" % "x.x.x"
```

## License ##
 
This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
