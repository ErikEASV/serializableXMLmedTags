package org.example;

import jakarta.xml.bind.*;
import java.io.File;

/*
Dette er et eksempel på serialisering til XML fil med XML tags.
Det kræver at modelklasser udstyres med XML direktiver og at alle objekter samles i
een rodklasse.
Yderligere skal JAXB mv. indsættes i depencies for Maven:
    <dependency>
        <groupId>jakarta.xml.bind</groupId>
        <artifactId>jakarta.xml.bind-api</artifactId>
        <version>4.0.2</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jaxb</groupId>
        <artifactId>jaxb-runtime</artifactId>
        <version>4.0.5</version>
    </dependency>
 */

public class JaxbDemo {

    public static void main(String[] args) throws Exception {
        // Lav testdata...
        Person p = new Person("Søren", 42);
        p.tilføjAdresse(new Adresse("Hovedgade 1", "8000", "Aarhus C"));
        p.tilføjAdresse(new Adresse("Sommervej 7", "8300", "Odder"));
        // NB hvis man ønsker flere personer skal man lave en klasse med en arraylist af Person
        // og så bruge den som rod til JAXBContext...

        // Nu er vi klar til at gemme objekterne i XML format...
        // Lav kontext til XML
        JAXBContext ctx = JAXBContext.newInstance(Person.class);

        // Gem som XML
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(p, new File("person.xml"));

        // -------------

        // Indlæs fra XML
        Unmarshaller u = ctx.createUnmarshaller();
        Person laast = (Person) u.unmarshal(new File("person.xml"));
        System.out.println("Indlæst: " + laast);
    }
}