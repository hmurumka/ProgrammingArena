package practice.dsa;

// remove all the duplicates from given array, make sure complexity
// would be max o(n)
//        int[] arr = {1, 2, 2, 3, 3, 4, 5, 5};
//        output should be {1, 2, 3, 4, 5}

public class RemoveDuplicatesTwoPointers {

    static void main() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 6, 7};
        // output should be {1, 2, 3, 4, 5}

        int l =0, r = 0;
        while((l <= r) && (r < arr.length))
        {
            if(arr[l] == arr[r]) {
                r++;
            }
            else if(arr[l] != arr[r]) {
                l++;
                arr[l] = arr[r];
                r++;
            }
        }

        for (int i = 0; i <= l; i++) {
            System.out.println(arr[i] + ",");
        }
    }

}
