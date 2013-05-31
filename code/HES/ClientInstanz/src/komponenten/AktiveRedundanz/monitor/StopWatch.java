package komponenten.AktiveRedundanz.monitor;


class StopWatch {

    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;
    private long totalTime = 0;


    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }


    public void stop() {
        this.stopTime = System.currentTimeMillis();
        totalTime += getElapsedTime();
        this.running = false;
    }


    //elaspsed time in milliseconds
    private long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        }
        else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }


    //elaspsed time in seconds
    private long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        }
        else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }

    public long getTotalElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((totalTime+getElapsedTime()) / 1000);
        }
        else {
            elapsed = (totalTime / 1000);
        }
        return elapsed;
    }


}