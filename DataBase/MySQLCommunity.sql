/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/10/16 17:52:47                          */
/*==============================================================*/


drop table if exists info_t_msgPost;

drop table if exists info_t_msgReplies;

/*==============================================================*/
/* Table: info_t_msgPost                                        */
/*==============================================================*/
create table info_t_msgPost
(
   postId               varchar(32) not null,
   postTile             varchar(200),
   postContent          varchar(4000),
   postTime             varchar(14),
   postIndex            varchar(100),
   keyWords             varchar(500),
   postUserId           varchar(50),
   postUserName         varchar(100),
   browerCount          int,
   remark               varchar(4000),
   appTime              varchar(14),
   appUserId            varchar(50),
   …Û∫À»À–’√˚                varchar(100),
   appContent           varchar(4000),
   primary key (postId)
);

/*==============================================================*/
/* Table: info_t_msgReplies                                     */
/*==============================================================*/
create table info_t_msgReplies
(
   repliesId            varchar(32) not null,
   postId               varchar(32),
   repliesContent       varchar(4000),
   repliesUserId        varchar(50),
   repliesName          varchar(100),
   repliesTime          varchar(10),
   repliesStatus        int comment 'Is valid?',
   appTime              varchar(14),
   appUserId            varchar(50),
   appUserName          varchar(100),
   appContent           varchar(4000),
   remark               varchar(4000),
   primary key (repliesId)
);

alter table info_t_msgReplies add constraint FK_postReplies foreign key (postId)
      references info_t_msgPost (postId) on delete restrict on update restrict;

