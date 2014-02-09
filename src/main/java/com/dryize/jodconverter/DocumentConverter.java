package com.dryize.jodconverter;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import java.io.File;

/**
 * Created by Lenovo on 12/27/13.
 */
public class DocumentConverter {

    public static Integer ConvertDocToPNG(String doc){
        OfficeManager officeManager = null;
        Integer result=-1;
        try {
            officeManager = new DefaultOfficeManagerConfiguration()
                    //.setOfficeHome("/home/dryize/openoffice4")
                    //.setConnectionProtocol(OfficeConnectionProtocol.PIPE)
                    .buildOfficeManager();
            officeManager.start();

            // 2) Create JODConverter converter
            OfficeDocumentConverter converter = new OfficeDocumentConverter(
                    officeManager);

            File pdf = new File(doc + "raw.pdf");
            converter.convert(new File(doc), pdf);
/*
            PDFDocument document = new PDFDocument();
            document.load(pdf);
            SimpleRenderer renderer = new SimpleRenderer();

            // set resolution (in DPI)
            renderer.setResolution(72);
            java.util.List<Image> images = renderer.render(document);


            new File(doc.path() + "png/").mkdirs();
            for (int i = 0; i < images.size(); i++) {

                ImageIO.write((RenderedImage) images.get(i), "jpg", new File(doc.path() + "png/" + (i + 1) + ".jpg"));
            }

            result =images.size();
*/
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            // 4) Stop LibreOffice in headless mode.
            if (officeManager != null) {
                officeManager.stop();
            }
        }

        return result;
    }



}
