package com.yzy.rcs.controller;

import com.yzy.rcs.service.CarsService;
import com.yzy.rcs.vo.CarsVo;
import com.yzy.rcs.vo.DataGridModel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class CarsController {
    @Autowired
    private CarsService carsService;

    @RequestMapping("/loadCarManager.action")
    public String loadCarManager(){
        return "WEB-INF/jsp/cars/carsManager.jsp";
    }

    @RequestMapping("/findCarsKey.action")
    @ResponseBody
    public DataGridModel<CarsVo> findCarsKey(CarsVo carsVo){
        return carsService.findCarsKey(carsVo);
    }

    /**
     * 处理图片的上传请求
     * **/
    @RequestMapping("/uploadCarImg")
    @ResponseBody
    public Map<String,String> uploadCarImg(MultipartFile mf, HttpSession session){
        Map<String,String> map=new HashMap<String,String>();
        try{
            /**
             * 将图片保存到服务器的upload
             * **/
            String path = session.getServletContext().getRealPath("/upload");

            //重写定义上传的文件名称
            String newName=mf.getOriginalFilename();
            newName= UUID.randomUUID().toString().replace("-","")+
                    newName.substring(newName.lastIndexOf("."));
            //在服务器上，创建空的文件
            File file=new File(path,newName);

            FileUtils.writeByteArrayToFile(file, mf.getBytes());

            map.put("path", "upload/"+newName);

        }catch(Exception ex){
            ex.printStackTrace();
            map.put("errorMsg", ex.getMessage());
        }

        return map;
    }

    /**
     * 处理车辆信息的添加请求
     * **/
    @RequestMapping("/saveCars")
    @ResponseBody
    public Map<String,String> saveCars(HttpSession session,
                                       CarsVo cvo){

        Map<String,String> map=new HashMap<String,String>();

        try{
            cvo.setIsrenting("YES");
            carsService.saveCars(cvo);
        }catch(Exception ex){
            ex.printStackTrace();
            map.put("errorMsg", ex.getMessage());
        }
        return map;
    }

    @RequestMapping("/updateCars")
    @ResponseBody
    public Map<String,String> updateCars(CarsVo carsVo){
        Map<String,String> map=new HashMap<>();
        try{
            this.carsService.updateCars(carsVo);
        }catch (Exception ex){
            map.put("errorMsg",ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/delCars")
    @ResponseBody
    public Map<String,String> delCars(CarsVo carsVo, HttpSession session){

        Map<String,String> map=new HashMap<>();
        try{
            this.carsService.delCars(carsVo);
            String path = session.getServletContext().getRealPath("/");
            String realPath=path+carsVo.getCarimg();
            File targetFile = new File(realPath);
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }catch (Exception ex){
            map.put("errorMsg",ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    /***
     * 查询所有可出租的车辆信息
     * **/
    @RequestMapping("/loadCarsStatusList")
    @ResponseBody
    public DataGridModel<CarsVo> loadCarsStatusList(CarsVo cvo){
        return carsService.loadCarsListStatus(cvo);
    }


}
