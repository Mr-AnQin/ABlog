package top.aqlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aqlog.entity.CityVisitor;

import java.util.List;

/**
 * @Description 城市访客数量统计持久层接口
 * @Author anqin
 * @Date 2021-02-26
 */
@Mapper
@Repository
public interface CityVisitorMapper {
	List<CityVisitor> getCityVisitorList();

	int saveCityVisitor(CityVisitor cityVisitor);
}
