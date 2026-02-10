package org.demo.documentation.other.fileConverter.converters;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.cxbox.core.dto.rowmeta.converter.Converter;
import org.cxbox.core.dto.rowmeta.converter.ConverterIdentifier;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class TextToPdfConverter implements Converter {

	public static final ConverterIdentifier TXT_TO_PDF =
			ConverterIdentifier.of(".txt", ".pdf");

	@Override
	public ConverterIdentifier converter() {
		return TXT_TO_PDF;
	}


	@Override
	public void convert(FileDownloadDto data, OutputStream out, String from, String to) {
		try (InputStream in = data.getContent().get();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
			 PDDocument doc = new PDDocument()) {

			PDFont font = PDType1Font.COURIER;
			float fontSize = 11f;
			float leading = 1.2f * fontSize;

			float margin = 40f;

			PDPage page = new PDPage(PDRectangle.A4);
			doc.addPage(page);

			float yStart = page.getMediaBox().getHeight() - margin;
			float y = yStart;
			float width = page.getMediaBox().getWidth() - 2 * margin;

			PDPageContentStream cs = new PDPageContentStream(doc, page);
			cs.setFont(font, fontSize);
			cs.beginText();
			cs.newLineAtOffset(margin, y);

			String line;
			while ((line = reader.readLine()) != null) {
				// Wrap the line into chunks that fit page width
				for (String wrapped : wrapLine(line, font, fontSize, width)) {

					// Page break
					if (y - leading < margin) {
						cs.endText();
						cs.close();

						page = new PDPage(PDRectangle.A4);
						doc.addPage(page);

						y = yStart;
						cs = new PDPageContentStream(doc, page);
						cs.setFont(font, fontSize);
						cs.beginText();
						cs.newLineAtOffset(margin, y);
					}

					cs.showText(wrapped.isEmpty() ? " " : wrapped);
					cs.newLineAtOffset(0, -leading);
					y -= leading;
				}
			}

			cs.endText();
			cs.close();

			doc.save(out);
			out.flush();

		} catch (IOException e) {
			throw new BusinessException(e).addPopup("Error while converting text to PDF");
		}
	}

	private static List<String> wrapLine(String line, PDFont font, float fontSize, float maxWidth) throws IOException {
		if (line == null || line.isEmpty()) return List.of("");
		List<String> out = new ArrayList<>();
		String remaining = line;
		while (!remaining.isEmpty()) {
			int cut = findMaxFittingIndex(remaining, font, fontSize, maxWidth);
			if (cut <= 0) cut = 1;
			int lastSpace = remaining.lastIndexOf(' ', cut - 1);
			if (lastSpace > 0) {
				cut = lastSpace + 1;
			}
			String part = remaining.substring(0, cut).stripTrailing();
			out.add(part);
			remaining = remaining.substring(cut).stripLeading();
		}
		return out;
	}

	private static int findMaxFittingIndex(String text, PDFont font, float fontSize, float maxWidth) throws IOException {
		int lo = 0, hi = text.length();
		while (lo < hi) {
			int mid = (lo + hi + 1) >>> 1;
			String sub = text.substring(0, mid);
			float width = font.getStringWidth(sub) / 1000f * fontSize;
			if (width <= maxWidth) lo = mid;
			else hi = mid - 1;
		}
		return lo;
	}
}