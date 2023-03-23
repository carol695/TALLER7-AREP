package org.example.servers.server1;

import org.example.URLReader;

import static spark.Spark.*;

public class SparkWeb1 {
    public static void main(String[] args) {
        secure(getKeyStore(), getPwdStore() , null, null);
        port(getPort());
        get("/local", ((request, response) -> "Hello local1"));
        get("/remote", (req, res) -> URLReader.readSecureUrl(getUrl(), getKeyOtherStore(), getPwdStore()));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

    public static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificates/server1/server1.p12";
    }

    public static String getPwdStore() {
        if (System.getenv("PWDSTORE") != null) {
            return System.getenv("PWDSTORE");
        }
        return "123456";
    }

    private static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("URL");
        }
        return "https://ec2-35-153-16-235.compute-1.amazonaws.com:5002/local";
    }

    public static String getKeyOtherStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificates/server2/server2.p12";
    }


}
