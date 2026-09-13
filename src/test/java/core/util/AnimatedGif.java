package core.util;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Writes a looped animated GIF from frames (used for the GIFs of the articles). */
public final class AnimatedGif {

	private AnimatedGif() {
	}

	/**
	 * @param frames  frames of the same size
	 * @param delays  delay of every frame in milliseconds
	 */
	public static void write(List<BufferedImage> frames, List<Integer> delays, Path file) throws IOException {
		Files.createDirectories(file.getParent());
		ImageWriter writer = ImageIO.getImageWritersByFormatName("gif").next();
		try (ImageOutputStream out = ImageIO.createImageOutputStream(file.toFile())) {
			writer.setOutput(out);
			writer.prepareWriteSequence(null);
			for (int i = 0; i < frames.size(); i++) {
				BufferedImage frame = frames.get(i);
				IIOMetadata meta = writer.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(frame), writer.getDefaultWriteParam());
				String format = meta.getNativeMetadataFormatName();
				IIOMetadataNode root = (IIOMetadataNode) meta.getAsTree(format);
				IIOMetadataNode gce = child(root, "GraphicControlExtension");
				gce.setAttribute("disposalMethod", "none");
				gce.setAttribute("userInputFlag", "FALSE");
				gce.setAttribute("transparentColorFlag", "FALSE");
				gce.setAttribute("delayTime", Integer.toString(delays.get(i) / 10));
				gce.setAttribute("transparentColorIndex", "0");
				if (i == 0) {
					IIOMetadataNode app = new IIOMetadataNode("ApplicationExtension");
					app.setAttribute("applicationID", "NETSCAPE");
					app.setAttribute("authenticationCode", "2.0");
					app.setUserObject(new byte[]{1, 0, 0});
					child(root, "ApplicationExtensions").appendChild(app);
				}
				meta.setFromTree(format, root);
				writer.writeToSequence(new IIOImage(frame, null, meta), writer.getDefaultWriteParam());
			}
			writer.endWriteSequence();
		} finally {
			writer.dispose();
		}
	}

	private static IIOMetadataNode child(IIOMetadataNode root, String name) {
		for (int i = 0; i < root.getLength(); i++) {
			if (root.item(i).getNodeName().equalsIgnoreCase(name)) {
				return (IIOMetadataNode) root.item(i);
			}
		}
		IIOMetadataNode node = new IIOMetadataNode(name);
		root.appendChild(node);
		return node;
	}

}
