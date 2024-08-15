package com.tiwari.studence.uiParser.Helper;

import com.tiwari.studence.proto.datatypes.BooleanEnum;
import com.tiwari.studence.proto.htmlWidgets.*;
import com.tiwari.studence.uiParser.enums.HtmlAttributes;
import org.jsoup.nodes.Attributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Helper {

  public HeadingConfigPb getHeaingConfig(String tag, String text) {
    HeadingConfigPb.Builder headingConfigBuilder = HeadingConfigPb.newBuilder();
    switch (tag) {
    case "h1":
      headingConfigBuilder.setFontSize(28);
      headingConfigBuilder.setFontWeight(FontWeightTypeEnum.BOLD);
      break;
    case "h2":
      headingConfigBuilder.setFontSize(24);
      headingConfigBuilder.setFontWeight(FontWeightTypeEnum.BOLD);
      break;
    case "h3":
      headingConfigBuilder.setFontSize(20);
      headingConfigBuilder.setFontWeight(FontWeightTypeEnum.W500);
      break;
    case "h4":
      headingConfigBuilder.setFontSize(18);
      headingConfigBuilder.setFontWeight(FontWeightTypeEnum.NORMAL);
      break;
    case "h5":
      headingConfigBuilder.setFontSize(26);
      headingConfigBuilder.setFontWeight(FontWeightTypeEnum.NORMAL);
      break;
    case "h6":
      headingConfigBuilder.setFontSize(24);
      headingConfigBuilder.setFontWeight(FontWeightTypeEnum.NORMAL);
      break;
    }
    headingConfigBuilder.setFontValue(text);
    return headingConfigBuilder.build();
  }

  public ConfigPb getConfig(ConfigPb.Builder configbuilder, Attributes config,
          boolean requiredNeeded, boolean chekedNeeded) {
    System.out.println(config);
    for (HtmlAttributes attr : Arrays.stream(HtmlAttributes.values()).toList()) {
      if (!config.get(attr.getTag()).isEmpty()) {
        switch (attr.getTag()) {
        case "style":
          Map<String, String> confgMap = getStyleMap(config.get(attr.getTag()));
          getConfigFromMap(configbuilder, confgMap);
          break;
        case "type":
          if (config.get(HtmlAttributes.TYPE.getTag()).trim()
                  .equals(HtmlAttributes.TEXT.getTag())) {
            configbuilder.getInputBoxConfigBuilder().setType(InputBoxTypeEnum.NORMAL_TEXT);
          } else if (config.get(HtmlAttributes.TYPE.getTag()).trim()
                  .equals(HtmlAttributes.PASSWORD.getTag())) {
            configbuilder.getInputBoxConfigBuilder().setType(InputBoxTypeEnum.PASSWORD);
          } else if (config.get(HtmlAttributes.TYPE.getTag()).trim()
                  .equals(HtmlAttributes.CHECKBOX.getTag())) {
            // to be added.
          } else {
            configbuilder.getInputBoxConfigBuilder().setType(InputBoxTypeEnum.UNKNOWN_INPUT_TYPE);
          }
          if (requiredNeeded) {
            if (config.hasKey(HtmlAttributes.REQUIRED.getTag())) {
              configbuilder.getInputBoxConfigBuilder().setIsRequired(BooleanEnum.TRUE);
            } else {
              configbuilder.getInputBoxConfigBuilder().setIsRequired(BooleanEnum.FALSE);
            }
          }
          if (chekedNeeded) {
            if (config.hasKey(HtmlAttributes.CHECKED.getTag())) {
              configbuilder.getCheckboxConfigBuilder().setIsChecked(BooleanEnum.TRUE);
            } else {
              configbuilder.getCheckboxConfigBuilder().setIsChecked(BooleanEnum.FALSE);
            }
          }

          break;
        case "placeholder":
          configbuilder.getInputBoxConfigBuilder().setPlaceHolder(config.get(attr.getTag()));
          break;
        case "name":
          configbuilder.getInputBoxConfigBuilder().setName(config.get(attr.getTag()));
          break;
        default:
          break;
        }
      }
    }
    return configbuilder.build();
  }

  private Map<String, String> getTypeMap(String s) {
    Map<String, String> map = new HashMap<>();

    return map;
  }

  private void getConfigFromMap(ConfigPb.Builder configbuilder, Map<String, String> confgMap) {
    for (Map.Entry<String, String> entry : confgMap.entrySet()) {
      switch (entry.getKey()) {
      case "padding":
        PaddingPb.Builder paddingBu = PaddingPb.newBuilder();
        if (entry.getValue().trim().contains("px")) {
          paddingBu.setUnit(ValueUnitTypeEnum.PX);
        } else {
          //code will add
        }
        if (entry.getValue().trim().contains(" ")) {
          paddingBu.setPaddingType(ValueTypeEnum.MULTIPLE_VALUE);
          String[] paddingSplit = entry.getValue().trim().split(" ");
          if (paddingSplit.length > 2) {
            paddingBu.getMultipleValuesBuilder()
                    .setTop(Double.valueOf(paddingSplit[0].replace("px", "")));
            paddingBu.getMultipleValuesBuilder()
                    .setRight(Double.valueOf(paddingSplit[1].replace("px", "")));
            paddingBu.getMultipleValuesBuilder()
                    .setBottom(Double.valueOf(paddingSplit[2].replace("px", "")));
            paddingBu.getMultipleValuesBuilder()
                    .setLeft(Double.valueOf(paddingSplit[3].replace("px", "")));
          } else {
            paddingBu.getMultipleValuesBuilder()
                    .setTop(Double.valueOf(paddingSplit[0].replace("px", "")));
            paddingBu.getMultipleValuesBuilder()
                    .setRight(Double.valueOf(paddingSplit[1].replace("px", "")));
            paddingBu.getMultipleValuesBuilder()
                    .setBottom(Double.valueOf(paddingSplit[0].replace("px", "")));
            paddingBu.getMultipleValuesBuilder()
                    .setLeft(Double.valueOf(paddingSplit[1].replace("px", "")));
          }
        } else {
          paddingBu.setPaddingType(ValueTypeEnum.SINGLE_VALUE);
          paddingBu.setValue(Double.valueOf(entry.getValue().trim().replace("px", "")));
        }
        configbuilder.setPadding(paddingBu.build());
        break;
      case "width":
        WidthPb.Builder widthBu = WidthPb.newBuilder();
        if (entry.getValue().trim().contains("px")) {
          widthBu.setUnit(ValueUnitTypeEnum.PX);
        } else {
          widthBu.setUnit(ValueUnitTypeEnum.PERCENT);
        }
        if (entry.getValue().trim().contains(" ")) {
          widthBu.setWidthType(ValueTypeEnum.MULTIPLE_VALUE);
          String[] paddingSplit = entry.getValue().trim().split(" ");
          if (paddingSplit.length > 2) {
            widthBu.getMultipleValuesBuilder()
                    .setTop(Double.valueOf(paddingSplit[0].replace("px", "")));
            widthBu.getMultipleValuesBuilder()
                    .setRight(Double.valueOf(paddingSplit[1].replace("px", "")));
            widthBu.getMultipleValuesBuilder()
                    .setBottom(Double.valueOf(paddingSplit[2].replace("px", "")));
            widthBu.getMultipleValuesBuilder()
                    .setLeft(Double.valueOf(paddingSplit[3].replace("px", "")));
          } else {
            widthBu.getMultipleValuesBuilder()
                    .setTop(Double.valueOf(paddingSplit[0].replace("px", "")));
            widthBu.getMultipleValuesBuilder()
                    .setRight(Double.valueOf(paddingSplit[1].replace("px", "")));
            widthBu.getMultipleValuesBuilder()
                    .setBottom(Double.valueOf(paddingSplit[0].replace("px", "")));
            widthBu.getMultipleValuesBuilder()
                    .setLeft(Double.valueOf(paddingSplit[1].replace("px", "")));
          }
        } else {
          widthBu.setWidthType(ValueTypeEnum.SINGLE_VALUE);
          if (entry.getValue().trim().contains("px")) {
            widthBu.setValue(Double.valueOf(entry.getValue().trim().replace("px", "")));
          } else if (entry.getValue().trim().contains("%")) {
            widthBu.setValue(Double.valueOf(entry.getValue().trim().replace("%", "")));
          }

        }
        configbuilder.setWidthConfig(widthBu.build());
        break;
      case "margin":
        MarginPb.Builder marginBu = MarginPb.newBuilder();
        if (entry.getValue().trim().contains("px")) {
          marginBu.setUnit(ValueUnitTypeEnum.PX);
        } else {
          marginBu.setUnit(ValueUnitTypeEnum.PERCENT);
        }
        if (entry.getValue().trim().contains(" ")) {
          marginBu.setMarginType(ValueTypeEnum.MULTIPLE_VALUE);
          String[] paddingSplit = entry.getValue().trim().split(" ");
          if (paddingSplit.length > 2) {
            marginBu.getMultipleValuesBuilder()
                    .setTop(Double.valueOf(paddingSplit[0].replace("px", "")));
            marginBu.getMultipleValuesBuilder()
                    .setRight(Double.valueOf(paddingSplit[1].replace("px", "")));
            marginBu.getMultipleValuesBuilder()
                    .setBottom(Double.valueOf(paddingSplit[2].replace("px", "")));
            marginBu.getMultipleValuesBuilder()
                    .setLeft(Double.valueOf(paddingSplit[3].replace("px", "")));
          } else {
            marginBu.getMultipleValuesBuilder()
                    .setTop(Double.valueOf(paddingSplit[0].replace("px", "")));
            marginBu.getMultipleValuesBuilder()
                    .setRight(Double.valueOf(paddingSplit[1].replace("px", "")));
            marginBu.getMultipleValuesBuilder()
                    .setBottom(Double.valueOf(paddingSplit[0].replace("px", "")));
            marginBu.getMultipleValuesBuilder()
                    .setLeft(Double.valueOf(paddingSplit[1].replace("px", "")));
          }
        } else {
          marginBu.setMarginType(ValueTypeEnum.SINGLE_VALUE);
          if (entry.getValue().trim().contains("px")) {
            marginBu.setValue(Double.valueOf(entry.getValue().trim().replace("px", "")));
          } else if (entry.getValue().trim().contains("%")) {
            marginBu.setValue(Double.valueOf(entry.getValue().trim().replace("%", "")));
          }

        }
        configbuilder.setMarginConfig(marginBu.build());
        break;
      case "border":
        BorderConfigPb.Builder borderConfigPb = BorderConfigPb.newBuilder();
        if (countOccurrencesOfPx(entry.getValue().trim(), "px") > 1) {
          //code to be added
        } else {
          borderConfigPb.setBorderValueType(ValueTypeEnum.SINGLE_VALUE);
          borderConfigPb.setUnit(ValueUnitTypeEnum.PX);
          String[] borderSplit = entry.getValue().trim().split(" ");
          for (String item : Arrays.stream(borderSplit).toList()) {
            if (item.contains("px")) {
              borderConfigPb.setValue(Double.valueOf(item.trim().replace("px", "")));
            } else if (item.contains("#")) {
              ColorPb.Builder colorPb = ColorPb.newBuilder();
              colorPb.setColorType(ColorTypeEnum.HEXCODE);
              colorPb.setHexCodeBackgroundColor(getColorCode(item.trim()));
              borderConfigPb.setColor(colorPb.build());
            } else {
              if (item.equals(HtmlAttributes.SOLID.getTag())) {
                borderConfigPb.setBorderType(BorderTypeEnum.SOLID);
              } else if (item.equals(HtmlAttributes.DOTTED.getTag())) {
                borderConfigPb.setBorderType(BorderTypeEnum.DOTTED);
              } else if (item.equals(HtmlAttributes.DASHED.getTag())) {
                borderConfigPb.setBorderType(BorderTypeEnum.DASHED);
              }
            }
          }
        }
        configbuilder.setBorderConfig(borderConfigPb.build());
        break;
      case "background-color":
        ColorPb.Builder colorBu = ColorPb.newBuilder();
        if (entry.getValue().trim().contains("#")) {
          colorBu.setColorType(ColorTypeEnum.HEXCODE);
          colorBu.setHexCodeBackgroundColor(getColorCode(entry.getValue().trim()));
        } else {
          //
        }
        configbuilder.setColorConfig(colorBu.build());
        break;
      }
    }
  }

  private String getColorCode(String code) {
    return code.replace("#", "0xFF");
  }

  private Map<String, String> getStyleMap(String s) {
    s = s.replace("\"", "");
    System.out.println(s);
    Map<String, String> map = new HashMap<>();
    if (s.contains(";")) {
      String[] items = s.split(";");
      for (String item : Arrays.stream(items).toList()) {
        String[] keyValue = item.split(":");
        map.put(keyValue[0], keyValue[1]);
      }
    } else {
      String[] keyValue = s.split(":");
      map.put(keyValue[0], keyValue[1]);
    }
    return map;
  }

  public int countOccurrencesOfPx(String str, String tocount) {
    int count = 0;
    int index = str.indexOf(tocount);
    while (index != -1) {
      count++;
      index = str.indexOf(tocount, index + 2); // Search for next occurrence after the current one
    }
    return count;
  }

}
