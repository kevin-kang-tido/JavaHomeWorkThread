import static java.lang.String.valueOf;

class DefineTwo {
    private void print(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }

    public synchronized void printWelcome(String chars) {
        this.print(chars);
    }

    public synchronized void printStar(String chars) {
        this.print(chars);
    }
    public synchronized void printStatements(String chars) {
        this.print(chars);
    }
    public synchronized void printLine(String chars) {
        this.print(chars);
    }
    public synchronized void download(String chars) {
        this.print(chars);
    }
}

public class ThreadHomework {
    static void loading() {
        String[] animationChars = {">", ">"};
        int timesToRepeat = 2;

        for (int i = 0; i < timesToRepeat; i++) {
            System.out.print(valueOf(animationChars[i % 2]));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Complete 100%!");
    }



    public static void main(String[] arg) throws InterruptedException {
        DefineTwo define = new DefineTwo();
        Thread thread1 = new Thread(() -> {
            define.printWelcome("WELCOME TO CSTAD ");
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                define.printStar("*****************************************");
            } catch (InterruptedException e) {
                System.out.println("Problem: " + e.getMessage());
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                define.printStatements("Don't Give up this Opportunity, Just do your best!");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                thread3.join();
                define.printLine("-------------------------------------------------");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        Thread thread5= new Thread(() -> {
            try {
                thread3.join();
                define.download("Download...........");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            loading();
        } catch (Exception exception) {
            System.out.println("Problem: " + exception.getMessage());
        }
    }
}
