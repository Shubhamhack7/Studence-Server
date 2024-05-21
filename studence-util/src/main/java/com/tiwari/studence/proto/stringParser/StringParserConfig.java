// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stringParserConfig.proto

package com.tiwari.studence.proto.stringParser;

public final class StringParserConfig {
  private StringParserConfig() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_SubStringPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_SubStringPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigUiPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigUiPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionUiPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionUiPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionUiPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionUiPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_SubStringUiPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_SubStringUiPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerUiPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerUiPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030stringParserConfig.proto\022&com.tiwari.s" +
      "tudence.proto.stringParser\"\300\004\n\024StringPar" +
      "serConfigPb\022[\n\021lengthRestriction\030\001 \001(\0132;" +
      ".com.tiwari.studence.proto.stringParser." +
      "LengthRestrictionPbH\000\210\001\001\022]\n\017charRestrict" +
      "ion\030\002 \001(\0132?.com.tiwari.studence.proto.st" +
      "ringParser.CharactersRestrictionPbH\001\210\001\001\022" +
      "R\n\020subStringChooser\030\003 \001(\01323.com.tiwari.s" +
      "tudence.proto.stringParser.SubStringPbH\002" +
      "\210\001\001\022V\n\024subStringElimination\030\004 \001(\01323.com." +
      "tiwari.studence.proto.stringParser.SubSt" +
      "ringPbH\003\210\001\001\022U\n\016caseNormalizer\030\005 \001(\01328.co" +
      "m.tiwari.studence.proto.stringParser.Cas" +
      "eNormalizerPbH\004\210\001\001B\024\n\022_lengthRestriction" +
      "B\022\n\020_charRestrictionB\023\n\021_subStringChoose" +
      "rB\027\n\025_subStringEliminationB\021\n\017_caseNorma" +
      "lizer\"\207\001\n\023LengthRestrictionPb\022\026\n\tisEnabl" +
      "ed\030\001 \001(\010H\000\210\001\001\022\026\n\tmaxLength\030\002 \001(\005H\001\210\001\001\022\026\n" +
      "\tminLength\030\003 \001(\005H\002\210\001\001B\014\n\n_isEnabledB\014\n\n_" +
      "maxLengthB\014\n\n_minLength\"\266\001\n\027CharactersRe" +
      "strictionPb\022\026\n\tisEnabled\030\001 \001(\010H\000\210\001\001\022\031\n\014a" +
      "llowNumeric\030\002 \001(\010H\001\210\001\001\022\032\n\rallowAlphabet\030" +
      "\003 \001(\010H\002\210\001\001\022\033\n\023allowedSpecialChars\030\004 \003(\tB" +
      "\014\n\n_isEnabledB\017\n\r_allowNumericB\020\n\016_allow" +
      "Alphabet\"\177\n\013SubStringPb\022\026\n\tisEnabled\030\001 \001" +
      "(\010H\000\210\001\001\022\027\n\nstartIndex\030\002 \001(\005H\001\210\001\001\022\025\n\010endI" +
      "ndex\030\003 \001(\005H\002\210\001\001B\014\n\n_isEnabledB\r\n\013_startI" +
      "ndexB\013\n\t_endIndex\"b\n\020CaseNormalizerPb\022\026\n" +
      "\tisEnabled\030\001 \001(\010H\000\210\001\001\022\030\n\013toUppercase\030\002 \001" +
      "(\010H\001\210\001\001B\014\n\n_isEnabledB\016\n\014_toUppercase\"\314\004" +
      "\n\026StringParserConfigUiPb\022]\n\021lengthRestri" +
      "ction\030\001 \001(\0132=.com.tiwari.studence.proto." +
      "stringParser.LengthRestrictionUiPbH\000\210\001\001\022" +
      "_\n\017charRestriction\030\002 \001(\0132A.com.tiwari.st" +
      "udence.proto.stringParser.CharactersRest" +
      "rictionUiPbH\001\210\001\001\022T\n\020subStringChooser\030\003 \001" +
      "(\01325.com.tiwari.studence.proto.stringPar" +
      "ser.SubStringUiPbH\002\210\001\001\022X\n\024subStringElimi" +
      "nation\030\004 \001(\01325.com.tiwari.studence.proto" +
      ".stringParser.SubStringUiPbH\003\210\001\001\022W\n\016case" +
      "Normalizer\030\005 \001(\0132:.com.tiwari.studence.p" +
      "roto.stringParser.CaseNormalizerUiPbH\004\210\001" +
      "\001B\024\n\022_lengthRestrictionB\022\n\020_charRestrict" +
      "ionB\023\n\021_subStringChooserB\027\n\025_subStringEl" +
      "iminationB\021\n\017_caseNormalizer\"\211\001\n\025LengthR" +
      "estrictionUiPb\022\026\n\tisEnabled\030\001 \001(\010H\000\210\001\001\022\026" +
      "\n\tmaxLength\030\002 \001(\005H\001\210\001\001\022\026\n\tminLength\030\003 \001(" +
      "\005H\002\210\001\001B\014\n\n_isEnabledB\014\n\n_maxLengthB\014\n\n_m" +
      "inLength\"\270\001\n\031CharactersRestrictionUiPb\022\026" +
      "\n\tisEnabled\030\001 \001(\010H\000\210\001\001\022\031\n\014allowNumeric\030\002" +
      " \001(\010H\001\210\001\001\022\032\n\rallowAlphabet\030\003 \001(\010H\002\210\001\001\022\033\n" +
      "\023allowedSpecialChars\030\004 \003(\tB\014\n\n_isEnabled" +
      "B\017\n\r_allowNumericB\020\n\016_allowAlphabet\"\201\001\n\r" +
      "SubStringUiPb\022\026\n\tisEnabled\030\001 \001(\010H\000\210\001\001\022\027\n" +
      "\nstartIndex\030\002 \001(\005H\001\210\001\001\022\025\n\010endIndex\030\003 \001(\005" +
      "H\002\210\001\001B\014\n\n_isEnabledB\r\n\013_startIndexB\013\n\t_e" +
      "ndIndex\"d\n\022CaseNormalizerUiPb\022\026\n\tisEnabl" +
      "ed\030\001 \001(\010H\000\210\001\001\022\030\n\013toUppercase\030\002 \001(\010H\001\210\001\001B" +
      "\014\n\n_isEnabledB\016\n\014_toUppercaseB\005P\001\240\001\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigPb_descriptor,
        new java.lang.String[] { "LengthRestriction", "CharRestriction", "SubStringChooser", "SubStringElimination", "CaseNormalizer", "LengthRestriction", "CharRestriction", "SubStringChooser", "SubStringElimination", "CaseNormalizer", });
    internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionPb_descriptor,
        new java.lang.String[] { "IsEnabled", "MaxLength", "MinLength", "IsEnabled", "MaxLength", "MinLength", });
    internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_descriptor,
        new java.lang.String[] { "IsEnabled", "AllowNumeric", "AllowAlphabet", "AllowedSpecialChars", "IsEnabled", "AllowNumeric", "AllowAlphabet", });
    internal_static_com_tiwari_studence_proto_stringParser_SubStringPb_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tiwari_studence_proto_stringParser_SubStringPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_SubStringPb_descriptor,
        new java.lang.String[] { "IsEnabled", "StartIndex", "EndIndex", "IsEnabled", "StartIndex", "EndIndex", });
    internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerPb_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerPb_descriptor,
        new java.lang.String[] { "IsEnabled", "ToUppercase", "IsEnabled", "ToUppercase", });
    internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigUiPb_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigUiPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_StringParserConfigUiPb_descriptor,
        new java.lang.String[] { "LengthRestriction", "CharRestriction", "SubStringChooser", "SubStringElimination", "CaseNormalizer", "LengthRestriction", "CharRestriction", "SubStringChooser", "SubStringElimination", "CaseNormalizer", });
    internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionUiPb_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionUiPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_LengthRestrictionUiPb_descriptor,
        new java.lang.String[] { "IsEnabled", "MaxLength", "MinLength", "IsEnabled", "MaxLength", "MinLength", });
    internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionUiPb_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionUiPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionUiPb_descriptor,
        new java.lang.String[] { "IsEnabled", "AllowNumeric", "AllowAlphabet", "AllowedSpecialChars", "IsEnabled", "AllowNumeric", "AllowAlphabet", });
    internal_static_com_tiwari_studence_proto_stringParser_SubStringUiPb_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_com_tiwari_studence_proto_stringParser_SubStringUiPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_SubStringUiPb_descriptor,
        new java.lang.String[] { "IsEnabled", "StartIndex", "EndIndex", "IsEnabled", "StartIndex", "EndIndex", });
    internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerUiPb_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerUiPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_stringParser_CaseNormalizerUiPb_descriptor,
        new java.lang.String[] { "IsEnabled", "ToUppercase", "IsEnabled", "ToUppercase", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
