package fr.enderstevegamer.arcanauhc;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Arcane {
    private int id;

    public static final Arcane BATELEUR = new Arcane(0);
    public static final Arcane PAPESSE = new Arcane(1);
    public static final Arcane IMPERATRICE = new Arcane(2);
    public static final Arcane EMPEREUR = new Arcane(3);
    public static final Arcane PAPE = new Arcane(4);
    public static final Arcane AMOUREUX = new Arcane(5);
    public static final Arcane CHARIOT = new Arcane(6);
    public static final Arcane JUSTICE = new Arcane(7);
    public static final Arcane HERMITE = new Arcane(8);
    public static final Arcane ROUE_DE_LA_FORTUNE = new Arcane(9);
    public static final Arcane FORCE = new Arcane(10);
    public static final Arcane PENDU = new Arcane(11);
    public static final Arcane SANS_NOM = new Arcane(12);
    public static final Arcane TEMPERANCE = new Arcane(13);
    public static final Arcane DIABLE = new Arcane(14);
    public static final Arcane MAISON_DIEU = new Arcane(15);
    public static final Arcane ETOILE = new Arcane(16);
    public static final Arcane LUNE = new Arcane(17);
    public static final Arcane SOLEIL = new Arcane(18);
    public static final Arcane JUGEMENT = new Arcane(19);
    public static final Arcane MONDE = new Arcane(20);
    public static final Arcane MAT = new Arcane(21);
    public static final Arcane SANS_ARCANE = new Arcane(22);

    private static final List<String> string_forms = Arrays.asList(
            "Le Bateleur",
            "La Papesse",
            "L'Impératrice",
            "L'Empereur",
            "Le Pape",
            "L'Amoureux",
            "Le Chariot",
            "La Justice",
            "L'Hermite",
            "La Roue de la Fortune",
            "La Force",
            "Le Pendu",
            "Le Sans Nom",
            "La Tempérance",
            "Le Diable",
            "La Maison-Dieu",
            "L'Étoile",
            "La Lune",
            "Le Soleil",
            "Le Jugement",
            "Le Monde",
            "Le Mat",
            "Sans Arcane"
    );

    private Arcane(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arcane arcane = (Arcane) o;
        return id == arcane.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Arcane clone = (Arcane) super.clone();
        clone.id = this.id;
        return clone;
    }

    @Override
    public String toString() {
        return string_forms.get(this.id);
    }

    public static Arcane getRandomArcane() {
        int i = (int) (Math.random() * 23);
        return new Arcane(i);
    }

    public Arcane copy() {
        return new Arcane(this.id);
    }
}
