package com.rscart.invoice;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {
	public void onStartPage(PdfWriter writer, Document document) {
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.RED);
		font.setSize(23);
		Rectangle rect = writer.getBoxSize("art");
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Retail Invoice/Bill",font),
				rect.getLeft(250.0f), rect.getTop(), 0);		
	}

	public void onEndPage(PdfWriter writer, Document document) {
		Rectangle rect = writer.getBoxSize("art");
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Customer Care : 1800 268 9898 || www.rscart.com/support"),
				rect.getLeft(130f), rect.getBottom(), 0);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("PageNo 1 of 1"),
				rect.getRight(), rect.getBottom(), 0);
	}
}