# Project test1

## Add bamoe-bom, kogito-bom and bamoe-ilmt-compliance-quarkus-pamoe dependencies
```
# Update project file pom.xml
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

## create maven project
```
PRJ_GROUP_ID=marco.bamoe9
PRJ_VER=1.0.0
ARTIFACT_ID=${PRJ_NAME}
PLATF_VER=2.16.7.Final

mvn io.quarkus:quarkus-maven-plugin:${PLATF_VER}:create \
    -DprojectGroupId=${PRJ_GROUP_ID} \
    -DprojectArtifactId=${ARTIFACT_ID} \
    -DprojectVersion=${PRJ_VER} \
    -DplatformVersion=${PLATF_VER} \
    -DplatformGroupId=io.quarkus.platform \
    -DplatformArtifactId=quarkus-bom \
    -Dextensions=resteasy-reactive-jackson,quarkus-smallrye-openapi,quarkus-smallrye-health

cd ./${ARTIFACT_ID}
```

## Update pom.xml with BAMOE dependencies
```
code pom.xml
```

## Rebuild project
```
mvn clean package
```

## Test project
```
mvn quarkus:dev
```

## Browse to
http://localhost:8080/q/swagger-ui/#/
