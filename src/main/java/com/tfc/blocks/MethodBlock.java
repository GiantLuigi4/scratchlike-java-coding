package com.tfc.blocks;

import com.tfc.Block;
import com.tfc.BlockCode;
import com.tfc.blocks.modifiers.access.AccessBlock;
import com.tfc.blocks.modifiers.access.PrivateBlock;
import com.tfc.blocks.modifiers.access.ProtectedBlock;
import com.tfc.blocks.modifiers.access.PublicBlock;

public class MethodBlock extends Block {
	private final AccessBlock access;
	private final TypeBlock returnType;
	private final TextBlock name;
	private BlockCode inner = new BlockCode();
	
	public MethodBlock(AccessBlock access, TextBlock name, TypeBlock typeBlock) {
		this.access = access;
		this.name = name;
		this.returnType = typeBlock;
		this.inner = new BlockCode();
	}
	
	public MethodBlock(String text) {
		if (text.substring("method:".length()).startsWith("accpriv")) access = new PrivateBlock();
		else if (text.substring("method:".length()).startsWith("accpub")) access = new PublicBlock();
		else access = new ProtectedBlock();
		String[] sections = text.split("§");
		this.name = new TextBlock("text:"+(sections[1]));
		this.returnType = new TypeBlock("type:"+sections[2]);
		int brackets = 0;
		StringBuilder code = new StringBuilder();
		for (int i = 3; i < sections.length; i++) {
			String s = sections[i];
			brackets += s.split("\\{").length;
			brackets -= s.split("}").length;
			code.append(s).append("§");
			if (brackets == 0) break;
		}
		this.inner = new BlockCode(code.substring(1).substring(0,code.length()-3).replace("▼","\n"));
	}
	
	@Override
	public String getText() {
		return name.toData();
	}
	
	@Override
	public String getKey() {
		return "method";
	}
	
	@Override
	public String toCode() {
		return access.toCode() + returnType.toCode() + super.toCode() + " {\n" + inner.toJava() + "\n}";
	}
	
	@Override
	public String toData() {
		return access.getKey() + "§" + name.getText() + "§" + returnType.getText() + "§{"+inner.toData().replace("\n","▼")+"}";
	}
	
	public void addCode(Block block) {
		inner.addBlock(block);
	}
}
