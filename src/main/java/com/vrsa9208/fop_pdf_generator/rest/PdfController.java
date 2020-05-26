package com.vrsa9208.fop_pdf_generator.rest;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrsa9208.fop_pdf_generator.util.pdf.PDFGenerator;

@RestController
@RequestMapping("/pdf")
public class PdfController {
	
	@Autowired
	private PDFGenerator pdfGenerator;

	@GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody byte[] getPdf() throws FileNotFoundException {
		Reader xmlInput = new FileReader("/Users/vvo0002/Documents/Temp/factura/factura.xml");
		Reader xmlTemplate = new FileReader("/Users/vvo0002/Documents/Temp/factura/template.xml");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		pdfGenerator.render(xmlInput, output, xmlTemplate);
		return output.toByteArray();
	}
}
