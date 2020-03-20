package com.lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care descrie un catalog ce poate contine unul sau mai multe documente
 */
public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents;

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        documents = new ArrayList<>();
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setPath(String path) {
        this.path = path;
    }

    String getPath() {
        return path;
    }

    /**
     * Adauga un document la lista de documente
     * @param document documentul ce trebuie adaugat
     */
    public void addDocument(Document document) {
        documents.add(document);
    }

    /**
     * Cauta un document dupa id
     * @param id id-ul documentului ce trebuie cautat
     * @return documentul cu id-ul precizat sau null in cazul in care nu este gasit
     */
    public Document findById(String id) {
        return documents.stream().filter(document -> document.getId().equals(id)).findFirst().orElse(null);
    }
}
