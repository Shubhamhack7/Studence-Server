package com.tiwari.studence.util.formatter;

public interface IFormatterEnum<E extends Enum> {
    public String getStringValue(E e);
    public E getEnum(String S);
}
