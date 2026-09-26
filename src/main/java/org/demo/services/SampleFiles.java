package org.demo.services;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.springframework.stereotype.Service;

/** Sample files with real content: the file widgets and fields show their preview (CardList, CardCarouselList). */
@Service
@RequiredArgsConstructor
public class SampleFiles {

	private static final Color BLUE = new Color(0x1890FF);

	private static final Color GRAY = new Color(0x595959);

	private final CustomFileUploadServices files;

	/** Uploads the file of the document with this title: Certificate, Floor plan, Price list, Invoice, Meeting notes or Contract. */
	public CxboxResponseDTO<FileUploadDto> upload(String title) {
		return switch (title) {
			case "Certificate" -> certificate();
			case "Floor plan" -> floorPlan();
			case "Price list" -> priceList();
			case "Invoice" -> invoice();
			case "Meeting notes" -> meetingNotes();
			case "Contract" -> contract();
			default -> throw new IllegalArgumentException("No sample file for " + title);
		};
	}

	public CxboxResponseDTO<FileUploadDto> contract() {
		return pdf("Contract.pdf", "Service contract", List.of(
				"The Customer orders and the Contractor provides",
				"the office cleaning services.",
				"",
				"1. Term: from 1 September to 31 December.",
				"2. Price: 1 200 per month.",
				"3. Payment: within 10 days after the act.",
				"",
				"Customer ____________    Contractor ____________"
		));
	}

	public CxboxResponseDTO<FileUploadDto> invoice() {
		return pdf("Invoice.pdf", "Invoice No 42", List.of(
				"Office cleaning, September        1 200.00",
				"Window cleaning                     300.00",
				"Carpet cleaning                     250.00",
				"",
				"Total                             1 750.00",
				"",
				"Due in 10 days."
		));
	}

	public CxboxResponseDTO<FileUploadDto> meetingNotes() {
		return files.uploadFile("Meeting notes.txt", "text/plain",
				"Weekly sync: the cleaning schedule is approved.".getBytes(StandardCharsets.UTF_8));
	}

	public CxboxResponseDTO<FileUploadDto> priceList() {
		return png("Price list.png", g -> {
			title(g, "Price list");
			String[][] rows = {{"Office cleaning", "1 200"}, {"Window cleaning", "300"}, {"Carpet cleaning", "250"},
					{"Floor polishing", "400"}, {"Kitchen cleaning", "150"}};
			g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
			for (int i = 0; i < rows.length; i++) {
				int y = 150 + i * 56;
				g.setColor(i % 2 == 0 ? new Color(0xE6F4FF) : Color.WHITE);
				g.fillRect(40, y - 36, 520, 56);
				g.setColor(GRAY);
				g.drawString(rows[i][0], 60, y);
				g.drawString(rows[i][1], 460, y);
			}
		});
	}

	public CxboxResponseDTO<FileUploadDto> floorPlan() {
		return png("Floor plan.png", g -> {
			title(g, "Second floor");
			g.setColor(GRAY);
			g.setStroke(new BasicStroke(6));
			g.drawRect(40, 100, 520, 440);
			g.setStroke(new BasicStroke(3));
			g.drawLine(300, 100, 300, 360);
			g.drawLine(40, 360, 560, 360);
			g.drawLine(420, 360, 420, 540);
			g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
			g.drawString("Office", 130, 240);
			g.drawString("Meeting room", 360, 240);
			g.drawString("Hall", 200, 460);
			g.drawString("Kitchen", 450, 460);
		});
	}

	public CxboxResponseDTO<FileUploadDto> certificate() {
		return png("Certificate.png", g -> {
			g.setColor(BLUE);
			g.setStroke(new BasicStroke(14));
			g.drawRect(30, 30, 540, 540);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 44));
			g.drawString("Certificate", 180, 200);
			g.setColor(GRAY);
			g.setFont(new Font(Font.SERIF, Font.PLAIN, 24));
			g.drawString("of the office cleaning quality", 140, 270);
			g.drawString("issued to the Main office", 165, 330);
			g.setColor(new Color(0xFAAD14));
			g.fillOval(250, 390, 100, 100);
		});
	}

	@SneakyThrows
	private CxboxResponseDTO<FileUploadDto> pdf(String fileName, String heading, List<String> lines) {
		try (PDDocument document = new PDDocument(); ByteArrayOutputStream output = new ByteArrayOutputStream()) {
			PDPage page = new PDPage();
			document.addPage(page);
			try (PDPageContentStream content = new PDPageContentStream(document, page)) {
				content.beginText();
				content.setFont(PDType1Font.HELVETICA_BOLD, 28);
				content.newLineAtOffset(72, 690);
				content.showText(heading);
				content.setFont(PDType1Font.HELVETICA, 16);
				content.setLeading(26);
				content.newLine();
				content.newLine();
				for (String line : lines) {
					content.showText(line);
					content.newLine();
				}
				content.endText();
			}
			document.save(output);
			return files.uploadFile(fileName, "application/pdf", output.toByteArray());
		}
	}

	@SneakyThrows
	private CxboxResponseDTO<FileUploadDto> png(String fileName, Consumer<Graphics2D> draw) {
		BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		draw.accept(g);
		g.dispose();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(image, "png", output);
		return files.uploadFile(fileName, "image/png", output.toByteArray());
	}

	private static void title(Graphics2D g, String text) {
		g.setColor(BLUE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
		g.drawString(text, 40, 70);
	}

}
