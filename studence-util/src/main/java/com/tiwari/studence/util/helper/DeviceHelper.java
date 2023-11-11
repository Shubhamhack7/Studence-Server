package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.devices.*;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.entity.EntityUtilHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DeviceHelper {

  @Inject
  DeviceHelper() {
  }

  public void updateDeviceScreenSize(DeviceScreenSize.Builder updateBuilder,
          DeviceScreenSize builder) {
    if (builder.getHieght() > 0) {
      updateBuilder.setHieght(builder.getHieght());
    }
    if (builder.getWidth() > 0) {
      updateBuilder.setWidth(builder.getWidth());
    }
  }

  public void updateLinuxDeviceInfoDetails(LinuxDeviceInfoDetails.Builder updateBuilder,
          LinuxDeviceInfoDetails builder) {
    if (Strings.notEmpty(builder.getName())) {
      updateBuilder.setName(builder.getName());
    }
    if (Strings.notEmpty(builder.getVersion())) {
      updateBuilder.setVersion(builder.getVersion());
    }
    if (Strings.notEmpty(builder.getId())) {
      updateBuilder.setId(builder.getId());
    }
    if (!builder.getIdLikeList().isEmpty()) {
      updateBuilder.clearIdLike().addAllIdLike(builder.getIdLikeList());
    }
    if (Strings.notEmpty(builder.getVersionCodename())) {
      updateBuilder.setVersionCodename(builder.getVersionCodename());
    }
    if (Strings.notEmpty(builder.getVersionId())) {
      updateBuilder.setVersionId(builder.getVersionId());
    }
    if (Strings.notEmpty(builder.getPrettyName())) {
      updateBuilder.setPrettyName(builder.getPrettyName());
    }
    if (Strings.notEmpty(builder.getBuildId())) {
      updateBuilder.setBuildId(builder.getBuildId());
    }
    if (Strings.notEmpty(builder.getVariant())) {
      updateBuilder.setVariant(builder.getVariant());
    }
    if (Strings.notEmpty(builder.getVariantId())) {
      updateBuilder.setVariantId(builder.getVariantId());
    }
    if (Strings.notEmpty(builder.getMachineId())) {
      updateBuilder.setMachineId(builder.getMachineId());
    }
  }

  public void updateWebBrowserInfoDetails(WebBrowserInfoDetails.Builder updateBuilder,
          WebBrowserInfoDetails builder) {
    if (Strings.notEmpty(builder.getBrowserName())) {
      updateBuilder.setBrowserName(builder.getBrowserName());
    }
    if (Strings.notEmpty(builder.getAppCodeName())) {
      updateBuilder.setAppCodeName(builder.getAppCodeName());
    }
    if (Strings.notEmpty(builder.getAppName())) {
      updateBuilder.setAppName(builder.getAppName());
    }
    if (Strings.notEmpty(builder.getAppVersion())) {
      updateBuilder.setAppVersion(builder.getAppVersion());
    }
    if (builder.getDeviceMemory() > 0) {
      updateBuilder.setDeviceMemory(builder.getDeviceMemory());
    }
    if (Strings.notEmpty(builder.getLanguage())) {
      updateBuilder.setLanguage(builder.getLanguage());
    }
    if (!builder.getLanguagesList().isEmpty()) {
      updateBuilder.clearLanguages().addAllLanguages(builder.getLanguagesList());
    }
    if (Strings.notEmpty(builder.getPlatform())) {
      updateBuilder.setPlatform(builder.getPlatform());
    }
    if (Strings.notEmpty(builder.getProduct())) {
      updateBuilder.setProduct(builder.getProduct());
    }
    if (Strings.notEmpty(builder.getProductSub())) {
      updateBuilder.setProductSub(builder.getProductSub());
    }
    if (Strings.notEmpty(builder.getUserAgent())) {
      updateBuilder.setUserAgent(builder.getUserAgent());
    }
    if (Strings.notEmpty(builder.getVendor())) {
      updateBuilder.setVendor(builder.getVendor());
    }
    if (Strings.notEmpty(builder.getVendorSub())) {
      updateBuilder.setVendorSub(builder.getVendorSub());
    }
    if (builder.getHardwareConcurrency() > 0) {
      updateBuilder.setHardwareConcurrency(builder.getHardwareConcurrency());
    }
    if (builder.getMaxTouchPoints() > 0) {
      updateBuilder.setMaxTouchPoints(builder.getMaxTouchPoints());
    }
  }

  public void updateMacOSDeviceDetails(MacOSDeviceDetails.Builder updateBuilder,
          MacOSDeviceDetails builder) {
    if (Strings.notEmpty(builder.getComputerName())) {
      updateBuilder.setComputerName(builder.getComputerName());
    }
    if (Strings.notEmpty(builder.getHostName())) {
      updateBuilder.setHostName(builder.getHostName());
    }
    if (Strings.notEmpty(builder.getArch())) {
      updateBuilder.setArch(builder.getArch());
    }
    if (Strings.notEmpty(builder.getModel())) {
      updateBuilder.setModel(builder.getModel());
    }
    if (Strings.notEmpty(builder.getKernelVersion())) {
      updateBuilder.setKernelVersion(builder.getKernelVersion());
    }
    if (builder.getMajorVersion() > 0) {
      updateBuilder.setMajorVersion(builder.getMajorVersion());
    }
    if (builder.getMinorVersion() > 0) {
      updateBuilder.setMinorVersion(builder.getMinorVersion());
    }
    if (builder.getPatchVersion() > 0) {
      updateBuilder.setPatchVersion(builder.getPatchVersion());
    }
    if (Strings.notEmpty(builder.getOsRelease())) {
      updateBuilder.setOsRelease(builder.getOsRelease());
    }
    if (builder.getActiveCpus() > 0) {
      updateBuilder.setActiveCpus(builder.getActiveCpus());
    }
    if (builder.getMemorySize() > 0) {
      updateBuilder.setMemorySize(builder.getMemorySize());
    }
    if (builder.getCpuFrequency() > 0) {
      updateBuilder.setCpuFrequency(builder.getCpuFrequency());
    }
    if (Strings.notEmpty(builder.getSystemGuid())) {
      updateBuilder.setSystemGuid(builder.getSystemGuid());
    }
  }

  public void updateWindowsDeviceDetails(WindowsDeviceDetails.Builder updateBuilder,
          WindowsDeviceDetails builder) {
    if (builder.getNumberOfCores() > 0) {
      updateBuilder.setNumberOfCores(builder.getNumberOfCores());
    }
    if (Strings.notEmpty(builder.getComputerName())) {
      updateBuilder.setComputerName(builder.getComputerName());
    }
    if (builder.getSystemMemoryInMegabytes() > 0) {
      updateBuilder.setSystemMemoryInMegabytes(builder.getSystemMemoryInMegabytes());
    }
    if (Strings.notEmpty(builder.getUserName())) {
      updateBuilder.setUserName(builder.getUserName());
    }
    if (builder.getMajorVersion() > 0) {
      updateBuilder.setMajorVersion(builder.getMajorVersion());
    }
    if (builder.getMinorVersion() > 0) {
      updateBuilder.setMinorVersion(builder.getMinorVersion());
    }
    if (builder.getBuildNumber() > 0) {
      updateBuilder.setBuildNumber(builder.getBuildNumber());
    }
    if (builder.getPlatformId() > 0) {
      updateBuilder.setPlatformId(builder.getPlatformId());
    }
    if (Strings.notEmpty(builder.getCsdVersion())) {
      updateBuilder.setCsdVersion(builder.getCsdVersion());
    }
    if (builder.getServicePackMajor() > 0) {
      updateBuilder.setServicePackMajor(builder.getServicePackMajor());
    }
    if (builder.getServicePackMinor() > 0) {
      updateBuilder.setServicePackMinor(builder.getServicePackMinor());
    }
    if (builder.getSuitMask() > 0) {
      updateBuilder.setSuitMask(builder.getSuitMask());
    }
    if (builder.getProductType() > 0) {
      updateBuilder.setProductType(builder.getProductType());
    }
    if (Strings.notEmpty(builder.getReserved())) {
      updateBuilder.setReserved(builder.getReserved());
    }
    if (Strings.notEmpty(builder.getBuildLab())) {
      updateBuilder.setBuildLab(builder.getBuildLab());
    }
    if (Strings.notEmpty(builder.getBuildLabEx())) {
      updateBuilder.setBuildLabEx(builder.getBuildLabEx());
    }
    if (Strings.notEmpty(builder.getDigitalProductId())) {
      updateBuilder.setDigitalProductId(builder.getDigitalProductId());
    }
    if (Strings.notEmpty(builder.getDisplayVersion())) {
      updateBuilder.setDisplayVersion(builder.getDisplayVersion());
    }
    if (Strings.notEmpty(builder.getEditionId())) {
      updateBuilder.setEditionId(builder.getEditionId());
    }
    if (Strings.notEmpty(builder.getInstallDate())) {
      updateBuilder.setInstallDate(builder.getInstallDate());
    }
    if (Strings.notEmpty(builder.getProductId())) {
      updateBuilder.setProductId(builder.getProductId());
    }
    if (Strings.notEmpty(builder.getProductName())) {
      updateBuilder.setProductName(builder.getProductName());
    }
    if (Strings.notEmpty(builder.getRegisteredOwner())) {
      updateBuilder.setRegisteredOwner(builder.getRegisteredOwner());
    }
    if (Strings.notEmpty(builder.getReleaseId())) {
      updateBuilder.setReleaseId(builder.getReleaseId());
    }
    if (Strings.notEmpty(builder.getDeviceId())) {
      updateBuilder.setDeviceId(builder.getDeviceId());
    }
  }

  public void updateIOSDeviceDetails(IOSDeviceDetails.Builder updateBuilder,
          IOSDeviceDetails builder) {
    if (Strings.notEmpty(builder.getName())) {
      updateBuilder.setName(builder.getName());
    }
    if (Strings.notEmpty(builder.getSystemName())) {
      updateBuilder.setSystemName(builder.getSystemName());
    }
    if (Strings.notEmpty(builder.getSystemVersion())) {
      updateBuilder.setSystemVersion(builder.getSystemVersion());
    }
    if (Strings.notEmpty(builder.getModel())) {
      updateBuilder.setModel(builder.getModel());
    }
    if (Strings.notEmpty(builder.getLocalizedModel())) {
      updateBuilder.setLocalizedModel(builder.getLocalizedModel());
    }
    if (Strings.notEmpty(builder.getIdentifierForVendor())) {
      updateBuilder.setIdentifierForVendor(builder.getIdentifierForVendor());
    }
    updateBuilder.setIsPhysicalDevice(builder.getIsPhysicalDevice());
    updateUtsname(updateBuilder.getUtsnameBuilder(), builder.getUtsname());
  }

  private void updateUtsname(Utsname.Builder updateBuilder, Utsname builder) {
    if (Strings.notEmpty(builder.getSysname())) {
      updateBuilder.setSysname(builder.getSysname());
    }
    if (Strings.notEmpty(builder.getNodename())) {
      updateBuilder.setNodename(builder.getNodename());
    }
    if (Strings.notEmpty(builder.getRelease())) {
      updateBuilder.setRelease(builder.getRelease());
    }
    if (Strings.notEmpty(builder.getMachine())) {
      updateBuilder.setMachine(builder.getMachine());
    }
    if (Strings.notEmpty(builder.getVersion())) {
      updateBuilder.setVersion(builder.getVersion());
    }
  }

  public void updateAndroidDeviceDetails(AndroidDeviceDetails.Builder updateBuilder,
          AndroidDeviceDetails builder) {
    if (Strings.notEmpty(builder.getSecurityPatch())) {
      updateBuilder.setSecurityPatch(builder.getSecurityPatch());
    }
    if (builder.getSdkInt() > 0) {
      updateBuilder.setSdkInt(builder.getSdkInt());
    }
    if (Strings.notEmpty(builder.getRelease())) {
      updateBuilder.setRelease(builder.getRelease());
    }
    if (builder.getPreviewSdkInt() > 0) {
      updateBuilder.setPreviewSdkInt(builder.getPreviewSdkInt());
    }
    if (Strings.notEmpty(builder.getIncremental())) {
      updateBuilder.setIncremental(builder.getIncremental());
    }
    if (Strings.notEmpty(builder.getCodename())) {
      updateBuilder.setBaseOs(builder.getCodename());
    }
    if (Strings.notEmpty(builder.getBaseOs())) {
      updateBuilder.setBaseOs(builder.getBaseOs());
    }
    if (Strings.notEmpty(builder.getBoard())) {
      updateBuilder.setBoard(builder.getBoard());
    }
    if (Strings.notEmpty(builder.getBootloader())) {
      updateBuilder.setBootloader(builder.getBootloader());
    }
    if (Strings.notEmpty(builder.getBrand())) {
      updateBuilder.setBrand(builder.getBrand());
    }
    if (Strings.notEmpty(builder.getDevice())) {
      updateBuilder.setDisplay(builder.getDisplay());
    }
    if (Strings.notEmpty(builder.getFingerprint())) {
      updateBuilder.setFingerprint(builder.getFingerprint());
    }
    if (Strings.notEmpty(builder.getHardware())) {
      updateBuilder.setHardware(builder.getHardware());
    }
    if (Strings.notEmpty(builder.getHost())) {
      updateBuilder.setHost(builder.getHost());
    }
    if (Strings.notEmpty(builder.getId())) {
      updateBuilder.setId(builder.getId());
    }
    if (Strings.notEmpty(builder.getManufacturer())) {
      updateBuilder.setManufacturer(builder.getManufacturer());
    }
    if (Strings.notEmpty(builder.getModel())) {
      updateBuilder.setModel(builder.getModel());
    }
    if (Strings.notEmpty(builder.getProduct())) {
      updateBuilder.setProduct(builder.getProduct());
    }
    if (builder.getSupported32BitAbisList().size() > 0) {
      for (String data : builder.getSupported32BitAbisList()) {
        if (Strings.notEmpty(data)) {
          updateBuilder.addSupported32BitAbis(data);
        }
      }
    }
    if (builder.getSupported64BitAbisList().size() > 0) {
      for (String data : builder.getSupported64BitAbisList()) {
        if (Strings.notEmpty(data)) {
          updateBuilder.addSupported64BitAbis(data);
        }
      }
    }
    if (builder.getSupportedAbisList().size() > 0) {
      for (String data : builder.getSupportedAbisList()) {
        if (Strings.notEmpty(data)) {
          updateBuilder.addSupportedAbis(data);
        }
      }
    }

    if (Strings.notEmpty(builder.getTags())) {
      updateBuilder.setTags(builder.getTags());
    }
    if (Strings.notEmpty(builder.getType())) {
      updateBuilder.setType(builder.getType());
    }
    updateBuilder.setIsPhysicalDevice(builder.getIsPhysicalDevice());
    if (builder.getSystemFeaturesList().size() > 0) {
      for (String data : builder.getSystemFeaturesList()) {
        if (Strings.notEmpty(data)) {
          updateBuilder.addSystemFeatures(data);
        }
      }
    }
    updateAndroidDisplayInfo(updateBuilder.getDisplayInfoBuilder(), builder.getDisplayInfo());
    if (Strings.notEmpty(builder.getSerialNumber())) {
      updateBuilder.setSerialNumber(builder.getSerialNumber());
    }
  }

  private void updateAndroidDisplayInfo(AndroidDisplayInfo.Builder updateBuilder,
          AndroidDisplayInfo builder) {
    if (builder.getDisplayHeightInches() > 0.0) {
      updateBuilder.setDisplayHeightInches(builder.getDisplayHeightInches());
    }
    if (builder.getDisplayHeightPixels() > 0) {
      updateBuilder.setDisplayHeightPixels(builder.getDisplayHeightPixels());
    }
    if (builder.getDisplayWidthInches() > 0.0) {
      updateBuilder.setDisplayWidthInches(builder.getDisplayWidthInches());
    }
    if (builder.getDisplayWidthPixels() > 0) {
      updateBuilder.setDisplayWidthPixels(builder.getDisplayWidthPixels());
    }
    if (builder.getDisplayXDpi() > 0) {
      updateBuilder.setDisplayXDpi(builder.getDisplayXDpi());
    }
    if (builder.getDisplayYDpi() > 0) {
      updateBuilder.setDisplayYDpi(builder.getDisplayYDpi());
    }
  }

  public String genreateUniqueId(DeviceDetailsPb builder) {
    StringBuilder uniqueId = new StringBuilder();
    uniqueId.append(builder.getDeviceId());
    if (EntityUtilHelper.isDbEntityNotEmpty(builder.getDbInfo())) {
      uniqueId.append(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
      uniqueId.append(
              EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(builder.getDbInfo()));
    }
    uniqueId.append(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
    uniqueId.append(builder.getDeviceIpAddress().getDeviceIpAddress());
    uniqueId.append(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
    uniqueId.append(builder.getMode().name());
    uniqueId.append(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
    uniqueId.append(builder.getDeviceType().name());
    uniqueId.append(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
    uniqueId.append(builder.getDeviceOsType().name());
    return uniqueId.toString();
  }

  public void updateDeviceIpAddress(DeviceIpAddress.Builder deviceIpAddress,
          DeviceIpAddress deviceIpAddress1) {
    if(Strings.notEmpty(deviceIpAddress.getDeviceIpAddress())){
      deviceIpAddress.setDeviceIpAddress(deviceIpAddress1.getDeviceIpAddress());
    }
    if(deviceIpAddress.getIpType()!=DeviceIPAddressType.UNKNOWN_IPADDRESS_TYPE){
      deviceIpAddress.setIpType(deviceIpAddress1.getIpType());
    }else{
      deviceIpAddress.setIpType(IPAddressCategorizer.getIPType(deviceIpAddress.getDeviceIpAddress()));
    }
  }
}
