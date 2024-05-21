package com.tiwari.studence.common.service.v2.idGenerator;

import com.tiwari.studence.proto.exponentialDelay.ExponentialDelayPb;

public class ExponentialDelayCalculator {
  public int exponentialDelay(ExponentialDelayPb expDelay, int tryNo) {
    if (tryNo == 0) {
      return 0;
    }
    return (int) (Math.pow(expDelay.getBaseDelay(), tryNo));
  }

  public int maxDelay(ExponentialDelayPb expDelay) {
    int totalDelay = 0;
    for (int tryNo = 0; tryNo <= expDelay.getMaxTries(); tryNo++) {
      totalDelay += exponentialDelay(expDelay, tryNo);
    }
    return 2 * totalDelay; // A fairly conservative delay
  }
}
