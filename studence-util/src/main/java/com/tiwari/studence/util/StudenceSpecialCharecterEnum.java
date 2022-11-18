package com.tiwari.studence.util;

import org.apache.commons.text.StringEscapeUtils;

public enum StudenceSpecialCharecterEnum {

  UNKNIOWN("", ""),
  EXCLAMATION("!", StringEscapeUtils.escapeJava("!")),
  DOUBLE_QUOTE("\"", StringEscapeUtils.escapeJava("\"")),
  HASH_SIGN("#", StringEscapeUtils.escapeJava("#")),
  DOLLER_SIGN("$", StringEscapeUtils.escapeJava("$")),
  PERCENTAGE_SIGN("%", StringEscapeUtils.escapeJava("%")),
  AMPERSAND_SIGN("&", StringEscapeUtils.escapeJava("&")),
  SINGLE_QUOTE("\'", StringEscapeUtils.escapeJava("\'")),
  LEFT_PARENTHESIS("(", StringEscapeUtils.escapeJava("(")),
  RIGHT_PARENTHESIS(")", StringEscapeUtils.escapeJava(")")),
  ASTERISK("*", StringEscapeUtils.escapeJava("*")),
  PLUS("+", StringEscapeUtils.escapeJava("+")),
  COMMA(",", StringEscapeUtils.escapeJava(",")),
  MINUS("-", StringEscapeUtils.escapeJava("-")),
  DOT(".", StringEscapeUtils.escapeJava(".")),
  FORWARD_SLASH("/", StringEscapeUtils.escapeJava("/")),
  COLON(":", StringEscapeUtils.escapeJava(":")),
  SEMI_COLOAN(";", StringEscapeUtils.escapeJava(";")),
  LESS_THEN("<", StringEscapeUtils.escapeJava("<")),
  EQUAL_SIGN("=", StringEscapeUtils.escapeJava("=")),
  GREATER_THEN(">", StringEscapeUtils.escapeJava(">")),
  QUESTION_MARK("?", StringEscapeUtils.escapeJava("?")),
  AT_SIGN("@", StringEscapeUtils.escapeJava("@")),
  LEFT_BRACKET("[", StringEscapeUtils.escapeJava("[")),
  BACK_SLASH("\\", StringEscapeUtils.escapeJava("\\")),
  RIGHT_BRACKET("]", StringEscapeUtils.escapeJava("]")),
  CARET("^", StringEscapeUtils.escapeJava("^")),
  UNDERSCORE("_", StringEscapeUtils.escapeJava("_")),
  GRAVE_ACCENT("`", StringEscapeUtils.escapeJava("`")),
  LEFT_BRACE("{", StringEscapeUtils.escapeJava("{")),
  PIPE("|", StringEscapeUtils.escapeJava("|")),
  RIGHT_BRACE("}", StringEscapeUtils.escapeJava("}")),
  TiLDE("~", StringEscapeUtils.escapeJava("~"));

  private final String m_signVal;
  private final String m_uniVal;

  StudenceSpecialCharecterEnum(String signval, String uniVal) {
    m_signVal = signval;
    m_uniVal = uniVal;
  }

  public String getSign() {
    return m_signVal;
  }
  
  public String getUnicode() {
    return m_uniVal;
  }

}
