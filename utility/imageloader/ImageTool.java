package imageloader;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * @author Zhaolong Zhong Jun 24, 2016
 * 
 * Reference:
 * http://stackoverflow.com/a/5882039/2427211
 */
public class ImageTool {
	
	public void downloadImage(List<String> urls, String pathFolder) {
		if (urls == null || urls.size() == 0) {
			throw new IllegalArgumentException();
		}
		
		int count = 0;
		
		URL imageUrl = null;
		for (String url : urls) {
			String[] strs = url.split("/");
			String imageName = strs[strs.length - 1];
			
			try {
				imageUrl = new URL(url);
				InputStream in = new BufferedInputStream(imageUrl.openStream());
				OutputStream out = new BufferedOutputStream(new FileOutputStream(pathFolder + "/" + imageName));

				int i; 
				while ((i = in.read()) != -1) {
					out.write(i);
				}
				
				in.close();
				out.close();
				count++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("completed: " + count + "/" + urls.size());
	}
	
	public BufferedImage resizeImage(BufferedImage image, int width, int height) {
		float scaleX = (float) width / image.getWidth();
		float scaleY = (float) height/ image.getHeight();
		float scale = Math.min(scaleX, scaleY);
		
		int w = Math.round(image.getWidth() * scale);
		int h = Math.round(image.getHeight() * scale);
		
		int type = image.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		boolean scaleDown = scale < 1;
		
		BufferedImage resizedImage;
		
		if (scaleDown) {
			int currentW = image.getWidth();
			int currentH = image.getHeight();
			resizedImage = image;
			
			while (currentW > w || currentH > h) {
				currentW = Math.max(w, currentW/2);
				currentH = Math.max(h, currentH/2);
				
				BufferedImage temp = new BufferedImage(currentW, currentH,type);
				Graphics2D g2 = temp.createGraphics();
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.drawImage(resizedImage, 0, 0, currentW, currentH, null);
				g2.dispose();
				resizedImage = temp;
			}
		} else {
			Object hint = scale > 2 ? RenderingHints.VALUE_INTERPOLATION_BICUBIC : RenderingHints.VALUE_INTERPOLATION_BILINEAR;

			resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = resizedImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(image, 0, 0, w, h, null);
            g2.dispose();
		}
		
		return resizedImage;	
	}
	
	public BufferedImage readImageFile(String pathToImage) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(pathToImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	public void writeImageToFile(BufferedImage image, String imageName, String formatName, String path) {
		try {
			File outputfile = new File(path + "/" + imageName + "." + formatName);
			ImageIO.write(image, formatName, outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getAllFilePath(String pathToFolder) {
		List<String> listOfFilePaths = new ArrayList<String>();
		
		File[] files = new File(pathToFolder).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				String path = file.getAbsolutePath();
				if (path.contains(".jpg") || path.contains(".png")) {
					listOfFilePaths.add(path);
				}
			}
		}
		
		return listOfFilePaths;
	}
	
	public void resizeAllImagesInAFolder() {
		String inputFolderPath = "";
		String outputFolderPath = "";
		
		int width = 300;
		int height = 300;
		String imageFormat = "jpg";
		
		List<String> paths = this.getAllFilePath(inputFolderPath);
		System.out.println(paths.size());
		
		// get all the resized images
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		
		BufferedImage image;
		for (String path : paths) {
			System.out.println(path);
			image = this.readImageFile(path);
			String[] strs = path.split("/");
			String imageName = strs[strs.length - 1];
			imageName = imageName.substring(0, imageName.indexOf('.'));
			map.put(imageName, this.resizeImage(image, width, height));
		}
		
		// save all the resized images
		for (Map.Entry<String, BufferedImage> entry : map.entrySet()) {
			this.writeImageToFile(entry.getValue(), entry.getKey(), imageFormat, outputFolderPath);
		}
	}
	
	public static void main(String[] args) {
		ImageTool imageTool = new ImageTool();
		imageTool.resizeAllImagesInAFolder();
	}
}
