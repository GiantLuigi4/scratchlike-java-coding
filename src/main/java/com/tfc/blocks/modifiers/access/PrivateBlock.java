package com.tfc.blocks.modifiers.access;

import com.tfc.Block;

public class PrivateBlock extends AccessBlock {
	@Override
	public String getText() {
		return "private ";
	}
	
	@Override
	public String getKey() {
		return "accpriv";
	}
}
