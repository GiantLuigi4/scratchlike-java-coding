package com.tfc.blocks;

import com.tfc.Block;
import com.tfc.BlockCode;
import com.tfc.blocks.modifiers.access.AccessBlock;
import com.tfc.blocks.modifiers.access.ProtectedBlock;
import com.tfc.blocks.modifiers.access.PublicBlock;

public class ClassBlock extends Block {
	private AccessBlock access;
	private TextBlock name = new TextBlock("text:");
	private final BlockCode code;
	
	public ClassBlock(AccessBlock access, TextBlock name, BlockCode code) {
		this.access = access;
		this.name = name;
		this.code = code;
	}
	
	public ClassBlock(TextBlock name) {
		this.name = name;
		this.code = new BlockCode();
		this.access = new PublicBlock();
	}
	
	public ClassBlock(String text) {
		String[] sections = text.split("§");
		this.access = (AccessBlock)Block.instance(sections[0].substring("class:".length()),sections[0].substring("class:".length())+":");
		this.name = new TextBlock("text:"+sections[1]);
		
		int brackets = 0;
		StringBuilder code = new StringBuilder();
		for (int i = 2; i < sections.length; i++) {
			String s = sections[i];
			brackets += s.split("\\{").length;
			brackets -= s.split("}").length;
			code.append(s).append("§");
			if (brackets == 0) break;
		}
		BlockCode code1;
		try {
			code1 = new BlockCode(code.substring(1,code.length()-3).replace("▼","\n"));
		} catch (Throwable err) {
			code1 = new BlockCode();
		}
		this.code = code1;
	}
	
	public ClassBlock() {
		this.code = new BlockCode();
		this.access = new PublicBlock();
		this.name = new TextBlock("text:hello");
	}
	
	@Override
	public String getText() {
		return "class ";
	}
	
	@Override
	public String getKey() {
		return "class";
	}
	
	@Override
	public String toCode() {
		return access.toCode() + name.toCode() + "{\n" + code.toJava() + "\n}";
	}
	
	@Override
	public String toData() {
		if (access == null) {
			throw new RuntimeException("Access is null");
		}
		return
				access.getKey() + "§" +
						name.toData() +
						"§{" + code.toData().replace("\n","▼") + "}";
	}
}
