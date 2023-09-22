package top.aqlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aqlog.entity.CityVisitor;
import top.aqlog.mapper.CityVisitorMapper;
import top.aqlog.service.CityVisitorService;

/**
 * @Description 城市访客数量统计业务层实现
 * @Author anqin
 * @Date 2021-02-26
 */
@Service
public class CityVisitorServiceImpl implements CityVisitorService {
	@Autowired
	CityVisitorMapper cityVisitorMapper;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveCityVisitor(CityVisitor cityVisitor) {
		cityVisitorMapper.saveCityVisitor(cityVisitor);
	}
}
