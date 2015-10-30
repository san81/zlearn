package com.san.rh;

import java.util.HashSet;
import java.util.Set;

public class RangeImplem implements Range {

    private int from;
    private int to;

    private Set<Range>  rangeValSet = new HashSet<Range>();
    
    private int min;
    private int max;

    public RangeImplem(){
        
    }
    
    private RangeImplem(int from, int to) {
        this.from=from;
        this.to=to;
        this.min=from;
        this.max=to;
    }

    @Override
    public Range newRange(int from, int to) {
        rangeValSet.clear();
        if(to<from) {
            //though an exception?
            System.out.println("Invalid Range values");
            return this;
        }
        Range nr=new RangeImplem(from, to);
        rangeValSet.add(nr);
        return nr;
    }

    private void adjustMinMax(Range nr){
      
        if(this.min>nr.min()){
            this.min=nr.min();
        }
        if(this.max<nr.max()){
            this.max=nr.max();
        }
    }
    
    @Override
    public boolean isIn(int value) {
       
        for(Range r:rangeValSet) {
            if(r.min()<=value && value <=r.max()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int min() {
        return min;
    }

    @Override
    public int max() {
        return max;
    }

    @Override
    public Range add(Range r) {
        this.rangeValSet.add(r);
        this.adjustMinMax(r);
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + from;
        result = prime * result + ((rangeValSet == null) ? 0 : rangeValSet.hashCode());
        result = prime * result + to;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RangeImplem other = (RangeImplem) obj;
        if (from != other.from)
            return false;
        if (rangeValSet == null) {
            if (other.rangeValSet != null)
                return false;
        } else if (!rangeValSet.equals(other.rangeValSet))
            return false;
        if (to != other.to)
            return false;
        return true;
    }

    

    
}
