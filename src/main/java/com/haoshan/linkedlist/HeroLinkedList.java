package com.haoshan.linkedlist;

import lombok.Data;

/**
 * 水浒英雄链表实现
 *
 * @author apple
 */
public class HeroLinkedList {

    /**
     * 链表的头
     */
    private HeroNode head = new HeroNode(0);
    private Integer heroSize = 0;

    public static void main(String[] args) {
        HeroLinkedList linkedList = new HeroLinkedList();
        HeroNode h1 = new HeroNode(1, "1");
        HeroNode h2 = new HeroNode(2, "2");
        HeroNode h3 = new HeroNode(3, "3");
        HeroNode h4 = new HeroNode(4, "4");
        HeroNode h5 = new HeroNode(5, "5");
        HeroNode h6 = new HeroNode(6, "6");
        HeroNode h7 = new HeroNode(7, "7");
        linkedList.add(h1);
        linkedList.add(h2);
        linkedList.add(h3);
        linkedList.add(h4);
        linkedList.add(h5);
        linkedList.add(h6);
        linkedList.add(h7);
        linkedList.delete(1);
        linkedList.delete(4);
        linkedList.list();
    }

    /**
     * 增加
     * // 要一直找到最后一个再进行添加
     * // 怎么判断是不是最后一个呢?
     * // this.getNext == null 的时候 this 就是最后一个英雄
     * this 需要一个临时变量来进行保存
     */
    public void add(HeroNode node) {
        // this 需要一个临时变量来进行保存
        HeroNode temp = head;
        // 使用循环一直向下查找,直到 this.getNext不为空
        while (temp.next != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        heroSize++;
    }

    /**
     * 通过编号查询英雄节点并打印输出
     */
    public HeroNode findByNo(int no) {
        while (true) {
            HeroNode next = head.getNext();
            if (next == null) {
                System.out.printf(" 抱歉没有在 %d 中找到编号为 %d 的英雄 \n", heroSize, no);
                break;
            } else {
                if (next.getNo() == no) {
                    System.out.println("↓↓↓ 找到对应编号的英雄 ↓↓↓");
                    System.out.println(next);
                    System.out.println("↑↑↑ 找到对应编号的英雄 ↑↑↑");
                    return next;
                }
            }
        }
        return null;
    }

    /**
     * 通过英雄编号删除链表中的英雄
     * <p>
     * // 找到要删除的节点,判断找到的这个节点是否存在子节点
     * // 找到要删除节点的上个节点
     * // 将当前节点的子节点放到上个节点的子节点的位置
     */
    public void delete(int no) {
        HeroNode temp = this.head;
        HeroNode next = null;
        while (temp.getNext() != null) {
            if (temp.next.no == no) {
                next = temp.next.getNext();
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(next);
    }

    // 修改


    /**
     * 查看链表信息
     */
    public void list() {
        HeroNode temp = this.head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "HeroLinkedList{" +
                "head=" + head +
                ", heroSize=" + heroSize +
                '}';
    }
}


@Data
class HeroNode {

    /**
     * 排名
     */
    public int no;

    /**
     * 姓名
     */
    public String name;

    /**
     * 下一位 -> 下一个节点
     */
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no) {
        this.no = no;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
