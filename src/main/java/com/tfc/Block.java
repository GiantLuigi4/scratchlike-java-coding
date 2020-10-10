package com.tfc;

import java.util.HashMap;
import java.util.function.Function;

public abstract class Block {
	private static final HashMap<String, Function<String, Block>> types = new HashMap<>();
	
	public abstract String getText();
	
	public abstract String getKey();
	
	public static void registerBlock(String key, Function<String, Block> parser) {
		types.put(key, parser);
	}
	
	public String toCode() {
		return getText();
	}
	
	public String toData() {
		return "";
	}
	
	public static Block instance(String type, String text) {
		return types.get(type).apply(text);
	}
}
