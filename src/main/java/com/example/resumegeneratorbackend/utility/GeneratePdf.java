package com.example.resumegeneratorbackend.utility;



import com.example.resumegeneratorbackend.model.Education;
import com.example.resumegeneratorbackend.model.Users;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdf {

    public static final String IMG = "resources/images/bruno.jpg";



    public static ByteArrayInputStream usersInfoPdf(Users users) {



        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);

            String imageUrl = "https://www.w3schools.com/images/picture.jpg";

            Image image2 = Image.getInstance(new URL(imageUrl));
            document.open();

            document.add(image2);
            document.add(new Paragraph("Front edge It:\t\t\t\t\t\t"));
            document.add(new Paragraph("Name:\t\t\t\t\t\t\t\t" + users.getFullName() ));
            document.add(new Paragraph("Address:\t\t\t\t\t\t\t\t" + users.getAddress() ));
         // document.add(new Paragraph("Name" + users.getEducations().toString() ));
            for (Education education : users.getEducations()){
              //  document.add(new Paragraph("Name" + users.getEducations().toString() ));
                document.add(new Paragraph("education title: \t\t\t\t\t\t" + education.getTitle() ));
                document.add(new Paragraph("education start date: \t\t \t\t\t\t" + education.getStart_date()));
                document.add(new Paragraph("education end date: \t\t \t\t\t\t" + education.getEnd_date()));
                document.add(new Paragraph("education Description: \t\t\t\t\t\t " + education.getDescription()));
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
