package com.ma2rix.music.common;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 이미지크기나 워터마크 처리 클래스 클래스 - 지정된 넖이와 폭으로 변경 - 넓이를 기준으로 비율에 맞추어서 변경 - 높이를 기준으로 비율에
 * 맞추어서 변경 - 텍스트 혹은 이미지 파일을 추가하여 워터마킹 이미지 생성
 * 
 * 원본이미지의 파일이름과 확장자 사이에 _thumnail 삽입하여 이미지 이름을 결정 ex) ahn.png ====>
 * ang_thumbname.png
 * 
 * 
 * 속도의 문제가 생길 경우 전용  ImageEncoder 와 Decoder 를 사용하고, 전용 이미지 저장 lib 를 사용
 * 
 * 
 *
 */

public class ImageGenerator {

	/**
	 * 썸네일 이미지의 suffix
	 */
	public static final String THUMBNAIL_PREFIX = "_thumbnail";
	public static final String WATERMARK_PREFIX = "_watermark";

	/**
	 * Minmap 이미지를 생성하기 위한 레벨 상수값
	 */
	public static final int MINMAP_STEP = 10;
	public static final int MINMAP_COUNT = 4;

	
	/**
	 * 지정된 크기로 이미지의 사이즈를 변경.
	 * 
	 * @param srcImageFile
	 * @param destImageFile 저장할 이미지 경로, 만약 널인 경우 원본 이미지 파일명에 SUFFIX 를 붙여서 파일이름을 생성 주로 null
	 *                 를 주어서, 원본 이미지 파일명에 suffix 를 추가해서 생성하도록 한다.
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void resize(File srcImageFile, File destImageFile, int width, int height)
			throws IOException {
		Image srcImage = loadImage(srcImageFile);
		String ext = getExtention(srcImageFile);
		Image targetImage = srcImage.getScaledInstance(width, height,Image.SCALE_SMOOTH);

		int pixels[] = new int[width * height];
		PixelGrabber g = new PixelGrabber(targetImage, 0, 0, width, height,pixels, 0, width);

		try {
			g.grabPixels();
		} catch (InterruptedException ex) {
			System.err.println(ex);
		}
		
		//대상 지정 경로가 null 인 경우, 원본 파일 경로를 사용하며, 원본 파일 이름에 prefix 를 붙임
		if (destImageFile == null) {
			String srcName = srcImageFile.getName();
			destImageFile = new File(generateFileNameWithPrefix(srcName, ImageGenerator.THUMBNAIL_PREFIX));
		}
		BufferedImage bufferedImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		write(bufferedImage, ext, destImageFile);
	}

	
	/**
	 * 지정된 너비를 기준으로 비율을 조절하여 사이즈를 변경.
	 * 
	 * @param src 변경할 이미지   
	 * @param des 저장할 이미지 경로, 만약 널인 경우 원본 이미지 파일명에 PREFIX 를 붙여서 파일이름을 생성
	 * @param width 변경할 이미지의 넓이 
	 */
	public static void resizeRatioX(File src, File des, int width) {}

	
	/**
	 * 지정된 높이를 기준으로 비율을 조절하여 사이즈를 변경
	 * 
	 * @param src 변경할 이미지
	 * @param des 저장할 이미지 경로, 만약 널인 경우 원본 이미지 파일명에 PREFIX 를 붙여서 파일이름을 생성
	 * @param height 변경할 이미지의 높이
	 */
	public static void resizeRatioY(File src, File des, int height) {}

	
	/**
	 * 지정된 텍스트로 워터마킹 이미지를 생성(알파 블렌딩 적용)
	 * 다른 효과를 주려면 알파 블렌딩 외의 다른 블렌딩을 사용
	 *
	 * @param sourceImageFile  원본 이미지 파일 
	 * @param destImageFile    null 인 경우 원본 이미지 파일의 경로, 이름에 prefix 를 추가해 생성
	 * @param text         		워터마킹으로 추가할 텍스트 
	 */
	public void generateTextWatermark(File sourceImageFile,File destImageFile,String text) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

