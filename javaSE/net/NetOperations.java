package javaSE.net;

import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

public class NetOperations {
    public static void takeHtml() throws Exception
    {
        URLConnection connection = new URL("http://www.google.com/").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        System.out.println(scanner.next());
    }
}
