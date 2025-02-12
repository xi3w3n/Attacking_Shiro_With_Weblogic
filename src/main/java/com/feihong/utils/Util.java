package com.feihong.utils;

import java.io.*;

public class Util {
    public static byte[] serialize(Object obj) throws IOException {
        //序列化
        ByteArrayOutputStream baous = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baous);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        return baous.toByteArray();
    }

    public static void deserialize(byte[] bytes) throws Exception {
        //反序列化
        ByteArrayInputStream bains = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bains);
        ois.readObject();
    }
}
