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
<<<<<<< HEAD
rm -rf studence-login/src/main/java/com/tiwari/studence/proto
rm -rf studence-teacher/src/main/java/com/tiwari/studence/proto
rm -rf studence-student/src/main/java/com/tiwari/studence/proto
rm -rf studence-classes/src/main/java/com/tiwari/studence/proto
rm -rf studence-campus/src/main/java/com/tiwari/studence/proto
rm -rf studence-guardian/src/main/java/com/tiwari/studence/proto
rm -rf studence-attendence/src/main/java/com/tiwari/studence/proto
rm -rf studence-typeAhead/src/main/java/com/tiwari/studence/proto
rm -rf studence-devices/src/main/java/com/tiwari/studence/proto
rm -rf studence-pushNotification/src/main/java/com/tiwari/studence/proto
=======
>>>>>>> production
rm -rf studence-management-app/src/main/java/com/tiwari/studence/proto
cd studence-proto

rm -rf studence-util/src/main/proto
rm -rf studence-common/src/main/proto
rm -rf studence-database/src/main/proto
rm -rf studence-common-http/src/main/proto
rm -rf studence-organisation/src/main/proto
rm -rf studence-campus/src/main/proto
rm -rf studence-teacher/src/main/proto
rm -rf studence-student/src/main/proto
rm -rf studence-attendence/src/main/proto
rm -rf studence-management-app/src/main/proto
cd ../studence-proto

echo [COMPILEING..........]
protoc time.proto --java_out=../studence-common/src/main/java
<<<<<<< HEAD
protoc requestContextPb.proto --java_out=../studence-common/src/main/java
protoc entityPb.proto --java_out=../studence-util/src/main/java
protoc dataTypesPb.proto --java_out=../studence-util/src/main/java
protoc pushNotificationPb.proto --java_out=../studence-util/src/main/java
protoc devicePb.proto --java_out=../studence-util/src/main/java
protoc loginPb.proto --java_out=../studence-login/src/main/java
protoc typeAheadPb.proto --java_out=../studence-typeAhead/src/main/java
=======
protoc namePb.proto --java_out=../studence-util/src/main/java
protoc searchdynamodb.proto --java_out=../studence-util/src/main/java
protoc contactDetailsPb.proto --java_out=../studence-util/src/main/java
protoc error.proto --java_out=../studence-util/src/main/java
protoc requestContextPb.proto --java_out=../studence-common/src/main/java
protoc entityPb.proto --java_out=../studence-util/src/main/java
>>>>>>> production
protoc organisationPb.proto --java_out=../studence-organisation/src/main/java
cd ..
echo "=================================================================================================="
echo "************************************ Protobuf Compilation Done ***********************************"
echo "=================================================================================================="