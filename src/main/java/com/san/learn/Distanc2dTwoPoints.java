
package com.san.learn;

/**
 * puzzle to calculate the distance between the two points in a 2d matrix
 * 
 * Ex.  (-7,-1) to ( -13,5)  = 6
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jan 10, 2016
 */
public class Distanc2dTwoPoints {

    enum Action { PLUS, MINUS };
    
    public static void main(String[] args) {
       // System.out.println(calculateDist(-7, -1, 0, 8));
        //System.out.println(calculateDist(4, 8, 4, -15));
        
        int x[]=  { 4, 8, -7, -5, -13, 9, -7, 8 };
        int y[] =  { 4, -15, -10, -3, -13, 12, 8, -8 };
        
        
        
       int totDist=0;
       for(int i=0;i+1<x.length; i++){
           int currentDist=calculateDist(x[i], y[i], x[i+1],y[i+1]);
           totDist+=currentDist;
           System.out.println(currentDist+" "+totDist);
       }
       System.out.println(totDist);
        
    }
    
    public static int calculateDist(int x1, int y1, int x2, int y2) {
       int dist=0;
       Action xAction=(x2>x1)?Action.PLUS:Action.MINUS;
       Action yAction=(y2>y1)?Action.PLUS:Action.MINUS;
       
       while(x1!=x2 && y1!=y2) {
           x1=applyAction(xAction,x1);
           y1=applyAction(yAction,y1);
           dist++;
       }
       
       if(x1!=x2){
           while(x1!=x2){
               x1=applyAction(xAction,x1);
               dist++;
           }
       }
       
       if(y1!=y2){
           while(y1!=y2){
               y1=applyAction(yAction,y1);
               dist++;
           }
       }
       
       return dist;
    }
    
    public static int applyAction(Action action, int p){
        switch(action){
            case PLUS:
                 return p+1;
            case MINUS:
                 return p-1; 
        }
        return p;
    }

}
