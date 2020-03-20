package com.lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Clasa ce gestioneaza operatiile externe cu documente
 */
public class CatalogUtil {
    /**
     * Salveaza un catalog local pe disk
     * @param catalog catalogul ce va si salvat
     * @throws IOException exceptie pentru cazul cand fisierul nu exista
     */
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
            oos.flush();
        }
    }

    /**
     * Incarca un catalog salvat local (de pe disk)
     * @param path calea pana la fisierul care reprezinta catalogul
     * @return un obiect de tip catalog incarcat de pe disk de la locatia primita ca parametru
     * @throws InvalidCatalogException exceptie ce reprezinta ca nu s-a gasit catalogul
     * @throws IOException execptie ce reprezinta o eroare la citire sau deschidere
     * @throws ClassNotFoundException clasa nu a fost gasita
     */
    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        }
        catch (FileNotFoundException ex) {
            throw new InvalidCatalogException(ex);
        }
    }

    /**
     * Mod de vizualizare a unui document (cu blowser default daca este un link si cu un editor default daca este un fisier salvat local)
     * @param doc documentul ce va fi vizualizat
     * @throws IOException documentul nu a fost gasit pe disk la calea precizata
     */
    public static void view(Document doc) throws IOException{
        Desktop desktop = null;

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }

        if (desktop != null) {
            if (doc.getLocation().startsWith("http"))
                try {
                    desktop.browse(new URI(doc.getLocation()));
                }
                catch (URISyntaxException ex) {
                    System.err.println(ex.getMessage());
                }
            else
                desktop.open(new File(doc.getLocation()));
        }
    }
}