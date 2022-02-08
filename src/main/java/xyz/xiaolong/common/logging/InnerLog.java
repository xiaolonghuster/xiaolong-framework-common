package xyz.xiaolong.common.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:48 PM use IntelliJ IDEA
 */
public class InnerLog {
    private String extra;
    private List<TraceInfo> innerinfo = new ArrayList();

    public InnerLog() {
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public List<TraceInfo> getInnerinfo() {
        return this.innerinfo;
    }

    public void setInnerinfo(List<TraceInfo> innerinfo) {
        this.innerinfo = innerinfo;
    }

    public String toString() {
        return "InnerLog [extra=" + this.extra + ", innerinfo=" + this.innerinfo + "]";
    }
}
