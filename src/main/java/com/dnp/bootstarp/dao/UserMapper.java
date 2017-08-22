package com.dnp.bootstarp.dao;

        import com.dnp.bootstarp.model.User;
        import com.baomidou.mybatisplus.mapper.BaseMapper;
        import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByName(@Param("username") String username);

}