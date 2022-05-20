//package com.haoshan.queue;
//
//import java.util.Scanner;
//
///**
// * 模拟使用数组实现队列
// *
// * @author apple
// */
//public class ArrayQueueDemo {
//    public static void main(String[] args) {
//        // 创建一个队列对象
//        ArrayQueue arrayQueue = new ArrayQueue(3);
//
//        // 用于接收用户输入的值
//        char input = ' ';
//
//        // 监听输入
//        Scanner scanner = new Scanner(System.in);
//        boolean loop = true;
//        while (loop) {
//            System.out.println("s(show): 显示队列");
//            System.out.println("a(add): 添加数据到队列");
//            System.out.println("g(get): 从队列中获取数据");
//            System.out.println("h(hea): 查看队列头的数据");
//            System.out.println("e(exit): 退出程序");
//            input = scanner.next().charAt(0);
//            switch (input) {
//                case 's':
//                    arrayQueue.showQueue();
//                    break;
//                case 'a':
//                    System.out.println("请输入一个值:");
//                    int value = scanner.nextInt();
//                    arrayQueue.addQueue(value);
//                    break;
//                case 'g':
//                    try {
//                        int queue = arrayQueue.getQueue();
//                        System.out.println("取出的数据为:" + queue);
//                    } catch (Exception e) {
//                        String message = e.getMessage();
//                        System.out.println(message);
//                    }
//                    break;
//                case 'h':
//                    int heard = arrayQueue.headQueue();
//                    System.out.println("查看头部的数据为:" + heard);
//                    break;
//                case 'e':
//                    loop = false;
//                    break;
//                default:
//            }
//        }
//        System.out.println("队列程序已退出");
//    }
//}
//
//
///** 创建一个队列对象 */
//class ArrayQueue {
//
//    /**
//     * 数组最大容量
//     */
//    private int maxSize;
//    /**
//     * 队列头
//     */
//    private int front;
//    /**
//     * 队列尾部
//     */
//    private int rear;
//    /**
//     * arr 用于存放数据,模拟队列
//     */
//    private int[] arr;
//
//    /**
//     * 单参构造器
//     */
//    public ArrayQueue(int arrMaxSize) {
//        this.maxSize = arrMaxSize;
//        this.arr = new int[arrMaxSize];
//        // 指向队列头部的前一个位置
//        this.front = -1;
//        // 指向队列尾部,即队列的最后一个参数
//        this.rear = -1;
//    }
//
//    /**
//     * 判断队列是不是已经满了
//     */
//    public boolean isFull() {
//        return this.rear == this.maxSize - 1;
//    }
//
//    /**
//     * 判断队列是不是空的
//     */
//    public boolean isEmpty() {
//        return this.rear == this.front;
//    }
//
//    /**
//     * 添加数据
//     */
//    public boolean addQueue(int value) {
//        if (isFull()) {
//            System.out.println("队列满了不能加数据");
//            return false;
//        }
//        this.rear++;
//        this.arr[this.rear] = value;
//        return true;
//    }
//
//    /**
//     * 数据出队列
//     */
//    public int getQueue() {
//        //  判断数据是不是空的
//        if (isEmpty()) {
//            throw new RuntimeException("队列是空的获取不到数据");
//        }
//        //  取数据
//        return this.arr[++this.front];
//    }
//
//    /**
//     * 显示队列的所有数据
//     */
//    public void showQueue() {
//
//        if (isEmpty()) {
//            System.out.println("队列是空的获取不到数据");
//            return;
//        }
//
//        for (int i = 0; i < this.arr.length; i++) {
//            System.out.printf("arr[%d] = %d\n", i, this.arr[i]);
//
//        }
//    }
//
//    /**
//     * 显示队列的头数据是哪个
//     */
//    public int headQueue() {
//        if (isEmpty()) {
//            throw new RuntimeException("队列是空的获取不到数据");
//        }
//        return this.arr[this.front + 1];
//    }
//
//}
