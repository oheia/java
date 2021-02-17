package com.ohei.framework.web;

import com.ohei.framework.util.JsonUtil;
import com.ohei.framework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @describe: http工具类
 */
@Slf4j
public class HttpUtil {

    private static final String X_REAL_IP = "X-Real-IP";
    private static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REQUESTED_WITH = "X-Requested-With";
    public static final String CONTENT_TYPE = "text/html;charset=UTF-8";
    public static final String ENCODING = "utf-8";
    public static final Pattern PATTERN_JSONP = Pattern.compile("^[a-zA-Z_\\$][0-9a-zA-Z_\\$]*$");

    public static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            +"|windows (phone|ce)|blackberry"
            +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            +"|laystation portable)|nokia|fennec|htc[-_]"
            +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    public static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    public static Pattern phone = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
    public static Pattern tablelet = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

    /**
     * 检测是否是移动设备访问
     * @param request 浏览器标识
     * @return true:移动设备接入，false:pc端接入
     */
    public static boolean isMoblieBrowser(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        if(null == userAgent){
            userAgent = "";
        }
        Matcher matcherPhone = phone.matcher(userAgent);
        Matcher matcherTable = tablelet.matcher(userAgent);
        if(matcherPhone.find() || matcherTable.find()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取远端ip地址
     *
     * @param request
     * @return
     */
    public static String getRemoteIP(HttpServletRequest request) {
//		log.info("X-Real-IP=" + request.getHeader(X_REAL_IP) + ",X-Forwarded-For="
//				+ request.getHeader(X_FORWARDED_FOR));
        String ip = request.getHeader(X_REAL_IP);
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader(X_FORWARDED_FOR);
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                ip = ip.substring(0, index);
            }
        } else {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取代理ip，高防中转时获取原ip需要从代理中获取
     *
     * @param request
     * @return
     */
    public static String getforwardedForIP(HttpServletRequest request) {
        String ip = request.getHeader(X_FORWARDED_FOR);
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                ip = ip.substring(0, index);
            }
        } else {
            ip = request.getHeader(X_REAL_IP);//真实ip
            if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            } else {
                ip = request.getRemoteAddr();
            }
        }
        if (ip.split(":").length > 4) {
            return "127.0.0.1";
        }
        return ip;
    }

    /**
     * 获取url根域名以及端口号
     *
     * @param request
     * @return
     */
    public static final String getBaseUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName()
                + ((request.getServerPort() == 80) ? "" : (":" + request.getServerPort()));
    }

    /**
     * 获取系统根路径
     *
     * @param request
     * @return
     */
    public static final String getBasePath(HttpServletRequest request) {
        return getBaseUrl(request) + request.getContextPath();
    }

    /**
     * 获取web根路径 物理路径
     *
     * @param request
     * @return
     */
    public static String getWebRealPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("");
    }

    /**
     * 获取当前地址
     *
     * @param request
     * @return
     */
    public static String getCurUrl(HttpServletRequest request) {
        return getBaseUrl(request) + request.getRequestURI();
    }

    public static String getUri(HttpServletRequest request) {
        String uri = request.getServletPath();
        if (StringUtils.isBlank(uri)) {
            uri = request.getRequestURI();
        }
        return uri;
    }

    /**
     * 获取根域名
     *
     * @param request
     * @return
     */
    public static String getRootdomain(HttpServletRequest request) {
        String domain = null;
        // 获取顶级域名
        domain = request.getServerName();
        try {
            Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv|co|vip)",
                    Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(domain);
            matcher.find();
            domain = matcher.group();
            log.info("根域名:" + domain);
        } catch (Exception e) {
        	log.warn("no find domain");
        }
        return domain;
    }


    /**
     * html转码（utf-8）
     *
     * @param value
     * @return
     */
    public static String htmlUTf8Encode(String value) {
        return htmlEncode(value, ENCODING);
    }

    /**
     * html转码（utf-8）
     *
     * @param value
     * @return
     */
    public static String htmlUTf8Decode(String value) {
        return htmlDecode(value, ENCODING);
    }

    /**
     * html转码（utf-8）
     *
     * @param value
     * @return
     */
    public static String htmlEncode(String value, String encoding) {
        if (StringUtils.isNotBlank(value)) {
            try {
                value = URLEncoder.encode(value, encoding);
            } catch (UnsupportedEncodingException e1) {
                log.warn(value + "转码异常");
            }
        } else {
            value = "";
        }
        return value;
    }

    /**
     * html转码（utf-8）
     *
     * @param value
     * @return
     */
    public static String htmlDecode(String value, String encoding) {
        if (StringUtils.isNotBlank(value)) {
            try {
                value = URLDecoder.decode(value, encoding);
            } catch (UnsupportedEncodingException e) {
                log.warn(value + "反转码异常");
            }
        } else {
            value = "";
        }
        return value;
    }

    /**
     * 获取cookie值
     *
     * @param request
     * @param key
     * @return
     */
    public static String getCookie(HttpServletRequest request, String key) {
        // 到cookie中查询，判断cookie是否为空，不为空时取出账号、密码
        Cookie[] cookies = request.getCookies();
        String value = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key)) {
                    value = c.getValue().trim();
                    break;
                }
            }
        }
        if (StringUtils.isNotBlank(value)) {
            value = htmlUTf8Decode(value);
        }
        return value;
    }

    /**
     * 获取指定域名下的cookie值
     *
     * @param request
     * @param key
     * @param domain
     * @return
     */
    public static String getCookie(HttpServletRequest request, String key, String domain) {
        // 到cookie中查询，判断cookie是否为空，不为空时取出账号、密码
        Cookie[] cookies = request.getCookies();
        String value = "";
        domain = "." + domain;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key)) {
                    if (StringUtils.isNotBlank(domain)) {
                        if (domain.equals(c.getDomain())) {
                            value = c.getValue().trim();
                            break;
                        }
                    } else {
                        value = c.getValue().trim();
                        break;
                    }
                }
            }
        }
        if (StringUtils.isNotBlank(value)) {
            value = htmlUTf8Decode(value);
        }
        return value;
    }

    /**
     * 清空cookie值
     *
     * @param request
     * @param response
     * @param key
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        //清了不带二级域名的缓存（兼容之前代码，避免浏览器还有上次的缓存，导致登录不成功）
        Cookie cookaccount = new Cookie(key, "");
        cookaccount.setMaxAge(0);
        cookaccount.setPath("/");
        String domain = request.getServerName();
        cookaccount.setDomain(domain);
        try {
            Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv|co|vip)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(domain);
            matcher.find();
            domain = matcher.group();
            cookaccount.setDomain(domain);
        } catch (Exception e) {
            log.warn("no find domain");
        }
        response.addCookie(cookaccount);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getLoginSession(HttpServletRequest request, Class<T> clazz, String sessionName) {
        return (T) request.getSession().getAttribute(sessionName);
    }

    public static void removeLoginSession(HttpServletRequest request, String sessionName) {
        request.getSession().removeAttribute(sessionName);
    }

    public static Map<String, Object> getRequestPara(HttpServletRequest request) {
        Map<String, Object> paras = new HashMap<String, Object>();
        Map<String, String[]> map = request.getParameterMap();
        for (Iterator<Entry<String, String[]>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Entry<String, String[]> element = it.next();
            Object strKey = element.getKey();
            String[] value = (String[]) element.getValue();
            for (int i = 0; i < value.length; i++) {
                paras.put(strKey.toString(), value[i]);
            }
        }
        return paras;
    }

    public static String getRequestParaString(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        Map<String, String[]> map = request.getParameterMap();
        for (Iterator<Entry<String, String[]>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Entry<String, String[]> element = it.next();
            Object strKey = element.getKey();
            String[] value = (String[]) element.getValue();
            for (int i = 0; i < value.length; i++) {
                sb.append(strKey.toString()).append("=").append(value[i] + "&");
            }
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static Object getJsonp(String jsonp, Object object) {
        if (jsonp != null && PATTERN_JSONP.matcher(jsonp).matches()) {
            String json = JsonUtil.toJson(object);
            return jsonp + "(" + json + ")";
        } else {
            return object;
        }
    }


    public static void setCookie(HttpServletRequest request,
                                 HttpServletResponse response, String key, String value, int expiry) {
        try {
            value = URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            log.warn("setCookie warn:" + e1.getMessage());
        }
        log.info(request.getServerName());
        Cookie cookaccount = new Cookie(key, value);
        cookaccount.setDomain(request.getServerName());
        if (expiry >= 0)
            cookaccount.setMaxAge(expiry);

        cookaccount.setPath("/");
        response.addCookie(cookaccount);
    }


    /**
     * 一级域名与二级域名分开，不共享
     *
     * @param request
     * @param response
     * @param key
     * @param value
     */
    public static void setSessionCookie(HttpServletRequest request,
                                        HttpServletResponse response, String key, String value) {
        setCookie(request, response, key, value, -1);
    }

    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }


    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
            // POST
        } else {
            return getRequestPostStr(request);
        }
    }
}
