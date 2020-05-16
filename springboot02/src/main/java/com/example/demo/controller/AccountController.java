package com.example.demo.controller;

import com.example.demo.common.CustomException;
import com.example.demo.common.Result;
import com.example.demo.entity.Account;
import com.example.demo.entity.Config;
import com.example.demo.service.AccountService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/account")
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private Config config;

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("config", config);
        return "account/login";//返回的视图路径前不要加‘/’，否则打包后会找不到模板文件
    }


    @PostMapping(value = "/validate")
    @ResponseBody
    public Result validateAccount(String loginName, String password, HttpServletRequest request) {
        System.out.println("loginName" + loginName);
        System.out.println("password" + password);
        String md5Pwd = null;
        try {
            md5Pwd = DigestUtils.md5DigestAsHex(new ByteArrayInputStream(password.getBytes()));
        } catch (IOException e) {
            log.info("密码加密出现异常" + e.getMessage(), e);
            new CustomException("密码加密出现异常");
        }
        Account account = accountService.getAccountByNameAndPwd(loginName, md5Pwd);
        if (account == null) {
            return Result.failed("账户不存在，登录失败");
        } else {
            //登录成功
            request.getSession().setAttribute("account", account);
            return Result.success("登录成功");
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("account");
        return "index";
    }

    @GetMapping(value = "/list")
    public String getAccountList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        PageInfo<Account> page = accountService.getAccountByPage(pageNum, pageSize);
        model.addAttribute("page", page);
        return "account/list";
    }

    @PostMapping(value = "/getAccountListByName")
    public String getAccountListByName(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "5") int pageSize,
                                       Model model, String accountName) {
        PageInfo<Account> page = accountService.getAccountListByName(pageNum, pageSize, accountName);
        model.addAttribute("page", page);
        return "account/list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public Result deleteById(int id) {
        //标记一下是否删除成功
        accountService.deleteById(id);
        return Result.success("删除成功");
    }

    @RequestMapping("/profile")
    public String profile() {
        try {
            //getPath();获取相对路径
            //getAbsolutePath()获取绝对路径
            File file = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(file.getAbsolutePath(), "static/uploads/");
            System.out.println(upload.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "account/profile";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("fileName") MultipartFile fileName, String password) {
        System.out.println("password" + password);
        System.out.println("file:" + fileName.getOriginalFilename());
        try {
            File file = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(file.getAbsolutePath(), "static/uploads");
            System.out.println("upload" + upload);
            try {
                fileName.transferTo(new File(upload + "/" + fileName.getOriginalFilename()));
            } catch (IOException e) {
                log.info("上传文件出现异常", e.getMessage());
                new CustomException("IO异常", e);
            }
        } catch (FileNotFoundException e) {
            log.info("上传文件出现异常", e.getMessage());
            new CustomException("IO异常", e);
        }
        return "account/profile";
    }

    @PostMapping("/register")
    public String register(Account account) {
        try {
            String md5str = DigestUtils.md5DigestAsHex(new ByteArrayInputStream(account.getPassword().getBytes()));
            account.setPassword(md5str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountService.register(account);
        return "redirect:/login";
    }

    @GetMapping("/registerPage")
    public String registerPage(Model model) {
        model.addAttribute("config", config);
        return "account/register";
    }
}
