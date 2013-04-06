package org.ost.main.MyUtils;

import java.awt.*;
import java.awt.print.*;
import javax.swing.*;

/**
 * Generic component printer.  This object allows any AWT or Swing component  (or DCT system)
 * to be printed by performing it pre and post print responsibilities.
 * <p>
 * When printing components, the role of the print method is nothing more than to scale the Graphics, turn off double
 * buffering, and call paint.  There is no particular reason to put that print method in the component being printed.  A
 * better approach is to build a generic printComponent method to which you simply pass the component you want printed.
 * <p>
 * With Swing, almost all components have double buffering turned on by default. In general, this is a great benefit,
 * making for convenient and efficient painting. However, in the specific case of printing, it can is a huge problem.
 * First, since printing components relies on scaling the coordinate system and then simply calling the component's
 * paint method, if double buffering is enabled printing amounts to little more than scaling up the buffer (off-screen
 * image) which results in ugly low-resolution printing like you already had available. Secondly, sending these huge
 * buffers to the printer results in huge print spooler files which take a very long time to print. Consequently this
 * object globally turns off double buffering before printing and turns it back on afterwards.
 * <p>
 * Threading Design : [x] Single Threaded  [ ] Threadsafe  [ ] Immutable  [ ] Isolated
 */

public class ComponentPrinter
extends Object
implements Printable
{

	// *****************************************************************************
	// INSTANCE PROPERTIES
	// *****************************************************************************

	private Component  component;                              // the component to print
	private PageFormat format;
	private String jobName;
	
	// *****************************************************************************
	// INSTANCE CREATE/DELETE
	// *****************************************************************************

	public ComponentPrinter(Component com, String incomingJobName) {
		component=com;
		jobName = incomingJobName;
	}

	// *****************************************************************************
	// INSTANCE METHODS
	// *****************************************************************************

	public void print() throws PrinterException {
		PrinterJob	printJob=PrinterJob.getPrinterJob();

		printJob.setJobName(jobName);

		format = printJob.getPageFormat(null);
		Paper paper = format.getPaper();
//		paper.setImageableArea(0.0, 0.0, 
//				format.getPaper().getWidth(), 
//				format.getPaper().getHeight());
//		paper.setImageableArea(0.0, 0.0, 
//				(8)*72, 
//				(11)*72);
		paper.setSize(8.5 * 72, 11 * 72);
		paper.setImageableArea(0.0 * 72, 0.0 * 72, 7.5 * 72, 10.5 * 72);	
		format.setPaper(paper);
		
		Book book = new Book();//java.awt.print.Book
		book.append(this, format);
		printJob.setPageable(book);
		//printJob.setPrintable(this);
		
		if(printJob.pageDialog(format) != null)
			if(printJob.printDialog()) {
				printJob.print();
			}
	}

	public int print(Graphics gc, PageFormat pageFormat, int pageIndex) {
		if(pageIndex>0) {
			return NO_SUCH_PAGE;
		}

		RepaintManager  mgr=RepaintManager.currentManager(component);
		Graphics2D      g2d=(Graphics2D)gc;
		
		double factorX = format.getImageableWidth() / component.getWidth();
		double factorY = format.getImageableHeight() / component.getHeight();
		double factor = Math.min( factorX, factorY );
		g2d.scale(factor,factor);
		
		g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
		mgr.setDoubleBufferingEnabled(false);  // only for swing components
		component.paint(g2d);
		mgr.setDoubleBufferingEnabled(true);  // only for swing components
		return PAGE_EXISTS;
	}

	// *****************************************************************************
	// STATIC METHODS
	// *****************************************************************************

	static public void printComponent(Component com,String incJobName) throws PrinterException {
		new ComponentPrinter(com,incJobName).print();
	}

} // END PUBLIC CLASS