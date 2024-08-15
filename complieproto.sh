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
rm -rf studence-util/src/main/java/com/tiwari/studence/proto
rm -rf studence-common/src/main/java/com/tiwari/studence/proto
rm -rf studence-dynamodb-database/src/main/java/com/tiwari/studence/proto
rm -rf studence-common-http/src/main/java/com/tiwari/studence/proto
rm -rf studence-organisation/src/main/java/com/tiwari/studence/proto
rm -rf studence-campus/src/main/java/com/tiwari/studence/proto
rm -rf studence-teacher/src/main/java/com/tiwari/studence/proto
rm -rf studence-student/src/main/java/com/tiwari/studence/proto
rm -rf studence-attendence/src/main/java/com/tiwari/studence/proto
rm -rf studence-login/src/main/java/com/tiwari/studence/proto
rm -rf studence-teacher/src/main/java/com/tiwari/studence/proto
rm -rf studence-student/src/main/java/com/tiwari/studence/proto
rm -rf studence-classes/src/main/java/com/tiwari/studence/proto
rm -rf studence-campus/src/main/java/com/tiwari/studence/proto
rm -rf studence-guardian/src/main/java/com/tiwari/studence/proto
rm -rf studence-attendence/src/main/java/com/tiwari/studence/proto
rm -rf studence-typeAhead/src/main/java/com/tiwari/studence/proto
rm -rf studence-management-app/src/main/java/com/tiwari/studence/proto
rm -rf studence-proto/src/main/java/com/tiwari/studence/proto
cd studence-proto/src/main/protobuf
echo [COMPILEING..........]
protoc time.proto --java_out=../java
protoc htmlWidgets.proto --java_out=../java
protoc voidPb.proto --java_out=../java
protoc timePb.proto --java_out=../java
protoc schedulerPb.proto --java_out=../java
protoc summaryPb.proto --java_out=../java
protoc subjectPb.proto --java_out=../java
protoc genericRefPb.proto --java_out=../java
protoc namePb.proto --java_out=../java
protoc searchdynamodb.proto --java_out=../java
protoc contactDetailsPb.proto --java_out=../java
protoc error.proto --java_out=../java
protoc requestContextPb.proto --java_out=../java
protoc entityPb.proto --java_out=../java
protoc fileInfoPb.proto --java_out=../java
protoc pushNotificationPb.proto --java_out=../java
protoc devicePb.proto --java_out=../java
protoc dataTypesPb.proto --java_out=../java
protoc loginPb.proto --java_out=../java
protoc typeAheadPb.proto --java_out=../java
protoc organisationPb.proto --java_out=../java
protoc campusPb.proto --java_out=../java
protoc teacherPb.proto --java_out=../java
protoc classesPb.proto --java_out=../java
protoc guardianPb.proto --java_out=../java
protoc studentPb.proto --java_out=../java
protoc attendencePb.proto --java_out=../java
cd ..
cd ..
cd ..
echo "=================================================================================================="
echo "************************************ Protobuf Compilation Done ***********************************"
echo "=================================================================================================="