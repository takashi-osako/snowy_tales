package snowy_tales;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        XMLWorker worker = new XMLWorker();
        
        // How to read from resources?
        worker.createPDF("/Users/dorisip/workspace/snowy_tales/PDFGenerator/src/resources/test.html");
    }
}
