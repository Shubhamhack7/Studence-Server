package com.tiwari.studence.common.service.v2.updater;

import com.tiwari.studence.proto.stringParser.StringParserConfigPb;
import com.tiwari.studence.proto.stringParser.StringParserConfigUiPb;

import javax.inject.Singleton;

@Singleton
public class StringParserConfigUiPbUpdater {





  public StringParserConfigPb getStringParserUiPb(
          StringParserConfigUiPb stringParserConfig) {
    StringParserConfigPb.Builder parserConfigBuilder = StringParserConfigPb
            .newBuilder();
    parserConfigBuilder.getCaseNormalizerBuilder().setIsEnabled(
            stringParserConfig.getCaseNormalizer().getIsEnabled());
    parserConfigBuilder.getCaseNormalizerBuilder().setIsEnabled(
            stringParserConfig.getCaseNormalizer().getToUppercase());

    parserConfigBuilder.getLengthRestrictionBuilder().setIsEnabled(
            stringParserConfig.getLengthRestriction().getIsEnabled());
    parserConfigBuilder.getLengthRestrictionBuilder().setMaxLength(
            stringParserConfig.getLengthRestriction().getMaxLength());
    parserConfigBuilder.getLengthRestrictionBuilder().setMinLength(
            stringParserConfig.getLengthRestriction().getMinLength());

    parserConfigBuilder.getCharRestrictionBuilder().setIsEnabled(
            stringParserConfig.getCharRestriction().getIsEnabled());
    parserConfigBuilder.getCharRestrictionBuilder().setAllowAlphabet(
            stringParserConfig.getCharRestriction().getAllowAlphabet());
    parserConfigBuilder.getCharRestrictionBuilder().setAllowNumeric(
            stringParserConfig.getCharRestriction().getAllowNumeric());
    parserConfigBuilder.getCharRestrictionBuilder()
            .addAllAllowedSpecialChars(
                    stringParserConfig.getCharRestriction()
                            .getAllowedSpecialCharsList());

    parserConfigBuilder.getSubStringChooserBuilder().setIsEnabled(
            stringParserConfig.getSubStringChooser().getIsEnabled());
    parserConfigBuilder.getSubStringChooserBuilder().setStartIndex(
            stringParserConfig.getSubStringChooser().getStartIndex());
    parserConfigBuilder.getSubStringChooserBuilder().setEndIndex(
            stringParserConfig.getSubStringChooser().getEndIndex());

    parserConfigBuilder.getSubStringEliminationBuilder().setIsEnabled(
            stringParserConfig.getSubStringElimination().getIsEnabled());
    parserConfigBuilder.getSubStringEliminationBuilder().setStartIndex(
            stringParserConfig.getSubStringElimination().getStartIndex());
    parserConfigBuilder.getSubStringEliminationBuilder().setEndIndex(
            stringParserConfig.getSubStringElimination().getEndIndex());

    return parserConfigBuilder.build();

  }

}
