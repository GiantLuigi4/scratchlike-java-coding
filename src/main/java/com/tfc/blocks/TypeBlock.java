package com.tfc.blocks;

import com.tfc.Block;

public class TypeBlock extends Block {
	String type;
	
	public TypeBlock(String type) {
		this.type = type.substring("type:".length());
	}
	
	@Override
	public String getText() {
		return type;
	}
	
	@Override
	public String getKey() {
		return "type";
	}
	
	@Override
	public String toData() {
		return type;
	}
	
	@Override
	public String toCode() {
		return type + " ";
	}
}
