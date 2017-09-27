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

import java.io.File;
import java.io.InputStream;
import java.util.List;

import io.igx.commons.cv.model.ClusterableColor;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.chart.factories.IChartComponentFactory;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

/**
 * @author Vinicius Carvalho
 */
public class KMeansColorPlotter {

	public static void plot(File output, InputStream image) throws Exception {
		List<ClusterableColor> colorPoints = KMeansColorScanner.scan(image,10);
		Coord3d[] points = new Coord3d[colorPoints.size()];
		org.jzy3d.colors.Color[] colors = new org.jzy3d.colors.Color[colorPoints.size()];
		for(int i=0;i<colorPoints.size();i++){
			points[i] = new Coord3d(colorPoints.get(i).getPoint()[0], colorPoints.get(i).getPoint()[1], colorPoints.get(i).getPoint()[2]);
			colors[i] = new org.jzy3d.colors.Color((int)colorPoints.get(i).getPoint()[0], (int)colorPoints.get(i).getPoint()[1], (int)colorPoints.get(i).getPoint()[2]);
		}
		colorPoints.clear();
		Scatter scatter = new Scatter(points,colors);
		Chart chart = AWTChartComponentFactory.chart(Quality.Nicest, IChartComponentFactory.Toolkit.offscreen);
		chart.getScene().add(scatter);
		chart.screenshot(output);
	}

}
