package org.demo.documentation.other.fileConverter;

import org.cxbox.core.dto.rowmeta.converter.Converter;
import org.cxbox.core.dto.rowmeta.converter.ConverterIdentifier;
import org.cxbox.core.dto.rowmeta.converter.FileConverterService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.demo.documentation.other.fileConverter.converters.DocxToDoc.DOCX_TO_DOC;
import static org.demo.documentation.other.fileConverter.converters.DocxToPdf.DOCX_TO_PDF;
import static org.demo.documentation.other.fileConverter.converters.JpgToPng.JPG_TO_PNG;
import static org.demo.documentation.other.fileConverter.converters.jave.WavToMp3.WAV_TO_MP3;

@Component
@Primary
public class FileConverterServiceExt extends FileConverterService {

	public static final String PNG = ".png";

	public static final String PDF = ".pdf";

	public static final String JPG = ".jpg";

	public static final String JPEG = ".jpeg";

	public static final String MP3 = ".mp3";

	public static final String WAV = ".wav";

	public static final String M4A = ".m4a";

	public static final String WMA = ".wma";

	public static final String TXT = ".txt";

	public static final String DOCX = ".docx";

	public static final String DOC = ".doc";

	public static final List<ConverterIdentifier> ALL_REGISTERED_CONVERTERS = List.of(
			DOCX_TO_DOC,
			DOCX_TO_PDF,
			JPG_TO_PNG,
			WAV_TO_MP3,
			DOCX_TO_PDF
	);

	public FileConverterServiceExt(List<Converter> converters) {
		super(converters);
	}

}
