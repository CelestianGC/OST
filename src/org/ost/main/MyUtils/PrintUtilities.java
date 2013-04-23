package org.ost.main.MyUtils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.RepaintManager;
import java.awt.*;
import javax.swing.*;
import java.awt.print.*;


public class PrintUtilities implements Printable{

	Component comp;
	double scaleFactor=0.0;

	public PrintUtilities(Component comp) {
		this.comp=comp;
	}

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {

		
		if (scaleFactor==0.0) {
			double scaleFactorX=0.0;
			double scaleFactorY=0.0;
			scaleFactorX=pageFormat.getImageableWidth()/comp.getWidth();
			scaleFactorY=pageFormat.getImageableHeight()/comp.getHeight();
			scaleFactor= (scaleFactorX < scaleFactorY) ? scaleFactorX : scaleFactorY;
		}
		//double scale = (double)Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
		//((Graphics2D)graphics).getTransform();
//		int totalNumPages = (int)Math.ceil(scale * comp.getHeight() / pageFormat.getImageableHeight());
		//*if(pageIndex >= totalNumPages)
		if(pageIndex<0) {
			return NO_SUCH_PAGE;
		}
		
		graphics.translate((int)pageFormat.getImageableX(),(int)pageFormat.getImageableY());
		if (graphics instanceof Graphics2D) {
			((Graphics2D)graphics).scale(scaleFactor,scaleFactor);
			//((Graphics2D)graphics).scale(scale,scale);
		}
		comp.printAll(graphics);
		return PAGE_EXISTS;
	}
}
