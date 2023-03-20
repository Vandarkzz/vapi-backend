package com.yupi.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.InterfaceInfo;

/**
* @author 华山第一帅
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-19 15:31:48
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
