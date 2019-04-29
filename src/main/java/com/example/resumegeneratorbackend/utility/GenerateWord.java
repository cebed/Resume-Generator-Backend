
        package com.example.resumegeneratorbackend.utility;

        import org.apache.poi.xwpf.usermodel.Borders;
        import org.apache.poi.xwpf.usermodel.XWPFDocument;
        import org.apache.poi.xwpf.usermodel.XWPFParagraph;
        import org.apache.poi.xwpf.usermodel.XWPFRun;

        import java.io.File;
        import java.io.FileOutputStream;


public class GenerateWord {

    public void writeDoc() throws Exception {
        //Blank Document
        XWPFDocument document= new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(
                new File("/Users/nurabd/Downloads/testa.docx"));

        //create paragraph
        XWPFParagraph paragraph = document.createParagraph();


        XWPFRun run=paragraph.createRun();
        run.setText("Hotel: ");

        document.write(out);
        out.close();
        System.out.println("hotel.docx written successully");
    }

}