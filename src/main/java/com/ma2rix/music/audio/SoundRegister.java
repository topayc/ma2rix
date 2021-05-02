package com.ma2rix.music.audio;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SoundRegister {
	

	public static void SoundRegister(String sourceDir, String targetDir, String sourceFilename) throws Exception   
	{
		String fileSource	= sourceDir + sourceFilename;
		String convertExt	= "_m2";
		String fileMp3;
		String fileOgg;
		String fileImg;
		String fileDiv[];
		String fileName;
		String fileExt;
		
		fileDiv = sourceFilename.split("\\."); 
		
		//System.out.println("sourceFilename:" + sourceFilename);
		//System.out.println("fileDiv.length:" + fileDiv.length);
		fileName = fileDiv[0];
		fileExt  = fileDiv[1];
		
		fileMp3 = targetDir + fileName + convertExt + ".mp3";
		fileOgg = targetDir + fileName + convertExt + ".ogg";
		fileImg = targetDir + fileName + convertExt + ".png";
		
		Date dStart = new Date();
		Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.SSS");

	    //System.out.println("SoundRegister start: " + ft.format(dStart));
		
		File sourceFile = new File(fileSource);
		File targetFile = null;
		AudioAttributes audioAttr = null;
		EncodingAttributes encAttrs = null;
		Encoder encoder = new Encoder();
		
		// mp3
		
		targetFile = null;
		audioAttr = null;
		encAttrs = null;
		
		targetFile = new File(fileMp3);
		audioAttr = new AudioAttributes();
		encAttrs = new EncodingAttributes();
		
		audioAttr.setCodec("libmp3lame");
		audioAttr.setBitRate(new Integer(128000));
		audioAttr.setChannels(new Integer(2));
		audioAttr.setSamplingRate(new Integer(44100));
		
		encAttrs.setFormat("mp3");
		encAttrs.setAudioAttributes(audioAttr);
		
		encoder.encode(sourceFile, targetFile, encAttrs);
		
		dNow = null; 
        dNow = new Date();
	    //System.out.println("SoundConvert mp3 complete : " + ft.format(dNow));
		
		// ogg
	    targetFile = null;
		audioAttr = null;
		encAttrs = null;
		
		targetFile = new File(fileOgg);
		audioAttr = new AudioAttributes();
		encAttrs = new EncodingAttributes();
		
		audioAttr.setCodec("libvorbis");
		audioAttr.setBitRate(new Integer(128000));
		audioAttr.setChannels(new Integer(2));
		audioAttr.setSamplingRate(new Integer(44100));
		
		encAttrs.setFormat("ogg");
		encAttrs.setAudioAttributes(audioAttr);
		
		encoder.encode(sourceFile, targetFile, encAttrs);
		
		dNow = null;
		dNow = new Date();
	    //System.out.println("SoundConvert ogg complete : " + ft.format(dNow));
	    
	    // sound image
	    SoundPlotImage.SaveImage(fileMp3, fileImg);
	    
	    dNow = null;
		dNow = new Date();
		//System.out.println("SoundPlotImage.SaveImage complete : " + ft.format(dNow));

	    Date dEnd = new Date();
	    long elapsedTime = (dEnd.getTime()-dStart.getTime())/1000;
	    //System.out.println("SoundRegister elapsed time(second) : " +  elapsedTime);

	}

	public static void main(String[] args) throws Exception {

		String sourceDir  = "d:\\sound\\";
		String targetDir  = "d:\\sound\\";
		// String sourceFilename = "sample1.mp3";
		String sourceFilename = "sample2.wav";
		
		SoundRegister(sourceDir, targetDir, sourceFilename);
				
	}


}
