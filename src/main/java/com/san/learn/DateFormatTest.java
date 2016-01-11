
package com.san.learn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class DateFormatTest {

    public static void main(String ar[]){
       /* Calendar cal = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("dd-MMMM");
        System.out.println(format.format(cal.getTime()));
        
        System.out.println(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
        
     
        
        StringBuilder sb = new StringBuilder();
        // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb, Locale.US);

        // Explicit argument indices may be used to re-order output.
       // formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
       
        System.out.println(padRight("Howto", 20) + "*");
        //System.out.println(padLeft("Howto", 20) + "*");
*/        
        System.out.println(getDateFromString("12/31/2015  02:15:33PM","MM/dd/yyyy hh:mm:ssa"));
    }
    
    public static String padRight(String s, int n) {
        return String.format("%1$" + n + "s", s).replace(' ', '0');  
   }
    
   public static Date getDateFromString(String dateString, String dateFormat) {
            if(null==dateString || "".equals(dateString)){
                return null;
            }
            DateFormat df = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
            Date result = null;
            try {
                result = df.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return result;
    }
}
