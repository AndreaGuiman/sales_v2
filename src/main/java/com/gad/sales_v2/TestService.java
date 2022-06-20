package com.gad.sales_v2;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("test")
public class TestService {

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] print() throws FileNotFoundException {
        createPDF();
        try{
            FileInputStream fileInputStream = new FileInputStream(new File("iTextPDF.pdf"));
            byte[] targetArray = new byte[fileInputStream.available()];
            fileInputStream.read(targetArray);
            return targetArray;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static void createPDF() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("iTextPDF.pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        Text text = new Text("test");
        Paragraph paragraph = new Paragraph(text);
        document.add(paragraph);

        document.close();
    }
}
