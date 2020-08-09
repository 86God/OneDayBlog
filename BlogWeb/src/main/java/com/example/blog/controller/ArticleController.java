package com.example.blog.controller;

import com.example.blog.bean.Article;
import com.example.blog.bean.ArticleList;
import com.example.blog.bean.Condition;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articleCtl")
@CrossOrigin
public class ArticleController {
    @Autowired
    ArticleService articleService;


    //查询文章类型列表
    @RequestMapping("/findArtTypeList")
    protected List<Map<String,Object>> findArtTypeList(){
        return articleService.findArtTypeList();
    }

    //查询用户专栏列表
    @RequestMapping("/findSpeColListByUserId")
    protected List<Map<String,Object>> findSpeColListByUserId(String userId){
        return articleService.findSpeColListByUserId(userId);
    }

    //添加文章
    @RequestMapping("/saveArt")
    protected int saveArt(Article article){
        return articleService.saveArt(article);
    }

    //更新文章
    @RequestMapping("/updateArt")
    protected int updateArt(Article article){
        articleService.updateArt(article);
        return article.getId();
    }

    //添加文章类型，文章所属专栏
    @RequestMapping("/saveArtTypeAndSpecol")
    protected Map<String,Object> saveArtTypeAndSpecol(int artId,String artType,String specol,int permType,int isreg){
        String[] artType1 = artType.split(",");
        String[] specol1 = specol.split(",");
        Map<String,Object> map = new HashMap<>();
        try{
            //添加文章
            articleService.saveArtTypeAndSpecol(artId,artType1,specol1,permType,isreg);
            //更新文章信息
            articleService.updateArtNum(artId);
            map.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }



    //查询文章列表，可以通过用户ID、文章类型名称、专栏ID
    @RequestMapping("/findArtListByPage")
    protected Map<String,Object> findArtListByPage(Condition condition,Integer page){
        System.out.println(condition);
        System.out.println(page);
        if(condition.getArtName() == null || condition.getArtName().equals("null")){
            condition.setArtName(null);
        }
        if(condition.getUserId() == null || condition.getUserId().equals("null")){
            condition.setUserId(null);
        }
        if(condition.getIsreg() == null || condition.getIsreg().equals("null")){
            condition.setIsreg(null);
        }

        if(condition.getArtType()==null || condition.getArtType().equals("null")){
            condition.setArtType(null);
        }
        if(condition.getSpeId()==null || condition.getSpeId().equals("null")){
            condition.setSpeId(null);
        }
        if(page!=null){
            condition.setPageNum(page);
        }
        System.out.println(condition);
        Map<String,Object> map = new HashMap<>();
        List<ArticleList> list = articleService.findArtListByPage(condition);
        map.put("data",list);
        int count = articleService.findArtListCount(condition);
        int pages = (int) Math.ceil(((double) count)/condition.getLimit());
        map.put("pages",pages);
        map.put("code",0);
        map.put("count",count);
        return map;
    }

    //根据id查询文章的详情信息
    @RequestMapping("/findArtById")
    protected Map<String,Object> findArtById(Integer artId,Integer userId){
        articleService.addVisit(userId,artId);
        return articleService.findArtById(artId);
    }

    //根据文章id查询文章所属专栏和类型
    @RequestMapping("/findArtRelById")
    protected Map<String,Object> findArtRelById(Integer artId){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = articleService.findArtRelById(artId);
        String typeList1 = (String) map1.get("typeList");
        String secList1 = (String) map1.get("secList");
        String[] typeList = null;
        String[] secList = null;
        if(typeList1 != null && typeList1 != ""){
            typeList = typeList1.split(",");
        }
        if(secList1 != null && secList1 != ""){
            secList = secList1.split(",");
        }
        Integer permType = (Integer) map1.get("permType");
        map.put("artId",artId);
        map.put("typeList",typeList);
        map.put("secList",secList);
        map.put("permType",permType);
        return map;
    }

    //根据文章id删除文章（包括文章类型和所属专栏）
    @RequestMapping("/deleteById")
    protected Map<String,Object> deleteById(Integer idList){
        Map<String,Object> map = new HashMap<>();
        try{
            articleService.deleteById(idList);
            map.put("code",0);
        }catch (Exception e) {
            e.printStackTrace();
            map.put("code", 1);
        }
        return map;
    }

    //根据文章id批量删除文章（包括文章类型和所属专栏）
    @RequestMapping("/batchDeleteById")
    protected Map<String,Object> batchDeleteById(String idList){
        Map<String,Object> map = new HashMap<>();
        try{
            articleService.batchDeleteById(idList);
            map.put("code",0);
        }catch (Exception e) {
            e.printStackTrace();
            map.put("code", 1);
        }
        return map;
    }

    //点赞和取消赞
    @RequestMapping("/giveLike")
    protected Map<String,Object> giveLike(Integer userId,Integer artId){
        Map<String,Object> map = new HashMap<>();
        int like = 0;
        try{
            boolean flag = articleService.ifLike(userId,artId);
            if(flag){
                articleService.removeLike(userId,artId);
                like = -1;
            }else{
                articleService.addLike(userId,artId);
                like = 1;
            }
            map.put("like",like);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //判断是否已经点赞
    @RequestMapping("/ifLike")
    protected int ifLike(Integer userId,Integer artId){
        boolean flag = articleService.ifLike(userId,artId);
        int ifLike = -1;
        if(flag){
            ifLike = 0;
        }else{
            ifLike = 1;
        }
        return ifLike;
    }

    //判断是否已经收藏
    @RequestMapping("/ifCollect")
    protected int ifCollect(Integer userId,Integer artId){
        boolean flag = articleService.ifCollect(userId,artId);
        int ifCollect = -1;
        if(flag){
            ifCollect = 0;
        }else{
            ifCollect = 1;
        }
        return ifCollect;
    }

    //收藏和取消收藏
    @RequestMapping("/addCollect")
    protected Map<String,Object> addCollect(Integer userId,Integer artId){
        Map<String,Object> map = new HashMap<>();
        int collect = 0;
        try{
            boolean flag = articleService.ifCollect(userId,artId);
            if(flag){
                articleService.removeCollect(userId,artId);
                collect = -1;
            }else{
                articleService.addCollect(userId,artId);
                collect = 1;
            }
            map.put("collect",collect);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    //查询文章列表，可以通过用户ID、文章类型名称、专栏ID
    @RequestMapping("/findArtCollectList")
    protected Map<String,Object> findArtCollectList(Integer userId,Integer pageNum,Integer limit){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        map1.put("pageNum",pageNum);
        map1.put("limit",limit);
        Map<String,Object> map = new HashMap<>();
        List<ArticleList> list = articleService.findArtCollectList(map1);
        map.put("data",list);
        int count = articleService.findArtCollectListCount(map1);
        int pages = (int) Math.ceil(((double) count)/limit);
        map.put("pages",pages);
        map.put("code",0);
        map.put("count",count);
        return map;
    }

    //发布评论
    @RequestMapping("/publishComment")
    protected Map<String,Object> publishComment(Integer userId,Integer artId,String commentTxt){
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        map1.put("userId",userId);
        map1.put("artId",artId);
        map1.put("commentTxt",commentTxt);
        try{
            articleService.publishComment(map1);
            map.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

    //查找评论列表
    @RequestMapping("/findCommentList")
    protected Map<String,Object> findCommentList(Integer pageNum,Integer limit,Integer artId){
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        map1.put("pageNum",pageNum);
        map1.put("limit",limit);
        map1.put("artId",artId);

        try{
            List<Map<String,Object>> list = articleService.findCommentList(map1);
            map.put("data",list);
            int count = articleService.findCommentListCount(map1);
            int pages = (int) Math.ceil(((double) count)/limit);
            map.put("pages",pages);
            map.put("count",count);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }




}
