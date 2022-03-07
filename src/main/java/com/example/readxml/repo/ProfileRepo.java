package com.example.readxml.repo;

import com.example.readxml.model.Profile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProfileRepo {

    @Select("SELECT * FROM profile1 where id=#{id};")
    public Profile getDatabaseProfile(Long id);

    @Select("select * from profile1")
    public List<Profile> findAll();

    @Insert("INSERT INTO profile1(id,profilename, drivername,url,username,password) VALUES (#{id},#{profilename},#{drivername},#{url},#{username},#{password})")
    public int insert(Profile profile);
}
