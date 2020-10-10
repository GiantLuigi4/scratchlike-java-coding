package com.tfc.blocks;

import com.tfc.Block;

public class TextBlock extends Block {
	private String text = "";
	
	public TextBlock() {
	}
	
	public TextBlock(String text) {
		this.text = text.substring("text:".length());
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public String getKey() {
		return "text";
	}
	
	@Override
	public String toData() {
		return text;
	}
	
	@Override
	public String toCode() {
		return text + " ";
	}
	
	public void set(String text) {
		this.text = text;
	}
}
