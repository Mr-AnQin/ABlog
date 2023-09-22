package top.aqlog.service;

import top.aqlog.model.vo.BlogInfo;
import top.aqlog.model.vo.PageResult;

import java.util.List;
import java.util.Map;

public interface RedisService {
	/**
	 * 被散列博客信息页面结果
	 *
	 * @param hash    哈希
	 * @param pageNum 页面num
	 * @return {@link PageResult}<{@link BlogInfo}>
	 */
	PageResult<BlogInfo> getBlogInfoPageResultByHash(String hash, Integer pageNum);

	/**
	 * 保存kvto散列
	 *
	 * @param hash  哈希
	 * @param key   关键
	 * @param value 价值
	 */
	void saveKVToHash(String hash, Object key, Object value);

	/**
	 * 保存映射到散列
	 *
	 * @param hash 哈希
	 * @param map  地图
	 */
	void saveMapToHash(String hash, Map map);

	/**
	 * 被散列映射
	 *
	 * @param hash 哈希
	 * @return {@link Map}
	 */
	Map getMapByHash(String hash);

	/**
	 * 被散列键值
	 *
	 * @param hash 哈希
	 * @param key  关键
	 * @return {@link Object}
	 */
	Object getValueByHashKey(String hash, Object key);

	/**
	 * 德尔希大关键
	 * 删除hash 大key
	 *
	 * @param hashKey 大key
	 * @return Long
	 */
	Long delHashBigKey(String hashKey);

	void incrementByHashKey(String hash, Object key, int increment);

	void deleteByHashKey(String hash, Object key);

	<T> List<T> getListByValue(String key);

	<T> void saveListToValue(String key, List<T> list);

	<T> Map<String, T> getMapByValue(String key);

	<T> void saveMapToValue(String key, Map<String, T> map);

	<T> T getObjectByValue(String key, Class t);

	void incrementByKey(String key, int increment);

	void saveObjectToValue(String key, Object object);

	void saveValueToSet(String key, Object value);

	int countBySet(String key);

	void deleteValueBySet(String key, Object value);

	boolean hasValueInSet(String key, Object value);

	void deleteCacheByKey(String key);

	boolean hasKey(String key);

	void expire(String key, long time);
}
