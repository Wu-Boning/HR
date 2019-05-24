package com.wbn.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wbn.hr.bean.Staff;

/**
 * 数据持久化
 * 	数据操作 DAO
 * @author 吴泊宁
 *
 */
@Mapper
public interface StaffMapper {

	@Insert("insert into staff(name,job,gender)"
			+ " value(#{name},#{job},#{gender})")
	public void save(Staff staff);
	
//	@Select("select * from staff")
	public List<Staff> findAll();
	
	/**
	 * 分页查询
	 * @param start页面起始位置
	 * @param end	页面结束位置
	 * @return
	 */
	@Select("select * from staff limit #{start},#{size}")
	public List<Staff> findPage(@Param("start")int start, @Param("size")int size);
	
	/**
	 * 查询记录总数
	 * @return
	 */
	@Select("select count(*) from staff")
	public int getCount();
	
	@Select("select * "
			+ "from staff"
			+ " where id=#{id}")
	public Staff load(@Param("id")int id);

	@Delete("delete from staff where id=#{id}")
	public void delete(@Param("id")int id);
	
	/**
	 * 更新
	 * @param staff
	 */
	@Update("update staff set name=#{name}, gender=#{gender}, job=#{job}"
			+ "where id=#{id}")
	public void updateStaff(Staff staff);

	
	
}
