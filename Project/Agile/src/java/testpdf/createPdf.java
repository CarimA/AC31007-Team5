/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpdf;

import java.io.IOException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import java.util.Calendar; 
import java.util.GregorianCalendar;


/**
 *
 * @author Aleksandr
 */
public class createPdf {
    public static void main(String[] args)
    {     
        //Creating PDF document object 
        PDDocument document = new PDDocument();  
        for (int i=0; i<3; i++) 
        {
            //Creating a blank page 
            PDPage blankPage = new PDPage();
            //Adding the blank page to the document
            document.addPage( blankPage );
        } 
        
        //Creating the PDDocumentInformation object 
        PDDocumentInformation pdd = document.getDocumentInformation();
        
        //Setting the author of the document
        pdd.setAuthor("Aleksandrs");
       
         // Setting the title of the document
        pdd.setTitle("Test document"); 
       
        //Setting the creator of the document 
        pdd.setCreator("Aleksandrs"); 
       
        //Setting the subject of the document 
        pdd.setSubject("Sample"); 
       
        //Setting the created date of the document 
        Calendar date = new GregorianCalendar();
        date.set(2017, 1, 18); 
        pdd.setCreationDate(date);
        //Setting the modified date of the document 
        date.set(2017, 1, 18); 
        pdd.setModificationDate(date); 
       
        //Setting keywords for the document 
        pdd.setKeywords("sample, first example, my pdf"); 
        //Removing the pages
        //document.removePage(1);
        //System.out.println("page removed");
       System.out.println("Properties added successfully ");
        try 
        {
            //Saving the document
            document.save("C:/Users/Aleksandr/Desktop/test.pdf");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(createPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PDF created");
        try 
        {
            //Closing the document
            document.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(createPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
