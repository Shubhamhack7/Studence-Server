echo "=================================================================================================="
echo "************************************ Protobuf Compilation ****************************************"
echo "=================================================================================================="
cd src/main/java
rm -rf proto
cd ..
cd proto
echo [COMPILEING..........]
protoc entityPb.proto --java_out=../../../src/main/java
cd ..
cd ..
cd ..
cd ..
echo "=================================================================================================="
echo "************************************ Protobuf Compilation Done ***********************************"
echo "=================================================================================================="