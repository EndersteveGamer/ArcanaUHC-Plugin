package fr.enderstevegamer.arcanauhc;

import org.bukkit.ChatColor;

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

    private static final List<List<String>> DOCS = Arrays.asList(
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.BATELEUR,
                    "- " + ChatColor.GREEN + "Resistance II " + ChatColor.WHITE + " sur tous types de pierre",
                    "- " + ChatColor.GREEN + "10% de drop de l'or " + ChatColor.WHITE + "en  minant du charbon",
                    "- " + ChatColor.RED + "+100% de dégâts de chute"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.PAPESSE,
                    "- " + ChatColor.GREEN + "5% de chance de drop un livre enchanté " + ChatColor.WHITE + "en minant " +
                            "du lapis-lazuli",
                    "- " + ChatColor.GREEN + "Invisibilité" + ChatColor.WHITE + " si il n'y a pas de bloc au dessus d'elle",
                    "- " + ChatColor.RED + "Slowness I permanent"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.IMPERATRICE,
                    "- " + ChatColor.GREEN + "+15% de dégâts à l'épée",
                    "- " + ChatColor.RED + "Slowness I permanent",
                    "- " + ChatColor.GOLD + "Lors d'un clic droit avec un bâton, produit une onde de choc qui " +
                            "repousse les joueurs dans un rayon de 30 blocs (3 minutes de cooldown)"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.EMPEREUR,
                    "- " + ChatColor.GREEN + "Speed II pendant 5 minutes" + ChatColor.WHITE + " après un kill",
                    "- " + ChatColor.GREEN + "25% de chance d'enflammer ses coups",
                    "- " + ChatColor.RED + "9 coeurs"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.PAPE,
                    "- " + ChatColor.GREEN + "Haste III permanent",
                    "- " + ChatColor.GREEN + "Double minerais" + ChatColor.WHITE + " pour l'or et le diamant",
                    "- " + ChatColor.GOLD + "Résistance I pendant 2 minutes quand il mange un pomme dorée",
                    "- " + ChatColor.RED + "Pas d'absorption",
                    "- " + ChatColor.GOLD + "Toutes les 10 minutes désigne un joueur aléatoire et lui fait obtenir une pomme d'or"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.AMOUREUX,
                    "- " + ChatColor.GREEN + "Pas de dégâts PvE",
                    "- " + "Reçoit un " + ChatColor.GREEN + "arc Punch I" + ChatColor.WHITE + " en même temps que son arcane",
                    "- " + ChatColor.RED + "-10% de dégâts à l'épée",
                    "- " + ChatColor.GOLD + "Lors d'un clic droit avec une houe en diamant, lance une boule de neige qui créera un lien entre l'Amoureux et la personne touchée." +
                            "Toute personne liée ne peut attaquer l'autre personne liée. Le lien se brise au bout d'une minute. Cette capacité a un cooldown de 10 minutes"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.CHARIOT,
                    "- " + ChatColor.GREEN + "Speed II permanent",
                    "- " + ChatColor.GREEN + "+15% de dégâts à l'épée",
                    "- " + ChatColor.RED + "-25% de dégâts à l'arc",
                    "- " + ChatColor.RED + "+15% de dégâts reçus"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.JUSTICE,
                    "- " + ChatColor.GREEN + "Peut voir qui a fait les kills",
                    "- " + ChatColor.GREEN + "+25% de dégâts infligés " + ChatColor.WHITE + "contre les joueurs ayant fait des kills",
                    "- " + ChatColor.GREEN + "-10% de dégâts reçus " + ChatColor.WHITE + "contre les joueurs ayant fait des kills",
                    "- " + ChatColor.RED + "Nausée I pendant 1 minute " + ChatColor.WHITE + "si elle tue un joueur n'ayant pas fait de kill"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.HERMITE,
                    "- " + ChatColor.GREEN + "12 coeurs",
                    "- Toutes les 5 minutes, alterne entre " + ChatColor.GREEN + "Speed II" + ChatColor.WHITE + " et " + ChatColor.RED + " Slowness I"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.ROUE_DE_LA_FORTUNE,
                    "- Toutes les 5 minutes, obtient 2 effets aléatoires entre:",
                    ChatColor.GREEN + "Speed I" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Haste I" + ChatColor.WHITE
                    + ", " + ChatColor.GREEN + "Resistance I" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Force 40%"
                    + ChatColor.WHITE + ", " + ChatColor.GREEN + "Saturation" + ChatColor.WHITE + ", " + ChatColor.GREEN
                    + "Fire Resistance" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Water Breathing" + ChatColor.WHITE
                    + ", " + ChatColor.RED + "Slowness I" + ChatColor.WHITE + ", " + ChatColor.RED + "Weakness IV (-2 attack damage)"
                    + ChatColor.WHITE + ", " + ChatColor.RED + "Hunger I" + ChatColor.WHITE + " et " + ChatColor.RED
                    + "Mining Fatigue I"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.FORCE,
                    "- " + ChatColor.GREEN + "+40% de dégâts à l'épée",
                    "- " + ChatColor.RED + "9 coeurs",
                    "- " + ChatColor.RED + "-40% de dégâts à l'arc",
                    "- " + ChatColor.RED + "+20% de dégâts reçus à l'arc",
                    "- " + ChatColor.RED + "Ne peut pas poser de seaux de lave"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.PENDU,
                    "- " + ChatColor.GREEN + "-15% de dégâts reçus",
                    "- " + ChatColor.GREEN + "10% de chance d'immobiliser l'ennemi pendant 2 secondes" + ChatColor.WHITE
                    + " avec ses flèches",
                    "- " + ChatColor.RED + "Weakness IV permanent (-2 attack damage)"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.SANS_NOM,
                    "- " + ChatColor.GREEN + "Pas de dégâts PvE",
                    "- " + ChatColor.GREEN + "10% d'infliger Wither I pendant 5 secondes" + ChatColor.WHITE + " quand il frappe quelqu'un",
                    "- " + ChatColor.RED + "10% de chance de ne pas drop" + ChatColor.WHITE + " le diamant et l'or"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.TEMPERANCE,
                    "- " + ChatColor.GREEN + "Boost de vitesse dans l'eau",
                    "- " + ChatColor.GREEN + "Résistance I permanent",
                    "- " + ChatColor.GREEN + "Pas de dégâts de lave",
                    "- " + ChatColor.RED + "Slowness I permanent"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.DIABLE,
                    "- Les pommes d'or " + ChatColor.GREEN + "régènèrent instantanément sa vie",
                    "- Obtient " + ChatColor.GREEN + "Force 40% pendant 5 minutes " + ChatColor.WHITE + "à chaque kill (cumulable)",
                    "- " + ChatColor.RED + "15% de chance de ne pas drop " + ChatColor.WHITE + "le diamant et l'or"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.MAISON_DIEU,
                    "- " + ChatColor.GREEN + "+15% de dégâts à l'arc",
                    "- " + ChatColor.GREEN + "20% de chance de faire tomber la foudre " + ChatColor.WHITE + "là où ses flèches retombent",
                    "- " + ChatColor.GREEN + "Speed I permanent",
                    "- " + ChatColor.GREEN + "Pas de dégâts de chute",
                    "- " + ChatColor.RED + "Jump Boost II permanent",
                    "- " + ChatColor.RED + "-15% de dégâts à l'épée"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.ETOILE,
                    "- " + ChatColor.GREEN + "+3 coeurs lorsqu'elle mange une pomme d'or",
                    "- " + ChatColor.GREEN + "+20% de dégâts infligés le jour",
                    "- " + ChatColor.RED + "-20% de dégâts infligés la nuit",
                    "- " + ChatColor.RED + "+20% de dégâts reçu le jour",
                    "- " + ChatColor.GREEN + "-20% de dégâts reçu la nuit"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.LUNE,
                    "- " + ChatColor.RED + "-15% de dégâts infligés le jour",
                    "- " + ChatColor.GREEN + "+15% de dégâts infligés la nuit",
                    "- " + ChatColor.RED + "+15% de dégâts reçus le jour",
                    "- " + ChatColor.GREEN + "-15% de dégâts reçus la nuit",
                    "- " + ChatColor.RED + "Sa saturation se consomme 2 fois plus vite",
                    "- " + ChatColor.GOLD + "Quand une arcane " + Arcane.LUNE + " meurt, le monde passe au jour" +
                            " éternel, jusqu'à ce qu'une arcane " + Arcane.SOLEIL + " ne meure"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.SOLEIL,
                    "- " + ChatColor.GREEN + "+15% de dégâts infligés le jour",
                    "- " + ChatColor.RED + "-15% de dégâts infligés la nuit",
                    "- " + ChatColor.GREEN + "-15% de dégâts reçus le jour",
                    "- " + ChatColor.RED + "+15% de dégâts reçus la nuit",
                    "- " + ChatColor.RED + "Sa saturation se consomme 2 fois plus vite",
                    "- " + ChatColor.GOLD + "Quand une arcane " + Arcane.SOLEIL + " meurt, le monde passe à la" +
                            " nuit éternelle, jusqu'à ce qu'une arcane " + Arcane.LUNE + " ne meure"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.JUGEMENT,
                    "- " + ChatColor.GREEN + "Pas de dégâts PvE",
                    "- " + ChatColor.GREEN + "Saturation permanente",
                    "- " + ChatColor.GREEN + "Inflige Weakness IV (-2 attack damage)" + ChatColor.WHITE + " à tous les joueurs dans un rayon de 10 blocs",
                    "- " + ChatColor.RED + "Slowness I" + ChatColor.WHITE + " si un joueur se trouve à moins de 10 blocs de lui",
                    "- " + ChatColor.GOLD + "+1% de force par arcane morte"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.MONDE,
                    "- " + ChatColor.GREEN + "13 coeurs",
                    "- " + ChatColor.RED + "Weakness IV permanent (-2 attack damage)",
                    "- " + ChatColor.GOLD + "Toutes les 5 minutes, reçoit l'arcane, le nombre de pommes d'or et la quantité" +
                            " de vie d'un joueur aléatoire de la partie. Le joueur observé reçoit Weakness I pendant 5 minutes"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.MAT,
                    "- " + ChatColor.GREEN + "Speed I permanent",
                    "- " + ChatColor.GREEN + "+20% de dégâts à l'épée",
                    "- " + ChatColor.RED + "-20% de dégâts à l'arc",
                    "- " + ChatColor.RED + "9 coeurs"
            ),
            Arrays.asList(
                    "Documentation pour " + ChatColor.GOLD + Arcane.SANS_ARCANE,
                    "Un joueur sans arcane peut récupérer une arcane en:",
                    "- Tuant une arcane",
                    "- Héritant d'une arcane tuée par une autre arcane",
                    "- Héritant d'une arcane morte en PvE",
                    ChatColor.GOLD + "Les arcanes " + Arcane.LUNE + " et " + Arcane.SOLEIL + " ne sont pas récupérables" +
                            ", et sont détruites à la mort de l'arcane"
            )
    );

    public List<String> getDocumentation() {
        return DOCS.get(this.id);
    }

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
