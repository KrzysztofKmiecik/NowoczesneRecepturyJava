class Main {
    public static void main(String[] args) {

      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymus class");
                System.out.println(Thread.currentThread().getName());
            }
        }).start();*/

        new Thread(()-> System.out.println("hello")).start();
        new Thread(()->{
            System.out.println("new Thread");
            System.out.println(Thread.currentThread().getName());
        }).start();

    }
}
