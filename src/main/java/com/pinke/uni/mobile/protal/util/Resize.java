package com.pinke.uni.mobile.protal.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resize {
	private BufferedImage bufImage;
	private int width;
	private int height;

	public Resize() {
	}

	/**
	 * 构造方法
	 * 
	 * @param srcPath
	 *            需要压缩的图片位置
	 * @param width
	 *            压缩后的宽
	 * @param height
	 *            压缩后的高
	 */
	public Resize(String srcPath, int width, int height) {
		this.width = width;
		this.height = height;
		try {
			this.bufImage = ImageIO.read(new File(srcPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param srcBufImage
	 *            图片流
	 * @param width
	 *            压缩后的宽
	 * @param height压缩后的高
	 * @return
	 */
	public static BufferedImage rize(BufferedImage srcBufImage, int width,
			int height) {

		BufferedImage bufTarget = null;

		double sx = (double) width / srcBufImage.getWidth();
		double sy = (double) height / srcBufImage.getHeight();

		int type = srcBufImage.getType();
		if (type == BufferedImage.TYPE_CUSTOM) {
			ColorModel cm = srcBufImage.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(width,
					height);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			bufTarget = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			bufTarget = new BufferedImage(width, height, type);

		Graphics2D g = bufTarget.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(srcBufImage,
				AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return bufTarget;
	}

	/**
	 * @param urlString
	 *            获取图片的外网图片url
	 * @param sourceAddress
	 *            生成到本地的地址
	 */
	public void requesturl(String urlString, String sourceAddress) {
		URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection urlConnection;
			try {
				urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setRequestProperty("Accept", "*/*");
				urlConnection.setRequestProperty("Accept-Language", "zh-cn");
				urlConnection
						.setRequestProperty(
								"User-Agent",
								"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; InfoPath.2; CIBA)");
				urlConnection.setRequestProperty("Accept-Encoding",
						"gzip, deflate");
				urlConnection.setRequestProperty("Connection", "Keep-Alive");

				if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

					InputStream in = urlConnection.getInputStream();

					File file = new File(sourceAddress);
					if (!file.exists()) {
						file.getParentFile().mkdirs();
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file);
					byte[] buff = new byte[1024];
					int rc = 0;
					while ((rc = in.read(buff, 0, 1024)) > 0) {
						out.write(buff, 0, rc);
					}
					out.flush();
					in.close();
					out.close();
				} else {
					// 日志记录
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}



	public BufferedImage getBufImage() {
		return bufImage;
	}

	public void setBufImage(BufferedImage bufImage) {
		this.bufImage = bufImage;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}