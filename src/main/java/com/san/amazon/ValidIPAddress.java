package com.san.amazon;

import java.util.regex.Pattern;

public class ValidIPAddress {

        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern pattenIPv4 =
                Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern pattenIPv6 =
                Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

        public String validIPAddress(String IP) {
            if (pattenIPv4.matcher(IP).matches()) return "IPv4";
            return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }


    public static void main(String[] args) {
        String IP = "172.16.254.1";
        IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        IP = "256.256.256.256";
        IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        IP = "1e1.4.5.6";
        IP = "12..33.4";
        IP = "01.01.01.01";
        System.out.println(new ValidIPAddress().validIPAddress(IP));
    }
}
