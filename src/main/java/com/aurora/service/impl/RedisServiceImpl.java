package com.aurora.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.aurora.service.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisServiceImpl implements RedisService {
    RedisTemplate<String, Object> redisTemplate;


    @Override
    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long del(List<String> keys) {
        return null;
    }

    @Override
    public Boolean expire(String key, long time) {
        return null;
    }

    @Override
    public Long getExpire(String key) {
        return null;
    }

    @Override
    public Boolean hasKey(String key) {
        return null;
    }

    @Override
    public Long incr(String key, long delta) {
        return null;
    }

    @Override
    public Long incrExpire(String key, long time) {
        return null;
    }

    @Override
    public Long decr(String key, long delta) {
        return null;
    }

    @Override
    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public Boolean hSet(String key, String hashKey, Object value, long time) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        return expire(key, time);
    }

    @Override
    public void hSet(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    @Override
    public Map<String, Object> hGetAll(String key) {
        return null;
    }

    @Override
    public Boolean hSetAll(String key, Map<String, Object> map, long time) {
        return null;
    }

    @Override
    public void hSetAll(String key, Map<String, ?> map) {

    }

    @Override
    public void hDel(String key, Object... hashKey) {

    }

    @Override
    public Boolean hHasKey(String key, String hashKey) {
        return null;
    }

    @Override
    public Long hIncr(String key, String hashKey, Long delta) {
        return null;
    }

    @Override
    public Long hDecr(String key, String hashKey, Long delta) {
        return null;
    }

    @Override
    public Double zIncr(String key, Object value, Double score) {
        return null;
    }

    @Override
    public Double zDecr(String key, Object value, Double score) {
        return null;
    }

    @Override
    public Map<Object, Double> zReverseRangeWithScore(String key, long start, long end) {
        return null;
    }

    @Override
    public Double zScore(String key, Object value) {
        return null;
    }

    @Override
    public Map<Object, Double> zAllScore(String key) {
        return null;
    }

    @Override
    public Set<Object> sMembers(String key) {
        return null;
    }

    @Override
    public Long sAdd(String key, Object... values) {
        return null;
    }

    @Override
    public Long sAddExpire(String key, long time, Object... values) {
        return null;
    }

    @Override
    public Boolean sIsMember(String key, Object value) {
        return null;
    }

    @Override
    public Long sSize(String key) {
        return null;
    }

    @Override
    public Long sRemove(String key, Object... values) {
        return null;
    }

    @Override
    public List<Object> lRange(String key, long start, long end) {
        return null;
    }

    @Override
    public Long lSize(String key) {
        return null;
    }

    @Override
    public Object lIndex(String key, long index) {
        return null;
    }

    @Override
    public Long lPush(String key, Object value) {
        return null;
    }

    @Override
    public Long lPush(String key, Object value, long time) {
        return null;
    }

    @Override
    public Long lPushAll(String key, Object... values) {
        return null;
    }

    @Override
    public Long lPushAll(String key, Long time, Object... values) {
        return null;
    }

    @Override
    public Long lRemove(String key, long count, Object value) {
        return null;
    }

    @Override
    public Boolean bitAdd(String key, int offset, boolean b) {
        return null;
    }

    @Override
    public Boolean bitGet(String key, int offset) {
        return null;
    }

    @Override
    public Long bitCount(String key) {
        return null;
    }

    @Override
    public List<Long> bitField(String key, int limit, int offset) {
        return null;
    }

    @Override
    public byte[] bitGetAll(String key) {
        return new byte[0];
    }

    @Override
    public Long hyperAdd(String key, Object... value) {
        return null;
    }

    @Override
    public Long hyperGet(String... key) {
        return null;
    }

    @Override
    public void hyperDel(String key) {

    }

    @Override
    public Long geoAdd(String key, Double x, Double y, String name) {
        return null;
    }

    @Override
    public List<Point> geoGetPointList(String key, Object... place) {
        return null;
    }

    @Override
    public Distance geoCalculationDistance(String key, String placeOne, String placeTow) {
        return null;
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<Object>> geoNearByPlace(String key, String place, Distance distance, long limit, Sort.Direction sort) {
        return null;
    }

    @Override
    public List<String> geoGetHash(String key, String... place) {
        return null;
    }
}
