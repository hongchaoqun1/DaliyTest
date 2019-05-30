package dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import vo.Picture;

import java.util.List;
import java.util.Map;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/21 14:48
 * @ClassName PictureDao
 */
@Repository
public interface PictureDao {
    /**
     * 返回数据列表
     *
     * @param map
     * @return
     */
    List<Picture> findPictures(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    int getTotalPictures(Map<String, Object> map);

    /**
     * 添加图片
     *
     * @param picture
     * @return
     */
    @Insert("INSERT INTO picture(path, remark) VALUES(#{path}, #{remark})")
    int insertPicture(Picture picture);

    /**
     * 修改图片
     *
     * @param picture
     * @return
     */
    int updPicture(Picture picture);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delPicture(Integer id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Picture findPictureById(Integer id);

    /**
     * 批量删除
     *
     * @param id
     * @return
     */
    int deleteBatch(Object[] id);
}
