package com.san.learn;

import java.util.Iterator;
import java.util.List;

/**
 * Created by santhoshgandhe on 10/10/16.
 */
/*public class MultiIterator {
}

    Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

        [1,2,3][4,5,6][7,8,9]
        [1,4,7,2,5,8,3,6,9]




        [1,2,3][4,5][]
        [1,4,2,5,3] */


public class MultiIterator<T> implements Iterator<T> {

    public List<Iterator<T>> iterators;
    public int index = -1;

    public void remove(){

    }

    public MultiIterator(List<Iterator<T>> iterators) {
        this.iterators = iterators;

    }

    public T next() {
        if (!hasNext()) {
            //throw new IteratorHasNoMoreNext();
        }

        do {
            index++;
            if (index == iterators.size()) {
                index = 0;
            }
        } while (!iterators.get(index).hasNext());

        T returnElement = iterators.get(index).next();
        return returnElement;
    }

    public boolean hasNext() {
        for (int i = 0; i < iterators.size(); i++) {
            if (iterators.get(i).hasNext()) {
                return true;
            }
        }
        return false;
    }
}








