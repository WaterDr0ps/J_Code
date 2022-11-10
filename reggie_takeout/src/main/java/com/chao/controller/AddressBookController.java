package com.chao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.chao.common.Result;
import com.chao.entity.AddressBook;
import com.chao.service.AddressBookService;
import com.chao.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eliot
 */
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    /**
     * 显示所有地址
     * @return
     */
    @GetMapping("/list")
    public Result<List<AddressBook>> list(){
        Long currentId = ThreadLocalUtils.getCurrentId();
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId,currentId);
        List<AddressBook> list = addressBookService.list(queryWrapper);
        return Result.success(list);
    }

    /**
     * 保存地址
     * @param addressBook
     * @return
     */
    @PostMapping
    public Result<String> save(@RequestBody AddressBook addressBook){
        //先设置当前用户id
        addressBook.setUserId(ThreadLocalUtils.getCurrentId());
        addressBookService.save(addressBook);
        return Result.success("保存成功");
    }

    /**
     * 设置默认地址
     * @param addressBook 仅用于接收 id字段
     * @return
     */
    @PutMapping("/default")
    public Result<AddressBook> defaultAddress(@RequestBody AddressBook addressBook){

        //先把其他的默认地址设为0
        LambdaUpdateWrapper<AddressBook> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(AddressBook::getUserId,ThreadLocalUtils.getCurrentId())
                .set(AddressBook::getIsDefault,0);
        addressBookService.update(updateWrapper);

        //再设置当前默认地址
        addressBook.setIsDefault(1);
        addressBookService.updateById(addressBook);
        return Result.success(addressBook);
    }

    /**
     * 根据id查询,回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<AddressBook> selectById(@PathVariable Long id){
        AddressBook addressBook = addressBookService.getById(id);
        return Result.success(addressBook);
    }

    /**
     * 更新地址信息
     * @param addressBook
     * @return
     */
    @PutMapping
    public Result<String> update(@RequestBody AddressBook addressBook){
        addressBookService.updateById(addressBook);
        return Result.success("地址修改成功");
    }

    /**
     * 删除地址
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result<String> deleteById(Long ids){
        addressBookService.removeById(ids);
        return Result.success("删除成功");
    }

    @GetMapping("/default")
    public Result<AddressBook> showDefaultAddress(){
        Long currentId = ThreadLocalUtils.getCurrentId();
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId,currentId)
                .eq(AddressBook::getIsDefault,1);
        AddressBook one = addressBookService.getOne(queryWrapper);

        return Result.success(one);
    }
}
