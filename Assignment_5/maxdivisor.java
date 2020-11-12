
public class maxdivisor extends Thread
{
      static int max = 0;
      static int whichNum = 0;
    int start;
    public maxdivisor(int start){
        this.start = start;
    }
    public static void main(String[] args){
    maxdivisor th1 =  new maxdivisor(1),th2 =  new maxdivisor(10001),th3 =  new maxdivisor(20001);
    maxdivisor th4 =  new maxdivisor(30001),th5=  new maxdivisor(40001),th6 =  new maxdivisor(50001);
    maxdivisor th7 =  new maxdivisor(60001),th8 =  new maxdivisor(70001),th9 =  new maxdivisor(80001);
    maxdivisor th10 =  new maxdivisor(90001);
    long startTime = System.currentTimeMillis();
    th1.start();
    th2.start();
    th3.start();
    th4.start();
    th5.start();
    th6.start();
    th7.start();
    th8.start();
    th9.start();
    th10.start();

    //sync threads so when th1 is done, th2 starts and so on
    try{
    th1.join();
    th2.join();
    th3.join();
    th4.join();
    th5.join();
    th6.join();
    th7.join();
    th8.join();
    th9.join();
    th10.join();
     }catch(Exception e){System.out.println(e);}  
     long elapsedTime = System.currentTimeMillis() - startTime;
       System.out.println("Thread " + whichNum + " had " + max + "divisors and used " +   (elapsedTime/1000.0) + "seconds"); 
    }
    public void run(){
      
        for(int i = 0; i<10000; i++){
            int count = 0;
            //counting divisors for each num
            for (int j = 1; j <= i ; j++) {
         if ( i % j == 0 )
            count ++;
      }
        
         if(count>max)
            {
                synchronized(this)
                {
                    max = count;
                    whichNum = i;
                }
            }
        }
    }
   
}