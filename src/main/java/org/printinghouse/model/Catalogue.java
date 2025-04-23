package org.printinghouse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogue {
    private final List<Publication> publications;

    public Catalogue(List<Publication> publications) {
        this.publications = new ArrayList<>(publications);
    }

    public List<Publication> getPublications() {
        return new ArrayList<>(publications);
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public boolean removePublicationById(int id) {
        return publications.removeIf(pub -> pub.getId() == id);
    }

    public Optional<Publication> getPublicationById(int id) {
        return publications.stream()
                .filter(pub -> pub.getId() == id)
                .findFirst();
    }
}
