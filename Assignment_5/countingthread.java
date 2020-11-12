public class countingthread extends Thread
{
    public static void main(String[] args)
    {
        countingthread th = new countingthread();
        th.start();
    }
    public void run(){
        for(int i = 1; i<= 100; i++){
            if (i%10 == 0){
                System.out.println(i);
            }
            try{
                Thread.sleep(1000);
               
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}

