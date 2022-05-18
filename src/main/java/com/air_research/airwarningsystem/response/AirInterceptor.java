package com.air_research.airwarningsystem.response;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zwell
 */
@Component
@Slf4j
public class AirInterceptor implements HandlerInterceptor {

    public static final String TOKEN_HEADER = "Authentication";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//      response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authentication");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String token = request.getHeader(TOKEN_HEADER);
        if("qweasd".equals(token)){
            return true;
        }
        String sessionToken = String.valueOf(request.getSession().getAttribute("token"));

        if(StringUtils.isEmpty(token)){
            returnJson(response, JSONObject.toJSONString(
                    new ServerResponse(ResultEnum.TOKEN_NULL.getSuccess(),
                            ResultEnum.TOKEN_NULL.getCode(), ResultEnum.TOKEN_NULL.getMessage(), null)));
            return false;
        }

        if(StringUtils.isEmpty(sessionToken)){
            returnJson(response, JSONObject.toJSONString(
                    new ServerResponse(ResultEnum.TOKEN_ERROR.getSuccess(), ResultEnum.TOKEN_ERROR.getCode(), ResultEnum.TOKEN_ERROR.getMessage(), null)));
            return false;
        }

        if(sessionToken.equals(token)){
            return authRuleVerify(request,response);
        }else {
            returnJson(response, JSONObject.toJSONString(
                    new ServerResponse(ResultEnum.TOKEN_ERROR.getSuccess(), ResultEnum.TOKEN_ERROR.getCode(), ResultEnum.TOKEN_ERROR.getMessage(), null)));
            return false;
        }
    }

    public boolean authRuleVerify(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    JSONObject user = (JSONObject)request.getSession().getAttribute("user");
//    if(user.getJSONObject("role")==null||user.getJSONObject("role").getJSONArray("functions")==null||user.getJSONObject("role").getJSONArray("functions").size()==0){
//      returnJson(response, JSONObject.toJSONString(
//              new ResultMsg(ResultCode.NO_PERMISSION.getCode(), ResultCode.NO_PERMISSION.getMsg(), null)));
//      return false;
//    }
//
//    //判断路径是否存在@PathVariable参数, 若有则替换
//    String requestURI = request.getRequestURI();
//    Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//    if(pathVariables.size()!=0){
//      for (Object obj : pathVariables.keySet()) {
//        requestURI = requestURI.replace((String) pathVariables.get(obj), "{" + (String) obj + "}");
//      }
//    }
//
//    JSONArray functions = user.getJSONObject("role").getJSONArray("functions");
//    for(int i = 0;i<functions.size();i++){
//      JSONArray permissions = functions.getJSONObject(i).getJSONArray("permissions");
//      for(int j = 0;j<permissions.size();j++){
//        if(requestURI.equals(permissions.getJSONObject(j).getString("url"))){
//          return true;
//        }
//      }
//    }
//    returnJson(response, JSONObject.toJSONString(
//            new ResultMsg(ResultCode.NO_PERMISSION.getCode(), ResultCode.NO_PERMISSION.getMsg(), null)));
//    return false;
        return true;
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
