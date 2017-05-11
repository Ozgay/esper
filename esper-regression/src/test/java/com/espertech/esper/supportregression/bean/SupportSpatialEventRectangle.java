/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.supportregression.bean;

import java.io.Serializable;

public class SupportSpatialEventRectangle implements Serializable
{
    private String id;
    private Double x;
    private Double y;
    private Double width;
    private Double height;
    private String category;

    public SupportSpatialEventRectangle(String id, Double x, Double y, Double width, Double height, String category) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.category = category;
    }

    public SupportSpatialEventRectangle(String id, double x, double y, double width, double height) {
        this(id, x, y, width, height, null);
    }

    public String getId() {
        return id;
    }

    public Double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getCategory() {
        return category;
    }
}
