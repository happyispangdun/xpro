package com.syl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串拆分
 */
public class SplitUtil {
	/**
	 *
	 * @param args 字符串对象
	 * @param str 分隔符
	 * @return 字符串对象拆分后的数组
	 */
	public static String[] split(String args, String str) {
		if (args == null || "".equals(args)) {
			return new String[0];
		}
		List list = new ArrayList();
		if (args.indexOf(str) == -1) {
			String[] s = new String[1];
			s[0] = args;
			return s;
		}
		if (args.substring(args.length() - 1).equals(str)) {
			args = args.substring(0, args.length() - 1);
		}
		while (true) {
			if (args.indexOf(str) != -1) {
				list.add(args.substring(0, args.indexOf(str)));
				args = args.substring(args.indexOf(str) + 1);
			} else {
				list.add(args);
				String[] s = new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					s[i] = (String) list.get(i);
				}
				return s;
			}
		}
	}

}
