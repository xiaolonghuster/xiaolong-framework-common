package xyz.xiaolong.common.logging;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:49 PM use IntelliJ IDEA
 */
public class TraceGenerator {
    private TraceGen trace = new TraceGen();

    private void checkOriginalId() {
        String id = this.trace.getOriginalRpcid();
        if (!id.startsWith("0")) {
            this.trace.setOriginalRpcid("0");
        }

        id = id.replace(".", "");

        try {
            Long.parseLong(id);
        } catch (NumberFormatException var3) {
            this.trace.setOriginalRpcid("0");
        }

    }

    public TraceGenerator() {
        this.trace = new TraceGen(RandomNumber.getRandomNumString(8));
        this.checkOriginalId();
    }

    public TraceGenerator(String originalRpcId) {
        this.trace = new TraceGen(RandomNumber.getRandomNumString(8), originalRpcId);
        this.checkOriginalId();
    }

    public TraceGenerator(String traceid, String originalRpcid) {
        this.trace = new TraceGen(traceid, originalRpcid);
    }

    public String genRpcId() {
        String derivedRpcIdString = this.trace.getCurrentRpcid();
        if (derivedRpcIdString != null && !derivedRpcIdString.trim().equals("")) {
            this.trace.setCurrentRpcid(derivedRpcIdString.substring(0, derivedRpcIdString.lastIndexOf(46)) + "." + (Integer.parseInt(derivedRpcIdString.substring(derivedRpcIdString.lastIndexOf(46) + 1)) + 1));
        } else {
            derivedRpcIdString = this.trace.getOriginalRpcid() + ".1";
            this.trace.setCurrentRpcid(derivedRpcIdString);
        }

        return this.trace.getCurrentRpcid();
    }

    public String genTraceId() {
        return this.trace.getTraceid();
    }
}

class TraceGen {
    private String traceid;
    private String originalRpcid;
    private String currentRpcid;

    public TraceGen() {
        this.traceid = "";
        this.originalRpcid = "";
        this.currentRpcid = "";
    }

    public TraceGen(String traceid, String originalRpcid, String currentRpcid) {
        this.traceid = traceid;
        this.originalRpcid = originalRpcid;
        this.currentRpcid = currentRpcid;
    }

    public TraceGen(String traceid) {
        this.traceid = traceid;
        this.originalRpcid = "0";
        this.currentRpcid = "";
    }

    public TraceGen(String traceid, String originalRpcid) {
        this.traceid = traceid;
        this.originalRpcid = originalRpcid;
        this.currentRpcid = "";
    }

    public String getTraceid() {
        return this.traceid;
    }

    public void setTraceid(String traceid) {
        this.traceid = traceid;
    }

    public String getOriginalRpcid() {
        return this.originalRpcid;
    }

    public void setOriginalRpcid(String originalRpcid) {
        this.originalRpcid = originalRpcid;
    }

    public String getCurrentRpcid() {
        return this.currentRpcid;
    }

    public void setCurrentRpcid(String currentRpcid) {
        this.currentRpcid = currentRpcid;
    }

    public String toString() {
        return "TraceGen [traceid=" + this.traceid + ", originalRpcid=" + this.originalRpcid + ", currentRpcid=" + this.currentRpcid + "]";
    }
}


