import java.util.Scanner;

/**
 * @author Neeraj Shah
 */
class StreamMedian {

    private int[] array;

    StreamMedian() {
        array = new int[0];
    }


    /**
     * Inserts the element in array of integers received as stream. The array is sorted and new elements
     * are inserted based on their ascending natural sort order
     */
    public void insert(int element) {
        int i = -1;

        // New array where we need to copy the old array + the element to be inserted
        int[] newArray = new int[array.length+1];

        // Find the pivot position, we need to increment i first to make sure that we don't run past
        // array boundary and once we are out of the loop i would be the array index where new element
        // needs to be inserted. Pretty neat huh??
        while(++i < array.length && 
                element >  array[i]
            );
        
        // If pivot point is not at first index then we would need to copy all the elements left of the
        // pivot point. However, if pivot point is at 0 then System.arraycopy will have no effect as last
        // argument, i, will be 0 which specifies number of elements to copy from source to destination
        System.arraycopy(array, 0, newArray, 0, i);

        // Copy the new element at the pivot position
        newArray[i] = element;

        // Copy all the elements right of the pivot position, again if the pivot position is at the end of
        // the array then array.length - i would yield 0 which is number of elements to copy form source to
        // the destination. Pretty neat huh??
        System.arraycopy(array, i, newArray, (i+1), (array.length-i));

        // Swap the newArray as array for obvious reasons
        array = newArray;
    }

    /**
     * @return If the number of elements are odd then middle most element is returned as the Median. If the
     *         number of elements are even then mean of values at mid and mid+1 is returned as Median
     */
    public int getMedian() {
        int midpoint = (int)(array.length/2);
        if(array.length % 2 == 0){
            return (int)Math.floor(
                (array[midpoint-1] + array[midpoint])/2
            );
        } else {
            return array[midpoint];
        }
    }

    /**
     * Pretty prints entire array
     */
    public void prettyPrint() {
        for(int element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StreamMedian streamMedian = new StreamMedian();

        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNext()) {
                streamMedian.insert(scanner.nextInt());
                System.out.print("Number stream ");
                streamMedian.prettyPrint();
                System.out.println("Median "+streamMedian.getMedian());
                System.out.println();
            }
        }
    }
}
