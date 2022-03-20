package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //Bài 1: Nhập 1 số nguyên n, kiểm tra nó có phải số hoàn hảo hay không.
        System.out.println("Nhập một số nguyên: ");
        Scanner sc1 = new Scanner(System.in);
        int n1 = sc1.nextInt();
        int sum = 0;
        for (int i = 1; i <= n1 / 2; i++) {
            if (n1 % i == 0) {
                sum += i;
            }
        }
        if (sum == n1) {
            System.out.println("Số " + n1 + " là số hoàn hảo");
        } else {
            System.out.println("Số " + n1 + " không phải là số hoàn hảo");
        }

        //Bài 2:  Nhập 1 số nguyên n, tìm số có vị trí thứ n của dãy Fibonaci.
        System.out.println("Nhập một số nguyên: ");
        Scanner sc2 = new Scanner(System.in);
        int n2 = sc2.nextInt();
        int f0=1,f1=1,fn=1;
        if(n2==0) fn=0;
        if(n2==1||n2==2) fn=1;
        else{
            for (int i=3;i<=n2;i++){
                f0=f1;
                f1=fn;
                fn=f0+f1;
            }
        }
        System.out.println("Số thứ " + n2 + " trong dãy Fibonacci là " + fn);

        // Bài 3: Nhập mảng 10 số nguyên, tìm các số nguyên tố và số thuộc dãy Fibonaci có trong mảng.
        int arr[] = new int[10];
        Scanner sc3 = new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Nhập giá trị phần tử thứ " + i + ": ");
            arr[i] = sc3.nextInt();
        }
        System.out.println("Mảng vừa nhập: ");
        for (int i=0;i<10;i++){
            System.out.println(arr[i]);
        }
        int nto=0;
        for (int i=0;i<10;i++){
            if (checkPrime(arr[i])) {
                nto++;
            }
        }
        System.out.println("Mảng vừa nhập có " + nto + " số nguyên tố: ");
        for (int i=0; i<10;i++){
            if (checkPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
        int fib=0;
        for (int i=0;i<10;i++){
            if (checkFibonacci(arr[i])) {
                fib++;
            }
        }
        System.out.println("Mảng vừa nhập có " + fib + " số thuộc dãy Fibonacci: ");
        for(int i=0;i<10;i++){
            if (checkFibonacci(arr[i])) {
                System.out.println(arr[i]);
            }
        }

        //Bài 4: Nhập 2 số nguyên, tìm ước chung lớn nhất và bội chung nhỏ nhất của 2 số đó.
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Nhập số nguyên thứ nhất: ");
        System.out.println("Nhập số nguyên thứ hai: ");
        int i,a,b,min,max,ucln=1,bcnn=0;
        a = sc4.nextInt();
        b = sc4.nextInt();
        if(a==0&&b==0) {
            System.out.println("Ước chung lớn nhất không tồn tại");
            System.out.println("Bội chung không tồn tại");
        }
        else if(a==0||b==0) {
            ucln=a+b;
            System.out.println("Bội chung không tồn tại");
            System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + ucln);
        }
        else {
            max=a*b;
            if(a>b){
                min=b;
                for(i=1;i<=min;i++){
                    if(a%i==0) ucln=i;
                }
                for(i=max;i>=a;i--){
                    if(i%a==0) bcnn=i;
                }
            }else {
                min=a;
                for(i=1;i<=min;i++){
                    if(b%i==0) ucln=i;
                }
                for(i=max;i>=b;i--){
                    if(b%i==0) bcnn=i;
                }
            }
            System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + ucln);
            System.out.println("Bội chung nhỏ nhất của " + a + " và " + b + " là: " + bcnn);
        }

    }
    public static boolean checkPrime(int n){
        if (n<2) return false;
        if (n<4) return true;
        for (int i=2;i<=n/2;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static boolean checkFibonacci(int value){
        //Kiểm tra xem giá trị vừa nhập có nằm trong dãy Fibonacci hay không
        int i=0;
        while (value > fibonacci(i)) {
            ++i;
        }
        if(value==fibonacci(i)) return true;
        return false;
    }
    public static int fibonacci(int n){
        //Liệt kê dãy số Fibonacci
        int f0=0,f1=1,fn=1;
        if(n<0) return -1;
        if(n==0||n==1) return n;
        for(int i=2;i<n;i++){
            f0=f1;
            f1=fn;
            fn=f0+f1;
        }
        return fn;
    }
}
