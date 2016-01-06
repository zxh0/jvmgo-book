package jvmgo.book.ch10;

public class JvmsExample {

    public static class TestExc extends RuntimeException {}
    public static class TestExc1 extends RuntimeException {}
    public static class TestExc2 extends RuntimeException {}

    void cantBeZero(int i) {
        if (i == 0) {
            throw new TestExc();
        }
    }

    void catchOne() {
        try {
            tryItOut();
        } catch (TestExc e) {
            handleExc(e);
        }
    }

    void catchTwo() {
        try {
            tryItOut();
        } catch (TestExc1 e) {
            handleExc(e);
        } catch (TestExc2 e) {
            handleExc(e);
        }
    }

    void nestedCatch() {
        try {
            try {
                tryItOut();
            } catch (TestExc1 e) {
                handleExc1(e);
            }
        } catch (TestExc2 e) {
            handleExc2(e);
        }
    }

    void tryItOut() {
        //throw new TestExc();
    }

    void handleExc(RuntimeException exc) {

    }
    void handleExc1(TestExc1 exc) {

    }
    void handleExc2(TestExc2 exc) {

    }

    public static void main(String[] args) {
        JvmsExample example = new JvmsExample();
        example.catchOne();
        example.catchTwo();
        example.nestedCatch();
    }

}
