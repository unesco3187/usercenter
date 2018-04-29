package com.xiao6.usercenter.mapper;

import com.xiao6.usercenter.entity.Girl;
import com.xiao6.usercenter.util.MyMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

//@Mapper
public interface GirlMapper extends MyMapper<Girl> {

    @Options(
            useGeneratedKeys = true,
            keyProperty = "userId"
    )
    @InsertProvider(
            type = SpecialProvider.class,
            method = "dynamicSQL"
    )
    int insertOneAndReturnUserId(Girl girl);
}