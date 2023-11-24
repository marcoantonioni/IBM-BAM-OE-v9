# Quick Kogito

https://www.ibm.com/docs/en/ibamoe/9.0.x?topic=started-initial-project-setup-walkthrough


## Maven setup

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

## Update pom.xml
```
# add in 
# <project>
#   <properties>

    <!-- ADDED -->
    <kogito.bom.group-id>com.ibm.bamoe</kogito.bom.group-id>
    <kogito.bom.artifact-id>bamoe-bom</kogito.bom.artifact-id>
    <kogito.bom.version>9.0.0.Final</kogito.bom.version>    

# add in   
# <project>
#   <dependencyManagement>
#     <dependencies>


      <!-- ADDED -->
      <dependency>
        <groupId>${kogito.bom.group-id}</groupId>
        <artifactId>${kogito.bom.artifact-id}</artifactId>
        <version>${kogito.bom.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>

# add in 
# <project>
#   <dependencies>

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

