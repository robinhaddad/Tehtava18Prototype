/*
prototype
 */
public  class Subject implements Cloneable, Runnable {

    private int hour;
    private int minutes;
    private int seconds;
    private String name;

    public int getSeconds() {return seconds;}
    public void setSeconds(int seconds) {this.seconds = seconds;}
    public int getMinutes() {return minutes;}
    public void setMinutes(int minutes) {this.minutes = minutes;}
    public int getHour() {return hour;}
    public void setHour(int hour) {this.hour = hour;}
    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public Subject(String name) {
        this.name = name;
    }

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        while (true){
            int seconds=this.getSeconds();
            int minutes=this.getMinutes();
            int hours=this.getHour();
            try {
                Thread.sleep(1000);
                seconds++;
                this.setSeconds(seconds);
                this.whatsTheTime();
                if(seconds==59){
                    minutes++;
                    this.setMinutes(minutes);
                    seconds=0;
                    this.setSeconds(seconds);
                    this.whatsTheTime();
                }
                if(minutes==59){
                    hours++;
                    this.setHour(hours);
                    minutes=0;
                    this.setMinutes(minutes);
                }
                if (hours==24) {
                    hours=0;
                    this.whatsTheTime();
                    this.setHour(hours);
                    this.setMinutes(0);
                    this.setSeconds(0);
                    this.whatsTheTime();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStartTime(int hours, int minutes, int seconds){
        this.setHour(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public void whatsTheTime(){
        int hour = this.getHour();
        int minutes = this.getMinutes();
        int seconds = this.getSeconds();
        if(minutes==60){minutes=0;}
        if (seconds==60){seconds=0;}
        if(hour==24){hour=0;}
        System.out.println(this.getName() +", "+hour +":"+ minutes +":"+ seconds);
    }
}
