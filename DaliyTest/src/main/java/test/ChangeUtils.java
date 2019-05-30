package test;

import java.io.*;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ChangeUtils {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String docPath = "D:\\ChromeDownload\\20190514090757635.docx";
        String pdfPath = "D:\\ChromeDownload\\20190514090757635.pdf";

        XWPFDocument document;
        InputStream doc = new FileInputStream(docPath);
        document = new XWPFDocument(doc);
        PdfOptions options = PdfOptions.create();
        OutputStream out = new FileOutputStream(pdfPath);
        PdfConverter.getInstance().convert(document, out, options);

        doc.close();
        out.close();
    }

}
