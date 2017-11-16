package com.algo.utils;

/**
 * Created by qiusir on 10/24/17.
 * bubbleSort,selectSort,insertSort bubbleSort worst,insertSort best
 */
public class AlgorithmsSortUtils {
    //divide search
    public int find(long[] elements,long searchKey) {
        int lowerBound = 0;
        int nElems = elements.length;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (elements[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (elements[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    //divide recursive query
    public int recFind(long searchKey,int lowerBound,int upperBound,long[] elements,int nElems) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (elements[curIn] == searchKey) {
            return curIn;
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (elements[curIn] < searchKey) {
                return recFind(searchKey,curIn+1,upperBound,elements,nElems);
            } else {
                return recFind(searchKey,lowerBound,curIn-1,elements,nElems);
            }
        }
    }
    // bubble sort
    // N*(N-1)/2 when n = 2 equals 45
    public void bubbleSort(int[] elements) {
        int out,in;
        for(out=elements.length-1; out > 1; out -- ) {
            for (in =0; in<out;in++) {
                if (elements[in] > elements[in+1]) {
                    int tmp = elements[in];
                    elements[in] = elements[in+1];
                    elements[in+1] = tmp;
                }
            }
        }
    }

    //select sort
    // N*(N-1)/2
    public void selectSort(int[] elements) {
        int out,in,min,nElems=elements.length;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in <nElems; in++) {
                if (elements[in] < elements[min]) {
                    min = in;
                }
                int tmp = elements[out];
                elements[out] = elements[min];
                elements[min] = tmp;
            }
        }
    }
    //insert sort
    //N*(N-1)/4
    public void insertSort(int[] elements) {
        int in,out,nElems=elements.length;
        for (out = 1; out < nElems; out++) {
            int temp = elements[out];
            in = out;
            while (in > 0 && elements[in-1] >= temp) {
                elements[in] = elements[in-1];
                --in;
            }
            elements[in] = temp;
        }
    }
    //order sort
    class Person {
        private String lastName;
        private String firstName;
        private int age;

        public Person(String lastName, String firstName, int age) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
        }

        public String getLast() {
            return lastName;
        }
    }

    public void insertionSort(Person[] persons) {
        int in,out,nEmens=persons.length;

        for (out = 1; out < nEmens; out++) {
            Person temp = persons[out];
            in = out;

            while (in > 0 && persons[in-1].getLast().compareTo(temp.getLast()) > 0) {
                persons[in] = persons[in-1];
                --in;
            }
            persons[in] = temp;
        }
    }
    //N
    public void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;
        while (aDex < sizeA && bDex < sizeB) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }

        while (aDex < sizeA) {
            arrayC[cDex++] = arrayA[aDex++];
        }

        while (bDex < sizeB) {
            arrayC[cDex++] = arrayB[bDex++];
        }
    }
    //O(N*logN) h(h-1)/3 h = h *3 + 1
    public void shellSort(long[] elements,int nElems) {
        int inner, outer;
        long temp;
        int h = 1;
        while (h <= nElems/3)
            h = h*3 + 1;
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = elements[outer];
                inner = outer;

                while (inner > h - 1 && elements[inner-h] >= temp) {
                    elements[inner] = elements[inner-h];
                    inner -= h;
                }
                elements[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
    //parttion
    public int partitionIt(int left,int right,long pivot,long[] elements) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && elements[++leftPtr] < pivot) ;
            while (rightPtr > left && elements[--rightPtr] > pivot);
            if (leftPtr >= rightPtr) {
                break;
            } else {
                long temp = elements[rightPtr];
                elements[rightPtr] = elements[leftPtr];
                elements[leftPtr] = temp;
            }
        }
        return leftPtr;
    }
    //quick sort
    public void recQuickSort(int left,int right,long[] elements) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = elements[right];

            int partition = partitionIt(left,right,pivot,elements);

            recQuickSort(left,partition-1,elements);

            recQuickSort(partition+1,right,elements);
        }
    }
}
