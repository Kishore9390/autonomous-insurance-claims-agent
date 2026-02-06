package com.synapx.claims.parser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;

public class PdfParser {
    public static String extractText(String path) {
        try (PDDocument doc = PDDocument.load(new File(path))) {
            return new PDFTextStripper().getText(doc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
