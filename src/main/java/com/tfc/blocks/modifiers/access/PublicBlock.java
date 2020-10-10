package com.tfc.blocks.modifiers.access;

import com.tfc.Block;

public class PublicBlock extends AccessBlock {
	@Override
	public String getText() {
		return "public ";
	}
	
	@Override
	public String getKey() {
		return "accpub";
	}
}
