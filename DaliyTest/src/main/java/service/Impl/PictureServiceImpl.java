package service.Impl;

import Utils.PageResult;
import Utils.PageUtil;
import dao.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PictureService;
import vo.Picture;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/21 15:34
 * @ClassName PictureServiceImpl
 */

@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureDao pictureDao;

    @Override
    public PageResult getPicturePage(PageUtil pageUtil) {
        return null;
    }

    @Override
    public Picture queryObject(Integer id) {
        return null;
    }

    @Override
    public int save(Picture picture) {
        return pictureDao.insertPicture(picture);
    }

    @Override
    public int update(Picture picture) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return 0;
    }
}
