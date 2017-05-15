package com.FireFury.Utils.ArrayUtils;

public class QuickSorter
{
   public static void sort(int[] a)
   {
       quicksort(a, 0, a.length - 1);
   }
   
   public static void quicksort(int[] a, int low, int high)
   {
       if(a == null || a.length <= 0)
       {
           return;
       }
       if(low >= high)
       {
           return;
       }
       
       int mid = low + (high - low)/2;
       int pivot = a[mid];
       
       int i = low, j = high;
       while(i <= j)
       {
           while(a[i] < pivot)
           {
               i++;
           }
           while(a[j] > pivot)
           {
               j--;
           }
           if(i <= j)
           {
               ArrayUtil.swap(a, i ,j);
               i++;
               j--;
           }
       }
       if(low < j)
       {
           quicksort(a, low, j);
       }
       if(high > i)
       {
           quicksort(a, i, high);
       }
   }
}
