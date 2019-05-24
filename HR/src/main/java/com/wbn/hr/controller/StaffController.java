package com.wbn.hr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wbn.hr.bean.Staff;
import com.wbn.hr.mapper.StaffMapper;

@RestController
@RequestMapping("/api/v1")
public class StaffController {
	
	//依赖注入
	@Autowired
	StaffMapper mapper;
	
	/**
	 * get方式访问/staffs
	 * @return
	 */
	@GetMapping("/staffs")
	public List<Staff> list(){
		return mapper.findAll();
	}
	
	/**
	 * 
	 * @param start 分页起始位置
	 * @param end	分页结束位置
	 * @return
	 */
	@GetMapping("/staff")
	public HashMap<String, Object> list(@RequestParam("start")int start,
			@RequestParam("size")int size){
		HashMap<String, Object> map = new HashMap<>();
		int count = mapper.getCount();
		map.put("count", count);
		List<Staff> list = mapper.findPage(start, size);
		map.put("staffs", list);
		return map;
	}
	
	/**
	 * get方式访问/staff/id
	 * @param id
	 * @return
	 */
	@GetMapping("/staff/find/{id}")
	public Staff getStaff(@PathVariable("id") int id) {
		return mapper.load(id);
	}
	
	/**
	 * json object --->@RequestBody
	 * form 不用写
	 * @param staff
	 * @return 
	 */
	@PostMapping("/staff")
	public Map<String, Object> create(@RequestBody Staff staff) {
		HashMap<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		mapper.save(staff);
		return msg;
	}
	
	@DeleteMapping("/staff/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable int id){
		HashMap<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		mapper.delete(id);		
		return msg;
	}
	
	@PostMapping("/staff/update")
	public void update(@RequestBody Staff staff) {
		System.out.println(staff);
		mapper.updateStaff(staff);
	}
	

	
	
	
	
	
	
}
