package jvmgo.book.ch08;

public class Array3D {

    public static void main(String[] args) {
        int[][][] threeD = new int[5][4][3];

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 3; ++k) {
                    threeD[i][j][k] = i + j + k;
                }
            }
        }

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 3; ++k) {
                    System.out.println(threeD[i][j][k]);
                }
            }
        }
    }

}
