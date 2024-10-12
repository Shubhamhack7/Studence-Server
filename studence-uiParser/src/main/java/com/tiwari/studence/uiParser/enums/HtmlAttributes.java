package com.tiwari.studence.uiParser.enums;

public enum HtmlAttributes {
  STYLE("style"),
  TYPE("type"),
  NAME("name"),
  PLACE_HOLDER("placeholder"),
  PADDING("padding"),
  BACKGROUND_COLOR("background-color"),
  TEXT("text"),
  PASSWORD("password"),
  SOLID("solid"),
  DOTTED("dotted"),
  DASHED("dashed"),
  HREF("href"),
  CHECKBOX("checkbox"),
  BUTTON_TYPE_SUBMIT("submit"),
  BUTTON_TYPE("button_type"),
  CHECKED("checked"),
  EVENT("event"),
  INPUT("input"),
  LABEL("label"),
  HEIGHT("height"),
  WIDTH("width"),
  EMAIL("email"),
  PHONE("phone"),
  PHONE_AND_EMAIL("phone_and_email"),
  REQUIRED("required");

  private final String tag;

  HtmlAttributes(String tag) {
    this.tag = tag;
  }

  public String getTag() {
    return tag;
  }
}
