package controller;

import common.Constants;
import common.Result;
import common.ResultGenerator;
import org.apache.poi.xwpf.converter.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PictureService;
import vo.Picture;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/22 14:56
 * @ClassName PictureController
 */

@Controller
@RequestMapping(value = "/pictures")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody Picture picture) {
        if (StringUtils.isEmpty(picture.getPath()) || StringUtils.isEmpty(picture.getRemark())) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }
        if (pictureService.save(picture) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }
}
