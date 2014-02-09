package com.dryize.jodconverter;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting JodConverter..." );
        for(String arg : args){
            System.out.println("arg -> " + arg);
        }
        DocumentConverter.ConvertDocToPNG(args[0]);

        OfficeManager officeManager = null;

        officeManager = new DefaultOfficeManagerConfiguration()
                //.setOfficeHome("/home/dryize/openoffice4")
                //.setConnectionProtocol(OfficeConnectionProtocol.PIPE)
                .buildOfficeManager();
        officeManager.start();

        // 2) Create JODConverter converter
        OfficeDocumentConverter converter = new OfficeDocumentConverter(
                officeManager);
    }
}
