package com.tiwari.studence.util.entity;

import com.tiwari.studence.util.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.Preconditions;

public class EntityUtilHelper {

	public static String getDbInfoIdWithSpecialCharecter(String hash, String range) {

		return hash + StudenceSpecialCharecterEnum.EXCLAMATION.getSign() + range;
	}

	public static Pair<String, String> getHashandRangeKey(String dbInfoId) {
		Preconditions.check(dbInfoId.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign()), "Id is not valid");
		String[] id_split = dbInfoId.split(StudenceSpecialCharecterEnum.EXCLAMATION.getSign());
		return new Pair<String, String>(id_split[0], id_split[1]);
	}
}
