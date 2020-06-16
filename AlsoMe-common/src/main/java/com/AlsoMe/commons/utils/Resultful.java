package com.AlsoMe.commons.utils;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class Resultful extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public Resultful() {
		put("code", 0);
		put("msg", "success");
	}

	public static Resultful error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static Resultful error(String msg) {
		return error(500, msg);
	}

	public static Resultful error(int code, String msg) {
		Resultful r = new Resultful();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Resultful ok(String msg) {
		Resultful r = new Resultful();
		r.put("msg", msg);
		return r;
	}

	public static Resultful ok(int  code) {
		Resultful r = new Resultful();
		r.put("code", code);
		return r;
	}

	public static Resultful ok(Map<String, Object> map) {
		Resultful r = new Resultful();
		r.putAll(map);
		return r;
	}

	public static Resultful ok() {
		return new Resultful();
	}

	@Override
	public Resultful put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
