package org.alcoseba.japanesequiz.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageGenerator {
	private File file;
	
	public ImageGenerator(File file) {
		this.file = file;
	}
	
	public void generate(String kana, String kanji) {
		int width = 854;
		int height = 480;

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		// g2d.setColor(Color.white);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.black);
		g2d.setFont(new Font("MS Gothic", Font.PLAIN, 13));
		Font currentFont = g2d.getFont();
		FontMetrics fontMetrics = g2d.getFontMetrics();
		int fontWidth = fontMetrics.stringWidth(kana);
		System.out.println(fontWidth);
		
		Font kanaFont = currentFont.deriveFont(currentFont.getSize() * 5F);
		g2d.setFont(kanaFont);
		g2d.drawString(kana, 0, fontMetrics.getHeight() * 2 + 20);
		
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 20F);
		g2d.setFont(newFont);

		fontMetrics = g2d.getFontMetrics();
		fontWidth = fontMetrics.stringWidth(kanji);
		int fontHeight = fontMetrics.getHeight();
		
		if (fontWidth > width) {
			newFont = currentFont.deriveFont(currentFont.getSize() * 10F);
			g2d.setFont(newFont);
			
			fontMetrics = g2d.getFontMetrics();
			fontWidth = fontMetrics.stringWidth(kanji);
		}
		
		System.out.println("fontWidth : " + fontWidth + " ; fontHeight : " + fontHeight);
		int x = (width - fontWidth) / 2;
		int y = ((height - fontHeight) / 2) + fontMetrics.getAscent();
		System.out.println("x : " + x + " ; y : " + y);
		
		g2d.drawString(kanji, x, y);
		g2d.dispose();

		try {
			ImageIO.write(bufferedImage, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
