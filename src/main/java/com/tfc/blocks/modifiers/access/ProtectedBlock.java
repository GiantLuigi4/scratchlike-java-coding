package com.tfc.blocks.modifiers.access;

import com.tfc.Block;

public class ProtectedBlock extends AccessBlock {
	@Override
	public String getText() {
		return "protected ";
	}
	
	@Override
	public String getKey() {
		return "accprot";
	}
}
