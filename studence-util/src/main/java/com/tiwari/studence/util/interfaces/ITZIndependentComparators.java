package com.tiwari.studence.util.interfaces;

public interface ITZIndependentComparators {
  public abstract boolean isEqual(String formattedDate1, String formattedDate2);

  public abstract boolean isBefore(String formattedDate1, String formattedDate2);

  public abstract boolean isBeforeOrEqual(String formattedDate1, String formattedDate2);

  public abstract boolean isAfter(String formattedDate1, String formattedDate2);

  public abstract boolean isAfterOrEqual(String formattedDate1, String formattedDate2);
}

