package com.tiwari.studence.uiParser.enums;

public enum HtmlTag {
  A("<a>"),
  ABBR("<abbr>"),
  ADDRESS("<address>"),
  H1("<h1>"),
  H2("<h2>"),
  H3("<h3>"),
  H4("<h4>"),
  H5("<h5>"),
  H6("<h6>"),
  CENTER("<center>"),
  INPUT("<input>"),
  FORM("<form>");

  private final String tag;

  HtmlTag(String tag) {
    this.tag = tag;
  }

  public String getTag() {
    return tag;
  }
}
