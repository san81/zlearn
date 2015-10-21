
package com.san.rest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class URLFetcher {
    
  
    public static void main(String ar[]) {
        try {
            
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
            
               Socket _socket = new Socket();
               _socket.connect(new InetSocketAddress("iqueue.leantaas.com", 443), 1000);
               // Install the all-trusting trust manager
               SSLContext sslContext = SSLContext.getInstance("SSL");
               sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                SSLSocketFactory factory = sslContext.getSocketFactory();
                SSLSocket sslsocket=(SSLSocket)factory.createSocket(_socket,_socket.getInetAddress().getHostName(),_socket.getPort(),true);
                // Empty host name avoids the SNI extension from being set
                String hostname = "";
                if (false) {
                    hostname = _socket.getInetAddress().getHostName();
                }
                 sslsocket = (SSLSocket) factory.createSocket(_socket, hostname, _socket.getPort(), true);
            sslsocket.setEnabledProtocols(new String[] {"TLSv1"});
            sslsocket.setUseClientMode(true);
            _socket = sslsocket;
        
        try {
            ((SSLSocket) _socket).startHandshake();
        } catch (IOException ioe) {
                // Workaround for Java inability to continue on ignored SNI
                if (true && ioe.getMessage().equals("handshake alert:  unrecognized_name")) {
                   System.out.println("Server received saw wrong SNI host, retrying without SNI");
                    //connect("https://iqueue.leantaas.com", false);
                    return;
                }
            System.out.println("Error during SSL handshake: " + ioe);
            throw ioe;
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}