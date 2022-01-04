package com.san.learn.sorts;

class GroupNegativesPostives {
	
    private void groupNegPosNumbers(int arr[])
    {
        int val,i,j;
        for( i=0; i<arr.length; i++){
            val = arr[i];
            
            if (val < 0) {
                j = i-1;
                // shift the positive numbers
                while (j >= 0 && arr[j] >= 0){
                    arr[j+1] = arr[j];
                    j--;
                }
            arr[j+1] = val; //copy the negative value
          }
            
        }
    }

    public static void main (String[] args)
    {
        int arr[] = {-2,0,2,-1,5,-3,25,36,-4};
        GroupNegativesPostives grp = new GroupNegativesPostives();
        grp.groupNegPosNumbers(arr);
        for(int i=0; i<arr.length;i++)
         	System.out.print(arr[i] +" ");

    }

}
