package com.tiwari.studence.util.time;

import com.tiwari.studence.util.interfaces.ITZIndependentComparators;

public abstract class ATZIndependentComparators implements ITZIndependentComparators {
  @Override
  public boolean isBeforeOrEqual(String formattedDate1, String formattedDate2) {
    return isBefore(formattedDate1, formattedDate2) || isEqual(formattedDate1, formattedDate2);
  }

  @Override
  public boolean isAfter(String formattedDate1, String formattedDate2) {
    return !isBeforeOrEqual(formattedDate1, formattedDate2);
  }

  @Override
  public boolean isAfterOrEqual(String formattedDate1, String formattedDate2) {
    return !isBefore(formattedDate1, formattedDate2);
  }
}
