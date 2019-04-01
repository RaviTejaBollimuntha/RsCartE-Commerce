package com.rscart.invoice;

import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

public class Invoice extends AbstractITextPdfView {
	@SuppressWarnings("static-access")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		writer.getInstance(doc, new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\invoice.pdf"));
		InvoiceUtil.CreateInvoice(model, doc, writer);
		
	}

}