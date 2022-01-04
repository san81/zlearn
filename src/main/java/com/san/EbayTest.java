package com.san;

/*
 traffic comming in realtime flow
 save 10% data for analysis

 5per day volume B

 50M

 countryCode
 commandName

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PageData {
    int countryCode;
    String commandName;
}

class PageDetails {
    PageData pd;
    String moreInfo;
}

public class EbayTest {

    int SAMPLE_SIZE = 5000;
    HashMap<PageData, List<PageDetails>> pageDataPerCountryCommand= new HashMap<>();

    public void gatherDataForAnalysis(PageDetails pageDetails){

        List<PageDetails> curList =
                pageDataPerCountryCommand.computeIfAbsent(pageDetails.pd, k -> new ArrayList<PageDetails>());
//        if(null == pageDataPerCountryCommand.get(pageDetails.pd) ) {
//            curList = new ArrayList<PageDetails>();
//            pageDataPerCountryCommand.put(pageDetails.pd, curList);
//        } else{
//            curList = pageDataPerCountryCommand.get(pageDetails.pd);
//        }

        curList.add(pageDetails);

        // 10%
        if(curList.size() <= SAMPLE_SIZE) {
            curList = sampleThis(curList);
            pageDataPerCountryCommand.put(pageDetails.pd, curList);
            //Flush

        }

        // flush based on the time


    }

    public List<PageDetails> sampleThis(List<PageDetails> curList) {
        return curList.subList(0, 10);
    }


}
