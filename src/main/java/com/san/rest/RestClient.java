
package com.san.rest;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class RestClient {

    static {
        try{
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            Socket _socket = new Socket();
            _socket.connect(new InetSocketAddress("iqueue.leantaas.com", 443), 1000);
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            SSLSocketFactory factory = sc.getSocketFactory();
            SSLSocket sslsocket = (SSLSocket) factory.createSocket(_socket, "iqueue.leantaas.com", _socket.getPort(), true);
            sslsocket.setEnabledProtocols(new String[] {"TLSv1"});
            sslsocket.setUseClientMode(true);
            ((SSLSocket) sslsocket).startHandshake();
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reindexTagCloud(String url, String uidPwd,String socksProxyHost,String socksProxyPort){

        try{
            //String url = "https://lnx.leantaas.com/druid-web/getpvmsummarydata";
            //String uidPwd="admin@leantaas.com:leoxnn9Adm1n";
            HttpsURLConnection conn=null;
            //sun.misc.BASE64Encoder b64 = new sun.misc.BASE64Encoder();
            //String encodedUidPwd = b64.encode(uidPwd.getBytes());

            if((socksProxyHost==null || socksProxyHost.isEmpty()) && (socksProxyPort==null || socksProxyPort.isEmpty())){
                URL resturl = new URL(url);
                conn = (HttpsURLConnection) resturl.openConnection();  
            }else{
                Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(socksProxyHost, Integer.parseInt(socksProxyPort)));
                conn = (HttpsURLConnection) new URL(url).openConnection(proxy);
            }
            conn.setDoOutput(true);  
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type","text/html");
            //conn.setRequestProperty("Authorization", "Basic "+encodedUidPwd);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");
            conn.setRequestProperty("SSL_TLS_SNI","iqueue.leantaas.com");
            

            System.out.println("Requesting");
            System.out.println(conn.getResponseCode());
            System.out.println(conn.getResponseMessage()); 
            InputStream is = conn.getInputStream();
            Scanner scanner = new Scanner(is);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            System.out.println("Request completed");
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("jsse.enableSNIExtension", "true");
        reindexTagCloud("https://iqueue.leantaas.com/druid-web/units", "uchealth_user@leantaas.com:Lean1234", "", "");
        //String url="https://54.67.21.109:9453/web/iqueue-site/login?p_auth=mgXldl84&p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin&_58_doActionAfterLogin=false";
        //reindexTagCloud(url, "santhosh.g@leantaas.com:Lean123", "", "");
    }
}
