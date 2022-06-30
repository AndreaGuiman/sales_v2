package com.gad.sales_v2.util.pdf;

import com.gad.sales_v2.order.Order;
import com.gad.sales_v2.product_quantity.ProductQuantity;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PDFService {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void createAndSave(Order order) throws FileNotFoundException, MalformedURLException {
        order.setDateOfOrder(LocalDateTime.now());
        order.setDateOfSending(LocalDateTime.now().plusDays(1));
        PdfWriter pdfWriter = new PdfWriter(String.format(
                "C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\invoices\\%s.pdf", order.getId()
        ));
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        float[] colWidthsTableHeader = new float[]{30, 40, 30};
        Table tableHeader = new Table(UnitValue.createPercentArray(colWidthsTableHeader));
        tableHeader.setWidth(UnitValue.createPercentValue(85));
        tableHeader.setHorizontalAlignment(HorizontalAlignment.CENTER);
        addInvoiceInfo(tableHeader, order);
        removeBorders(tableHeader);

        float[] colWidthsTableProducts = new float[]{7, 46, 7, 10, 10, 10, 10};
        Table tableProducts = new Table(UnitValue.createPercentArray(colWidthsTableProducts));
        addProductList(tableProducts, order);

        double totalPrice = getPrice(order, false);
        double productTotalAmountTVA = getPrice(order, true);
        Text text = new Text(String.format(
                "Valoarea totala: %s ron", (Double.parseDouble(decimalFormat.format(totalPrice + productTotalAmountTVA)))
        ));
        Paragraph paragraph = new Paragraph(text).setTextAlignment(TextAlignment.LEFT);
        document.add(tableHeader);
        document.add(new Paragraph(new Text("\n")));
        document.add(tableProducts);
        document.add(new Paragraph(new Text("\n")));
        document.add(paragraph);
        Text text1 = new Text(String.format(
                "Emis de: %1$s %2$s", order.getAgent().getFirstName(), order.getAgent().getLastName()
        ));
        Paragraph paragraph1 = new Paragraph(text1).setTextAlignment(TextAlignment.LEFT);
        document.add(paragraph1);
        document.close();
    }

    private static void addInvoiceInfo(Table table, Order order) throws MalformedURLException {
        table.addCell(getCell(
                String.format("Furnizor: %s", "AGMed SRL"),
                8,
                TextAlignment.LEFT
        ));
        table.addCell(
                new Cell()
                        .add(new Image(ImageDataFactory.create("C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\logo.png"))
                                .scaleAbsolute(180, 40))
        );
        table.addCell(getCell(
                String.format("Cumparator: %s", order.getClient().getName()),
                8,
                TextAlignment.RIGHT
        ));

        table.addCell(getCell(
                String.format("Nr. Reg. Com.: %s", "J08/100/1900"),
                8,
                TextAlignment.LEFT
        ));
        table.addCell(getCell(
                "Comanda: ",
                11,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                String.format("Nr. Reg. Com.: %s", "J08/100/1900"),
                8,
                TextAlignment.RIGHT
        ));

        table.addCell(getCell(
                String.format("C.I.F.: %s", "10188800"),
                8,
                TextAlignment.LEFT
        ));
        table.addCell(getCell(
                String.format("Nr. LMDC.: %s", order.getId()),
                11,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                String.format("C.I.F.: %s", order.getClient().getVatOrIdNumber()),
                8,
                TextAlignment.RIGHT
        ));

        table.addCell(getCell(
                String.format("Sediul: %s", "Strada Grivitei Nr 27"),
                8,
                TextAlignment.LEFT
        ));
        table.addCell(getCell(
                String.format("Data emitere: %s", order.getDateOfOrder().toLocalDate()),
                11,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                String.format("Sediul: %s", order.getClient().getAddress()),
                8,
                TextAlignment.RIGHT
        ));

        table.addCell(getCell(
                String.format("Banca: %s", "BCR"),
                8,
                TextAlignment.LEFT
        ));
        table.addCell(getCell(
                "",
                11,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                String.format("Banca: %s", order.getClient().getBankAccount()),
                8,
                TextAlignment.RIGHT
        ));
    }

    private static void addProductList(Table table, Order order) {

        table.addCell(getCell(
                "Nr. Crt.",
                9,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                "Denumirea produselor sau a serviciilor",
                9,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                "U.M.",
                9,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                "Cantitatea",
                9,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                "Prețul unitar fără TVA - RON",
                9,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                "Valoarea fără TVA - RON",
                8,
                TextAlignment.CENTER
        ));
        table.addCell(getCell(
                "Valoare TVA 19% - RON",
                8,
                TextAlignment.CENTER
        ));

        List<ProductQuantity> products = order.getProductQuantities();
        int size = products.size();
        Double productFinalPrice;
        Double productTVA;
        for(int i = 0; i < size; i++){
            table.addCell(getCell(
                    String.valueOf(i + 1),
                    9,
                    TextAlignment.CENTER
            ));
            table.addCell(getCell(
                    products.get(i).getProduct().getName(),
                    10,
                    TextAlignment.CENTER
            ));
            table.addCell(getCell(
                    "BUC",
                    9,
                    TextAlignment.CENTER
            ));
            table.addCell(getCell(
                    String.valueOf(products.get(i).getQuantity()),
                    9,
                    TextAlignment.CENTER
            ));
            table.addCell(getCell(
                    String.valueOf(products.get(i).getProduct().getPrice()),
                    9,
                    TextAlignment.CENTER
            ));
            productFinalPrice = products.get(i).getProduct().getPrice() * products.get(i).getQuantity();
            table.addCell(getCell(
                    String.valueOf(Double.parseDouble(decimalFormat.format(productFinalPrice))),
                    8,
                    TextAlignment.CENTER
            ));
            productTVA = productFinalPrice * 0.19;
            table.addCell(getCell(
                    String.valueOf(Double.parseDouble(decimalFormat.format(productTVA))),
                    8,
                    TextAlignment.CENTER
            ));
        }
    }

    private static Cell getCell(String text, float fontSize, TextAlignment textAlignment){

        Cell cell = new Cell(1, 1);

        cell.add(new Paragraph(text));
        cell.setFontSize(fontSize);
        cell.setTextAlignment(textAlignment);

        return cell;
    }

    private static void removeBorders(Table table){

        for(IElement iElement: table.getChildren()){
            ((Cell)iElement).setBorder(Border.NO_BORDER);
        }
    }

    private static double getPrice(Order order, boolean withTVA){

        AtomicReference<Double> price = new AtomicReference<>((double) 0);
        List<ProductQuantity> productQuantities = order.getProductQuantities();
        productQuantities.forEach(productQuantity -> {
            if(withTVA) {
                price.updateAndGet(v -> v + productQuantity.getProduct().getPrice() * productQuantity.getQuantity() * 0.19);
            }
            else{
                price.updateAndGet(v -> v + productQuantity.getProduct().getPrice() * productQuantity.getQuantity());
            }
        });
        return Double.parseDouble(decimalFormat.format(price.get()));
    }

    public static String getPathToPDF(Long id){
        return String.format("C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\invoices\\%s.pdf", id);
    }
}
