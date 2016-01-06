package jvmgo.book.ch07;

public class InvokeInterfaceTest {

    public static void main(String[] args) {
        Vector v = new Vector3D(3.1, 3.2, 3.3);
        v.multiply(3);

        Vector3D v3 = (Vector3D) v;
        System.out.println(v3.x);
        System.out.println(v3.y);
        System.out.println(v3.z);
    }

}
