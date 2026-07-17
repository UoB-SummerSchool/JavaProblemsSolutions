public class P8_i {
    public static void main(String[] args) {
        int[] nums = {7, 3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3, 0, 6, 2, 4, 9, 1, 9, 2, 2, 5, 1, 1, 9, 6, 7, 4, 4, 2, 6, 5, 7, 4, 7, 4, 2, 3, 5, 5, 3, 4, 9, 1, 9, 4, 9, 3, 4};
        int maxProduct = 0;
        int n = nums.length;

        for (int i = 0; i <= n - 5; i++) {

            int product = 1;
            for(int j = i; j < i + 5; j++)
                product*=nums[j];

            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        System.out.println("The maximum product of 5 adjacent integers is: " + maxProduct);
    }
}
