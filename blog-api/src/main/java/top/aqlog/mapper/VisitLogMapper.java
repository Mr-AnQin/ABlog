package top.aqlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aqlog.entity.VisitLog;
import top.aqlog.model.dto.VisitLogUuidTime;

import java.util.List;

/**
 * @Description 访问日志持久层接口
 * @Author anqin
 * @Date 2020-12-04
 */
@Mapper
@Repository
public interface VisitLogMapper {
	List<VisitLog> getVisitLogListByUUIDAndDate(String uuid, String startDate, String endDate);

	List<VisitLogUuidTime> getUUIDAndCreateTimeByYesterday();

	int saveVisitLog(VisitLog log);

	int deleteVisitLogById(Long id);

	int countVisitLogByToday();
}
