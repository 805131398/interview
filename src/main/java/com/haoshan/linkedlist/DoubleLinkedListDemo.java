package com.haoshan.linkedlist;

import lombok.Data;


/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 heroNode1 = new HeroNode2(1, "1");
        HeroNode2 heroNode2 = new HeroNode2(2, "2");
        HeroNode2 heroNode3 = new HeroNode2(3, "3");
        HeroNode2 heroNode4 = new HeroNode2(4, "4");
        HeroNode2 heroNode5 = new HeroNode2(5, "5");
        HeroNode2 heroNode6 = new HeroNode2(6, "6");
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode5);
        doubleLinkedList.add(heroNode6);

        doubleLinkedList.list();
        HeroNode2 heroNode6_66 = new HeroNode2(6, "66");

        doubleLinkedList.addHeroByNo(heroNode6_66);
        doubleLinkedList.addHeroByNo(heroNode2);
        doubleLinkedList.addHeroByNo(heroNode4);

        doubleLinkedList.list();
    }
}


/**
 * 创建一个双向链表的类
 */
class DoubleLinkedList {
    /**
     * 初始化表头，头结点，不存放具体数据
     */
    private final HeroNode2 head = new HeroNode2(0, "");

    // 返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历双向链表
     */
    public void list() {
        // 首先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为是头结点，不能动，所以我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (temp != null) {
            // 判断是否是链表的最后
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 添加一个节点到链表的最后
     */
    public void add(HeroNode2 headNode) {
        // 因为head 节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;
        while (temp.next != null) {
            // 遍历到最后一个节点
            temp = temp.next;
        }
        // 形成一个双向链表
        headNode.pre = temp;
        temp.next = headNode;
    }


    public void addHeroByNo(HeroNode2 newHeroNode) {
        // 1. 判断位置,可能会出现的情况:找到相同的,在最后一个,在第一个,在中间
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            } else if (temp.next.no > newHeroNode.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 存在,更新把那就
            update(newHeroNode);
        } else {
            assert temp != null;
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
        }
    }

    /**
     * 修改一个节点的内容
     */
    public void update(HeroNode2 newHeroNode) {
        // 1.找到节点
        HeroNode2 temp = head.next;
        //  使用一个节点表示是否找到了节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("遍历完链表但是没有找到对应的节点");
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 2.修改节点信息
        if (flag) {
            temp.name = newHeroNode.name;
        } else {
            System.out.println("修改失败：没有找到编号为" + newHeroNode.no + "的英雄");
        }
    }

    /**
     * 从双向链表中删除一个节点
     */
    public void delete(int no) {
        // 1.找到节点
        HeroNode2 temp = head.next;
        //  使用一个节点表示是否找到了节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("遍历完链表但是没有找到对应的节点");
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 找到之后执行删除操作
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("删除失败：没有找到编号为 [" + no + "] 的英雄");
        }
    }
}


@Data
class HeroNode2 {

    /**
     * 排名
     */
    public int no;

    /**
     * 姓名
     */
    public String name;

    /**
     * 下一位 -> 下一个节点 默认为null
     */
    public HeroNode2 next;

    /**
     * 前一个节点，默认为null
     */
    public HeroNode2 pre;

    public HeroNode2() {
    }

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{"
                + "no=" + no
                + ", name='" + name + '\''
                + ", next='" + next + '\''
                + '}';
    }
}
