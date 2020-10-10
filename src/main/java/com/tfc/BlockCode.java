package com.tfc;

import com.tfc.bytecode.utils.Formatter;

import java.util.ArrayList;

public class BlockCode {
	private final ArrayList<Block> blocks = new ArrayList<>();
	
	public String toJava() {
		StringBuilder code = new StringBuilder();
		for (Block b : blocks) code.append(b.toCode());
		return Formatter.formatForCompile(code.toString());
	}
	
	public String toData() {
		StringBuilder builder = new StringBuilder();
		for (Block b : blocks) builder.append(b.getKey()).append(":").append(b.toData()).append("\n");
		return builder.toString();
	}
	
	public void addBlock(Block b) {
		blocks.add(b);
	}
	
	public BlockCode(String code) {
		for (String s : code.split("\n")) {
			String type = s.split(":")[0];
			try {
				blocks.add(Block.instance(type,s));
			} catch (Throwable err) {
				System.out.println(type);
				System.out.println(s);
				throw new RuntimeException(err);
			}
		}
	}
	
	public BlockCode() {
	}
}
