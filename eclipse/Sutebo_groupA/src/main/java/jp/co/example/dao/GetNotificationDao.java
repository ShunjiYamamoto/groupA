package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.NoticeInfo;



public interface GetNotificationDao {

    public List<NoticeInfo> findAll();

}
