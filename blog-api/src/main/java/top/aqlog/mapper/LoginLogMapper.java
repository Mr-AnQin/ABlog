package top.aqlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aqlog.entity.LoginLog;

import java.util.List;

/**
 * @Description 登录日志持久层接口
 * @Author anqin
 * @Date 2020-12-03
 */
@Mapper
@Repository
public interface LoginLogMapper {
	List<LoginLog> getLoginLogListByDate(String startDate, String endDate);

	int saveLoginLog(LoginLog log);

	int deleteLoginLogById(Long id);
}
