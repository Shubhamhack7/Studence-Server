echo "=================================================================================================="
echo "************************************ Protobuf Compilation ****************************************"
echo "=================================================================================================="
cd src/main/proto
echo [COMPILEING..........]
protoc organisationPb.proto --java_out=../../../src/main/java
cd ..
cd ..
cd ..
cd ..
echo "=================================================================================================="
echo "************************************ Protobuf Compilation Done ***********************************"
echo "=================================================================================================="