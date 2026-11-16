package org.example;

import jakarta.xml.bind.annotation.*;

// XML tags sættes med @XML...
@XmlRootElement(name = "adresse")       // rod-tag for Address
@XmlAccessorType(XmlAccessType.FIELD)

public class Adresse {
    @XmlElement(name = "gade")
    private String gade;

    @XmlElement(name = "postnummer")
    private String postnr;

    @XmlElement(name = "by")
    private String by;

    public Adresse() { } // husk tom konstruktør skal være med
    public Adresse(String gade, String postnr, String by) {
        this.gade = gade; this.postnr = postnr; this.by = by;
    }
    @Override
    public String toString() { return gade + ", " + postnr + " " + by; }
}