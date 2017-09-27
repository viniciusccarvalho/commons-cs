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

import org.apache.commons.math4.ml.clustering.Clusterable;

/**
 * @author Vinicius Carvalho
 */
public class ClusterableColor implements Clusterable{

	private final double[] points;

	public ClusterableColor(Color color){
		this.points = new double[]{color.getRed(),color.getGreen(),color.getBlue()};
	}

	@Override
	public double[] getPoint() {
		return this.points;
	}
}
