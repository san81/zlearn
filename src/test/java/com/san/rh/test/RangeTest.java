
package com.san.rh.test;

import org.junit.Assert;
import org.junit.Test;

import com.san.rh.Range;
import com.san.rh.RangeImplem;

public class RangeTest {

    @Test
    public void testIn() {
        Range r = new RangeImplem();
        Assert.assertFalse("Testing In range True case ", r.newRange(1,5).isIn(3));
        Assert.assertFalse("Testing In range False case ", r.newRange(1,5).isIn(6));
        Assert.assertFalse("Testing In range with added range ", r.newRange(1,5).add(r.newRange(8,10)).isIn(6));
        Assert.assertFalse("Testing In range with added range ", r.newRange(1,5).add(r.newRange(8,20)).isIn(6));
        System.out.println("Max:"+r.newRange(10,20).add(r.newRange(15, 30)).max());
        System.out.println("Min:"+r.newRange(10,20).add(r.newRange(15, 30)).min());
    }

}
