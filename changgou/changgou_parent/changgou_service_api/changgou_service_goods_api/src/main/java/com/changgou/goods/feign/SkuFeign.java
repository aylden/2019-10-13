package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Sku;
import com.changgou.order.pojo.OrderItem;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name = "goods")
@RequestMapping("/sku")
public interface SkuFeign {

    /***
     * Sku分页条件搜索实现
     * @param sku
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    Result<PageInfo> findPage(@RequestBody(required = false) Sku sku, @PathVariable(value = "page") int page, @PathVariable(value = "size") int size);

    /***
     * Sku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    Result<PageInfo> findPage(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size);

    /***
     * 多条件搜索品牌数据
     * @param sku
     * @return
     */
    @PostMapping(value = "/search")
    Result<List<Sku>> findList(@RequestBody(required = false) Sku sku);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    Result delete(@PathVariable(value = "id") Long id);

    /***
     * 修改Sku数据
     * @param sku
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    Result update(@RequestBody Sku sku, @PathVariable(value = "id") Long id);

    /***
     * 新增Sku数据
     * @param sku
     * @return
     */
    @PostMapping
    Result add(@RequestBody Sku sku);

    /***
     * 根据ID查询Sku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Sku> findById(@PathVariable(name = "id") Long id);

    /***
     * 查询Sku全部数据
     * @return
     */
    @GetMapping
    Result<List<Sku>> findAll();

    /**
     * 根据状态查询sku列表
     *
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    public Result<List<Sku>> findByStatus(@PathVariable(value = "status") String status);

    @PostMapping("/decreaseSku")
    public Result decreaseSku(@RequestBody OrderItem orderItem);

    @PostMapping("/increaseSku")
    public Result increaseSku(@RequestBody OrderItem orderItem);


}