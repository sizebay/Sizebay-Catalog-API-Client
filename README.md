# Sizebay Catalog API client

## Requirements
Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation
To install the API client library to your local Maven repository, simply execute:
```shell
mvn install
```

## Deploy 

Just push to branch master to launch a new version. It is worth mentioning that to launch a new version the *pom.xml*, 
must be changed with the tag of the new version.

## CI and Maven repository

CI is managed by Github Actions and the Maven repository is managed AWS Code Artifact.

## Usage

After the client libarary is installed/deployed, you can use it in your Maven project by adding the following to your *pom.xml*:

```xml
<dependency>
  <groupId>com.sizebay.sizebay-catalog-api-client</groupId>
  <artifactId>sizebay-catalog-api-client</artifactId>
  <version>${version.sizebay.sizebay-catalog-api-client}</version>
</dependency>
```
