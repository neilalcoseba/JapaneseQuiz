package org.alcoseba.japanesequiz.util;

import java.io.File;

import org.junit.Test;

public class ImageGeneratorTest {

	@Test
	public void testGenerate() {
		File outputDir = new File(System.getProperty("user.dir"), "target");
		File saveFile = new File(outputDir, "test.jpg");
		ImageGenerator imageGenerator = new ImageGenerator(saveFile);
		imageGenerator.generate("さけ", "酒粕酒粕酒粕酒粕酒粕酒粕酒粕酒粕");
	}
}
