import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class httpUCIP {

    public static HttpURLConnection connection;
    public static OutputStream out;

    public httpUCIP() {}

    public static String _postXmlData(String IP, String Port, String xmldata) {

        String retValue = "-1";
        try {
            String url = String.format("http://%s:%s/Air", IP, Port);

            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            HttpURLConnection connection = (HttpURLConnection) uc;
            connection.setConnectTimeout(30000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // headers
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setRequestProperty("Content-Length", "" + xmldata.length());
            connection.setRequestProperty("Host", "101.741.461.5:100111");
            connection.setRequestProperty("User-Agent", "UGw Server/5.0/1.0");
            connection.setRequestProperty("Authorization", "Basic sfsdfsdfsdfsdfsdfsdfsdfsdf=");

            OutputStream out = connection.getOutputStream();
            Writer wout = new OutputStreamWriter(out);
            wout.write(xmldata);
            wout.flush();
            wout.close();

            StringBuilder response = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), StandardCharsets.UTF_8));
            String line;

            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            retValue = response.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retValue;
    }

    public static String callApi(String IP, String Port, String reqBody) {
        return  _postXmlData(IP, Port, reqBody);
    }
}
