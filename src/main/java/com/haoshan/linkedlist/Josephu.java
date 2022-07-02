package com.haoshan.linkedlist;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * 约瑟夫问题
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.create(5);
        circleSingleLinkedList.josephu(288);
    }
}

// 创建一个环形的单向链表
@Slf4j
class CircleSingleLinkedList {
    /**
     * 创建一个first节点，当前没有编号
     */
    public Boy first = null;

    /**
     * 创建一个环形链表
     */
    public void create(int num) {
        if (num < 1) {
            System.out.println("创建数量不能小于 1");
            return;
        }
        // 临时节点保存最后一个，用于组成一个环形
        Boy currBoy = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                boy.setNext(boy);
                first = boy;
                currBoy = first;
            } else {
                currBoy.setNext(boy);
                boy.setNext(first);
                currBoy = boy;
            }
        }
    }

    /**
     * 打印环形链表
     */
    public void list() {
        if (first == null) {
            System.out.println("当前环形链表是空的！");
            return;
        }
        Boy next = first;
        do {
            // 获取下一个节点
            log.info("no 的值为: {}", next.getNo());
            next = next.getNext();
        } while (next.getNo() != first.getNo());
        System.out.println("已全部打印");
    }
    /**
     * @param num 每次弹出的小孩的顺位数
     */
    public void josephu(int num) {
        if (first == null) {
            System.out.println("当前环形链表是空的！");
            return;
        }
        //  计数器
        int counter = 1;
        // 临时变量
        Boy current = first;
        while (true) {
            counter++;
            Boy next = current.getNext();
            if (next == current) {
                log.info("被吃掉的小孩的 no 的值为: {}", next.getNo());
                break;
            }
            if (counter == num) {
                counter = 1;
                log.info("被吃掉的小孩的 no 的值为: {}", next.getNo());
                System.out.println();
                System.out.println();
                current.setNext(next.getNext());
                current = next.getNext();
            }else {
                current = current.getNext();
            }
        }
    }
}

/**
 * 创建一个Boy类,表示一个节点
 */
@Data
class Boy {
    /**
     * 编号
     */
    private int no;

    /**
     * 指向下一个小孩
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }


}
