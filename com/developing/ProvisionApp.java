package com.developing;
import java.time.Instant;
import java.util.PriorityQueue;

class Query{
    private long timeStamp;
    private String ip;
    private final long interval;
    Query(long timeStamp, String ip, long interval) {
        this.timeStamp = timeStamp;
        this.ip = ip;
        this.interval = interval;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getIp() {
        return ip;
    }

    public long getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "Query{" +
                "timeStamp=" + timeStamp +
                ", ip='" + ip + '\'' +
                '}';
    }
}

public final class ProvisionApp {

    private static PriorityQueue<Query> taskQueue;

    static{
        taskQueue = new PriorityQueue<>((obj, other) -> obj.getTimeStamp()-other.getTimeStamp()<0L?-1:1);
    }

    static boolean provisionIp(String ip, int interval){
        try {
            taskQueue.add(new Query(Instant.now().getEpochSecond(), ip, interval));
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    static void start(){
        while(!taskQueue.isEmpty()){
            Query q = taskQueue.peek();
            System.out.println(q.getIp() + ":" + PingApp.checkStatus(q.getIp()));
            taskQueue.poll();
            q.setTimeStamp(q.getTimeStamp()+q.getInterval());
            taskQueue.offer(q);
        }
    }

    public static void main(String[] args) {
        try {
            ProvisionApp.provisionIp("10.20", 1000);
            ProvisionApp.provisionIp("google.com", 2000);
            ProvisionApp.provisionIp("10.20.40.229", 4000);
            ProvisionApp.start();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}