package sockets;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.nio.charset.MalformedInputException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Original author: Prof. Rollins. Modified by O. Karpenko.
 * HttpFetcher - shows how to sent an HTTP get request to a given webserver via the java program,
 * and how to get the response
 *
 */
public class HttpFetcher {

    public static int PORT = 80;
    private static URL url;

    /** Sends an HTTP request to fetch a given resource from the given host.
     *  Returns the response as a string.
     * @param host
     * @param pathAndResource
     * @return A string that contains HTML code.
     */
    public static String fetch() {
        String line = "";
        try {
            url = new URL("https://swapi.dev/api/planets/1/?format=json");
            //url = new URL("https://api.open-meteo.com/v1/forecast?latitude=37.7&longitude=122&current_weather=true");
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection)connection;
            System.out.println(httpConnection.getResponseCode() + " " + httpConnection.getResponseMessage());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()))) {
                System.out.println(br.readLine());
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        catch(MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return line;

    }

    /**
     * A method that creates a GET request for the given host and resource
     * @param host
     * @param pathResourceQuery
     * @return HTTP GET request returned as a string
     */
    private static String getRequest(String host, String pathResourceQuery) {
        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET
                // request
                + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
                + "Connection: close" + System.lineSeparator() // make sure the server closes the
                // connection after we fetch one page
                + System.lineSeparator();
        return request;
    }

    public static void main(String[] args) {
        String res = HttpFetcher.fetch();
        System.out.println(res);
    }
}