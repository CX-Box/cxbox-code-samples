package org.demo.documentation.other.fileConverter.converters;

import org.cxbox.core.dto.rowmeta.converter.Converter;
import org.cxbox.core.dto.rowmeta.converter.ConverterIdentifier;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.demo.documentation.other.fileConverter.FileConverterServiceExt;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class JpgToPng implements Converter {

	public static ConverterIdentifier JPG_TO_PNG = ConverterIdentifier.of(FileConverterServiceExt.JPG, FileConverterServiceExt.PNG);

	@Override
	public ConverterIdentifier converter() {
		return JPG_TO_PNG;
	}


	@Override
	public void convert(FileDownloadDto data, OutputStream out, String from, String to) {
		try (InputStream in = data.getContent().get()) {
			BufferedImage image = ImageIO.read(in);
			if (image == null) {
				throw new BusinessException("Unsupported or corrupted image stream")
						.addPopup("Unsupported or corrupted image");
			}
			boolean writed = ImageIO.write(image, "png", out);
			if (!writed) {
				throw new BusinessException("No PNG writer available in ImageIO")
						.addPopup("No PNG writer available");
			}
			out.flush();
		} catch (IOException e) {
			throw new BusinessException("Cannot convert this data");
		}
	}

}
