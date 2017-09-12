package com.san.learn;/*Nav�i�gate the left half of array till you won�t find a pos�i�tive inte�ger and reverse the array after that point.(Say that part is called �A�)
Nav�i�gate the right half of array till you won�t find a pos�i�tive inte�ger and reverse the array before that point. (Say that part is called �B�)
swap in reverse the those parts from both the array (A and B),*/

public class RearrangeNumber
{
    int[] intputArray;

    public RearrangeNumber(int[] arrA)
    {
        this.intputArray = arrA;
    }

    public void divideGroups(int low, int high)
    {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        divideGroups(low, mid);
        divideGroups(mid + 1, high);
        partition(low, mid, high);

    }

    public void partition(int low, int mid, int high)
    {
        int left = low;
        int right = mid + 1;
        while (left <= intputArray.length && left <= mid && intputArray[left] >= 0)
            left++;
        while (right <= intputArray.length && right <= high && intputArray[right] >= 0)
            right++;
        reverseSwap(left, mid);
        reverseSwap(mid + 1, right - 1);
        reverseSwap(left, right - 1);
    }

    public void reverseSwap(int left, int right)
    {
        while (right > left)
        {
            int temp = intputArray[left];
            intputArray[left] = intputArray[right];
            intputArray[right] = temp;
            left++;
            right--;
        }
    }

    public void display()
    {
        for (int i = 0; i < intputArray.length; i++)
        {
            System.out.print(" " + intputArray[i]);
        }
    }

    public static void main(String args[])
    {

        int a[] =
        { 13, -6, 2, -2, 4, 8, -9, 10 };
        RearrangeNumber rearrangeNumberInput1 = new RearrangeNumber(a);
        System.out.print("Input : ");
        rearrangeNumberInput1.display();
        rearrangeNumberInput1.divideGroups(0, a.length - 1);
        System.out.println("");
        System.out.print("ReArranged Output : ");
        rearrangeNumberInput1.display();
        System.out.println("");
        int[] a1 =
        { 1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20 };

        RearrangeNumber rearrangeNumberInput2 = new RearrangeNumber(a1);
        System.out.print("Input : ");
        rearrangeNumberInput2.display();
        rearrangeNumberInput2.divideGroups(0, a1.length - 1);
        System.out.println("");
        System.out.print("ReArranged Output : ");
        rearrangeNumberInput2.display();
        System.out.println("");
        int[] a3 =
        { 1, -2, -3, -4, 5, 0, -6, 7, -8, 9, -10, -11, 0, -12, 20 };

        RearrangeNumber rearrangeNumberInput3 = new RearrangeNumber(a3);
        System.out.print("Input : ");
        rearrangeNumberInput3.display();
        rearrangeNumberInput3.divideGroups(0, a3.length - 1);
        System.out.println("");
        System.out.print("ReArranged Output : ");
        rearrangeNumberInput3.display();
    }
}
