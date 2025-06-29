    package Bridge_2;

    public class Program {
        public static void main(String[] args) {
            Renderer mobile = new MobileRenderer();
            Renderer desktop = new DesktopRenderer();

            Document pdfMobile = new PDFDocument(mobile);
            Document wordDesktop = new WordDocument(desktop);
            Document markdownMobile = new MarkdownDocument(mobile);
            Document pdfDesktop = new PDFDocument(desktop);

            pdfMobile.display();
            wordDesktop.display();
            markdownMobile.display();
            pdfDesktop.display();
        }
    }
