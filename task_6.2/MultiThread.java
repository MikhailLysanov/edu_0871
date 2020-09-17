public class MultiThread {

    public static void main(String[] args) {
        /*
        //Способ №1
        MyThead t1 = new MyThead();
        MyThead t2 = new MyThead();
        t1.start();
        t2.start();*/

        /*
        //Способ №2
        Thread t1 = new Thread(new MyRunnableClass());
        Thread t2 = new Thread(new MyRunnableClass());
        t1.start();
        t2.start();*/

        //Способ №3
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 500; i < 600; i++) {
                    System.out.println(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 900; i > 800; i--) {
                    System.out.println(i);
                }
            }
        });

        t1.start();
        t2.start();
    }

}

class MyRunnableClass implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class MyThead extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
