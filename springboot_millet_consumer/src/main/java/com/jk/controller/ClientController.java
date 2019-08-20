package com.jk.controller;


import ch.qos.logback.core.util.FileUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;
import com.jk.service.ClientService;
import com.jk.util.CheckImgUtil;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Reference
    private ClientService clientService;


    @RequestMapping("queryUserList")
    @ResponseBody
    public DataGridResult queryUserList(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryUserList(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("queryMemberList")
    @ResponseBody
    public DataGridResult queryMemberList(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryMemberList(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }

    @RequestMapping("updateClient")
    @ResponseBody
    public void updateClient(String aa,String id){
        clientService.updateClient(aa,id);
    }

    //获取图片验证码
    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){

        CheckImgUtil.buildCheckImg(request, response);

    }

//登陆
    @RequestMapping("loginUser")
	@ResponseBody
	public String login(User user,String code,HttpServletRequest request){

		//验证验证码
		//从session中取出验证码
        System.out.println(user.getUserAccount());
		String realCode = request.getSession().getAttribute("checkcode").toString();
		//校验验证码
		if(!realCode.toLowerCase().equals(code.toLowerCase())){

			return "codeError";
		}
		//验证账号
		User loginUser = clientService.queryUserName(user.getUserAccount());

		if(loginUser == null){

			return "userError";
		}
        System.out.println(loginUser.getUserPassword());
		//验证密码
		if(!loginUser.getUserPassword().equals(user.getUserPassword())){

			return "pwError";
		}
		//登录成功

		request.getSession().setAttribute("user", loginUser);
		return "success";
	}

	@RequestMapping("updateCancel")
	@ResponseBody
    public void updateCancel(Integer id) {
        clientService.updateCancel(id);
    }



	@RequestMapping("addCoupon")
    @ResponseBody
    public void addCoupon(Coupon coupon){
        clientService.addCoupon(coupon);
    }

    @RequestMapping("queryCoupon")
    @ResponseBody
    public DataGridResult queryCoupon(@RequestBody ParameUtil params) {

        DataGridResult result = new DataGridResult();
        PageUtil pageUtil = clientService.queryCoupon(params);
        result.setRows(pageUtil.getList());
        result.setTotal(pageUtil.getSumSize());
        return result;
    }


}