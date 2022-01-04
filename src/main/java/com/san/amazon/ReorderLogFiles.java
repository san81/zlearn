package com.san.amazon;

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Set<String> letterLogs = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] o1words = o1.split(" ", 2);
                String[] o2words = o2.split(" ", 2);
                int cmp = o1words[1].compareTo(o2words[1]);
                if(cmp==0){
                    return o1words[0].compareTo(o2words[0]);
                }else{
                    return cmp;
                }
            }
        });
        List<String> digitLogs = new ArrayList<>();
        for(String log:logs){
            boolean isLetterLogs = true;
            String secondWord = log.split("\\s+")[1];
            if(!Character.isDigit(secondWord.charAt(0))){
                letterLogs.add(log);
            }else{
                digitLogs.add(log);
            }
        }
        List<String> combined = new ArrayList<>();
        combined.addAll(letterLogs); combined.addAll(digitLogs);
        return combined.toArray(new String[letterLogs.size()+digitLogs.size()]);
    }

    public static void main(String[] args) {
//        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
//        String[] logs = new String[]{"dig1 8 1 5 1","let1 art zero can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs = new String[]{"6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"};
        System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(logs)));
    }
}
