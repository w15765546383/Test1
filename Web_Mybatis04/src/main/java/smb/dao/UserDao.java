package smb.dao;

import org.apache.ibatis.annotations.Param;
import smb.pojo.User;
import smb.pojo.UserInfo;

import java.util.List;

public interface UserDao {
    List< UserInfo > findAllUserInfo();
    /***
     *  根据address查询用户,如果没有传入地址则查询出所有用户
     *   @param address
     *   @return
     */
    List<User> findUserListByAddress(@Param("address") String address);
    /***
     * 根据用户的地址和性别查询用户, 如果有address才考虑address的条件，如果有sex才考虑sex的 条件
     * @param user
     * @return
     **/
    List< User > findUserListByAddressAndSex(User user);
    void deleteById(List<Integer> id);
}
