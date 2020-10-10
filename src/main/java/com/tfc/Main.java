package com.tfc;

import com.tfc.blocks.*;
import com.tfc.blocks.modifiers.access.PrivateBlock;
import com.tfc.blocks.modifiers.access.ProtectedBlock;
import com.tfc.blocks.modifiers.access.PublicBlock;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends JComponent {
	public static BlockCode mainCode = new BlockCode();
	
	public static void main(String[] args) throws IOException {
		Block.registerBlock("if", (text) -> new IfBlock(text.replace("§", "\n")));
		Block.registerBlock("while", (text) -> new WhileBlock(text.replace("§", "\n")));
		Block.registerBlock("class", ClassBlock::new);
		Block.registerBlock("method", MethodBlock::new);
		Block.registerBlock("text", TextBlock::new);
		Block.registerBlock("var", VarBlock::new);
		Block.registerBlock("accpub", (text) -> new PublicBlock());
		Block.registerBlock("accpri", (text) -> new PrivateBlock());
		Block.registerBlock("accprot", (text) -> new ProtectedBlock());
		
		BlockCode code = new BlockCode();
		code.addBlock(new PublicBlock());
		code.addBlock(new ClassBlock(new TextBlock("text:HelloBlocks")));
		MethodBlock block = new MethodBlock(new PublicBlock(), new TextBlock("text:main(String[] args)"), new TypeBlock("type:void"));
		VarBlock var = new VarBlock(new TypeBlock("type:java.lang.String"));
		var.setName("test");
		var.setVal("\"hello\"");
		block.addCode(var);
		code.addBlock(block);
		String dat = code.toData();
		File f = new File("test.data");
		if (!f.exists()) f.createNewFile();
		FileOutputStream stream = new FileOutputStream(f);
		stream.write(dat.getBytes());
		stream.close();
//		System.out.println(dat);
//		System.out.println(code.toJava());
		mainCode.addBlock(new ClassBlock(new PublicBlock(), new TextBlock("text:HelloBlocks"), code));
		
		f = new File("test1.data");
		if (!f.exists()) f.createNewFile();
		stream = new FileOutputStream(f);
		stream.write(mainCode.toData().getBytes());
		stream.close();
		
//		System.out.println(new MethodBlock("method:" + block.toData()).toData());
		
//		System.out.println(new BlockCode(code.toData()).toData());
		JFrame frame = new JFrame("Java CodeBlocks (Scratch for Java)");
		int width = 800;
		int height =(int) (((width/600f)-(300f/600f))*width);
		frame.setMinimumSize(new Dimension(width,height));
		frame.setSize(width,height);
		frame.add(new Main());
		frame.setVisible(true);
		while (frame.isDisplayable()) {
			frame.repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GRAY);
		g.fillRect(0,-1,250,10000);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(0,-1,250,10000);
		g.drawRect(0,-1,249,10000);
		g.drawRect(0,-1,248,10000);
	}
}
