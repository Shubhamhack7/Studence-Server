package com.tiwari.studence.uiParser.uiParser;

import com.tiwari.studence.proto.htmlWidgets.*;
import com.tiwari.studence.uiParser.Helper.Helper;
import com.tiwari.studence.uiParser.Helper.JSONToGenerateFile;
import com.tiwari.studence.uiParser.enums.HtmlAttributes;
import com.tiwari.studence.uiParser.enums.HtmlNodeLevelEnum;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.collect.StackArray;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.protobuf.ProtobufToJson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

public class HTMLDocReaderAndParser {
  int containerCounter = 0;
  int widgetCounter = 0;
  private List<String> ids = Lists.newArrayList();
  private StackArray<HtmlNodeLevelEnum> levelStack = new StackArray<>(4);
  private Helper helper = new Helper();
  private UiPagePb.Builder pagebuilder = UiPagePb.newBuilder();
  private List<Pair<String, String>> tagAndIds = Lists.newArrayList();

  public String readHtmlFile(String filePath) throws IOException {
    ClassLoader classLoader = HTMLDocReaderAndParser.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(filePath);

    if (inputStream == null) {
      throw new IOException("File not found: " + filePath);
    }

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      StringBuilder content = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");

      }
      return content.toString();
    }
  }

  public void convertHtmlToDocument(String filePath, String fileName) throws IOException {
    levelStack.push(HtmlNodeLevelEnum.LEVEL_0);
    conversion(readHtmlFile(filePath), ContainerPb.newBuilder(), WidgetPb.newBuilder());
    levelStack.pop();
    System.out.println(ProtobufToJson.protobufToJsonString(pagebuilder.build()));
    JSONToGenerateFile.generateJSONFile(pagebuilder.build(), fileName);

  }

  void check(Element a) {
    Preconditions.checkWithString(isIdPresentinTag(a),
            "ID is missing in " + a.tagName() + " tag having attributes" + a.attributes(),
            a.toString());
  }

  private void setWidgetType(WidgetPb.Builder widgetbuilder, Element a) {
    if (a.attributes().get(HtmlAttributes.TYPE.getTag()).trim()
            .equals(HtmlAttributes.TEXT.getTag())) {
      widgetbuilder.setWidgetType(WidgetsTypeEnum.TEXT_INPUT_BOX);
    } else if (a.attributes().get(HtmlAttributes.TYPE.getTag()).trim()
            .equals(HtmlAttributes.PASSWORD.getTag())) {
      widgetbuilder.setWidgetType(WidgetsTypeEnum.TEXT_INPUT_BOX_PASSWORD);
    } else if (a.attributes().get(HtmlAttributes.TYPE.getTag()).trim()
            .equals(HtmlAttributes.EMAIL.getTag())) {
      widgetbuilder.setWidgetType(WidgetsTypeEnum.TEXT_INPUT_BOX_EMAIL);
    } else if (a.attributes().get(HtmlAttributes.TYPE.getTag()).trim()
            .equals(HtmlAttributes.CHECKBOX.getTag())) {
      widgetbuilder.setWidgetType(WidgetsTypeEnum.CHECKBOX);
      widgetbuilder.getConfigBuilder().getCheckboxConfigBuilder()
              .setCheckboxName(a.attribute(HtmlAttributes.LABEL.getTag()).getValue());
    } else {
      widgetbuilder.setWidgetType(WidgetsTypeEnum.UNKNOWN_WIDGETS);
    }
  }

  public void conversion(String htmlCode, ContainerPb.Builder containerPb,
          WidgetPb.Builder widgetbuilder) {
    Document document = Jsoup.parse(htmlCode);
    for (Element a : document.getAllElements()) {
      if (ids.contains(a.attributes().get("id").toString())) {
        continue;
      }
      switch (a.tagName()) {
      case "title":
        pagebuilder.setTile(a.text());
        break;
      case "center":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        ContainerPb.Builder centerContainorBuilder;
        if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
          centerContainorBuilder = pagebuilder.addChildrenContainerBuilder();
          centerContainorBuilder.setContainerType(ContainerTypeEnum.CENTER);
          centerContainorBuilder.setContainerPosition(++containerCounter);
        } else {
          centerContainorBuilder = containerPb;
          containerPb.setContainerType(ContainerTypeEnum.CENTER);
          containerPb.setContainerPosition(++containerCounter);
        }
        if (a.childNodeSize() > 0) {
          for (Element innertag : a.children()) {
            if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
              conversion(innertag.toString(), centerContainorBuilder,
                      centerContainorBuilder.addChildrenWidgetBuilder());
            } else {
              conversion(innertag.toString(), containerPb, containerPb.addChildrenWidgetBuilder());
            }

          }
        } else {
          //code to be added.
        }
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "h1":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        widgetbuilder.setWidgetType(WidgetsTypeEnum.TEXT_HEADING);
        widgetbuilder.setWidgetPosition(++widgetCounter);
        widgetbuilder.setWidgetId(genreateWidgetId(a.attributes().get("id").trim(), widgetCounter));
        widgetbuilder.getConfigBuilder()
                .setHeadingConfig(helper.getHeaingConfig(a.tagName(), a.text()));
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "a":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        widgetbuilder.setWidgetType(WidgetsTypeEnum.A_TAG);
        widgetbuilder.setWidgetPosition(++widgetCounter);
        widgetbuilder.setWidgetId(genreateWidgetId(a.attributes().get("id").trim(),widgetCounter));
        widgetbuilder.getConfigBuilder().getATagConfigBuilder()
                .setHref(a.attribute(HtmlAttributes.HREF.getTag()).getValue());
        widgetbuilder.getConfigBuilder().getATagConfigBuilder()
                .setLabel(a.attribute(HtmlAttributes.LABEL.getTag()).getValue());
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "body":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        ContainerPb.Builder bodyContainerBuilder;
        if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
          bodyContainerBuilder = pagebuilder.addChildrenContainerBuilder();
          bodyContainerBuilder.setContainerType(ContainerTypeEnum.BODY);
          bodyContainerBuilder.setContainerPosition(++containerCounter);
          helper.getConfig(bodyContainerBuilder.getConfigBuilder(), a.attributes(), false, false);
        } else {
          bodyContainerBuilder = containerPb;
          containerPb.setContainerType(ContainerTypeEnum.BODY);
          containerPb.setContainerPosition(++containerCounter);
          helper.getConfig(containerPb.getConfigBuilder(), a.attributes(), false, false);
        }
        if (a.childNodeSize() > 0) {
          for (Element innertag : a.children()) {
            if (innertag.tagName().equals("div") || innertag.tagName().equals("form")) {
              if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
                setStackValue(levelStack.peek());
                conversion(innertag.toString(), bodyContainerBuilder.addChildContainerBuilder(),
                        WidgetPb.newBuilder());
                levelStack.pop();
              } else {
                setStackValue(levelStack.peek());
                conversion(innertag.toString(), containerPb.addChildContainerBuilder(),
                        WidgetPb.newBuilder());
                levelStack.pop();
              }
            } else {
              if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
                conversion(innertag.toString(), bodyContainerBuilder,
                        bodyContainerBuilder.addChildrenWidgetBuilder());
              } else {
                conversion(innertag.toString(), containerPb,
                        containerPb.addChildrenWidgetBuilder());
              }
            }
          }
        } else {
          //code to be added.
        }
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "div":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        ContainerPb.Builder divContainerBuilder;
        if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
          divContainerBuilder = pagebuilder.addChildrenContainerBuilder();
          divContainerBuilder.setContainerType(ContainerTypeEnum.CONTAINER);
          divContainerBuilder.setContainerPosition(++containerCounter);
          helper.getConfig(divContainerBuilder.getConfigBuilder(), a.attributes(), false, false);
        } else {
          divContainerBuilder = containerPb;
          containerPb.setContainerType(ContainerTypeEnum.CONTAINER);
          containerPb.setContainerPosition(++containerCounter);
          helper.getConfig(containerPb.getConfigBuilder(), a.attributes(), false, false);
        }

        if (!a.children().isEmpty()) {
          for (Element divChild : a.children()) {
            System.out.println(a.tagName());
            if (divChild.tagName().equals("div") || divChild.tagName().equals("form")) {
              if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
                setStackValue(levelStack.peek());
                conversion(divChild.toString(), divContainerBuilder.addChildContainerBuilder(),
                        WidgetPb.newBuilder());
                levelStack.pop();
              } else {
                setStackValue(levelStack.peek());
                conversion(divChild.toString(), containerPb.addChildContainerBuilder(),
                        WidgetPb.newBuilder());
                levelStack.pop();
              }
            } else {
              conversion(divChild.toString(), ContainerPb.newBuilder(),
                      containerPb.addChildrenWidgetBuilder());
            }
          }
        }
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "label":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        widgetbuilder.setWidgetPosition(++widgetCounter);
        widgetbuilder.setWidgetId(genreateWidgetId(a.attributes().get("id").trim(),widgetCounter));
        widgetbuilder.setWidgetType(WidgetsTypeEnum.LABEL);
        widgetbuilder.getConfigBuilder().getLabelConfigBuilder().setLabelText(a.text());
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "button":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        widgetbuilder.setWidgetPosition(++widgetCounter);
        widgetbuilder.setWidgetId(genreateWidgetId(a.attributes().get("id").trim(),widgetCounter));
        String ab = a.attributes().get(HtmlAttributes.BUTTON_TYPE.getTag()).trim();
        if (a.attributes().get(HtmlAttributes.BUTTON_TYPE.getTag()).trim()
                .equals(HtmlAttributes.EVENT.getTag())) {
          widgetbuilder.setWidgetType(WidgetsTypeEnum.EVENT_BUTTON);
          widgetbuilder.getConfigBuilder().getButtonConfigBuilder()
                  .setButtonType(ButtonTypeEnum.EVENT);
        } else if (a.attributes().get(HtmlAttributes.BUTTON_TYPE.getTag()).trim()
                .equals(HtmlAttributes.INPUT.getTag())) {
          widgetbuilder.setWidgetType(WidgetsTypeEnum.INPUT_BUTTON);
          widgetbuilder.getConfigBuilder().getButtonConfigBuilder()
                  .setButtonType(ButtonTypeEnum.INPUT);
        } else if (a.attributes().get(HtmlAttributes.TYPE.getTag()).trim()
                .equals(HtmlAttributes.BUTTON_TYPE_SUBMIT.getTag())) {
          widgetbuilder.getConfigBuilder().getButtonConfigBuilder()
                  .setButtonType(ButtonTypeEnum.EVENT);
        } else {
          //widgetbuilder.setWidgetType(WidgetsTypeEnum.UNKNOWN_WIDGETS);
        }
        widgetbuilder.getConfigBuilder().getButtonConfigBuilder().getEventButtonBuilder()
                .setLabel(a.text());
        helper.getConfig(widgetbuilder.getConfigBuilder(), a.attributes(), false, false);
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "input":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        widgetbuilder.setWidgetPosition(++widgetCounter);
        widgetbuilder.setWidgetId(genreateWidgetId(a.attributes().get("id").trim(),widgetCounter));
        setWidgetType(widgetbuilder,a);
        helper.getConfig(widgetbuilder.getConfigBuilder(), a.attributes(), true, true);
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      case "form":
        if (a.attributes().asList().isEmpty()) {
          break;
        }
        check(a);
        ContainerPb.Builder formContainerBuilder;
        if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
          formContainerBuilder = pagebuilder.addChildrenContainerBuilder();
          formContainerBuilder.setContainerType(ContainerTypeEnum.FORM);
          formContainerBuilder.setLayoutType(helper.getFormLayout(a.attributes().get("style")));
          formContainerBuilder.setContainerPosition(++containerCounter);
        } else {
          formContainerBuilder = containerPb;
          containerPb.setContainerType(ContainerTypeEnum.FORM);
          containerPb.setContainerPosition(++containerCounter);
        }
        helper.getConfig(widgetbuilder.getConfigBuilder(), a.attributes(), false, false);
        if (a.childNodeSize() > 0) {
          for (Element innertag : a.children()) {
            if (innertag.tagName().equals("div") || innertag.tagName().equals("form")) {
              if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
                setStackValue(levelStack.peek());
                conversion(innertag.toString(), formContainerBuilder.addChildContainerBuilder(),
                        WidgetPb.newBuilder());
                levelStack.pop();
              } else {
                setStackValue(levelStack.peek());
                conversion(innertag.toString(), containerPb.addChildContainerBuilder(),
                        WidgetPb.newBuilder());
                levelStack.pop();
              }
            } else {
              if (levelStack.peek() == HtmlNodeLevelEnum.LEVEL_0) {
                conversion(innertag.toString(), formContainerBuilder,
                        formContainerBuilder.addChildrenWidgetBuilder());
              } else {
                conversion(innertag.toString(), containerPb,
                        containerPb.addChildrenWidgetBuilder());
              }
            }
          }
        } else {
          //code to be added.
        }
        ids.add(a.attributes().get("id").toString());
        tagAndIds.add(new Pair<>(a.tagName(), a.attributes().get("id").trim()));
        break;
      }

      // System.out.println(a);
      //System.out.println("------------------------===-----------------------------");
    }

  }

  private String genreateWidgetId(String id, int widgetCounter) {
    return StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + id + StudenceSpecialCharecterEnum.UNDERSCORE.getSign() + String.valueOf(
            widgetCounter);
  }

  private boolean isIdPresentinTag(Element a) {
    String id = a.attributes().get("id");
    if (id.trim().isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  private void setStackValue(HtmlNodeLevelEnum peek) {
    switch (peek) {
    case LEVEL_0:
      levelStack.push(HtmlNodeLevelEnum.LEVEL_1);
      break;
    case LEVEL_1:
      levelStack.push(HtmlNodeLevelEnum.LEVEL_2);
      break;
    case LEVEL_2:
      levelStack.push(HtmlNodeLevelEnum.LEVEL_3);
      break;
    case LEVEL_3:
      break;

    }

  }

}