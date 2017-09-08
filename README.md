# Spring Boot @ConfigurationProperties test

Render defaults:

```
$ ./gradlew bootRun
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:findMainClass
:bootRun
EnvTestApplication.EnvTestProperties(name=default name, container=EnvTestApplication.EnvTestProperties.Container(singleValue=default single value in container, multiValue=[default first multi value in container, default second multi value in container]))

BUILD SUCCESSFUL

Total time: 1.946 secs
```

Render overrides based on environment variables:

```
$ ENV_TEST_PREFIX_NAME=anon ./gradlew bootRun
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:findMainClass
:bootRun
EnvTestApplication.EnvTestProperties(name=anon, container=EnvTestApplication.EnvTestProperties.Container(singleValue=default single value in container, multiValue=[default first multi value in container, default second multi value in container]))

BUILD SUCCESSFUL

Total time: 1.907 secs
```
