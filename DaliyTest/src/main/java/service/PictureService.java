package service;


import Utils.PageResult;
import Utils.PageUtil;
import vo.Picture;

import java.util.List;
import java.util.Map;

/**
 * @author cp
 * @Description TODO
 * @date 2019/5/21 15:32
 * @InterfaceName PictureService
 */
public interface PictureService {
    /**
     * 查询列表数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getPicturePage(PageUtil pageUtil);

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     */
    Picture queryObject(Integer id);

    /**
     * 新增图片对象
     *
     * @param picture
     */
    int save(Picture picture);

    /**
     * 修改
     *
     * @param picture
     */
    int update(Picture picture);

    /**
     * 删除
     *
     * @param id
     */
    int delete(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     */
    int deleteBatch(Integer[] ids);
}
