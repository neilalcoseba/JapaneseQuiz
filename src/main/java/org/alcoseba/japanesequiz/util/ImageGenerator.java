package org.alcoseba.japanesequiz.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
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
        Font initialFont = new Font("MS Gothic", Font.PLAIN, 50);
        BufferedImage textImg = createTextImage(kanji, 854, 480, 0,
                initialFont, Color.BLACK, Color.GRAY);
        writeImage(this.file, textImg);
	}
	
	private BufferedImage createTextImage(String text, int targetWidth,
            int targetHeight, int textYOffset, Font font, Color textColor, Color bgColor) {

        // The final image
        BufferedImage finalImg = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D finalImgG = finalImg.createGraphics();        
        Font closestFont = scaleFont(finalImg, font, text);
        finalImgG.setFont(closestFont);

        // Create new image to fit text
        int textWidth = finalImgG.getFontMetrics().stringWidth(text);
        int textHeight = finalImgG.getFontMetrics().getHeight();
        BufferedImage textImg = createBackgroundImg(textWidth, textHeight * 2, bgColor);

        // Draw text
        Graphics2D textImgG = textImg.createGraphics();
        textImgG.setFont(closestFont);
        textImgG.setColor(textColor);
        textImgG.drawString(text, 0, textHeight);

        // Scale text image
        double scale = getScale(textImg.getWidth(), textImg.getHeight(),
                targetWidth, targetHeight);
        Image resized = textImg.getScaledInstance((int) (textImg.getWidth() * scale),
                (int) (textImg.getHeight() * scale), Image.SCALE_SMOOTH);

        // Draw text image onto final image
        finalImgG.drawImage(resized, 0, textYOffset, null);
        return finalImg;
    }

    private Font scaleFont(BufferedImage img, Font font, String text) {
        Graphics2D g2D = img.createGraphics();
        g2D.setFont(font);
        double scale = getScale(g2D.getFontMetrics().stringWidth(text), 
                g2D.getFontMetrics().getHeight(), img.getWidth(), 
                img.getHeight());
        return g2D.getFont().deriveFont(AffineTransform.getScaleInstance(scale, scale));
    }

    private double getScale(int width, int height, int targetWidth, int targetHeight) {
        assert width > 0 && height > 0 : "width and height must be > 0";
        double scaleX = (double) targetWidth / width;
        double scaleY = (double) targetHeight / height;
        return scaleX > scaleY ? scaleY : scaleX;
    }

    private BufferedImage createBackgroundImg(int width, int height, Color color) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        return bufferedImage;
    }

    private void writeImage(File destinationImage, 
            BufferedImage bufferedImage) {
        try {
            ImageIO.write(bufferedImage, "jpg", destinationImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Image Saved");
    }
}
