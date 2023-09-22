package top.aqlog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aqlog.annotation.OperationLogger;
import top.aqlog.model.vo.Result;
import top.aqlog.service.AboutService;

import java.util.Map;

/**
 * @Description 关于我页面后台管理
 * @Author anqin
 * @Date 2020-09-01
 */
@RestController
@RequestMapping("/admin")
public class AboutAdminController {
	@Autowired
	AboutService aboutService;

	/**
	 * 获取关于我页面配置
	 *
	 * @return
	 */
	@GetMapping("/about")
	public Result about() {
		return Result.ok("请求成功", aboutService.getAboutSetting());
	}

	/**
	 * 修改关于我页面
	 *
	 * @param map
	 * @return
	 */
	@OperationLogger("修改关于我页面")
	@PutMapping("/about")
	public Result updateAbout(@RequestBody Map<String, String> map) {
		aboutService.updateAbout(map);
		return Result.ok("修改成功");
	}
}
