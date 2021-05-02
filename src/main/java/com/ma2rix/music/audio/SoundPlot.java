package com.ma2rix.music.audio;
 

 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
 

 
/**
 
 * A simple class that allows to plot float[] arrays
 
 * to a swing window. The first function to plot that
 
 * is given to this class will set the minimum and 
 
 * maximum height values. I'm not that good with Swing
 
 * so i might have done a couple of stupid things in here :)
 
 * 
 
 * @author mzechner
 
 *
 
 */
 
public class SoundPlot 
 
{
 
        /** the image **/
 
        private BufferedImage image;    
 
        
 
        /** the last scaling factor to normalize samples **/
 
        private float scalingFactor = 1;
 
        
         /** wheter the plot was cleared, if true we have to recalculate the scaling factor **/
 
        private boolean cleared = true;
 
        
 
        /** current marker position and color **/
 
        private int markerPosition = 0;
 
        private Color markerColor = Color.white;
        
        
        
        private int rectWidth = 0;
        
        private int rectHeight = 0;
        
 
       
        /**
        
         * Creates a new SoundPlot with the given title and dimensions.
 
         * 
 
         * @param title The title.
 
         * @param width The width of the plot in pixels.
 
         * @param height The height of the plot in pixels.
 
         */
 
        public SoundPlot( final int width, final int height ) throws Exception
 
        {
 
                image = new BufferedImage( 1, 1, BufferedImage.TYPE_4BYTE_ABGR );
                
                rectWidth = width;
                rectHeight = height;
 
                try
 
                {
 
                        SwingUtilities.invokeAndWait( new Runnable() {
 
                                @Override
 
                                public void run() 
 
                                {
 
                                        BufferedImage img = new BufferedImage( rectWidth, rectHeight, BufferedImage.TYPE_4BYTE_ABGR );
 
                                        Graphics2D g = (Graphics2D)img.getGraphics();
 
                                        g.setColor( Color.white );
 
                                        g.fillRect( 0, 0, width, height );
 
                                        g.dispose();
 
                                        image = img;   
                                }
 
                        });
 
                }
 
                catch( Exception ex )
 
                {
 
                        // doh...
 
                }
 
        }
 
        
 
        public void clear( )  throws Exception
 
        {
 
                SwingUtilities.invokeLater( new Runnable( ) {
 

 
                        @Override
 
                        public void run() {
 
                                Graphics2D g = image.createGraphics();
 
                                g.setColor( Color.black );
 
                                g.fillRect( 0, 0, image.getWidth(), image.getHeight() );
 
                                g.dispose();
 
                                cleared = true;
 
                        }
 
                });
 
        }
 
        
 
         public void plotImage( final String imageFilename, float[] samples, final float samplesPerPixel, final Color color )  throws Exception
        
        {                       
        		//frame.setVisible(false);
	        	Date dNow = new Date();
		        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.SSS");
	
	    	    //System.out.println("plotImage start: " + ft.format(dNow));
	 
                synchronized( image )
 
                {                                               
 
                        if( image.getWidth() <  samples.length / samplesPerPixel )
 
                        {
 
                                //image = new BufferedImage( (int)(samples.length / samplesPerPixel), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR );
                                image = new BufferedImage( (int)(samples.length / samplesPerPixel), rectHeight, BufferedImage.TYPE_4BYTE_ABGR );
 
                                Graphics2D g = image.createGraphics();
 
                                //g.setColor( Color.black );
                                g.setColor( Color.white );
 
                                g.fillRect( 0, 0, image.getWidth(), image.getHeight() ); 
 
                                g.dispose();
 
                                //panel.setSize( image.getWidth(), image.getHeight( ));
 
                        }
                        
                        dNow = null; 
                        dNow = new Date();

                	    //System.out.println("plotImage 1 : " + ft.format(dNow));
 
                                
 
                        if( cleared )
 
                        {
 
                                float min = 0;
 
                                float max = 0;
 
                                for( int i = 0; i < samples.length; i++ )
 
                                {
 
                                        min = Math.min( samples[i], min );
 
                                        max = Math.max( samples[i], max );
 
                                }
 
                                scalingFactor = max - min;
 
                                cleared = false;
 
                        }
                        
                        dNow = null; 
                        dNow = new Date();

                	    //System.out.println("plotImage 2 : " + ft.format(dNow));
 
                        
 
                        Graphics2D g = image.createGraphics();
 
                        g.setColor( color );
 
                        float lastValue = (samples[0] / scalingFactor) * image.getHeight() / 3 + image.getHeight() / 2;
 
                        for( int i = 1; i < samples.length; i++ )
 
                        {
 
                                float value = (samples[i] / scalingFactor) * image.getHeight() / 3 + image.getHeight() / 2;
 
                                g.drawLine( (int)((i-1) / samplesPerPixel), image.getHeight() - (int)lastValue, (int)(i / samplesPerPixel), image.getHeight() - (int)value );
 
                                lastValue = value;
 
                        }
 
                        g.dispose();
                        
                        dNow = null; 
                        dNow = new Date();

                	    //System.out.println("plotImage 3 : " + ft.format(dNow));
                        
                        //ImageIcon icon = new ImageIcon( image );
                	    
                	    if (ImageIO.write(image, "png", new File(imageFilename)))
                        {
                            //System.out.println(imageFilename + " -- saved");
                        }
                        
                	    /*
                        try {
	                            //if (ImageIO.write(image, "png", new File("d:\\sound\\output_image.png")))
	                            if (ImageIO.write(image, "png", new File(imageFilename)))
	                            {
	                                System.out.println(imageFilename + " -- saved");
	                            }
	                    } catch (IOException e) {
	                            e.printStackTrace();
	                    }
	                    */
                        
                        dNow = null; 
                        dNow = new Date();

                	    //System.out.println("plotImage 4 : " + ft.format(dNow));
 
                }               
 
        }
 
        
 
        public void setMarker( int x, Color color )
 
        {
 
                        this.markerPosition = x;
 
                        this.markerColor = color;       
 
        }
 
}
 
