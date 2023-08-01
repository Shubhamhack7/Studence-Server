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
protoc requestContextPb.proto --java_out=../studence-common/src/main/java
protoc entityPb.proto --java_out=../studence-util/src/main/java
protoc organisationPb.proto --java_out=../studence-organisation/src/main/java
cd ..
echo "=================================================================================================="
echo "************************************ Protobuf Compilation Done ***********************************"
echo "=================================================================================================="