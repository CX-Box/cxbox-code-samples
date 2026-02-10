package org.demo.documentation.other.fileConverter.converters;

import org.cxbox.core.dto.rowmeta.converter.Converter;
import org.cxbox.core.dto.rowmeta.converter.ConverterIdentifier;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.demo.documentation.other.fileConverter.FileConverterServiceExt;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Service
public class DocxToDoc implements Converter {

	public static ConverterIdentifier DOCX_TO_DOC = ConverterIdentifier.of(FileConverterServiceExt.DOCX, FileConverterServiceExt.DOC);

	@Override
	public ConverterIdentifier converter() {
		return DOCX_TO_DOC;
	}


	@Override
	public void convert(FileDownloadDto data, OutputStream out, String from, String to) {
		throw new BusinessException("Cannot convert file DOC to Docx");
	}


}
