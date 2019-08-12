package com.xiajun.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.pojo.Bgm;
import com.xiajun.admin.service.impl.BgmServiceImpl;
import com.xiajun.admin.utils.JSONResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/bgm")
public class BgmController {
    @Autowired
    private BgmServiceImpl bgmService;
    @PostMapping("/queryBgmList")
    @ResponseBody
    public JSONResult queryBgmList(Page<Bgm> page) {
        bgmService.page(page);
        return JSONResult.ok(page);
    }


    @PostMapping("/addBgm")
    @ResponseBody
    public JSONResult addBgm(@RequestBody Bgm bgm) {

        bgmService.save(bgm);
        return JSONResult.ok();
    }

    @GetMapping("/delBgm")
    @ResponseBody
    public JSONResult delBgm(@RequestParam("id") String bgmId) {
        bgmService.removeById(bgmId);
        return JSONResult.ok();
    }

    @PostMapping("/bgmUpload")
    @ResponseBody
    public JSONResult bgmUpload(@RequestParam("file") MultipartFile[] files) throws Exception {

        // 文件保存的命名空间
		String fileSpace = "/Users/xiajun/03.Workspaces/ddj-video-files/";
//        String fileSpace = "C:" + File.separator + "imooc_videos_dev" + File.separator + "mvc-bgm";
        // 保存到数据库中的相对路径
        String uploadPathDB = File.separator + "bgm";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {

                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalPath = fileSpace + uploadPathDB + File.separator + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += (File.separator + fileName);

                    File outFile = new File(finalPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }

            } else {
                return JSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JSONResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        return JSONResult.ok(uploadPathDB);
    }



}

