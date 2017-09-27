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

package io.igx.commons.cv.model;

import java.awt.*;


/**
 * @author Vinicius Carvalho
 */
public class ColorStats {

	private Color color;

	private Integer counter = 0;

	public ColorStats(Color color, Integer counter) {
		this.color = color;
		this.counter = counter;
	}

	public Color getColor() {
		return color;
	}

	public Integer getCounter() {
		return counter;
	}

	public String getRGB(){
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}
}
