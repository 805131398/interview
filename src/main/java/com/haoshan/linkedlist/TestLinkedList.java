package com.haoshan.linkedlist;

import lombok.Data;

import java.util.Stack;

/**
 * 水浒英雄链表实现
 *
 * @author apple
 */

public class TestLinkedList {
    public static void main(String[] args) {
        SingleLinkedLinkedList linkedList = new SingleLinkedLinkedList();
        SingleLinkedLinkedList linkedList2 = new SingleLinkedLinkedList();
        // 创建 7 个英雄
        HeroNode h1 = new HeroNode(1, "1");
        HeroNode h2 = new HeroNode(2, "2");
        HeroNode h3 = new HeroNode(3, "3");
        HeroNode h4 = new HeroNode(4, "4");
        HeroNode h5 = new HeroNode(5, "5");
        HeroNode h6 = new HeroNode(6, "6");
        HeroNode h7 = new HeroNode(7, "7");
        //  添加到链表中
        //
        linkedList.add(h1);
        linkedList.add(h3);
        linkedList.add(h6);
        linkedList.add(h7);


        linkedList2.add(h2);
        linkedList2.add(h4);
        linkedList2.add(h5);
        linkedList2.add(h6);


        //        linkedList.addByHeroNo(h1);
        //        linkedList.addByHeroNo(h3);
        //        linkedList.addByHeroNo(h6);
        //        linkedList.addByHeroNo(h7);
        //
        //
        //        linkedList.addByHeroNo(h2);
        //        linkedList.addByHeroNo(h4);
        //        linkedList.addByHeroNo(h5);
        //        linkedList.addByHeroNo(h6);

        //        linkedList.list();

   /*     //  删除两个英雄
        linkedList.delete(1);
        linkedList.delete(4);
        //  修改其中一个的名称
        linkedList.update(new HeroNode(7, "7777"));
        // 按照英雄的编号增加到链表中
        linkedList.addByHeroNo(h1);
        linkedList.addByHeroNo(h4);

        // findByNo 具体查找
        System.out.println("findByNo 具体查找");
        linkedList.findByNo(2);

        // 1、当前链表中有效的节点个数为:
        getLinkedListSize(linkedList.getHead());


        // 2、查找单链表中的倒数第 k 个节点
        findLastIndexNode(linkedList.getHead(), 6);

        //        findLastIndexNode(linkedList.getHead(), 7);

        //  查询链表中的数据
        linkedList.list();

        // 3、单链表的反转
        //        reverse(linkedList.getHead());

        //        reverseList(linkedList.getHead());

        reversePrintln(linkedList.getHead());

    */

        merge(linkedList, linkedList2);

    }

    public static void merge(SingleLinkedLinkedList linkedList, SingleLinkedLinkedList linkedList2) {
        HeroNode temp = linkedList2.getHead().getNext();
        while (temp != null) {
            linkedList.addByHeroNo(new HeroNode(temp.no,temp.name));
            temp = temp.next;
        }

        linkedList.list();

    }


    public static void reversePrintln(HeroNode head) {
        HeroNode temp = head.next;
        Stack<HeroNode> heroNodeStack = new Stack<>();
        while (temp != null) {
            heroNodeStack.push(temp);
            temp = temp.next;
        }
        while (heroNodeStack.size() > 0) {
            System.out.println(heroNodeStack.pop());
        }
    }

    public static void reverseList(HeroNode head) {
        // 如果当前链表为空,或者只有一个几点, 无需反转,直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 插首法
        HeroNode newHead = new HeroNode(0);
        HeroNode temp = head.next;
        HeroNode next;
        while (temp != null) {
            // 将本次的循环变量的 next 进行一次保存. 目的:然后在赋值给临时变量 temp
            next = temp.next;
            // 因为已经上一行变量 next 已经保存了临时变量的 next 指针(temp.next) ,
            // 所以临时变量 temp 的 next 指针重新指向新链表的最前端
            // 目的是将新链表头以下的节点放到当前节点的 next 引用中
            // 也就是说让当前节点的 next 指针指向新链表的头下面的 next
            temp.next = newHead.next;
            // 此时的临时变量 temp 可以作为一个新地引用给到新头 newHead 了
            newHead.next = temp;
            // 然后在赋值给临时变量 temp
            temp = next;
        }
        temp = newHead.getNext();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("reverseList 打印");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 反转链表比较 low
     */
    public static void reverse(HeroNode head) {
        SingleLinkedLinkedList linkedList = new SingleLinkedLinkedList();
        int linkedListSize = getLinkedListSize(head);
        for (int i = 1; i < linkedListSize; i++) {
            HeroNode lastIndexNode = findLastIndexNode(head, i);
            HeroNode heroNode = new HeroNode(lastIndexNode.getNo(), lastIndexNode.getName());
            linkedList.add(heroNode);
        }
        System.out.println("多次遍历 reverse");
        linkedList.list();
    }

    /**
     * 获取链表倒数第 index 个节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 1.先获取到这个链表的总长度是多少
        int linkedListSize = getLinkedListSize(head);

        if (index > linkedListSize) {
            return null;
        }

        // 2.计算要找的节点顺序查找应该是第几个,下标从 0 开始
        int lastIndex = linkedListSize - index;
        // 3.声明一个临时变量来判断循环到了第几次
        int i = 0;
        // 4.声明一个临时节点来遍历数据
        HeroNode temp = head.next;
        while (temp.next != null) {
            if (i++ == lastIndex) {
                break;
            }
            temp = temp.next;
        }
        System.out.println("找到的倒数第" + i + "节点是:" + temp);
        return temp;
    }

    /**
     * 获取链表有效节点的长度
     */
    public static int getLinkedListSize(HeroNode head) {

        HeroNode temp = head.next;
        if (temp == null) {
            return 0;
        }
        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        //        System.out.println("当前链表中有效的节点个数为:  " + length);
        return length;

    }
}

/**
 * 单向链表
 */
class SingleLinkedLinkedList {

    /**
     * 链表的头
     */
    private final HeroNode head = new HeroNode(0);
    private Integer heroSize = 0;

    public HeroNode getHead() {
        return head;
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
     * 通过编号的顺序来添加英雄节点
     */
    public void addByHeroNo(HeroNode hero) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > hero.no) {
                break;
            } else if (temp.next.no == hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("存在");
        } else {
            hero.next = temp.next;
            temp.next = hero;
        }
    }


    /**
     * 通过编号查询英雄节点并打印输出
     */
    public void findByNo(int no) {
        HeroNode next = head.getNext();
        while (true) {
            if (next == null) {
                System.out.printf(" 抱歉没有在 %d 中找到编号为 %d 的英雄 \n", heroSize, no);
                break;
            } else {
                if (next.getNo() == no) {
                    System.out.println("↓↓↓ 找到对应编号的英雄 ↓↓↓");
                    System.out.println(next);
                    System.out.println("↑↑↑ 找到对应编号的英雄 ↑↑↑");
                    break;
                }
            }
            next = next.getNext();
        }
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

    /**
     * 修改,只修改名称
     */
    public void update(HeroNode hero) {
        HeroNode temp = this.head;
        while (temp.getNext() != null) {
            if (temp.no == hero.no) {
                temp.setName(hero.getName());
                break;
            }
            temp = temp.getNext();
        }
        // 如果最后一个一样的话照样修改
        if (temp.no == hero.no) {
            temp.setName(hero.getName());
        }
    }


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
                //                ", heroSize=" + heroSize +
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
