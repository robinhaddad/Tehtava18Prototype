/*
concrete prototype
 */
public class MyClock implements Cloneable, Runnable {

    private String clockName;
    private Subject subj;
    public Subject getSubj() {
        return subj;
    }

    public MyClock(String clockName, String subjectName){
        this.clockName = clockName;
        subj = new Subject(subjectName);
    }

    public String getClockName() {return clockName;}
    public void setClockName(String clockName) {
        this.clockName = clockName;
    }

    public MyClock deepCopy() {
        MyClock s = null;
        try {
            s = (MyClock)super.clone();
            s.subj = (Subject)subj.clone();
        } catch (CloneNotSupportedException e) {}
        return s;
    }

    @Override
    public void run(){subj.run();}
}
