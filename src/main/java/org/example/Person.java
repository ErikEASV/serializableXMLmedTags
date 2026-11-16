package org.example;

import jakarta.xml.bind.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "person")        // rod-tag for Person
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name = "navn")
    private String navn;

    @XmlElement(name = "alder")
    private int alder;

    @XmlElementWrapper(name = "adresser")  // omsluttende <adresser>
    @XmlElement(name = "adresse")          // hvert element hedder <adresse>
    private List<Adresse> adresser = new ArrayList<>();

    public Person() { } // tom konstruktør SKAL være der.
    public Person(String navn, int alder) { this.navn = navn; this.alder = alder; }

    public void tilføjAdresse(Adresse a) { adresser.add(a); }

    @Override public String toString() { return "Person{navn=" + navn + ", adresser=" + adresser + "}"; }
}