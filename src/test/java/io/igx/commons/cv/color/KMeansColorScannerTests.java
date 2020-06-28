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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Vinicius Carvalho
 */
public class KMeansColorScannerTests {
	@Test(expected = IllegalArgumentException.class)
	public void failMaxSize() throws Exception {
		ColorPaletteGenerator.createPalette(Integer.MAX_VALUE,new ByteArrayOutputStream(),"png");
	}

	@Test(expected = IllegalArgumentException.class)
	public void failMinSize() throws Exception {
		ColorPaletteGenerator.createPalette(63,new ByteArrayOutputStream(),"png");
	}

	@Test(expected = IllegalArgumentException.class)
	public void failNotSquare() throws Exception {
		ColorPaletteGenerator.createPalette(65,new ByteArrayOutputStream(),"png");
	}

	@Test(expected = IllegalArgumentException.class)
	public void failFormat() throws Exception {
		ColorPaletteGenerator.createPalette(64,new ByteArrayOutputStream(),"zip");
	}

	@Test
	public void generateImage() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ColorPaletteGenerator.createPalette(64,baos,"gif");
		System.out.println(baos.size());
		Assertions.assertThat(baos.size()).isGreaterThan(0);
	}



}


