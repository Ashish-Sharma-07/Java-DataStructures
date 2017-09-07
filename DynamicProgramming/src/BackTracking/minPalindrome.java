package BackTracking;

import java.util.Scanner;

public class minPalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String cp = str;
        String opstr="";
        int i = str.length()-1;
        while(!isPalindrome(cp))
        {
            opstr +=str.charAt(i);
            i--;
            cp = opstr.concat(str);
        }
        System.out.println(cp);

    }

    private static boolean isPalindrome(String str) {
        for(int i = 0 , j = str.length()-1;i<=j;i++,j--)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;
    }

}
