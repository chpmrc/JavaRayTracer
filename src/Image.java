import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Image {
	int width;
	int height;
	BufferedImage image;
	
	public Image(int w, int h){
		width = w;
		height = h;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void writePixel(int x, int y, int rgbValue){
		image.setRGB(x, y, rgbValue);
	}
	
	public void fill(int rgbValue){
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				image.setRGB(i, j, rgbValue);
			}
		}
	}
	
	public void writeTiff(String path){
		File outputfile = new File(path);
		try {
			ImageIO.write(image, "bmp", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
