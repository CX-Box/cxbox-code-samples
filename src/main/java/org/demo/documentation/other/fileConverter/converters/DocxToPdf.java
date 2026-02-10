package org.demo.documentation.other.fileConverter.converters;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.cxbox.core.dto.rowmeta.converter.Converter;
import org.cxbox.core.dto.rowmeta.converter.ConverterIdentifier;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.demo.documentation.other.fileConverter.FileConverterServiceExt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

@Service
public class DocxToPdf implements Converter {

	public static ConverterIdentifier DOCX_TO_PDF = ConverterIdentifier.of(FileConverterServiceExt.DOCX, FileConverterServiceExt.PDF);

	@Override
	public ConverterIdentifier converter() {
		return DOCX_TO_PDF;
	}


	@Override
	public void convert(FileDownloadDto data, OutputStream out, String from, String to) {
		try (XWPFDocument doc = new XWPFDocument(data.getContent().get())) {
			ensureTableCellProps(doc);
			PdfOptions options = PdfOptions.create();
			PdfConverter.getInstance().convert(doc, out, options);
			out.flush();
		} catch (IOException e) {
			throw new BusinessException(e).addPopup("Cannot convert file to PDF");
		}
	}

	public static void ensureTableCellProps(XWPFDocument doc) {
		for (XWPFTable table : doc.getTables()) {
			for (XWPFTableRow row : table.getRows()) {
				for (XWPFTableCell cell : row.getTableCells()) {
					CTTc tc = cell.getCTTc();
					CTTcPr tcPr = tc.isSetTcPr() ? tc.getTcPr() : tc.addNewTcPr();
					CTTblWidth tcW = tcPr.isSetTcW() ? tcPr.getTcW() : tcPr.addNewTcW();
					BigInteger w = (BigInteger) tcW.getW();
					if (w == null || w.signum() <= 0) {
						tcW.setType(STTblWidth.DXA);
						tcW.setW(1);
					}
				}
			}
		}
	}
}
