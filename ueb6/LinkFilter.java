import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Eine Klasse die Anchor tags nach href und a wert filtert
 * 
 * 
 *
 * @author Mouayad Haji Omar, Zubeir Mohamed
 * @version 1.0
 */
public class LinkFilter {

    /**
     * 
     * Funktion die mithilfe reguläre ausdrücke den href und a wert rausfiltert
     * 
     * @param line Einzelne Zeile der Datei
     * @return Schlüsselwert paar das jeweils href wert und wert des anchor tags
     *         enthält
     */
    public SimpleEntry<String, String> filter(String line) {
        Pattern valuePattern = Pattern.compile("<a[^>]*>([^<]+)<\\/a>");
        Pattern hrefPattern = Pattern.compile("href=\"(.*?)\"");
        Matcher valueMatcher = valuePattern.matcher(line);
        Matcher hrefMatcher = hrefPattern.matcher(line);
        String href = null;
        String value = null;

        if (valueMatcher.find()) {
            value = valueMatcher.group(1);
        }

        if (hrefMatcher.find()) {
            href = hrefMatcher.group(1);
        }

        return new SimpleEntry<String, String>(value, href);
    }

    /**
     * Mit dem Scanner lesen wir die html datei, dann geben wir jede zeile in den
     * filter der uns falls vorhanden die gewünschten werte zurückgibt.
     * 
     * @param args Nimmt die html datei an
     */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File(args[0]));

            while (input.hasNextLine()) {
                SimpleEntry<String, String> data = new LinkFilter().filter(input.nextLine());
                if (data.getKey() != null && data.getValue() != null) {
                    System.out.println(data.getKey() + " " + data.getValue());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
    }
}