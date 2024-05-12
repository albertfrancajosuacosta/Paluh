import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.*;

public class Teste
{
    public static void main(String[] args) throws IOException{
    	
    	
    	// Assuming you have a PDDocument object loaded with your PDF
    	
    	File file = new File("HelloWorld.pdf");
    	PDDocument document = Loader.loadPDF(file);
    	
    	PDPage pagina = document.getPage(0);
    	
    	System.out.println(pagina.getContents());

    	//List<PDFPagePanel> pagePanels = new ArrayList<>();
    	
    	//for (PDPage page : document.getPages()) {
    	  //PDFPagePanel pagePanel = new PDFPagePanel(page);
    	  //pagePanels.add(pagePanel);
    	//}

    	// Add pagePanels to a JScrollPane within your Swing frame
    	//JScrollPane scrollPane = new JScrollPane(pagePanels.get(0));
    	// Add functionality to switch between pages using pagePanels

    	// Add scrollPane to your Swing frame layout
    	
    	
    
    }

} 
