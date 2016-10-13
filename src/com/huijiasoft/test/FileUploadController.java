package com.huijiasoft.test;
 
import java.io.File;
import java.util.List;
 
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
 
/**
 * FileUploadController 接收上传的文件
 */
public class FileUploadController extends Controller {
    private final int MAXSize = 50 * 1024 * 1024; // 50M
    private String filedir=PathKit.getWebRootPath() + "\\upload\\uservideo\\";//指定用户训练视频文件上传路径
 
    /**
     * 接收上传的文件
     * 注意：前提是lib中引入cos-26Dec2008.jar包
     */
    public void upload() {
        // TODO Auto-generated method stub
        try {
//          UploadFile upFile = getFile();//单个上传文件一句搞定  默认路径是 upload
//          UploadFile upFile = getFile("FILE", filedir, maxSize, "utf-8");//只用于表单提交方式， 单个上传文件
            List<UploadFile> upFiles = getFiles(filedir, MAXSize, "utf-8");//批量上传文件
            for (UploadFile fileItem : upFiles) {
                 
                String fPath=filedir+fileItem.getOriginalFileName();
                System.out.println("上传fPath"+fPath);
                String newPath=filedir+fileItem.getOriginalFileName().replace(".", "1.");//例如：交叉接触动作1.3gp
                File oldFile=new File(fPath);
                File newFile=new File(newPath);
                if(newFile.exists()){
                    System.out.println("-------------删除"+fileItem.getOriginalFileName());
                    //删除旧的
                    oldFile.delete();
                    //新的重命名
                    boolean updateName=newFile.renameTo(oldFile);
                    System.out.println("-------------updateName:"+updateName);
                     
                }
                 
            }
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            renderJson("status", "0");//失败
        }
        renderJson("status", "1");//成功
 
    }
}