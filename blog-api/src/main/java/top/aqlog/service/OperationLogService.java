package top.aqlog.service;

import org.springframework.scheduling.annotation.Async;
import top.aqlog.entity.OperationLog;

import java.util.List;

public interface OperationLogService {
	List<OperationLog> getOperationLogListByDate(String startDate, String endDate);

	@Async
	void saveOperationLog(OperationLog log);

	void deleteOperationLogById(Long id);
}
