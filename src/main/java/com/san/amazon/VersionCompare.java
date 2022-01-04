package com.san.amazon;

public class VersionCompare {
    public int compareVersion(String version1, String version2) {
        String[] v1p = version1.split("[.]");
        String[] v2p = version2.split("[.]");
        int pCount = Math.max(v1p.length, v2p.length);
        for(int i=0;i<pCount; i++){
            int v1Int = 0, v2Int=0;
            if(v1p.length>i){
                v1Int = Integer.parseInt(v1p[i]);
            }
            if(v2p.length>i){
                v2Int = Integer.parseInt(v2p[i]);
            }
            if(v1Int<v2Int){
                return -1;
            }else if(v2Int<v1Int){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        String version1 = "1.01", version2 = "1.001";
//        String version1 = "1.0", version2 = "1.0.0";
//        String version1 = "0.1", version2 = "1.1";
//        String version1 = "1.0.1", version2 = "1";
        String version1 = "7.5.2.4", version2 = "7.5.3";
        System.out.println(new VersionCompare().compareVersion(version1, version2));
    }
}
