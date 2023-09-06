package org.example;

public class DecimaltoBinary {

    public static void main(String[] args) {
        // binary to decimal
        String decimal = "100100110";
        char[] arr = decimal.toCharArray();
        int j = 0, sum = 0;
        for (int i =arr.length-1; i>=0; i--){
            sum += Character.digit(arr[i], 10) * Math.pow(2, j);
            //System.out.println(sum);
            j++;
        }
        System.out.println(sum);

        // decimal to binary
        int binary = 294;
        StringBuilder sb = new StringBuilder();
        int num = binary;
        int remainder = 0;
        while(num != 1){
            remainder = num % 2;
            num = num/2;
            sb.append(remainder);
        }
        String res = sb.toString();
        System.out.println(res);
    }
}
