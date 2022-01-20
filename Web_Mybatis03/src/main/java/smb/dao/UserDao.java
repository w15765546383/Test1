package smb.dao;

import org.apache.ibatis.annotations.Param;
import smb.pojo.QueryVo;
import smb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 查询所有
     *
     * @return
     */
    List < User > findAll ();

    /**
     * 增加数据
     *
     * @return
     */
    int addUser ( User user );

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User searchById ( Integer id );

    /**
     * 修改用户信息
     *
     * @param map
     * @return
     */
    int updateUser ( Map map );

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteById ( Integer id );

    /**
     * 用户名模糊查询
     *
     * @param username
     * @return
     */
    List < User > searchByUsername ( String username );

    List < User > searchByCondition ( QueryVo queryVo );
}