			// 알파 블렌딩 그래픽 프로퍼티 세팅
			AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
			g2d.setComposite(alphaChannel);
			g2d.setColor(Color.BLUE);
			g2d.setFont(new Font("Arial", Font.BOLD, 64));
			FontMetrics fontMetrics = g2d.getFontMetrics();
			Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

			// 텍스트가 그려질 좌표 계산, 원본 이미지의 중앙으로 설정
			int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
			int centerY = sourceImage.getHeight() / 2;

			// 텍스트 워터마크 드로잉
			g2d.drawString(text, centerX, centerY);
			if (destImageFile == null) {
				String srcName = sourceImageFile.getName();
				destImageFile= new File(generateFileNameWithPrefix(srcName, ImageGenerator.WATERMARK_PREFIX));
			}
			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	/**
	 * 지정된 이미지를 사용하여 워터마킹 이미지를 생성(알파 블렌딩 적용)
	 * 다른 효과를 주려면 알파 블렌딩 외의 다른 블렌딩을 사용
	 * 
	 * @param sourceImageFile		원본 이미지 파일
	 * @param destImageFile        null 인 경우 원본 이미지 파일의 경로, 이름에 prefix 를 추가해 생성
	 * @param watermarkImageFile   워터마킹으로 사용할  이미지 파일
	 */
	public void generateImageWatermark(File sourceImageFile, File destImageFile,File watermarkImageFile) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
			g2d.setComposite(alphaChannel);

			int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
			int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
			g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);
			
			if (destImageFile == null) {
				String srcName = sourceImageFile.getName();
				destImageFile= new File(generateFileNameWithPrefix(srcName, ImageGenerator.WATERMARK_PREFIX));
			}
			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	/**
	 * 정의된 레벨의  Minmap Image 를 생성 (민맵 레벨과 민맵 사이즈)
	 * 
	 * @param image 원본 Image
	 */
	public void generateMinampImage(Image image) {

	}

	/**
	 * 이미지 파일을 로드. 단 주어진 확장자에 따라 ImageIO 와 ImageIcon 를 적절히 사용하여 로딩 시간을 줄임 
	 * @param src  로드할 이미지 파일 
	 */
	private static Image loadImage(File src) throws IOException {
		Image img = null;
		String ext = src.getName().substring(src.getName().lastIndexOf('.') + 1).toLowerCase();
		if (ext.equals("bmp") || ext.equals("png") || ext.equals("git")) {
			img = ImageIO.read(src);
		} else {
			img = new ImageIcon(src.toURI().toURL()).getImage();
		}
		return img;
	}

	/**
	 * 지정된 경로로 이미지를 저장, 저장상의 속도 문제가 있을 경우 전용 이미지 저장 Lib 사용 
	 * 
	 * @param bImage        저장할 이미지 
	 * @param formatName    저장할 이미지의 format 문자열
	 * @param output        출력할 파일 이음 
	 */
	private static void write(BufferedImage bImage, String formatName,
			File output) throws IOException {
		ImageIO.write(bImage, formatName, output);
	}
	
	/** 
	 *  파일이름에 prefix 를 붙어 파일이름을 생성 
	 * @param fileName   원본 파일 이름
	 * @param prefix     원본 파일 이름에 추가될 프리픽스
	 */
	private static String generateFileNameWithPrefix(String fileName, String prefix) {
		String fileNameDiv[] = fileName.split("\\.");
		return fileNameDiv[0] + prefix + "." + fileNameDiv[1];
	}

	/**
	 * 파일의 확장자를 반환
	 * 
	 * @param srcImage
	 */
	private static String getExtention(File srcImage) {
		return srcImage.getName()
				.substring(srcImage.getName().lastIndexOf('.') + 1)
				.toLowerCase();
	}

	public static void main(String[] arg) {
		//사용법은 위 메서드의 주석을 참조
	}
}
