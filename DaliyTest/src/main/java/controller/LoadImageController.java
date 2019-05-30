package controller;

import common.Result;
import common.ResultGenerator;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import vo.ResultVo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/14 11:20
 * @ClassName LoadImageController
 */

@Controller
@RequestMapping("/images")
public class LoadImageController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result upload(HttpServletRequest request, @RequestParam("file")MultipartFile file)throws IOException{
        ServletContext sc = request.getSession().getServletContext();
        String dir = sc.getRealPath("/upload");
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");


        Random r = new Random();
        String imgName = "";
        if ("jpg".equals(type)) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpg";
        } else if ("png".equals(type)) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".png";
        } else if ("jpeg".equals(type)) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpeg";
        } else if ("gif".equals(type)) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".gif";
        } else {
            return null;
        }


        File newFile = new File(dir, imgName);
        String path = newFile.getPath();

        FileUtils.writeByteArrayToFile(new File(dir, imgName), file.getBytes());
        Result result = ResultGenerator.genSuccessResult();
        result.setData("/upload/" + imgName);
        return result;
    }

}
