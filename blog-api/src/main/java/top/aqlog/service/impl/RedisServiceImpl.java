package top.aqlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.aqlog.model.vo.BlogInfo;
import top.aqlog.model.vo.PageResult;
import top.aqlog.service.RedisService;
import top.aqlog.util.JacksonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description 读写Redis相关操作
 * @Author anqin
 * @Date 2020-09-27
 */
@Service
@SuppressWarnings(value = "all")
public class RedisServiceImpl implements RedisService {
	@Autowired
	RedisTemplate jsonRedisTemplate;

	@Override
	public PageResult<BlogInfo> getBlogInfoPageResultByHash(String hash, Integer pageNum) {
		if (jsonRedisTemplate.opsForHash().hasKey(hash, pageNum)) {
			Object redisResult = jsonRedisTemplate.opsForHash().get(hash, pageNum);
			return JacksonUtils.convertValue(redisResult, PageResult.class);

		} else {
			return null;
		}
	}

	@Override
	public void saveKVToHash(String hash, Object key, Object value) {
		jsonRedisTemplate.opsForHash().put(hash, key, value);
	}

	@Override
	public void saveMapToHash(String hash, Map map) {
		jsonRedisTemplate.opsForHash().putAll(hash, map);
	}

	@Override
	public Map getMapByHash(String hash) {
		return jsonRedisTemplate.opsForHash().entries(hash);
	}

	@Override
	public Object getValueByHashKey(String hash, Object key) {
		return jsonRedisTemplate.opsForHash().get(hash, key);
	}

	/**
	 * 删除hash 大key
	 *
	 * @param hashKey 大key
	 * @return boolean
	 */
	@Override
	public Long delHashBigKey(String hashKey) {
		Set<Object> keys = jsonRedisTemplate.opsForHash().keys(hashKey);
		if(keys.size() == 0){
			return 0L;
		}
		return jsonRedisTemplate.opsForHash().delete(hashKey, keys.toArray());

	}

	@Override
	public void incrementByHashKey(String hash, Object key, int increment) {
		if (increment < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		jsonRedisTemplate.opsForHash().increment(hash, key, increment);
	}

	@Override
	public void deleteByHashKey(String hash, Object key) {
		jsonRedisTemplate.opsForHash().delete(hash, key);
	}

	@Override
	public <T> List<T> getListByValue(String key) {
		List<T> redisResult = (List<T>) jsonRedisTemplate.opsForValue().get(key);
		return redisResult;
	}

	@Override
	public <T> void saveListToValue(String key, List<T> list) {
		jsonRedisTemplate.opsForValue().set(key, list);
	}

	@Override
	public <T> Map<String, T> getMapByValue(String key) {
		Map<String, T> redisResult = (Map<String, T>) jsonRedisTemplate.opsForValue().get(key);
		return redisResult;
	}

	@Override
	public <T> void saveMapToValue(String key, Map<String, T> map) {
		jsonRedisTemplate.opsForValue().set(key, map);
	}

	@Override
	public <T> T getObjectByValue(String key, Class t) {
		Object redisResult = jsonRedisTemplate.opsForValue().get(key);
		return (T) JacksonUtils.convertValue(redisResult, t);
	}

	@Override
	public void incrementByKey(String key, int increment) {
		if (increment < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		jsonRedisTemplate.opsForValue().increment(key, increment);
	}

	@Override
	public void saveObjectToValue(String key, Object object) {
		jsonRedisTemplate.opsForValue().set(key, object);
	}

	@Override
	public void saveValueToSet(String key, Object value) {
		jsonRedisTemplate.opsForSet().add(key, value);
	}

	@Override
	public int countBySet(String key) {
		return jsonRedisTemplate.opsForSet().size(key).intValue();
	}

	@Override
	public void deleteValueBySet(String key, Object value) {
		jsonRedisTemplate.opsForSet().remove(key, value);
	}

	@Override
	public boolean hasValueInSet(String key, Object value) {
		return Boolean.TRUE.equals(jsonRedisTemplate.opsForSet().isMember(key, value));
	}

	@Override
	public void deleteCacheByKey(String key) {
		jsonRedisTemplate.delete(key);
	}

	@Override
	public boolean hasKey(String key) {
		return Boolean.TRUE.equals(jsonRedisTemplate.hasKey(key));
	}

	@Override
	public void expire(String key, long time) {
		jsonRedisTemplate.expire(key, time, TimeUnit.SECONDS);
	}
}
