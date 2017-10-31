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

package io.igx.commons.cv.util;

import java.awt.*;

/**
 * @author Vinicius Carvalho
 */
public class ColorUtils {

	public static float getLuma(Color color){
		return (float) (0.2126 * color.getRed() + 0.7152 * color.getGreen() + 0.0722 * color.getBlue());
	}


	public static int[] RGB2YUV(Color color){

		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		int Y = (int)(0.299*r+0.587*g+0.114*b);
		int Cb=(int)(128-0.169*r-0.331*g+0.500*b);
		int Cr =(int)(128+0.500*r-0.419*g-0.081*b);

		return  new int[]{Y, Cb, Cr};
	}

	public static void main(String[] args) {
		System.out.println(getLuma(Color.LIGHT_GRAY));
	}
}
