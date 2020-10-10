package com.tfc.blocks;

import com.tfc.Block;

public class WhileBlock extends Block {
	@Override
	public String getText() {
		return "while (";
	}
	
	@Override
	public String getKey() {
		return "while";
	}
	
	public WhileBlock() {
	}
	
	public WhileBlock(String text) {
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
