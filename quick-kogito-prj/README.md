

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

cd ./${ARTIFACT_ID}

code .

```

## update pom.xml
```
```

## clean package and run
```
mvn clean package

mvn quarkus:dev
```


## curl
```

curl -X 'POST' \
  'http://localhost:8080/pricing' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "Age": 50,
  "Previous incidents?": false
}'

```

