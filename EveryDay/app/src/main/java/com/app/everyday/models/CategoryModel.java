package com.app.everyday.models;

import java.util.List;

/**
 * Author：YJQ on 2016/1/15 10:34
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class CategoryModel {


    /**
     * status : 0
     * result : [{"category":[{"categoryId":1,"name":"风尚","englishName":"cosmetics","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/cosmetics@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":2,"name":"护肤","englishName":"skincare","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/skincare@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":3,"name":"时装","englishName":"costume","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/costume@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":4,"name":"手袋","englishName":"beauty tool","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/beauty_tool@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":5,"name":"配饰","englishName":"accessory","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/accessory@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":6,"name":"鞋履","englishName":"shoes","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/shoes@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":7,"name":"香水","englishName":"perfume","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/perfume@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":43,"name":"彩妆","englishName":"cosmetics","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/cosmetics@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":45,"name":"美体","englishName":"body","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/body@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":47,"name":"美发","englishName":"hairdressing","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/hairdressing@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":89,"name":"购物","englishName":"shopping","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/hairdressing@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}}],"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"category":[{"categoryId":8,"name":"美食","englishName":"tea","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/tea@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"categoryId":9,"name":"厨具","englishName":"kitchenware","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/kitchenware@2x.png","image":"","priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"categoryId":10,"name":"酒","englishName":"kitchen tool","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/kitchen_tool@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"categoryId":11,"name":"饮品","englishName":"coffee","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/coffee@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"categoryId":12,"name":"正餐","englishName":"chinese food","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/chinese_food@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"categoryId":13,"name":"甜品","englishName":"western-style food","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/western_style_food@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"categoryId":15,"name":"零食","englishName":"snack","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/snack@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}}],"categoryGroup":{"categoryGroupId":2,"name":"美食","englishName":"Delicacy","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_large@2x.png","color":"#FFC000","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/delicacy_bg@2x.png"}},{"category":[{"categoryId":16,"name":"家居","englishName":"household appliances","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/household_appliances@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":17,"name":"清洁","englishName":"cleaning","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/cleaning@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":18,"name":"家具","englishName":"bathroom","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/bathroom@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":19,"name":"收纳","englishName":"storage","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/storage@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":20,"name":"电器","englishName":"smart home","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/smart_home@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":21,"name":"空间","englishName":"decoration","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/decoration@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":22,"name":"摆件","englishName":"clothcare","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/clothcare@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"categoryId":23,"name":"植物","englishName":"aroma","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/aroma@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}}],"categoryGroup":{"categoryGroupId":3,"name":"家居","englishName":"House","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_large@2x.png","color":"#00DEBD","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/house_bg@2x.png"}},{"category":[{"categoryId":26,"name":"旅行用品","englishName":"tourist accessories","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/tourist_accessories@2x.png","image":null,"priority":2,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":24,"name":"旅行","englishName":"grogshop","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/grogshop@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":25,"name":"目的地","englishName":"tourist destination","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/tourist_destination@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":34,"name":"航空","englishName":"aviation","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/aviation@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":35,"name":"酒店","englishName":"grogshop","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/grogshop@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":37,"name":"摄影","englishName":"photography","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/photography@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":39,"name":"攻略","englishName":"strategy","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/strategy@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"categoryId":41,"name":"休闲","englishName":"leisure","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/leisure@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}}],"categoryGroup":{"categoryGroupId":4,"name":"旅游","englishName":"Tourism","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_large@2x.png","color":"#0BC2F5","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/tourism_bg@2x.png"}},{"category":[{"categoryId":27,"name":"格物","englishName":"office goods","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/office_goods@2x.png","image":null,"priority":3,"categoryGroup":{"categoryGroupId":5,"name":"格物","englishName":"Goods","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_large@2x.png","color":"#B574C3","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_bg@2x.png"}},{"categoryId":28,"name":"办公小物","englishName":"gift","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/gift@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":5,"name":"格物","englishName":"Goods","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_large@2x.png","color":"#B574C3","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_bg@2x.png"}},{"categoryId":29,"name":"礼物","englishName":"merchandise","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/merchandise@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":5,"name":"格物","englishName":"Goods","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_large@2x.png","color":"#B574C3","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_bg@2x.png"}},{"categoryId":30,"name":"电子设备","englishName":"stationery","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/stationery@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":5,"name":"格物","englishName":"Goods","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_large@2x.png","color":"#B574C3","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_bg@2x.png"}},{"categoryId":31,"name":"杂物","englishName":"musical instrument","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/musical_instrument@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":5,"name":"格物","englishName":"Goods","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_large@2x.png","color":"#B574C3","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_bg@2x.png"}}],"categoryGroup":{"categoryGroupId":5,"name":"格物","englishName":"Goods","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_large@2x.png","color":"#B574C3","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/goods_bg@2x.png"}}]
     */

    private int status;
    /**
     * category : [{"categoryId":1,"name":"风尚","englishName":"cosmetics","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/cosmetics@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":2,"name":"护肤","englishName":"skincare","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/skincare@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":3,"name":"时装","englishName":"costume","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/costume@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":4,"name":"手袋","englishName":"beauty tool","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/beauty_tool@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":5,"name":"配饰","englishName":"accessory","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/accessory@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":6,"name":"鞋履","englishName":"shoes","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/shoes@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":7,"name":"香水","englishName":"perfume","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/perfume@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":43,"name":"彩妆","englishName":"cosmetics","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/cosmetics@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":45,"name":"美体","englishName":"body","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/body@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":47,"name":"美发","englishName":"hairdressing","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/hairdressing@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}},{"categoryId":89,"name":"购物","englishName":"shopping","icon":"http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/hairdressing@2x.png","image":null,"priority":0,"categoryGroup":{"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}}]
     * categoryGroup : {"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}
     */

    private List<ResultEntity> result;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        /**
         * categoryGroupId : 1
         * name : 风尚
         * englishName : Fashion
         * icon : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png
         * largeIcon : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png
         * color : #F83648
         * image : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png
         */

        private CategoryGroupEntity categoryGroup;
        /**
         * categoryId : 1
         * name : 风尚
         * englishName : cosmetics
         * icon : http://7xizes.com1.z0.glb.clouddn.com/@/v1/icon/i/category/cosmetics@2x.png
         * image : null
         * priority : 0
         * categoryGroup : {"categoryGroupId":1,"name":"风尚","englishName":"Fashion","icon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png","largeIcon":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png","color":"#F83648","image":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png"}
         */

        private List<CategoryEntity> category;

        public void setCategoryGroup(CategoryGroupEntity categoryGroup) {
            this.categoryGroup = categoryGroup;
        }

        public void setCategory(List<CategoryEntity> category) {
            this.category = category;
        }

        public CategoryGroupEntity getCategoryGroup() {
            return categoryGroup;
        }

        public List<CategoryEntity> getCategory() {
            return category;
        }

        public static class CategoryGroupEntity {
            private int categoryGroupId;
            private String name;
            private String englishName;
            private String icon;
            private String largeIcon;
            private String color;
            private String image;

            public void setCategoryGroupId(int categoryGroupId) {
                this.categoryGroupId = categoryGroupId;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setEnglishName(String englishName) {
                this.englishName = englishName;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setLargeIcon(String largeIcon) {
                this.largeIcon = largeIcon;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getCategoryGroupId() {
                return categoryGroupId;
            }

            public String getName() {
                return name;
            }

            public String getEnglishName() {
                return englishName;
            }

            public String getIcon() {
                return icon;
            }

            public String getLargeIcon() {
                return largeIcon;
            }

            public String getColor() {
                return color;
            }

            public String getImage() {
                return image;
            }
        }

        public static class CategoryEntity {
            private int categoryId;
            private String name;
            private String englishName;
            private String icon;
            private Object image;
            private int priority;
            /**
             * categoryGroupId : 1
             * name : 风尚
             * englishName : Fashion
             * icon : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion@2x.png
             * largeIcon : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_large@2x.png
             * color : #F83648
             * image : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/icon/i/categoryGroup/fashion_bg@2x.png
             */

            private CategoryGroupEntity categoryGroup;

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setEnglishName(String englishName) {
                this.englishName = englishName;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setImage(Object image) {
                this.image = image;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public void setCategoryGroup(CategoryGroupEntity categoryGroup) {
                this.categoryGroup = categoryGroup;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public String getName() {
                return name;
            }

            public String getEnglishName() {
                return englishName;
            }

            public String getIcon() {
                return icon;
            }

            public Object getImage() {
                return image;
            }

            public int getPriority() {
                return priority;
            }

            public CategoryGroupEntity getCategoryGroup() {
                return categoryGroup;
            }

            public static class CategoryGroupEntity {
                private int categoryGroupId;
                private String name;
                private String englishName;
                private String icon;
                private String largeIcon;
                private String color;
                private String image;

                public void setCategoryGroupId(int categoryGroupId) {
                    this.categoryGroupId = categoryGroupId;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setEnglishName(String englishName) {
                    this.englishName = englishName;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public void setLargeIcon(String largeIcon) {
                    this.largeIcon = largeIcon;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public int getCategoryGroupId() {
                    return categoryGroupId;
                }

                public String getName() {
                    return name;
                }

                public String getEnglishName() {
                    return englishName;
                }

                public String getIcon() {
                    return icon;
                }

                public String getLargeIcon() {
                    return largeIcon;
                }

                public String getColor() {
                    return color;
                }

                public String getImage() {
                    return image;
                }
            }
        }
    }
}
