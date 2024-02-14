import static java.lang.StringTemplate.STR;

class Define{
    private void print(String string){
        for(int i=0;i<string.length();i++){
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(200);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }
    public synchronized void printWelcome(String chars){
        this.print(chars);
    }
    public synchronized void printStar(String chars){
        this.print(chars);
    }
}
class Reader1 extends Thread{
    private final char [] chars;
    public Reader1(char [] chars){
        this.chars = chars;
    }
    @Override
    public void run() {

    }
}

public class TestingThread{
    static void loading(){
        // Define the animation characters
        String[] animationChars = { ".", "..", "...", "...." };
        // Number of times to repeat the animation
        int timesToRepeat = 10;

        // Print the loading animation
        for (int i = 0; i < timesToRepeat; i++) {
            System.out.print(STR."\r[*] Loading \{animationChars[i % 4]}");
            try {
                // Add a delay to control the speed of the animation
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // Print completion message after the animation finishes
        System.out.println("\nLoading complete!");
    }
    public static void main(String[] arg) throws InterruptedException {
        char [] chars  = {'W','E','L','C','O','M','E',' ','T','O',' ', 'C','S','T','A','D'};
        char []   charStar = {'*', '*','*','*','*','*'};
        DefineTwo define = new DefineTwo();
        Thread thread1 = new Thread(()->{
            define.printWelcome("WELCOME TO CSTAD ");
        });
        Thread thread2 = new Thread(()->{
            define.printStar("*****************************************");
        });
        Thread thread3 = new Thread(()->{
            define.printStar("Don't Give up this Opportunity, Just do your best!");
        });
        Thread thread4 = new Thread(()->{
            define.printStar("-------------------------------------------------");
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        //
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();

        }catch (Exception exception){
            System.out.println("Problem: "+exception.getMessage());
        }
    }
}


