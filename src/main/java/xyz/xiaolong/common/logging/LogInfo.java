package xyz.xiaolong.common.logging;

import com.alibaba.fastjson.JSON;
import xyz.xiaolong.common.utils.DateTimeUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:49 PM use IntelliJ IDEA
 */
public class LogInfo {
    protected String component = "";
    protected String address = "";
    protected String machine = "";
    protected String appid = "";
    protected String osid = "";
    protected String ver = "";
    protected String imei = "";
    protected String imsi = "";
    protected String uid = "";
    protected String userid = "";
    protected String sid = "";
    protected String ap = "";
    protected String ua = "";
    protected String df = "";
    protected String scheme = "";
    protected long starttime = 0L;
    protected long endtime = 0L;
    protected long usetime = 0L;
    protected String requesturl = "";
    protected String remoteip = "";
    protected int status = 0;
    protected String retCode = "";
    protected final StringBuffer errorMsg = new StringBuffer();
    protected String desc = "";
    protected String reqpkg = "";
    protected Map<String, String> httpHeader = new HashMap();
    public String resppkg = "";
    public final StringBuffer inner = new StringBuffer();
    public String createdtime = "";
    protected String traceid = "";
    protected final InnerLog innerLog = new InnerLog();
    protected final TraceGenerator traceGenerator = new TraceGenerator();

    public Map<String, String> getHttpHeader() {
        return this.httpHeader;
    }

    public void setHttpHeader(Map<String, String> httpHeader) {
        this.httpHeader = httpHeader;
    }

    public String getTraceid() {
        return this.traceid;
    }

