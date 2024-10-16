@echo off
echo "######"
echo "#     #  #####    ####    #####   ####"
echo "#     #  #    #  #    #     #    #    #"
echo "######   #    #  #    #     #    #    #"
echo "#        #####   #    #     #    #    #"
echo "#        #   #   #    #     #    #    #"
echo "#        #    #   ####      #     ####"
echo "=================================================================================================="
echo "************************************ Protobuf Compilation ****************************************"
echo "=================================================================================================="

echo [DELETING..........]
rd /s /q studence-util\src\main\java\com\tiwari\studence\proto
rd /s /q studence-common\src\main\java\com\tiwari\studence\proto
rd /s /q studence-dynamodb-database\src\main\java\com\tiwari\studence\proto
rd /s /q studence-common-http\src\main\java\com\tiwari\studence\proto
rd /s /q studence-organisation\src\main\java\com\tiwari\studence\proto
rd /s /q studence-campus\src\main\java\com\tiwari\studence\proto
rd /s /q studence-teacher\src\main\java\com\tiwari\studence\proto
rd /s /q studence-student\src\main\java\com\tiwari\studence\proto
rd /s /q studence-attendence\src\main\java\com\tiwari\studence\proto
rd /s /q studence-login\src\main\java\com\tiwari\studence\proto
rd /s /q studence-teacher\src\main\java\com\tiwari\studence\proto
rd /s /q studence-student\src\main\java\com\tiwari\studence\proto
rd /s /q studence-classes\src\main\java\com\tiwari\studence\proto
rd /s /q studence-campus\src\main\java\com\tiwari\studence\proto
rd /s /q studence-guardian\src\main\java\com\tiwari\studence\proto
rd /s /q studence-attendence\src\main\java\com\tiwari\studence\proto
rd /s /q studence-management-app\src\main\java\com\tiwari\studence\proto

cd studence-proto

echo [COMPILING..........]
protoc time.proto --java_out=../studence-common/src/main/java
protoc summaryPb.proto --java_out=../studence-util/src/main/java
protoc genericRefPb.proto --java_out=../studence-util/src/main/java
protoc namePb.proto --java_out=../studence-util/src/main/java
protoc searchdynamodb.proto --java_out=../studence-util/src/main/java
protoc contactDetailsPb.proto --java_out=../studence-util/src/main/java
protoc error.proto --java_out=../studence-util/src/main/java
protoc requestContextPb.proto --java_out=../studence-common/src/main/java
protoc entityPb.proto --java_out=../studence-util/src/main/java
protoc dataTypesPb.proto --java_out=../studence-util/src/main/java
protoc loginPb.proto --java_out=../studence-login/src/main/java
protoc organisationPb.proto --java_out=../studence-organisation/src/main/java
protoc campusPb.proto --java_out=../studence-campus/src/main/java
protoc teacherPb.proto --java_out=../studence-teacher/src/main/java
protoc classPb.proto --java_out=../studence-classes/src/main/java
protoc guardianPb.proto --java_out=../studence-guardian/src/main/java
protoc studentPb.proto --java_out=../studence-student/src/main/java
protoc attendencePb.proto --java_out=../studence-attendence/src/main/java

cd ..

echo "=================================================================================================="
echo "************************************ Protobuf Compilation Done ***********************************"
echo "=================================================================================================="
