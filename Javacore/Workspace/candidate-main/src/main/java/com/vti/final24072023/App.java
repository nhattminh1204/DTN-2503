package com.vti.final24072023;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
//        in ra các số từ 1->10
//        System.out.println(1);
//        System.out.println(2);
//        System.out.println(3);
//        System.out.println(4);
//        System.out.println(5);
//        System.out.println(6);
//        System.out.println(7);
//        System.out.println(8);
//        System.out.println(9);
//        System.out.println(10);
        // hành đng lặp đi lap lai mot hanh dong có quy tac
        // gtri khơi dau =1;  dieu kien dung vong lap i <= 10 (false), bước nhảy  sau moi vong lap i se tang them 1 don vi
        int[] arr = {1,2,3,4,5,6,7,8,9};
//        int a;
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(i);
//        }

        // chỉ in ra các gtri <5

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]>=5) {
//                break;
//            }
//            System.out.println(arr[i]);
//        }
//        System.out.println("hello");

        // ko in ra gtri =5
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]==5) {
//                continue;
//            }
//            System.out.println(arr[i]);
//
//        }
//        System.out.println("Hello");

        // dung chương trình khi gtri =5

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]==5) {
//                return;
//            }
//            System.out.println(arr[i]);
//
//        }
//        System.out.println("Hello");

        int x = 1;
        int y = 1;
//        x= x+2;//
        x+=2;
//        y = ++x;// hd1: gán y=x   hd2: tang x len 1 don vi
        // i++ thì hd1; sẽ xảy ra trước, hd2: thực hiện sau
        // ++i thì hd2 xảy ra trc, hd1 xay ra sau
//        System.out.println("x= "+x);
//        System.out.println("y = "+y);
        // 5/2=2
        // 5%2 =1

        //date -> String
//        Date date = new Date();
//
//        String parten = "ddMMyy";
//        SimpleDateFormat format = new SimpleDateFormat(parten);
//        String d = format.format(date);
//
//        System.out.print(date);
//        System.out.println(d);
//
//        System.out.printf("%s  %s\n", date, d);
//
//        // String -> Date
//        String s = "12-12-2020";
//        String parten1 = "dd-MM-yyyy";
//        SimpleDateFormat format1 = new SimpleDateFormat(parten1);
//        Date date1 = format1.parse(s);
//        System.out.println(date1);
//        // tinh tong va hieu cua 2 so 1 va 2
//        System.out.println("Tong ="+ (1+2));
//        System.out.println("Hieu ="+ (1-2));
//        // tinh tong va hieu cua 2 so 2 va 3
//        System.out.println("Tong ="+ (2+3));
//        System.out.println("Hieu ="+ (2-3));
//        // tinh tong va hieu cua 2 so 4 va 2
//        System.out.println("Tong ="+ (4+2));
//        System.out.println("Hieu ="+ (4-2));
        tongHieu(1,2);
        tongHieu(2,3);
        tongHieu(4,2);


    }
     public static void tongHieu(int a, int b) {
         System.out.println("Tong ="+ (a+b));
         System.out.println("Hieu ="+ (a-b));
     }



}
