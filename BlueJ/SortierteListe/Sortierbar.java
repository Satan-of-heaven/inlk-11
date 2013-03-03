/**
 * Ein Sortierbares Objekt muss einen Wert zur Sortierung zur Verfügung stellen.
 * 
 * @author Thomas Karp
 * @version (0.000001 alpha)
 */

public interface Sortierbar {
	/**
	 * Liefert den Wert zurück, nach dem sortiert werden soll.
	 * 
	 * @return Wert, nach dem sortiert werden soll.
	 */
	int getWert();
}
