package com.tfc.blocks;

import com.tfc.Block;

public class VarBlock extends Block {
	private final TypeBlock type;
	private final TextBlock name = new TextBlock();
	private final TextBlock val = new TextBlock();
	
	public VarBlock(TypeBlock type) {
		this.type = type;
	}
	
	//TODO
	public VarBlock(String text) {
		String[] split = text.split("§");
		this.type = new TypeBlock("type:" + split[0]);
		this.name.set(split[1]);
		this.val.set(split[2]);
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public void setVal(String val) {
		this.val.set(val);
	}
	
	@Override
	public String getText() {
		return type.getText() + " " + name.getText() + " = " + val.getText() + ";";
	}
	
	@Override
	public String getKey() {
		return "var";
	}
	
	@Override
	public String toData() {
		return type.toData() + "§" + name.toData() + "§" + val.toData();
	}
}
