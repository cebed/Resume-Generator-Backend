package com.example.resumegeneratorbackend.utility;



import com.example.resumegeneratorbackend.model.Education;
import com.example.resumegeneratorbackend.model.Users;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdf {


    public static ByteArrayInputStream usersInfoPdf(Users users) {



        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {


            PdfWriter.getInstance(document, out);
            document.open();
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
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
