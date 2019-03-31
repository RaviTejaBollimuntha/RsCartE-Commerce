package com.rscart.invoice;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.rscart.model.AddressForm;
import com.rscart.model.InvoiceOrderItem;
import com.rscart.model.Order;
import com.rscart.model.ShippingForm;

public class InvoiceUtil {
	private static String FROM_ID = "rscartsite@gmail.com";

	public static int emailInvoice(Map<String, Object> model, JavaMailSender mailSenderService,
			HttpServletRequest request, String emailto) {
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\invoice.pdf");
		Document doc = new Document();
		PdfWriter writer;
		try {			
			writer = PdfWriter.getInstance(doc, new FileOutputStream(f));
			CreateInvoice(model, doc, writer);
			MimeMessage mimeMessage = mailSenderService.createMimeMessage();
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
			mailMsg.setFrom(FROM_ID);
			mailMsg.setTo(FROM_ID);
			mailMsg.setSubject("Test mail with Attachment");
			mailMsg.setText("Please find Attachment.");
			FileSystemResource file1 = new FileSystemResource(System.getProperty("user.dir")+"\\src\\main\\resources\\invoice.pdf");
			// send off the email
			mailMsg.addAttachment("invoice.pdf",file1);
			mailSenderService.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public static Document CreateInvoice(Map<String, Object> model, Document doc, PdfWriter writer) throws Exception {
		Rectangle rect = new Rectangle(30, 30, 550, 800);
		writer.setBoxSize("art", rect);
		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
		writer.setPageEvent(event);
		doc.open();
		Order order = (Order) model.get("order");
		PdfPTable tab = new PdfPTable(3); // 3 columns.
		tab.setWidthPercentage(100); // Width 100%
		tab.setSpacingBefore(10f); // Space before table
		tab.setSpacingAfter(10f); // Space after table

		// Set Column widths
		float[] columnWidths = { 1.5f, 1f, 1f };
		tab.setWidths(columnWidths);
		String imFile =System.getProperty("user.dir")+"/src/main/webapp/resources/images/logo.png";
		Image img = Image.getInstance(imFile);

		PdfPCell cell1 = new PdfPCell();
		cell1.setBorderColor(BaseColor.WHITE);
		cell1.setPaddingLeft(10);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell1.addElement(img);
		Paragraph para = new Paragraph();
		para.add(new Chunk(
				"\nRsCart Headquarters\r\n" + "935 W. Webster Ave New Streets ,\r\n" + "Chicago\r\n" + "NY, IL 60614"));
		para.add(new Chunk("\nCALL:" + "866-874-4338"));
		para.add(new Chunk("\nEMAIL:" + "rscartsite@gmail.com"));
		PdfPCell cell2 = new PdfPCell(para);
		cell2.setBorderColor(BaseColor.WHITE);
		cell2.setPaddingLeft(10);
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Paragraph para1 = new Paragraph();
		para1.add(new Chunk("Tax Invoice #:" + String.valueOf(order.getOrderId()%5000)));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		para1.add(new Chunk("\n Date:" + dateFormat.format(date)));
		PdfPCell cell3 = new PdfPCell(para1);
		cell3.setBorderColor(BaseColor.WHITE);
		cell3.setPaddingLeft(10);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tab.addCell(cell1);
		tab.addCell(cell2);
		tab.addCell(cell3);
		doc.add(tab);
		Chunk linebreak = new Chunk(new DottedLineSeparator());
		doc.add(linebreak);
		PdfPTable atab = new PdfPTable(3); // 3 columns.
		atab.setWidthPercentage(100); // Width 100%
		atab.setSpacingBefore(10f); // Space before table
		atab.setSpacingAfter(10f); // Space after table
		atab.setWidths(columnWidths);

		PdfPCell acell1 = new PdfPCell();
		acell1.setBorderColor(BaseColor.WHITE);
		acell1.setPaddingLeft(10);
		acell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		acell1.setVerticalAlignment(Element.ALIGN_LEFT);
		Paragraph apara1 = new Paragraph();
		apara1.add(new Chunk("Order ID: " + String.valueOf(order.getOrderId()) + "\r\n" + "Order Date:"
				+ String.valueOf(order.getCreatedDate()) + "\r\n" + "Invoice No:" + String.valueOf(order.getOrderId())
				+ "\r\n" + "Invoice Date:" + String.valueOf(order.getCreatedDate()) + "\r\n" + "VAT/TIN:07810387105"));
		acell1.addElement(apara1);
		AddressForm customeraddress = (AddressForm) model.get("customeraddresss");
		Paragraph apara = new Paragraph();
		apara.add(new Chunk("Billing Address:\r\n" + customeraddress.getFullName() + "\r\n"
				+ customeraddress.getAddress1() + " " + customeraddress.getAddress2() + "\r\n"
				+ customeraddress.getCity() + " " + customeraddress.getState() + "\r\n" + customeraddress.getCountry()
				+ " " + customeraddress.getZipCode()));
		PdfPCell acell2 = new PdfPCell(apara);
		acell2.setBorderColor(BaseColor.WHITE);
		acell2.setPaddingLeft(10);
		acell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		acell2.setVerticalAlignment(Element.ALIGN_LEFT);
		ShippingForm address = (ShippingForm) model.get("addressDetails");
		Paragraph apara11 = new Paragraph();
		apara11.add(new Chunk("Shipping Address:\r\n" + address.getFullName() + "\r\n" + address.getAddress1() + " "
				+ address.getAddress2() + "\r\n" + address.getCity() + " " + address.getState() + "\r\n"
				+ address.getCountry() + " " + address.getZipCode()));

		PdfPCell acell3 = new PdfPCell(apara11);
		acell3.setBorderColor(BaseColor.WHITE);
		acell3.setPaddingLeft(10);
		acell3.setHorizontalAlignment(Element.ALIGN_LEFT);
		acell3.setVerticalAlignment(Element.ALIGN_LEFT);
		atab.addCell(acell1);
		atab.addCell(acell2);
		atab.addCell(acell3);
		doc.add(atab);
		doc.add(linebreak);
		PdfPTable table = new PdfPTable(6);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 0.8f, 4.0f, 1.5f, 0.8f, 1.5f, 1.5f });
		table.setSpacingBefore(10);
		table.setSpacingAfter(10f);
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.BLACK);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBorderColor(BaseColor.WHITE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("S.No", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("ITEM DESCRIPTION", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Qty", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Tax", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Total", font));
		table.addCell(cell);
		// write table row data
		@SuppressWarnings("unchecked")
		List<InvoiceOrderItem> orderItemsList = (List<InvoiceOrderItem>) model.get("orderItemsList");
		int i = 0, price = 0, qty = 0, tax = 0, sub = 0;
		for (InvoiceOrderItem orders : orderItemsList) {
			table.addCell(String.valueOf(++i));
			table.addCell(orders.getNAME());// item
			table.addCell(String.valueOf(orders.getPRICE()));// price
			price += orders.getPRICE();
			table.addCell(String.valueOf(orders.getQUANTITY()));// qty
			qty += orders.getQUANTITY();
			table.addCell(String.valueOf(orders.getPRICE() * 0.1));// gst
			tax += orders.getPRICE() * 0.1;
			table.addCell(String.valueOf(orders.getPRICE() * 0.1 + (orders.getQUANTITY() * orders.getPRICE())));// total
			sub += tax + orders.getQUANTITY() * orders.getPRICE();
		}
		doc.add(table);
		doc.add(linebreak);

		PdfPTable pdfPTable = new PdfPTable(6);
		pdfPTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		pdfPTable.setWidthPercentage(100.0f);
		pdfPTable.setWidths(new float[] { 0.8f, 4.0f, 1.5f, 0.8f, 1.5f, 1.5f });
		pdfPTable.setSpacingBefore(10);
		pdfPTable.setSpacingAfter(10f);
		pdfPTable.addCell("   ");
		pdfPTable.addCell("                         SuB Total:");
		pdfPTable.addCell(String.valueOf(price));
		pdfPTable.addCell(String.valueOf(qty));
		pdfPTable.addCell(String.valueOf(tax));
		pdfPTable.addCell(String.valueOf(sub));
		doc.add(pdfPTable);
		DottedLineSeparator separator = new DottedLineSeparator();
		Chunk c = new Chunk(separator);
		Paragraph p = new Paragraph("                           ");
		p.add(c);
		doc.add(p);
		PdfPTable fPTable = new PdfPTable(3);
		fPTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		fPTable.setWidthPercentage(100.0f);
		fPTable.setWidths(new float[] { 5.0f, 5.0f, 5.0f });
		fPTable.setSpacingBefore(10);
		fPTable.setSpacingAfter(10f);
		fPTable.addCell(" ");
		fPTable.addCell("                         Grand Total :");
		fPTable.addCell(String.valueOf(sub));
		doc.add(fPTable);
		doc.add(linebreak);
		ColumnText ct = new ColumnText(writer.getDirectContent());
		ct.setSimpleColumn(20, 0, 570, 220);
		Font green = new Font(FontFamily.HELVETICA, 9, Font.ITALIC, BaseColor.DARK_GRAY);
		Chunk greenText = new Chunk("Ordered Through :RaCart.com \r\n"
				+ "Customer Care : 1800 208 9898 || www.RsCart.com/support\r\n" + "\r\n"
				+ "At RsCart we try to deliver perfectly each and every time. But in the off-chance that you need to return the item, please do so with theReturns Policyoriginal Brand without which it will be really difficult for us to act on your request.Please help us in helping you. Terms and conditions apply.\r\n"
				+ "box/price tag, original packing and invoice The goods sold as part of this shipment are intended for end user consumption / retail sale and not for re-sale.\r\n"
				+ "\r\n"
				+ "Regd. office: RS Retail Services Private Limited, Ozone Manay Tech Park, No 56/18, 'B' Block, 9th Floor, Garvebhavipalya, Hosur Road, Bangalore-560068, Karnataka, India,Phone No : 9180 49083999. CIN : U72900KA2009PTC050123.",
				green);
		Paragraph p1 = new Paragraph(greenText);
		ct.addElement(p1);
		ct.go();
		doc.close();
		return doc;
	}

}