    public void setTraceid(String traceid) {
        this.traceid = traceid;
    }

    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMachine() {
        return this.machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOsid() {
        return this.osid;
    }

    public void setOsid(String osid) {
        this.osid = osid;
    }

    public String getVer() {
        return this.ver;
    }

    public void setVer(String ver) {
        if (ver != null) {
            this.ver = ver;
        }

    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        if (imei != null) {
            this.imei = imei;
        }

    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        if (uid != null) {
            this.uid = uid;
        }

    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        if (userid != null) {
            this.userid = userid;
        }

    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        if (sid != null) {
            this.sid = sid;
        }

    }

    public String getDf() {
        return this.df;
    }

    public void setDf(String df) {
        if (df != null) {
            this.df = df;
        }

    }

    public String getAp() {
        return this.ap;
    }

    public void setAp(String ap) {
        if (ap != null) {
            this.ap = ap;
        }

    }

    public String getUa() {
        return this.ua;
    }

    public void setUa(String ua) {
        if (ua != null) {
            this.ua = ua;
        }

    }

    public String getScheme() {
        return this.scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public long getStarttime() {
        return this.starttime;
    }

    public void setStarttime(long starttime) {
        if (starttime > 0L) {
            this.starttime = starttime;
        }

    }

    public long getEndtime() {
        return this.endtime;
    }

    public void setEndtime(long endtime) {
        if (endtime > 0L) {
            this.endtime = endtime;
        }

    }

    public long getUsetime() {
        return this.usetime;
    }

    public void setUsetime(long usetime) {
        if (usetime > 0L) {
            this.usetime = usetime;
        }

    }

    public String getRequesturl() {
        return this.requesturl;
    }

    public void setRequesturl(String requesturl) {
        if (requesturl != null) {
            this.requesturl = requesturl;
        }

    }

    public String getRemoteip() {
        return this.remoteip;
    }

    public void setRemoteip(String remoteip) {
        if (remoteip != null) {
            this.remoteip = remoteip;
        }

    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        if (status >= 0) {
            this.status = status;
        }

    }

    public String getRetCode() {
        return this.retCode;
    }

    public void setRetCode(String code) {
        if (code != null) {
            this.retCode = code;
        }

    }

    public String getErrorMsg() {
        return this.errorMsg.toString();
    }

    public void setErrorMsg(String errorMsg) {
        if (errorMsg != null) {
            this.errorMsg.append(errorMsg + "\r\n");
        }

    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        if (desc != null) {
            this.desc = desc;
        }

    }

    public String getInner() {
        return this.inner.toString();
    }

    public void setInner(String info) {
        if (this.inner != null) {
            this.inner.append(info + "#\r\n");
        }

    }

    public String getCreatedtime() {
        return this.createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public String getReqpkg() {
        return this.reqpkg;
    }

    public void setReqpkg(String pkg) {
        this.reqpkg = pkg.replaceAll(">\\s*<", ">\r\n<");
    }

    public String getResppkg() {
        return this.resppkg;
    }

    public void setResppkg(String pkg) {
        this.resppkg = pkg.replaceAll(">\\s*<", ">\r\n<");
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImsi(String imsi) {
        if (imsi != null) {
            this.imsi = imsi;
        }

    }

    public Map<String, String> getLogInfoMap() {
        Map<String, String> map = this.getBaseOsspLogMap();
        map.put("requesturl", this.getRequesturl());
        map.put("appid", this.getAppid());
        map.put("ver", this.getVer());
        map.put("userid", this.getUserid());
        map.put("sid", this.getSid());
        map.put("imei", this.getImei());
        map.put("imsi", this.getImsi());
        map.put("ap", this.getAp());
        map.put("ua", this.getUa());
        map.put("scheme", this.getScheme());
        map.put("status", this.getStatus() + "");
        map.put("error_msg", this.getErrorMsg());
        map.put("header", JSON.toJSONString(this.getHttpHeader()));
        map.put("inner", JSON.toJSONString(this.getInnerLog()));
        return map;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("*************************************begin****************************************\r\n");
        buffer.append("requesturl:" + this.getRequesturl() + "\r\n");
        buffer.append("remoteip:" + this.getRemoteip() + "\r\n");
        buffer.append("appid:" + this.getAppid() + "\r\n");
        buffer.append("ver:" + this.getVer() + "\r\n");
        buffer.append("uid:" + this.getUid() + "\r\n");
        buffer.append("userid:" + this.getUserid() + "\r\n");
        buffer.append("sid:" + this.getSid() + "\r\n");
        buffer.append("imei:" + this.getImei() + "\r\n");
        buffer.append("imsi:" + this.getImsi() + "\r\n");
        buffer.append("ap:" + this.getAp() + "\r\n");
        buffer.append("ua:" + this.getUa() + "\r\n");
        buffer.append("scheme:" + this.getScheme() + "\r\n");
        buffer.append("traceid:" + this.getTraceid() + "\r\n");
        buffer.append("starttime:" + DateTimeUtils.format("yyyy-MM-dd HH:mm:ss", new Date(this.getStarttime())) + "\r\n");
        buffer.append("endtime:" + DateTimeUtils.format("yyyy-MM-dd HH:mm:ss", new Date(this.getEndtime())) + "\r\n");
        buffer.append("usetime:" + this.getUsetime() + "\r\n");
        buffer.append("status:" + this.getStatus() + "\r\n");
        buffer.append("desc:" + this.getDesc() + "\r\n");
        buffer.append("retcode:" + this.getRetCode() + "\r\n");
        buffer.append("error_msg:\r\n" + this.getErrorMsg() + "\r\n");
        buffer.append("header:\r\n" + this.getHttpHeader() + "\r\n");
        buffer.append("reqpkg:\r\n" + this.getReqpkg() + "\r\n");
        buffer.append("inner:\r\n" + this.getInnerLog() + "\r\n");
        buffer.append("resppkg:\r\n" + this.getResppkg() + "\r\n");
        buffer.append("createdtime:" + this.getCreatedtime() + "\r\n");
        buffer.append("**************************************end*****************************************\r\n\r\n");
        return buffer.toString();
    }

    public void appendInnerLog(String content) {
        this.inner.append(content + "\r\n");
    }

    public void buildLogInfoRes(int status, String desc, String retcode) {
        this.setStatus(status);
        this.setDesc(desc);
        this.setRetCode(retcode);
    }

    public TraceGenerator getTraceGenerator() {
        return this.traceGenerator;
    }

    public InnerLog getInnerLog() {
        this.innerLog.setExtra(this.inner.toString());
        return this.innerLog;
    }

    public LogInfo() {
        this.setTraceid(this.traceGenerator.genTraceId());
    }

    public void buildTraceInfo(String rpcid, String beginTime, long useTime, String retcode, String info, String type) {
        this.innerLog.getInnerinfo().add(new TraceInfo(rpcid, type, useTime, beginTime, retcode, info));
    }

    public void addTraceInfo(TraceInfo traceInfo) {
        this.innerLog.getInnerinfo().add(traceInfo);
    }

    protected Map<String, String> getBaseOsspLogMap() {
        Map<String, String> logMap = new HashMap();
        logMap.put("retcode", this.getRetCode());
        logMap.put("retdesc", this.getDesc());
        logMap.put("remoteip", this.getRemoteip());
        logMap.put("uid", this.getUid());
        logMap.put("req", this.getReqpkg());
        logMap.put("resp", this.getResppkg());
        logMap.put("stm", DateTimeUtils.format("yyyy-MM-dd HH:mm:ss.SSS", new Date(this.getStarttime())));
        logMap.put("etm", DateTimeUtils.format("yyyy-MM-dd HH:mm:ss.SSS", new Date(this.getEndtime())));
        logMap.put("utm", String.valueOf(this.getUsetime()));
        logMap.put("traceid", this.getTraceid());
        return logMap;
    }
}

