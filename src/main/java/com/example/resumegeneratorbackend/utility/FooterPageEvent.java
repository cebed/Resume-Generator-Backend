package com.example.resumegeneratorbackend.utility;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;
import java.util.logging.Logger;


public class FooterPageEvent extends PdfPageEventHelper {
    private String address;
    private String  city;
    private String postno;


    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }
    public void onEndPage(PdfWriter writer, Document document) {

            Rectangle rect = writer.getBoxSize("art");
            Font footerfont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
            Font footerfont1 = new Font(Font.FontFamily.TIMES_ROMAN, 10);


            Chunk c = new Chunk("FrontEdgeIT AB", footerfont);
            Chunk c1 = new Chunk(address,footerfont1);
            Chunk c2 = new Chunk("SE- "+ postno + " " + city ,footerfont1);





            ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase(c), rect.getLeft(60), rect.getBottom(5), 0);
            ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase(c1), rect.getLeft(60), rect.getBottom(-8), 0);
            ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase(c2), rect.getLeft(60), rect.getBottom(-22), 0);

            //ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Bottom Right"), rect.getRight(), rect.getBottom(), 0);


            final int currentPageNumber = writer.getCurrentPageNumber();

            if (currentPageNumber == 1) {
                return;
            }

            try {
                final Rectangle pageSize = document.getPageSize();
                final PdfContentByte directContent = writer.getDirectContent();

                directContent.setColorFill(BaseColor.BLACK);
                directContent.setFontAndSize(BaseFont.createFont(), 10);

                directContent.setTextMatrix(pageSize.getRight(300), pageSize.getBottom(30));
                directContent.showText(String.valueOf(currentPageNumber));

            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }

        }
    }

