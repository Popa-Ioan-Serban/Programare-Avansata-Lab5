package com.lab5;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.testCreateSave();
        main.testLoadView();
    }

    /**
     * Metoda ce exemplifica crearea unui Catalog si Document, adaugarea documentului in Catalog si salarea local a catalogului
     */
    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources ", "/home/serban/Desktop/TestCatalog/catalog.ser");
        Document document = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");

        document.addTag("type", "Slides");
        catalog.addDocument(document);

        try {
            CatalogUtil.save(catalog);
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Metoda ce exemplifica incarcarea unui Catalog si vizualizarea unui document
     */
    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("/home/serban/Desktop/TestCatalog/catalog.ser");
            Document document = catalog.findById("java1");
            CatalogUtil.view(document);
        }
        catch(InvalidCatalogException | IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
