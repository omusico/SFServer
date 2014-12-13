/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.utils;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author 305027939
 */
public class NetInterceptAdapter extends HandlerInterceptorAdapter {

    private static final Log log = LogFactory.getLog(NetInterceptAdapter.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        log.debug("Begin to Filter session");

        try {
            String realPath = request.getServletContext().getRealPath("/");

        } catch (Exception ex) {
            log.error(ex);
        }

        return super.preHandle(request, response, handler);
    }

    private boolean isWindows() {
        boolean flag = false;
        if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
            flag = true;
        }
        return flag;
    }

    private String getLinuxIP() throws SocketException {
        //鏍规嵁缃戝崱鍙栨湰鏈洪厤缃殑IP  
        Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
            System.out.println(ni.getName());
            ip = (InetAddress) ni.getInetAddresses().nextElement();
            if (!ip.isSiteLocalAddress()
                    && !ip.isLoopbackAddress()
                    && ip.getHostAddress().indexOf(":") == -1) {
                return ip.getHostAddress();
            }
        }
        return "127.0.0.1";
    }

}
