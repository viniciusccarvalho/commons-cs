/*
 *  Copyright 2017 original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.igx.commons.cv.color;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;


/**
 * Creates a sample color of up to 16 bit colors in a image using 20x20 squares
 *
 * @author Vinicius Carvalho
 */
public class ColorPaletteGenerator {

	private static final List<String> supportedFormats = Arrays.asList("png","jpg");
	private static final String formats = "(?i)(jpe?g|png|gif|bmp)";
	private final static int squareSize = 10;

	/**
	 * Creates a sample palette image
	 * @param numColors number of colors of the sample, has to be a square number of max of 65,536
	 * @param out Output of the generated image
	 * @param format Image format, supported JPG and PNG only
	 */
	public static void createPalette(int numColors, OutputStream out, String format){
		if(numColors >= 65_536) {
			throw new IllegalArgumentException("Can't output more than 16 bit colors");
		}
		if(numColors <= 64){
			throw new IllegalArgumentException("Minimum size of colors has to be 64");
		}
		if(!isPerfectSquare(numColors)){
			throw new IllegalArgumentException("Number of colors has to be a perfect square for the color matrix");
		}
		if(!format.matches(formats)){
			throw new IllegalArgumentException("Unsupported format, supported formats are (png|gif|bmp|jpg|jpeg)");
		}
		Color[] colors = generateColors(numColors);
		int rows = (int)Math.sqrt(numColors);
		BufferedImage image = new BufferedImage(squareSize*rows,squareSize*rows	,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		for(int i=0;i<rows;i++){
			for(int j=0;j<rows;j++){
				g2d.setColor(colors[(i*rows)+j]);
				g2d.fillRect(i*squareSize,j*squareSize,squareSize,squareSize);
			}
		}
		try {
			ImageIO.write(image,format,out);
		}
		catch (IOException e) {
			throw new IllegalStateException("Failed to write image to output stream",e);
		}
	}

	public static Color[] generateColors(int n)
	{
		Color[] cols = new Color[n];
		for(int i = 0; i < n; i++)
		{
			cols[i] = Color.getHSBColor((float) i / (float) n, 0.85f, 1.0f);
		}
		return cols;
	}

	/**
	 * From : https://stackoverflow.com/questions/295579/fastest-way-to-determine-if-an-integers-square-root-is-an-integer
	 * @param n
	 * @return
	 */
	private final static boolean isPerfectSquare(int n)
	{
		if (n < 0)
			return false;

		int tst = (int)(Math.sqrt(n) + 0.5);
		return tst*tst == n;
	}
}
