package com.tfc.blocks;

import com.tfc.Block;

public class IfBlock extends Block {
	@Override
	public String getText() {
		return "if (";
	}
	
	@Override
	public String getKey() {
		return "if";
	}
	
	public IfBlock() {
	}
	
	public IfBlock(String text) {
	}
	
	@Override
	//TODO
	public String toData() {
		return super.toData();
	}
	
	@Override
	//TODO
	public String toCode() {
		return super.toCode();
	}
}
