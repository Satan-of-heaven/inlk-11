
import java.awt.List;
import java.util.*;
import javax.swing.*;

/**
 * GUIListe stellt eine grafische Liste zur Verfügung, der man Elemente sortiert hinzufügen kann.
 * 
 * @author Thomas Karp
 * @version (0.000001 alpha)
 */
public class GUIListe {

    private JFrame frame;
    private List liste;
    private ArrayList<Sortierbar> elemente;
    private boolean aufsteigend;

    /**
     * Erzeugt eine leere GUI mit vordefinierter Größe.
     */
    public GUIListe() {
        this("", 250, 150);
    }

    /**
     * Erzeugt eine leere GUI.
     * @param titel Titel, der in der Titelzeile angezeigt wird.
     * @param breite Breite des Fensters.
     * @param höhe Höhe des Fensters.
     */
    public GUIListe(String titel, int breite, int höhe) {
        aufsteigend = true;
        frame = new JFrame(titel);
        elemente = new ArrayList<Sortierbar>();
        initComponents(breite, höhe);
    }

    /**
     * Zeigt das Fenser an.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Sortiert die Liste aufsteigend.
     */
    public void aufsteigendSortieren() {
        aufsteigend = true;
        Collections.sort(elemente, new Comparator<Sortierbar>() {

            public int compare(Sortierbar o1, Sortierbar o2) {
                return o1.getWert() - o2.getWert();
            }
        });
        // Liste leeren und neu füllen.
        liste.removeAll();
        for (Sortierbar s : elemente) {
            liste.add(s.getWert() + " " + s.toString());
        }
    }
    /**
     * Sortiert die Liste absteigend.
     */
    public void absteigendSortieren() {
        aufsteigend = false;
        Collections.sort(elemente, new Comparator<Sortierbar>() {

            public int compare(Sortierbar o1, Sortierbar o2) {
                return o2.getWert() - o1.getWert();
            }
        });
        // Liste leeren und neu füllen.
        liste.removeAll();
        for (Sortierbar s : elemente) {
            liste.add(s.getWert() + " " + s.toString());
        }
    }

    /**
     * Füge ein neues Element hinzu.
     * @param element Sortierbares Element, das eingefügt werden soll.
     */
    public void einreihen(Sortierbar element) {
        // in ArrayList einfügen
        elemente.add(element);
        if(aufsteigend)
        {
            aufsteigendSortieren();
        }
        else
        {
            absteigendSortieren();
        }
    }

    /**
     * Initialisiere JFrame
     */
    private void initComponents(int breite, int höhe) {

        liste = new java.awt.List();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(liste, javax.swing.GroupLayout.DEFAULT_SIZE, breite, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(liste, javax.swing.GroupLayout.DEFAULT_SIZE, höhe, Short.MAX_VALUE).addContainerGap()));

        frame.pack();
    }
}
