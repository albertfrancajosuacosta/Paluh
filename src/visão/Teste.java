package visão;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Teste
{
    public static void main(String[] args) throws IOException{
    	Teste t = new Teste();

		
    }
    
    public Teste() {
    	teste();
    }
    
    
    public void teste() {
    	URL url = this.getClass().getClassLoader().getResource("Teste.html");
		File f = new File("Teste.html");
    	
    	System.out.println(f);
    	try {
			System.out.println(f.toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

} 
