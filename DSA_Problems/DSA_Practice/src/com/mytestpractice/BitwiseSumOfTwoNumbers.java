package com.mytestpractice;


public class BitwiseSumOfTwoNumbers {
    public static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;       // Carry where both bits are 1
            System.out.println("1-->  a ="+a+ " b="+b+" carry="+carry);
            a = a ^ b;               // Sum without carry
            b = carry << 1;
            System.out.println("2-->  a ="+a+ " b="+b+" carry="+carry);// Carry added to next higher bit
        }
        return a;
    }

    public static void main(String[] args) {
        int x = 8;
        int y = 12;
        System.out.println("Sum: " + add(x, y));  // Output: 47
    }
}
