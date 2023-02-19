package com.tiwari.studence.util.protobuf;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

public class ProtobufToJson {

	public static String protobufToJsonString(Message message) {
		StringWriter stringWriter = new StringWriter();
		protobufToJson(message, stringWriter);
		return stringWriter.toString();
	}

	public static Message jsonStringToProtobuf(String json, GeneratedMessageV3.Builder yourObjectBuilder) {
		try {
			JsonFormat.parser().ignoringUnknownFields().merge(json, yourObjectBuilder);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		return yourObjectBuilder.build();
	}

	private static void protobufToJson(Message message, Writer writer) {
		protobufToJson(message, new JsonWriter(writer));
	}

	private static void protobufToJson(Message message, JsonWriter jsonWriter) {
		jsonWriter.writeObject(ow -> protobufToJson(message, ow));
	}

	private static void protobufToJson(Message message, JsonWriter.ObjectWriter objectWriter) {
		message.getAllFields().forEach((field, value) -> {
			objectWriter.writeEntry(field.getName(), w -> {
				if (field.isRepeated()) {
					List<?> list = (List<?>) value;
					w.writeArray(aw -> {
						for (Object item : list) {
							aw.writeValue(itemWriter -> writeValue(item, field, itemWriter));
						}
					});
				} else {
					writeValue(value, field, w);
				}
			});
		});
	}

	private static void writeValue(Object value, Descriptors.FieldDescriptor field,
			JsonWriter.ValueWriter valueWriter) {
		switch (field.getJavaType()) {
		case BOOLEAN:
			valueWriter.writeBoolean((Boolean) value);
			break;
		case FLOAT:
		case DOUBLE:
		case INT:
		case LONG:
			valueWriter.writeNumber((Number) value);
			break;
		case STRING:
			valueWriter.writeString((String) value);
			break;
		case MESSAGE:
			valueWriter.writeObject(ow -> protobufToJson((Message) value, ow));
			break;
		case ENUM:
			valueWriter.writeEnum((EnumValueDescriptor) value);
			break;
		default:
			throw new RuntimeException("unsupported type: " + field.getJavaType());
		}
	}

	public final String convert(GeneratedMessageV3 value) {
		return new com.googlecode.protobuf.format.JsonFormat().printToString(value);
	}
}