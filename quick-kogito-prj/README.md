# Quick Kogito

https://www.ibm.com/docs/en/ibamoe/9.0.x?topic=started-initial-project-setup-walkthrough


## Maven local repo setup

```
# add to local maven registry the supported BAMOE repo, for example

mvn install:install-file -DgroupId=com.ibm.bamoe -DartifactId=bamoe-bom -Dversion=9.0.1.Final -Dpackaging=jar -Dfile=/...your path.../bamoe-9.0.1-maven-repository.zip

# now BAMOE repo is in folder
ls -al # repo ~/.m2/repository/com/ibm/bamoe/bamoe-bom/9.0.1.Final/

```


## Create project
```
PRJ_GROUP_ID=marco.bamoe9
PRJ_VER=1.0.0
ARTIFACT_ID=quick-kogito
PLATF_VER=2.16.7.Final

mvn io.quarkus:quarkus-maven-plugin:2.16.7.Final:create \
    -DprojectGroupId=${PRJ_GROUP_ID} \
    -DprojectArtifactId=${ARTIFACT_ID} \
    -DprojectVersion=${PRJ_VER} \
    -DplatformVersion=${PLATF_VER} \
    -DplatformGroupId=io.quarkus.platform \
    -DplatformArtifactId=quarkus-bom \
    -Dextensions=kogito-quarkus,dmn,resteasy-reactive-jackson,quarkus-smallrye-openapi,quarkus-smallrye-health

cd ./quick-kogito

```

## Add bamoe-bom, kogito-bom and bamoe-ilmt-compliance-quarkus-pamoe dependencies
```
# Update application file pom.xml
  <properties>
    <!-- ADDED -->
    <kogito.bom.group-id>com.ibm.bamoe</kogito.bom.group-id>
    <kogito.bom.artifact-id>bamoe-bom</kogito.bom.artifact-id>
    <kogito.bom.version>9.0.1.Final</kogito.bom.version>    

  <dependencyManagement>
    <dependencies>

      <!-- ADDED -->
      <dependency>
        <groupId>${kogito.bom.group-id}</groupId>
        <artifactId>${kogito.bom.artifact-id}</artifactId>
        <version>${kogito.bom.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>

      <!-- COMMENTED OR REMOVEED
      <dependency>
        <groupId>${quarkus.platform.group-id}</groupId>
        <artifactId>quarkus-kogito-bom</artifactId>
        <version>${quarkus.platform.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
      -->

  <dependencies>

    <!-- ADDED -->
    <dependency>
      <groupId>com.ibm.bamoe</groupId>
      <artifactId>bamoe-ilmt-compliance-quarkus-pamoe</artifactId>
    </dependency>

```
## Rebuild project
```
mvn clean package
```

## Test project
```
mvn quarkus:dev

# Browse to
http://localhost:8080/q/swagger-ui/#/

# curl

curl -X 'POST' \
  'http://localhost:8080/pricing' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "Age": 50,
  "Previous incidents?": false
}'

```

