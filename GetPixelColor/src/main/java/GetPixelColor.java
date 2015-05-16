package main.java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetPixelColor {
	public static void main(String args[]) throws IOException{
		File file = new File("src\\assets\\scanned.jpg");
		BufferedImage image = ImageIO.read(file);
		int color = image.getRGB(60, 60);
		
		int red 	= (color & 0x00FF0000) >> 16;
		int green	= (color & 0x0000FF00) >> 8;
		int blue	= (color & 0x000000FF);
		
		System.out.println("Red Color value = "+ red);
		System.out.println("Green Color value = "+ green);
		System.out.println("Blue Color value = "+ blue);
	}
	
}
