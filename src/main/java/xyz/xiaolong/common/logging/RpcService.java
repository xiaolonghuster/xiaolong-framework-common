package xyz.xiaolong.common.logging;

import xyz.xiaolong.common.utils.DateTimeUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:51 PM use IntelliJ IDEA
 */
public class RpcService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RpcService.class);

    public RpcService() {
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, RpcService.IRpcHandler<T> rpcHandler) {
        return rpc(logInfo, rpcType, "", "", rpcHandler);
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, String reqPkg, RpcService.IRpcHandler<T> rpcHandler) {
        return rpc(logInfo, rpcType, reqPkg, "", rpcHandler);
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, RpcService.ILogicRpcHandler<T> rpcHandler) {
        return rpc(logInfo, rpcType, "", "", rpcHandler);
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, String reqPkg, RpcService.ILogicRpcHandler<T> rpcHandler) {
        return rpc(logInfo, rpcType, reqPkg, "", rpcHandler);
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, String reqPkg, String url, RpcService.ILogicRpcHandler<T> rpcHandler) {
        return rpc(logInfo, rpcType, reqPkg, url, rpcHandler);
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, String reqPkg, String url, RpcService.IRpcHandler<T> rpcHandler) {
        T t = null;
        long start = System.currentTimeMillis();
        TraceInfo traceInfo = TraceInfo.getDefaultTraceInfo(logInfo, rpcType, DateTimeUtils.format("yyyy-MM-dd HH:mm:ss.SSS", new Date(start)));
        traceInfo.setReqpkg(reqPkg);
        traceInfo.setReqadd(url);

        try {
            t = rpcHandler.handle(traceInfo);
            if (t != null) {
                traceInfo.setRespkg(t.toString());
            }
        } catch (Exception var13) {
            LOGGER.error(ExceptionUtils.getStackTrace(var13));
            traceInfo.setErrinfo(ExceptionUtils.getStackTrace(var13));
            traceInfo.setRetcode("99999");
        } finally {
            traceInfo.setUtm(System.currentTimeMillis() - start);
            logInfo.addTraceInfo(traceInfo);
        }

        return t;
    }

    public static <T> T rpc(LogInfo logInfo, TraceInfo.RpcType rpcType, String reqPkg, String reqHeader, String url, RpcService.ILogicRpcHandler<T> rpcHandler) {
        T t = null;
        long start = System.currentTimeMillis();
        TraceInfo traceInfo = TraceInfo.getDefaultTraceInfo(logInfo, rpcType, DateTimeUtils.format("yyyy-MM-dd HH:mm:ss.SSS", new Date(start)));
        traceInfo.setReqpkg(reqPkg);
        traceInfo.setReqheader(reqHeader);
        traceInfo.setReqadd(url);

        try {
            t = rpcHandler.handle(traceInfo);
            if (t != null) {
                traceInfo.setRespkg(t.toString());
            }

            rpcHandler.checkRes(t, traceInfo);
        } catch (Exception var13) {
            LOGGER.error(ExceptionUtils.getStackTrace(var13));
            traceInfo.setErrinfo(ExceptionUtils.getStackTrace(var13));
            traceInfo.setRetcode("99999");
            rpcHandler.exp(traceInfo);
        } finally {
            traceInfo.setUtm(System.currentTimeMillis() - start);
            logInfo.addTraceInfo(traceInfo);
            rpcHandler.finalHandle(traceInfo);
        }

        return t;
    }

    public interface ILogicRpcHandler<T> extends RpcService.IRpcHandler<T> {
        void checkRes(T var1, TraceInfo var2);

        void exp(TraceInfo var1);

        void finalHandle(TraceInfo var1);
    }

    public interface IRpcHandler<T> {
        T handle(TraceInfo var1) throws Exception;
    }
}

