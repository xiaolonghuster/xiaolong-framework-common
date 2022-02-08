package xyz.xiaolong.common.logging;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:48 PM use IntelliJ IDEA
 */
public class TraceInfo {
    public static final String RPCCODE_SUCCESS = "0000";
    public static final String RPCCODE_UNKNOWN_ERROR = "9999";
    private String rpcid = "";
    private String rpctype = "";
    private long utm = 0L;
    private String stm = "";
    private String retcode = "0000";
    private String errinfo = "";
    private String reqpkg = "";
    private String reqheader = "";
    private String respkg = "";
    private String reqadd = "";
    private String traceId = "";

    public String getRpcid() {
        return this.rpcid;
    }

    public void setRpcid(String rpcid) {
        this.rpcid = rpcid;
    }

    public String getRpctype() {
        return this.rpctype;
    }

    public void setRpctype(String rpctype) {
        this.rpctype = rpctype;
    }

    public long getUtm() {
        return this.utm;
    }

    public void setUtm(long utm) {
        this.utm = utm;
    }

    public String getStm() {
        return this.stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    public String getRetcode() {
        return this.retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getErrinfo() {
        return this.errinfo;
    }

    public void setErrinfo(String errinfo) {
        this.errinfo = errinfo;
    }

    public String getReqpkg() {
        return this.reqpkg;
    }

    public String getReqheader() {
        return reqheader;
    }

    public void setReqheader(String reqheader) {
        this.reqheader = reqheader;
    }

    public void setReqpkg(String reqpkg) {
        this.reqpkg = reqpkg;
    }

    public String getRespkg() {
        return this.respkg;
    }

    public void setRespkg(String respkg) {
        this.respkg = respkg;
    }

    public String getReqadd() {
        return this.reqadd;
    }

    public void setReqadd(String reqadd) {
        this.reqadd = reqadd;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    TraceInfo(String rpcid, String rpctype, long utm, String stm, String retcode, String errinfo) {
        this.rpcid = rpcid;
        this.rpctype = rpctype;
        this.utm = utm;
        this.stm = stm;
        this.retcode = retcode;
        this.errinfo = errinfo;
    }

    public TraceInfo() {
    }

    public static TraceInfo getDefaultTraceInfo(LogInfo logInfo) {
        TraceInfo traceInfo = new TraceInfo();
        traceInfo.setTraceId(logInfo.getTraceGenerator().genTraceId());
        traceInfo.setRpcid(logInfo.getTraceGenerator().genRpcId());
        return traceInfo;
    }

    public static TraceInfo getDefaultTraceInfo(LogInfo logInfo, TraceInfo.RpcType rpcType, String stm) {
        TraceInfo traceInfo = new TraceInfo();
        traceInfo.setTraceId(logInfo.getTraceGenerator().genTraceId());
        traceInfo.setRpcid(logInfo.getTraceGenerator().genRpcId());
        traceInfo.setRpctype(rpcType.toString());
        traceInfo.setStm(stm);
        return traceInfo;
    }

    @Override
    public String toString() {
        return "TraceInfo{" +
                "rpcid='" + rpcid + '\'' +
                ", rpctype='" + rpctype + '\'' +
                ", utm=" + utm +
                ", stm='" + stm + '\'' +
                ", retcode='" + retcode + '\'' +
                ", errinfo='" + errinfo + '\'' +
                ", reqpkg='" + reqpkg + '\'' +
                ", reqheader='" + reqheader + '\'' +
                ", respkg='" + respkg + '\'' +
                ", reqadd='" + reqadd + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }

    public interface RpcType {
    }
}

