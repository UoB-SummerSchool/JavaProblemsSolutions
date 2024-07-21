
public class P8_Euler_but_extended {

    private static int WINDOW_SZ = 13;
    private static String NUMBER_STRING = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long a = run();
        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime);
        System.out.println("Time: " + duration1 + " Solution: " + a);

        startTime = System.nanoTime();
        a = run2();
        endTime = System.nanoTime();
        long duration2 = (endTime - startTime);
        System.out.println("Time: " + duration2 + " Solution: " + a);
        System.out.println(duration1- duration2);
    }
    public static long run() {
        long maxProd = 0;
        for (int i = 0; i <= NUMBER_STRING.length() - WINDOW_SZ; i++) {
            long prod = 1;
            for (int j = 0; j < WINDOW_SZ; j++)
                prod *= NUMBER_STRING.charAt(i + j) - '0';
            maxProd = Math.max(prod, maxProd);
        }
        return maxProd;
    }
    public static long gw(int i){
        long prod = 1;
        for (int j = 0; j < WINDOW_SZ; j++)
            prod *= NUMBER_STRING.charAt(i + j) - '0';
        return prod;
    }

    // find last zero in window
    public static int gl0 (int i){
        int j = WINDOW_SZ;

        while(NUMBER_STRING.charAt(i+j--) != '0');

        return i+j+2; // + 1 to rewind j-- and another +1 to step over zero
    }

    public static long run2(){
        long maxProd = gw(0);
        long prod = maxProd;

        int i = 1;
        while (i <= NUMBER_STRING.length() - WINDOW_SZ) {
            if (prod == 0) {
                i = gl0(i);
                if(!(i + WINDOW_SZ <= NUMBER_STRING.length()))
                    break;
                prod = gw(i);
                maxProd = Math.max(prod, maxProd);
                i++;
                continue;
            }

            long left = NUMBER_STRING.charAt(i - 1) - '0';
            long right = NUMBER_STRING.charAt(i + WINDOW_SZ - 1) - '0';
            
            prod = prod * right / left;
            maxProd = Math.max(prod, maxProd);
            if (prod != 0)
                i++;

        }

        return maxProd;
    }



}