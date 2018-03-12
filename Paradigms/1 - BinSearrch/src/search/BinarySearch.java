package search;

import static java.lang.Integer.parseInt;

/**
 * @author Nikita Kochetkov M3134
 */

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binSearch_1(args));
        //System.out.println(binSearch_2(args));
    }

    //pre: args != null
    //post: R = max' :  n' = args.length()-1 ∧ ∀i = 1..n'-1:  if (args[i] <= args[0]) : max'=i
    private static int binSearch_1(String[] args) {
        //args.length>0
        String[] mas = new String[args.length - 1];
        //args != null
        System.arraycopy(args, 1, mas, 0, args.length - 1);
        //mas = args-args[0]
        return recSearch(mas, -1, mas.length, parseInt(args[0]));
    }

    //pre: mas != null ∧ (-1 <= l < r) ∧ (0 <= r <= mas.length) ∧ (abs(key) < 2^31) ∧ (enough stack memory)
    //post: (mas[l..r] > key ∧ r == mas.length) || (R <= mas.length ∧ mas[R] <= key)
    //inv: mas!=null, abs(key) < 2^31 ∧ l <= R <= r
    private static int recSearch(String[] mas, int l, int r, int key) {
        if (mas.length == 0) return 0;
        // (abs(l) < 2^31) ∧ (abs(r) < 2^31)
        if (l >= r - 1) return r;
        // (abs(l) < 2^31) ∧ (abs(r) < 2^31)
        int m = (l + r) / 2;
        // m = (l' + r') / 2 ∧ m = Z
        if (parseInt(mas[m]) <= key) {
            return recSearch(mas, l, m, key);
        } else {
            return recSearch(mas, m, r, key);
        }
    }
    //O(logn) because log(2,mas.length)

    //pre: args != null
    //post: R = max :  n' = args.length()-1 ∧ ∀i = 1..n'-1:  if (args[i] <= args[0]) : max=i
    private static int binSearch_2(String[] args) {
        // args.length>0
        String[] mas = new String[args.length - 1];
        // args != null
        System.arraycopy(args, 1, mas, 0, args.length - 1);
        //  mas = args-args[0]
        return iterSearch(mas, parseInt(args[0]));
    }

    //pre: mas != null ∧ abs(key) < 2^31 ∧ mas[l]=+inf ∧ mas[r] = -inf
    //post: ((mas[l..r] > key ∧ r == mas.length) || (R <= mas.length ∧ mas[R] <= key)) ∧ (mas=mas')
    //inv: mas!=null ∧ abs(key) < 2^31 ∧ l <= R <= r
    private static int iterSearch(String[] mas, int key) {
        if (mas.length == 0) return 0;
        int l = -1;
        // abs(mas.length) < 2^31 ∧ mas.length >= 0
        int r = mas.length;
        // r' = mas.length
        // inv: mas[l] > key ∧ mas[r] <= key
        while (l < r - 1) {
            int m = (l + r) / 2;
            // m = (l + r) / 2 ∧ m = Z
            if (parseInt(mas[m]) > key)
                l = m;
                // l' = m
            else
                r = m;
                // r' = m
        }
        // while l < r -1:
        // m = (l' + r') / 2 ∧ m = Z
        // if ((int)mas[m] > key) ? l' = m : r' = m
        return r;
    }
    //O(logn) because log(2,mas.length)
}

