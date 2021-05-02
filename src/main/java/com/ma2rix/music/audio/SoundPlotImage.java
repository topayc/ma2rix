package com.ma2rix.music.audio;
 
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.badlogic.audio.io.MP3Decoder;

 
 
/**
 
 * A simple example on how to do real-time plotting. First all samples
 
 * from an mp3 file are read in and plotted, 1024 samples per pixel. Next
 
 * we open a new MP3Decoder and an AudioDevice and play back the music. While
 
 * doing this we also set a marker in the plot that shows us the current position
 
 * of the music playback. The marker position is calculated in pixels by
 
 * measuring the elapsed time between the start of the playback and the 
 
 * current time. The elapsed time is then multiplied by the frequency divided
 
 * by the sample window size (1024 samples in this case). This gives us the
 
 * x-coordinate of the marker in the plot. After writting a sample window
 
 * to the audio device and setting the marker we sleep for 20ms to give
 
 * the Swing GUI thread time to repaint the plot with the updated marker
 
 * position.
 
 * 
 
 * @author mzechner
 
 *
 
 */
 
public class SoundPlotImage 
 
{
 
        private static final int SAMPLE_WINDOW_SIZE = 1024;
        
        public SoundPlotImage()
        {
        }
 
        public static void SaveImage(String waveFilename, String imageFilename) throws Exception
        {
    		Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.SSS");

    	    //System.out.println("Current Date: " + ft.format(dNow));

    		
            // float[] samples = readInAllSamples( FILE );
            float[] samples = readInAllSamples( waveFilename );
            
            dNow = null; 
            dNow = new Date();

    	    //System.out.println("readInAllSamples End : " + ft.format(dNow));



    	    // SoundPlot plot = new SoundPlot( "Wave Plot", 1024, 512 );
            SoundPlot plot = new SoundPlot( 1024, 512 );
            
            dNow = null; 
            dNow = new Date();

    	    //System.out.println("SoundPlot End : " + ft.format(dNow));

            plot.plotImage( imageFilename, samples, SAMPLE_WINDOW_SIZE, Color.red );     
            
            dNow = null; 
            dNow = new Date();

    	    //System.out.println("plotImage End : " + ft.format(dNow));

        }
 
        
 
        public static float[] readInAllSamples( String file ) throws FileNotFoundException, Exception
 
        {
 
                MP3Decoder decoder = new MP3Decoder( new FileInputStream( file ) );
 
                ArrayList<Float> allSamples = new ArrayList<Float>( );
 
                float[] samples = new float[1024];
                // float[] samples = new float[512];
                
                Date dNow = new Date();
    	        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.SSS");

        	    //System.out.println("readInAllSamples start: " + ft.format(dNow));
 

        	    // int ii = 1;
                while( decoder.readSamples( samples ) > 0 )
                 {
                	//System.out.println("decoder.readSamples[" + ii++ +"] " + samples.length);
 
                        for( int i = 0; i < samples.length; i++ )
 
                                allSamples.add( samples[i] );
 
                }
                
                dNow = null; 
                dNow = new Date();

                //System.out.println("readInAllSamples 1: " + ft.format(dNow));
 

                
                samples = new float[allSamples.size()];
 
                for( int i = 0; i < samples.length; i++ )
 
                        samples[i] = allSamples.get(i);
                
                //System.out.println("readInAllSamples 2: " + ft.format(dNow));
 

 
                return samples;
 
        }

        public static void main( String[] argv ) throws FileNotFoundException, Exception
        
        {
 
        		//System.out.println("-- argv[0]:" + argv[0]);
        		//System.out.println("-- argv[1]:" + argv[1]);
        		
        		SaveImage(argv[0], argv[1]);
        		
        }
 
}
 
