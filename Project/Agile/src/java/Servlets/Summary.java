/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import testpdf.createPdf;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Aleksandr
 */
@WebServlet(name = "Summary", urlPatterns = {"/Summary"})
public class Summary extends HttpServlet {
    
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("summary.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String id = request.getParameter("id");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String module = request.getParameter("module");
        
        HttpSession session = request.getSession(); 
        
        if (id!=""&&firstname!=""&&lastname!=""&&module!="")
        {
            session.setAttribute("id", id);
            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);
            session.setAttribute("module", module);
            rd = request.getRequestDispatcher("pdfsummary.jsp");
            createPDF(id,firstname,lastname,module);
        }
        else
        {
            rd = request.getRequestDispatcher("summary.jsp");
        }
        rd.forward(request, response);
        
    }
    public void createPDF(String id, String firstname, String lastname, String module) throws IOException
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
        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        //Begin the Content stream 
      //Begin the Content stream 
      contentStream.beginText(); 
       
      //Setting the font to the Content stream
      contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );
       
      //Setting the leading
      contentStream.setLeading(14.5f);

      //Setting the position for the line
      contentStream.newLineAtOffset(25, 725);

      String text1 = "Maticulation number: " + id;
      String text2 = "Firstname: " + firstname;
      String text3 = "Lastname: " + lastname;
      String text4 = "Module: " + module;

      //Adding text in the form of string
      contentStream. showText(text1);
      contentStream.newLine();
      contentStream. showText(text2);
      contentStream.newLine();
      contentStream. showText(text3);
      contentStream.newLine();
      contentStream. showText(text4);
      //Ending the content stream
      contentStream.endText();


      System.out.println("Content added");

      //Closing the content stream
      contentStream.close();

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
