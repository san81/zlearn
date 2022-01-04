package com.san.google.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class ReadNChars {

    public int read4(char[] buf){
        buf[0] = 'a';buf[1] = 'b';buf[2] = 'c';;
        return 3;
    }

    int lastBuff = 0;
    char[] globalBuf = new char[4];
    int globalBufIdx = 0;

    public int copyBufs(char[] sourceBuf, int sourceBufIdx, char[] destBuf, int destBufIdx, int charCnt) {
        for(int i=0;i<charCnt; i++) {
            destBuf[destBufIdx++] = sourceBuf[sourceBufIdx++];
        }
        return destBufIdx;
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    public int read(char[] buf, int n) {

        if(lastBuff==-1) {
            //reached end of the file
            return 0;
        }

        if(lastBuff>=n) {
            lastBuff -= n;
            copyBufs(globalBuf, globalBufIdx, buf, 0, n);
            return n;
        }

        while(n>lastBuff) {
            char[] tmpBuf = new char[3];
            int r4 = read4(tmpBuf);
            copyBufs(tmpBuf, 0, globalBuf, globalBufIdx, r4);
            lastBuff += r4;
            if(r4 ==0 || n<=lastBuff ){
                break;
            }
        }

        if(lastBuff>=n) {
            lastBuff -= n;
            copyBufs(globalBuf, globalBufIdx, buf, 0, n);
            return n;
        }else{
            int tmp = lastBuff;
            lastBuff = -1;
            copyBufs(globalBuf, globalBufIdx, buf, 0, lastBuff);
            return tmp;
        }
    }

    public static void main(String[] args) {
        ReadNChars rnc = new ReadNChars();
        int[] queries = {1,2,1};
        char[] buf = new char[4];
        List<Integer> result =  new ArrayList<>();
        for(int q:queries) {
            result.add(rnc.read(buf, q));
        }
        System.out.println(result);
    }
}