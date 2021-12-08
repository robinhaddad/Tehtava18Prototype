/*
client
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyClock myClock = new MyClock("myClock","original");
        MyClock clonedClock = myClock.deepCopy();

        System.out.println(myClock.getClockName()+","+myClock.getSubj().getName());
        System.out.println(clonedClock.getClockName()+","+clonedClock.getSubj().getName());

        clonedClock.setClockName("clonedClock");
        clonedClock.getSubj().setName("clone");
        clonedClock.getSubj().setStartTime(6,15,20);

        System.out.println(myClock.getClockName());
        myClock.getSubj().whatsTheTime();

        System.out.println(clonedClock.getClockName());
        clonedClock.getSubj().whatsTheTime();

        Thread thread = new Thread(myClock);
        Thread thread1 = new Thread(clonedClock);

        thread.start();
        thread1.start();
    }
}
