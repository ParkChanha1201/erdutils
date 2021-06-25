package com.chcraft.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class TokenChanger {
	//토큰의 형식이 [token]형식이면 정규표현식으로 인식해버려서 곤란함 해결방안 필요
	//해결함. Pattern의 quote를 사용하면 알아서 escape해준다.
	public static String replaceToken(String source, Map<String, String> args) {
		for(Entry<String, String> arg : args.entrySet()) {
			source = source.replaceAll(Pattern.quote(arg.getKey()), arg.getValue());
		}

		return source;
	}
}
