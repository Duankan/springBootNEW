package com.example.demo.redis;

import com.github.Duankan.utils.SerializerUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * jdk序列化与反序列化
 */
public class RedisSerializer2 implements RedisSerializer<Object> {
    static final byte[] EMPTY_ARRAY = new byte[0];
    SerializerUtil serializerUtil=new SerializerUtil();
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if(o==null){
            return EMPTY_ARRAY;
        }
        try {
            return serializerUtil.serializer_jdk(o);
        }
        catch (Exception e){
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(isEmpty(bytes)){
            return null;
        }
        try {
            return serializerUtil.unSerializer_jdk(bytes);
        }
        catch (Exception e){
            throw new SerializationException("Cannot deserialize", e);
        }
    }
    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
