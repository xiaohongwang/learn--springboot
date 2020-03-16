package com.springboot.utils;


import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : wangxiaohong
 * create at:  2020-03-16  09:57
 * @description: 系统工具类
 */
public class Common {

    /**
    * @Title:getClientIp
    * @Description: 获取客户端请求ip request.getRemoteAddr();// 最后直接发送请求到服务器的机器ip
     * 实际生产环境，往往会配置代理将请求进行多次转发 此方法拿到的ip地址不是真实客户端ip
     * 咋转发过程中，nginx等代理工具 会添加请求头X-Forwarded-For X-Real-IP 这些头中会保留真实客户端
    * @author: wangxiaohong
    * @param: [request]
    * @return java.lang.String
    * @date: 09:58 2020-03-16
    * @version v1.0
    */
    public static String getClientIp(HttpServletRequest request){
        //TODOX-Forwarded-For  X-Real-IP unKnown
        String ip = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
           //多次反向代理后会有多个ip值，第一个ip才是真实ip
           int index = ip.indexOf(",");
           if(index != -1){
                return ip.substring(0,index);
           }else{
                return ip;
           }
        }
        ip = request.getHeader("X-Real-IP");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
                return ip;
        }
        return request.getRemoteAddr();
    }
}
