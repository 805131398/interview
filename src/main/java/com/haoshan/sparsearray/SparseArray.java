package com.haoshan.sparsearray;

/**
 * 稀疏数组
 * @author zhanghao
 */
public class SparseArray {
    public static void main(String[] args) {
        //  创建一个原始的二维数组 11*11
        int chessRow = 11;
        int chessCol = 11;
        //  0: 标识没有棋子, 1 标识黑子 2 表示白子
        int[][] chessArray = new int[chessRow][chessCol];
        //  棋盘的落子
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[6][1] = 2;
        // sum : 有效值的数量
        int sum = 0;
        System.out.println("原始的二维数组");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }

        // 创建稀疏数组,给稀疏数组赋值,sum + 1 的 1 是把表头的一列加上, 3 是固定写法
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessRow;
        sparseArray[0][1] = chessCol;
        sparseArray[0][2] = sum;

        //  每次遍历到有效值的话 +1,存储数据
        int index = 1;
        // 通过遍历将有效值放到稀疏数组中
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArray[i][j];
                    index++;
                }
            }
        }

        System.out.println("----------以下是稀疏数组-------------");
        System.out.println("\trow\t\tcol\t\tval");
        for (int[] row : sparseArray) {
            System.out.printf("\t%d\t\t%d\t\t%d\t \n", row[0], row[1], row[2]);
        }


        // 将稀疏数组恢复成原始的数组
        int[][] newChessArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            newChessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("以下是还原后的二维数组");
        for (int[] row : newChessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
    }
}
