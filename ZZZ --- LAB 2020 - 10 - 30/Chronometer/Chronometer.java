import java.lang.System;

public class Chronometer{
    //Declaration
    private long startTime;
    private long partialTime;
    private boolean running;
    private boolean stopped;

    //Metodi
    public void start(){
        startTime = System.currentTimeMillis();
        running = true;
    }
    public void stop(){
        running = false;
        stopped = true;
    }
    public void reset(){
        startTime = 0;
        partialTime = 0;
        running= false;
        stopped = false;
    }
    public long  getElapsedTime(){
        if(running || stopped){
            partialTime = System.currentTimeMillis();
        }
        return (partialTime - startTime);
    }

    public boolean isRunning(){
        return running;
    }
    
    public String toString(){
        String state = "";
        if(running){
            state = "running";
        }
        if(!running){
            state ="off";
        }
        if(stopped){
            state="ready";
        }
        return "Chronometer  : " + state + " " + (double)(getElapsedTime()/1000.0) + "  s";
    }
}