package com.example.resumegeneratorbackend.utility;



import com.example.resumegeneratorbackend.model.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdf {


    public static ByteArrayInputStream usersInfoPdf(Users users) {

        Document document = new Document(PageSize.A4, 70f, 70f, 50f, 85f);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {



            PdfWriter writer = PdfWriter.getInstance(document, out);
            Rectangle rect = new Rectangle(50, 50, 650, 900);
            writer.setBoxSize("art", rect);
            FooterPageEvent event = new FooterPageEvent();
            writer.setPageEvent(event);
            document.open();


            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD);
            Font entityFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Font normalfont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font userprofilefont= new Font(Font.FontFamily.TIMES_ROMAN,14);


            String imageUrl = "https://frontedgeit.se/wp-content/uploads/2018/04/primar-vit-u-tagline.png";

            Image image2 = Image.getInstance(new URL(imageUrl));
            image2.scalePercent(20,20);

            document.add(image2);


            document.add(new Paragraph(users.getFullName(), boldFont ));

            document.add(new Paragraph("Title:\t" + users.getCurrentTitle(), userprofilefont ));


            Image prophileImage = Image.getInstance(new URL(users.getImage()));
            prophileImage.scalePercent(20,20);
            prophileImage.setIndentationLeft(350);
            document.add(prophileImage);

            // Setting paragraph line spacing to 32
            Paragraph para1 = new Paragraph();

            // Setting the space before and after the paragraph
            para1.setSpacingBefore(30);
            para1.add(new Chunk(users.getUserProfile()));
            document.add(para1);
            LineSeparator l = new LineSeparator(0.5f, 100, null, Element.ALIGN_CENTER, 0.5f);
            document.add(new Chunk(l));



            Paragraph entityName = new Paragraph("ERFARENHETER", entityFont);
            entityName.setSpacingBefore(25);
            entityName.setSpacingAfter(15);
            document.add(entityName);

                for(Workexperience workexperience : users.getWorkExperience()){

                    PdfPTable table = new PdfPTable(2);
                    table.setWidths(new float[] { 1, 4 });
                    table.setSpacingAfter(20);
                    PdfPCell cellOne = new PdfPCell(new Phrase(workexperience.getStart_date(), normalfont));
                    PdfPCell cellTwo = new PdfPCell(new Phrase("Företag1"+", "+workexperience.getTitle(), normalfont));
                    PdfPCell cellThree =new PdfPCell(new Phrase("-"+"\n"+ workexperience.getEnd_date(),  normalfont));
                    PdfPCell cellFour =new PdfPCell(new Phrase(workexperience.getDescription(), normalfont));


                    cellOne.setBorder(Rectangle.NO_BORDER);
                    //cellOne.setBackgroundColor(new Color(255,255,45));

                    cellTwo.setBorder(Rectangle.NO_BORDER);
                    cellThree.setBorder(Rectangle.NO_BORDER);
                    cellFour.setBorder(Rectangle.NO_BORDER);


                    table.setWidthPercentage(100);
                    table.addCell(cellOne);
                    table.addCell(cellTwo);
                    table.addCell(cellThree);
                    table.addCell(cellFour);

                    document.add(table);


                }

            Paragraph entityName2 = new Paragraph("KOMPETENSER", entityFont);
            entityName2.setSpacingAfter(7);
            document.add(entityName2);

            for(Skills skills : users.getSkills()){
                PdfPTable table = new PdfPTable(2);
                table.setWidths(new float[] { 1, 4 });
                PdfPCell cellOne = new PdfPCell(new Phrase(skills.getTitle(), normalfont));
                PdfPCell cellTwo = new PdfPCell(new Phrase(skills.getLevel(), normalfont));
                cellOne.setBorder(Rectangle.NO_BORDER);
                //cellOne.setBackgroundColor(new Color(255,255,45));

                cellTwo.setBorder(Rectangle.NO_BORDER);
                table.setWidthPercentage(100);
                table.addCell(cellOne);
                table.addCell(cellTwo);

                document.add(table);
            }


            Paragraph entityName3 = new Paragraph("CERTIFIERINGAR", entityFont);
            entityName3.setSpacingBefore(20);
            entityName3.setSpacingAfter(7);
            document.add(entityName3);
            document.add(new Paragraph("missing content right now", normalfont));
            //for loop här för certificates


            /*
                    KURSER
             */

            Paragraph entityName4 = new Paragraph("KURSER", entityFont);
            entityName4.setSpacingBefore(20);
            entityName4.setSpacingAfter(7);
            document.add(entityName4);

            for(Courses courses : users.getCourses()){
                PdfPTable table = new PdfPTable(2);
                table.setWidths(new float[] { 1, 4 });


                PdfPCell cellOne = new PdfPCell(new Phrase(courses.getStart_date(), normalfont));
                PdfPCell cellTwo = new PdfPCell(new Phrase(courses.getTitle(), normalfont));
                cellOne.setBorder(Rectangle.NO_BORDER);
                //cellOne.setBackgroundColor(new Color(255,255,45));

                cellTwo.setBorder(Rectangle.NO_BORDER);
                table.setWidthPercentage(100);
                table.addCell(cellOne);
                table.addCell(cellTwo);

                document.add(table);
            }

            /*
                    utbildningar
             */
            Paragraph entityName5 = new Paragraph("UTBILDNINGAR", entityFont);
            entityName5.setSpacingBefore(20);
            entityName5.setSpacingAfter(7);
            document.add(entityName5);

            for(Education education : users.getEducations()){
                PdfPTable eduTable = new PdfPTable(2);
                eduTable.setSpacingAfter(15);
                eduTable.setWidths(new float[] { 1, 4 });


                PdfPCell cellone = new PdfPCell(new Phrase(education.getStart_date(), normalfont));
                PdfPCell celltwo = new PdfPCell(new Phrase(education.getTitle()+", "+education.getDescription(), normalfont));
                cellone.setBorder(Rectangle.NO_BORDER);
                celltwo.setBorder(Rectangle.NO_BORDER);
                eduTable.setWidthPercentage(100);
                eduTable.addCell(cellone);
                eduTable.addCell(celltwo);

                document.add(eduTable);
            }

            /*
                    TIDIGARE ANSTÄLLNINGAR
             */
            Paragraph entityName6 = new Paragraph("TIDIGARE ANSTÄLLNINGAR", entityFont);
            entityName6.setSpacingBefore(20);
            entityName6.setSpacingAfter(7);
            document.add(entityName6);

             /*
                    SPRÅK
             */
            Paragraph entityName7 = new Paragraph("SPRÅK", entityFont);
            entityName7.setSpacingBefore(20);
            entityName7.setSpacingAfter(7);
            document.add(entityName7);

            Font bulletfont = new Font(Font.FontFamily.ZAPFDINGBATS, 5);
            Chunk bullet = new Chunk(String.valueOf((char) 108), bulletfont);





            for(Languages languages : users.getLanguages()){
                Paragraph lang = new Paragraph();
                lang.add(bullet);
                lang.add(new Phrase("\t\t\t\t " + languages.getTitle() + " ", normalfont));
                document.add(lang);
            }



            /*
                    Övrigt
             */
            Paragraph entityName8 = new Paragraph("ÖVRIGT", entityFont);
            entityName8.setSpacingBefore(20);
            entityName8.setSpacingAfter(7);
            document.add(entityName8);

            for(Others others : users.getOthers()){
                PdfPTable otherTable = new PdfPTable(2);
                otherTable.setSpacingAfter(15);
                otherTable.setWidths(new float[] { 1, 4 });


                PdfPCell cellone = new PdfPCell(new Phrase(others.getTitle(), normalfont));
                PdfPCell celltwo = new PdfPCell(new Phrase(others.getDescription(), normalfont));
                cellone.setBorder(Rectangle.NO_BORDER);
                celltwo.setBorder(Rectangle.NO_BORDER);
                otherTable.setWidthPercentage(100);
                otherTable.addCell(cellone);
                otherTable.addCell(celltwo);

                document.add(otherTable);
            }


            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(GeneratePdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }



}
